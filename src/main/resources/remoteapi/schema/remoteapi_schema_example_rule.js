// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
// RemoteApiGen your rule settings as ECMAScript5 (related to RemoteApiRule.js in freegen)
// _/_/_/_/_/_/_/_/_/_/

// =======================================================================================
//                                                                                   Base
//                                                                                  ======
// 自動生成対象を調整する(RequestもResponseのないAPIの自動生成) @until 2019/08/31
// @since 2019/09/01 RemoteApiRule.jsですべてtrueになっています。
remoteApiRule.target = function(api) {
    // 自動生成対象から除外したいURLがあれば、他のremoteApiRule.targetのoverrideの指定方法を参考にしてください。
    return true;
};

// 自動生成対象から除外する(URLで指定)
remoteApiRule.target = function(api) {
    if (!baseRule.target(api)) {
        return false;
    }
    var targetUrls = [
        '/xxx/yyy/zzz'
    ];
    for (var targetUrlIndex in targetUrls) {
        if (targetUrls[targetUrlIndex].indexOf(api.url) !== -1) {
            return true;
        }
    }
    return false;
};

// 自動生成対象から除外する(Content-Typeで指定)
remoteApiRule.target = function(api) {
    if (!baseRule.target(api)) {
        return false;
    }
    var contentTypes = [];
    Array.prototype.push.apply(contentTypes, api.consumes ? api.consumes: []);
    Array.prototype.push.apply(contentTypes, api.produces ? api.produces: []);
    return contentTypes.indexOf('application/json') !== -1 || (contentTypes.indexOf('application/xml') !== -1);
};

// 自動生成時のパッケージからURLの一部(バージョン番号など)を除去
remoteApiRule.subPackage = function(api) {
    return baseRule.subPackage(api).replace(/\.v1/g, '');
};

// =======================================================================================
//                                                                                Behavior
//                                                                                ========
// Bhvクラスを自動生成しない。Param/Returnクラスのみを利用したい場合。
remoteApiRule.behaviorClassGeneration = false;

// Bhvクラスのメソッドを自動生成しない。メソッドを手動で作成したい場合。
remoteApiRule.behaviorMethodGeneration = true;

// Bhvクラスのメソッドをpublicではなく、protectedにする。Gapクラスで利用するものだけpublicにしたい場合。
remoteApiRule.behaviorMethodAccessModifier = 'protected';

// org.lastaflute.remoteapi.LastaRemoteBehaviorを継承した独自クラスを設定する。複数のremoteApiがあり、複数のremoteApiにまたがる拡張処理がある場合。
remoteApiRule.frameworkBehaviorClass = 'xxx.yyy.remoteapi.MyProjectRemoteBehavior';

// Bhvクラスのサブパッケージを分けずにフラットにする。
remoteApiRule.behaviorSubPackage = function(api) {
    return '';
};

// Bhvクラスのサブパッケージを細かく分ける。
remoteApiRule.behaviorSubPackage = function(api) {
    return this.subPackage(api).replace(/^([^.]*)\.(.+)/, '$1.$2');
};

// Bhvクラスのリクエストメソッドに常にHTTPメソッド(Get、Post etc.)を付与する。
remoteApiRule.behaviorRequestMethodName = function(api) {
    var methodPart = manager.camelize(this.subPackage(api).replace(this.behaviorSubPackage(api), '').replace(/\./g, '_'));
    return 'request' + manager.initCap(methodPart) + (api.httpMethod ? manager.initCap(api.httpMethod) : '');
}

// Bhvクラスのルールメソッドに常にHTTPメソッド(Get、Post etc.)を付与する。
remoteApiRule.behaviorRuleMethodName = function(api) {
    var methodPart = manager.camelize(this.subPackage(api).replace(this.behaviorSubPackage(api), '').replace(/\./g, '_'));
    return 'ruleOf' + manager.initCap(methodPart) + (api.httpMethod ? manager.initCap(api.httpMethod) : '');
}

// =======================================================================================
//                                                                            Param/Return
//                                                                            ============
// Bhvクラスのサブパッケージを分けずにフラットにする。
remoteApiRule.beanSubPackage = function(api) {
    return '';
};

// 自動生成するParam/Returnクラスの親Definitionクラスを生成する。
remoteApiRule.beanExtendsDefinitionGeneration = true;

