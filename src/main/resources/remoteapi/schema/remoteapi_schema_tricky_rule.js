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

// test of 
// @Override
remoteApiRule.targetField = function(api, topLevelBean, jsonFieldName) {
  return ['fieldNotGenerated'].indexOf(jsonFieldName) === -1;
}

// test of #5 Derived from swagger field name to java field name (add @SerializedName) 
// @Override
remoteApiRule.fieldName = function(api, topLevelBean, jsonFieldName) {
  customJsonFieldName = jsonFieldName.replace(/[*-]/, '').replace(/1/, 'one');
  return baseRule.fieldName.bind(this)(api, topLevelBean, customJsonFieldName);
}

// test of suffix hell e.g. result result headache
remoteApiRule.nestClassName = function(api, className) {
  // For example, remote side uses Spring Framework
  return className.replace(/(Part|Model|Bean)$/, '') + 'Part';
}
