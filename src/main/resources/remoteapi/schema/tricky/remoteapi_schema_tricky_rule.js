// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
// RemoteApiGen your rule settings as ECMAScript5 (related to RemoteApiRule.js in freegen)
// _/_/_/_/_/_/_/_/_/_/
// =======================================================================================
//                                                                                  Option
//                                                                                  ======
//
// -----------------------------------------------------
//                                          Field Naming
//                                          ------------
// test of no case conversion
// #hope only specify at /fieldcase/noconv/ by jflute
// @Override
remoteApiRule.fieldNamingMapping = function() {
  return { // empty means no conversion at all parts
  };
}

// test of #9 Limit the generation target of property of bean of Param and return.
// @Override
remoteApiRule.targetField = function(api, topLevelBean, jsonFieldName) {
  return ['fieldNotGenerated'].indexOf(jsonFieldName) === -1;
}

// test of #5 Derived from swagger field name to java field name (add @SerializedName) 
// @Override
remoteApiRule.fieldName = function(api, topLevelBean, jsonFieldName) {
  // いったん元のサンプルを維持するために、bind(this) したりしなかったり
  if (api.url.contains('/ngchar/')) {
    // アスタリスクやハイフンなどの変数名で使えないものを_にしたり、先頭の数字をアルファベットに変えたり。
    var customName = jsonFieldName.replace(/[*-]/, '_').replace(/^1/, 'one');
    return baseRule.fieldName(api, topLevelBean, customName);
  } else if (api.url.contains('/noconv/')) {
    // ケース混在のケースなので、キャメル変換させずまんまの形で表現させるために super 側を呼ばない。
    return jsonFieldName;

  // _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
  // 数字キャメル問題: sea_land_1 が seaLand1 になって、Gsonの逆キャメルで sea_land1 になっちゃう。
  // _/_/_/_/_/_/_/_/
  } else if (api.url.contains('/numbercamel/') && api.httpMethod === 'get') {
    // 回避策1: 数字をアルファベットにしてしまう。
    var customName = jsonFieldName
        .replace(/1/, 'one').replace(/2/, 'two').replace(/3/, 'three').replace(/4/, 'four').replace(/5/, 'five')
        .replace(/6/, 'six').replace(/7/, 'seven').replace(/8/, 'eight').replace(/9/, 'nine');
    return baseRule.fieldName(api, topLevelBean, customName);
  } else if (api.url.contains('/numbercamel/') && api.httpMethod === 'post') {
    // 回避策2: ケース変換しない、Java上でスネークケースのインスタンス変数名を許容する。
    // Lasta RemoteApi の LaJsonSender の JsonMappingOption にて、FieldNaming を IDENTITY にすること。
    // 未指定でもデフォルトでは IDENTITY になるが、アプリ側でデフォルトを変えている可能性もあるので。
    return jsonFieldName.replace(/^3/, 'three'); // 先頭数字だけアルファベット変換 (テストケースとしてたまたま)
  } else if (api.url.contains('/numbercamel/') && api.httpMethod === 'put') {
    // まんまキャメルケースにするとこうなるのパターン。
    // #for_now jflute 回避策3何かあるかな？ (2026/04/02)
    var customName = jsonFieldName.replace(/^3/, 'three'); // 先頭数字だけアルファベット変換 (テストケースとしてたまたま)
    return baseRule.fieldName(api, topLevelBean, customName)
  } else {
    // #for_now jflute 元のテストが bind(this) で、super側のキャメル変換を抑制していたのでとりあえずそのまま (2026/04/02)
    return baseRule.fieldName.bind(this)(api, topLevelBean, jsonFieldName);
  }
}

// test of suffix hell e.g. result result headache
remoteApiRule.nestClassName = function(api, className) {
  // For example, remote side uses Spring Framework
  return className.replace(/(Part|Model|Bean)$/, '') + 'Part';
}