// 自動生成するParamクラスにextendsするクラスを指定する。
remoteApiRule.paramExtendsClass = function(api, properties) {
    // api、propertiesの内容によって変えることも可能
    return 'xxx.yyy.zzz.AbcParam';
};

// 自動生成するParamクラスにimplementsするインターフェースを指定する。
remoteApiRule.paramImplementsClasses = function(api, properties) {
    // api、propertiesの内容によって変えることも可能
    return 'xxx.yyy.zzz.AbcParam';
};

// 自動生成するParamクラスのSuffixを変更する。
remoteApiRule.paramClassName = function(api, detail) {
    return baseRule.paramClassName(api).replace(/Param$/g, 'Xxx');
},

// 自動生成するReturnクラスにextendsするクラスを指定する。
remoteApiRule.returnExtendsClass = function(api, properties) {
    // api、propertiesの内容によって変えることも可能
    return 'xxx.yyy.zzz.AbcParam';
};

// 自動生成するReturnクラスにimplementsするインターフェースを指定する。
remoteApiRule.returnImplementsClasses = function(api, properties) {
    // api、propertiesの内容によって変えることも可能
    return 'xxx.yyy.zzz.AbcReturn';
};

// 自動生成するReturnクラスのSuffixを変更する。
remoteApiRule.returnClassName = function(api, detail) {
    return baseRule.returnClassName(api).replace(/Return$/g, 'Xxx');
},

// 自動生成するParam/Returnクラスのネストクラスの名前を調整する。
remoteApiRule.nestClassName = function(api, className) {
    return className.replace(/Xxx$/, '') + 'Yyy';
    // 以下はデフォルト設定。
    // lastafluteの推奨suffixのPart、Spring MVCの推奨suffixのModel、Javaの一般的なsuffixのBeanを除去して、Partをsuffixにつける。
    // ※Resultの除去は互換性のために残しています。
    // return className.replace(/(Part|Result|Model|Bean)$/, '') + 'Part';
};

// 自動生成するParam/Returnクラスのフィールドを調整する。
remoteApiRule.targetField = function(api, topLevelBean, jsonFieldName) {
    return ['fieldNotGenerated'].indexOf(jsonFieldName) === -1;
}

// =======================================================================================
//                                                                                  Option
//                                                                                  ======
// 自動生成ファイルのimprot宣言の順番を調整する。
remoteApiRule.importOrderList = function() {
    return ['java', 'javax', 'junit', 'org', 'com', 'net', 'ognl', 'mockit', 'jp'];
},

// リクエストやレスポンスの各フィールド名を調整する。
// デフォルトは、小文字スネークケースからキャメルケースに変換して自動生成する。
// 変換しないようにする場合は、this.FIELD_NAMING.CAMEL_TO_LOWER_SNAKEをnullにしてください。
remoteApiRule.fieldNamingMapping = function() {
    return {
        'path': this.FIELD_NAMING.CAMEL_TO_LOWER_SNAKE,
        'query': this.FIELD_NAMING.CAMEL_TO_LOWER_SNAKE,
        'formData': this.FIELD_NAMING.CAMEL_TO_LOWER_SNAKE,
        'json': this.FIELD_NAMING.CAMEL_TO_LOWER_SNAKE,
        'xml': this.FIELD_NAMING.CAMEL_TO_LOWER_SNAKE
    };
},

// -----------------------------------------------------
//                                          Type Mapping
//                                          ------------
// swagger.jsonの型とJavaの型を調整する。
remoteApiRule.typeMap = function() {
    var typeMap = baseRule.typeMap();
    // 配列(リスト)のマッピングを、java.util.ListからEclipse CollectionsのImmutableListに変更。
    typeMap['array'] = 'org.eclipse.collections.api.list.ImmutableList';
    // 日時のマッピングを、java.time.LocalDateTimeからjava.time.ZonedDateTimeに変更。    
    typeMap['date-time'] = 'java.time.ZonedDateTime';
    return typeMap;
};

// -----------------------------------------------------
//                                              clean up
//                                              --------
// 自動生成後のファイルのクリーンアップ(削除)対象を調整する。
// @since 2019/11/31 ファイルの中身に「 @author FreeGen」が含まれるファイルがクリーンアップ(削除)対象になります。
remoteApiRule.deleteTarget = function(request, file) {
    // 標準の動きで問題がある場合は、条件を足してください。
	return baseRule.deleteTarget(request, file) && xxx;
};
