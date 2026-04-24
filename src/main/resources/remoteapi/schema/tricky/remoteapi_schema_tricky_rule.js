// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
// RemoteApiGen your rule settings as ECMAScript5 (related to RemoteApiRule.js in freegen)
// _/_/_/_/_/_/_/_/_/_/

// ===================================================================================
//                                                                  Param/Return(base)
//                                                                  ==================
// -----------------------------------------------------
//                                            Bean Field
//                                            ----------
// test of #9 Limit the generation target of property of bean of Param and return.
// @Override
remoteApiRule.targetField = function(api, topLevelBean, jsonFieldName) {
  return ['fieldNotGenerated'].indexOf(jsonFieldName) === -1;
}

// test of #5 Derived from swagger field name to java field name (add @SerializedName) 
// @Override
remoteApiRule.fieldName = function(api, topLevelBean, jsonFieldName) {
  // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
  // ここでの super 呼び出しの前提:
  // o ストレートに super を呼び出した場合: キャメル変換される
  // o bind(this) で super を呼び出した場合: キャメル変換されない
  //   (custom rule側で fieldNamingMapping() を空っぽオーバーライドしているから)
  //
  // これらをテストケース (url) によって使い分ける。
  // _/_/_/_/_/_/_/_/
  if (api.url.contains('/ngchar/')) {
    // アスタリスクやハイフンなどの変数名で使えないものを_にしたり、先頭の数字をアルファベットに変えたり。
    var customName = jsonFieldName.replace(/[*-]/, '_').replace(/^1/, 'one');
    return baseRule.fieldName(api, topLevelBean, customName); // superのまま呼んでキャメル変換もする
  } else if (api.url.contains('/noconv/')) {
    // ケース混在のケースなので、キャメル変換させずまんまの形で表現させるために、
    // bind(this)によりcustom rule側の fieldNamingMapping() 呼ぶようにする。
    // (custom rule側では、無変換を実現するオーバーライドをしていること前提)
    return baseRule.fieldName.bind(this)(api, topLevelBean, jsonFieldName);

  // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
  // 数字キャメル問題: sea_land_1 が seaLand1 になって、Gsonの逆キャメルで sea_land1 になっちゃう。
  // _/_/_/_/_/_/_/_/
  } else if (api.url.contains('/numbercamel/') && api.httpMethod === 'get') {
    // 回避策1: 数字をアルファベットにしてしまう。
    var customName = jsonFieldName
        .replace(/1/, 'one').replace(/2/, 'two').replace(/3/, 'three').replace(/4/, 'four').replace(/5/, 'five')
        .replace(/6/, 'six').replace(/7/, 'seven').replace(/8/, 'eight').replace(/9/, 'nine');
    return baseRule.fieldName(api, topLevelBean, customName); // superを呼んでキャメル変換もする
  } else if (api.url.contains('/numbercamel/') && api.httpMethod === 'post') {
    // 回避策2: ケース変換しない、Java上でスネークケースのインスタンス変数名を許容する。
    // Lasta RemoteApi の LaJsonSender の JsonMappingOption にて、FieldNaming を IDENTITY にすること。
    // 未指定でもデフォルトでは IDENTITY になるが、アプリ側でデフォルトを変えている可能性もあるので。
    var customName = jsonFieldName.replace(/^3/, 'three'); // 先頭数字だけアルファベット変換 (テストケースとしてたまたま)
    return baseRule.fieldName.bind(this)(api, topLevelBean, customName); // キャメル変換しないようにbind
  } else if (api.url.contains('/numbercamel/') && api.httpMethod === 'put') {
    // まんまキャメルケースにするとこうなるのパターン。
    // #for_now jflute 回避策3何かあるかな？ (2026/04/02)
    var customName = jsonFieldName.replace(/^3/, 'three'); // 先頭数字だけアルファベット変換 (テストケースとしてたまたま)
    return baseRule.fieldName(api, topLevelBean, customName) // superを呼んでキャメル変換もする
  } else {
    // デフォルトでは super側の fieldNamingMapping を呼び出してキャメル変換ありにする。
    // (ここはどっちでもいい。テストケースの都合でまた変えるかも) (2026/04/24)
    return baseRule.fieldName(api, topLevelBean, jsonFieldName);
  }
}


// -----------------------------------------------------
//                                             Nest Bean
//                                             ---------
// test of suffix hell e.g. result result headache
remoteApiRule.nestClassName = function(api, className) {
  // For example, remote side uses Spring Framework
  return className.replace(/(Part|Model|Bean)$/, '') + 'Part';
}


// ===================================================================================
//                                                                              Option
//                                                                              ======
// test of no case conversion
// @Override
remoteApiRule.fieldNamingMapping = function() {
  // キャメルケース変換を一切しないのをcustom rule側のデフォルトとする。
  // fieldName() のオーバーライドにて、super の fieldName() を呼ばないようにするやり方だと、
  // super側にキャメルケースとは別の変換処理が入った時に追従できないので、
  // あくまで fieldNamingMapping() のオーバーライドで無変換を表現するパターン。
  return { // empty means no conversion at all parts
  };
}
