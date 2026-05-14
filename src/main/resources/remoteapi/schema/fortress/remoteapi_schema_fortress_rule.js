// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
// RemoteApiGen your rule settings as ECMAScript5 (related to RemoteApiRule.js in freegen)
// _/_/_/_/_/_/_/_/_/_/

// ======================================================================================
//                                                                                  Base
//                                                                                 ======
// @Override
remoteApiRule.target = function(api) { // you can select generated API
    // #for_now remove this condition after fixing Parameters headache by jflute (2022/01/20)
    if (api.httpMethod === 'parameters') {
        return false;
    }
    if (api.url.indexOf('/default/') >= 0 || api.url.indexOf('/class/') >= 0) {
        return false; // cannot generate now (Reservation Word)
    }
    if (api.httpMethod === 'get' && api.url.indexOf('/onbodyjson') >= 0) {
        return false; // cannot generate now (GET but JsonBody)
    }
    if (api.url.indexOf('/json/swagger') >= 0) {
        return false; // cannot generate now (Too many nested Part classes)
    }
    return true;
}


// ======================================================================================
//                                                                               Behavior
//                                                                               ========
// e.g. resources having many nests
var canBeRestful = function(api) {
    return api.url.indexOf('/ballet-dancers/') >= 0
        || api.url.indexOf('/products/') >= 0
        || api.url.indexOf('/members/') >= 0
        || api.url.indexOf('/restlike') >= 0;
};

// generate hierarchical behaviors if resources hanving many nests
// @Override
remoteApiRule.behaviorSubPackage = function(api) {
    if (canBeRestful(api)) {
        return this.subPackage(api).replace(/^([^.]*)\.(.+)/, '$1.$2'); // default is $1 only
    } else {
        return baseRule.behaviorSubPackage(api);
    }
}

// always HTTP Method if Restful
// @Override
remoteApiRule.isAvailableFixedHttpMethodSuffixOfIdentityName = function(api, option) {
    return canBeRestful(api);
}



// =======================================================================================
//                                                                            Param/Return
//                                                                            ============
// extends common super class for e.g. HTTP headers
// @Override
remoteApiRule.returnExtendsClass = function(api, properties) {
    if (api.httpMethod === 'get' && !api.url.endsWith('}/')) { // means List GET
        return "org.docksidestage.bizfw.remoteapi.AbstractListGetReturn";
    } else {
        return baseRule.returnExtendsClass(api, properties);
    }
}



// test: 対象フィールドを絞ったケース
// @Override
remoteApiRule.targetField = function(api, topLevelBean, jsonFieldName) {
    var targetFieldClasses = {
        RemoteLidoProductDetailReturn: [
            'product_id',
            'product_name',
            'category_name',
            // test: 定価を除外してみる (2026/03/07)
            //'regular_price',
            'product_handle_code',
        ],
        RemoteWxRemogenBodyBasicParam: [
            // test: requiredのものを除外してみる。するとimport文のRequiredが消えて欲しい (2026/03/11)
            //'sea',
            'land',
            'piari',
            'bonvo',
            'dstore',
            //'amba',
            'miraco',
            'dohotel',
        ],
        RemoteWxRemogenBodyListParam: [
            // test: requiredのものを一部だけ除外してみる。import文のRequiredが残って欲しい (2026/03/11)
            //'sea',
            'land',
            'piari',
            'bonvo',
            'dstore',
            'amba',
            'miraco',
            'dohotel',
        ],
        RemoteWxRequestJsonBodyClienterrorParam: [
            // test: requiredのものを除外してみる。するとimport文のRequiredが消えて欲しい (2026/03/11)
            // fortress側では@NotNullのものも、こっちでは@Requiredになるものがあるので注意: List以外のプロパティ
            'sea',
            //'sea_dockside',
            'sea_hangar',
            'sea_magiclamp',
            'sea',
            //'land',
            'piari',
            'bonvo',
            //'dstore',
            //'amba',
            'miraco',
            //'toscana',
            // test: toscanaが除外されているので park_entrance_view の required は評価されないはず
            'park_entrance_view',
            'hotel_entrance_view',
            //'nannimo_view',
            'venezia_list',
            'canal_view',
            //'river_view',
            'dohotel',
            'format_bodying',
        ],
        RemoteWxRequestJsonBodySystemerrorParam: [
            // test: notnullのものを除外してみる。するとimport文のNotNullが消えて欲しい (2026/03/11)
            'sea',
            'sea_dockside',
            //'sea_hangar',
            //'sea_magiclamp',
            'sea',
            'land',
            'piari',
            'bonvo',
            'dstore',
            'amba',
            'miraco',
            'toscana',
            'park_entrance_view',
            'hotel_entrance_view',
            'nannimo_view',
            //'venezia_list',
            'canal_view',
            'river_view',
            'dohotel',
            'format_bodying',
        ],
        RemoteWxRequestJsonBodyClienterrorReturn: [
            // test: Returnでプロパティを絞ってみてBeanやTestなど想定通りになるか？ (2026/03/14)
            'sea',
            //'sea_dockside',
            'sea_hangar',
            'sea_magiclamp',
            'sea',
            //'land',
            'piari',
            'bonvo',
            //'dstore',
            //'amba',
            'miraco',
            //'toscana',
            // test: toscanaが除外されているので park_entrance_view の required は評価されないはず
            'park_entrance_view',
            'hotel_entrance_view',
            //'nannimo_view',
            'venezia_list',
            'canal_view',
            //'river_view',
            'dohotel',
            'format_bodying',
        ],
    };
    var targetFields = targetFieldClasses[topLevelBean.className]
    if (targetFields) { // 絞り対象のクラスだったら
        return targetFields.indexOf(jsonFieldName) >= 0; // 指定されているものだけtrue
    }
    return true; // デフォルトではすべて対象
}



// =======================================================================================
//                                                                                  Option
//                                                                                  ======
// @Override
remoteApiRule.typeMap = function() {
    var typeMap = baseRule.typeMap();
    typeMap['array'] = 'org.eclipse.collections.api.list.ImmutableList';
    return typeMap;
}

// name and type mapping for e.g. classification
var manualMappingClassMap = {
    'memberStatus': 'org.docksidestage.dbflute.allcommon.CDef.MemberStatus',
    'productStatus': 'org.docksidestage.dbflute.allcommon.CDef.ProductStatus',
};

// @Override
remoteApiRule.pathVariableManualMappingClass = function(api, pathVariable) {
    return manualMappingClassMap[pathVariable.name];
}

// @Override
remoteApiRule.beanPropertyManualMappingClass = function(api, beanClassName, property) {
    return manualMappingClassMap[property.name];
}
