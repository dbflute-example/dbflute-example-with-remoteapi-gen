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
    var customJsonFieldName = jsonFieldName.replace(/[*-]/, '_').replace(/^1/, 'one');
    return baseRule.fieldName(api, topLevelBean, customJsonFieldName);
  } else if (api.url.contains('/numbercamel/')) {
    var customJsonFieldName = jsonFieldName.replace(/3/, 'three');
    return baseRule.fieldName(api, topLevelBean, customJsonFieldName);
  } else {
    // #for_now jflute 元のテストが bind(this) で、super側のキャメル変換を抑制していたのでとりあえずそのまま (2026/04/02)
    var customJsonFieldName = jsonFieldName;
    return baseRule.fieldName.bind(this)(api, topLevelBean, customJsonFieldName);
  }
}

// test of suffix hell e.g. result result headache
remoteApiRule.nestClassName = function(api, className) {
  // For example, remote side uses Spring Framework
  return className.replace(/(Part|Model|Bean)$/, '') + 'Part';
}
