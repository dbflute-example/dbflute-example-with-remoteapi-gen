// _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
// RemoteApiGen your rule settings as ECMAScript5 (related to RemoteApiRule.js in freegen)
// _/_/_/_/_/_/_/_/_/_/
// =======================================================================================
//                                                                                   Base
//                                                                                  ======
// @Override
remoteApiRule.schema = function(request) {
    return baseRule.schema(request) + 'Xxx';
}

// @Override
remoteApiRule.schemaPackage = function(schema) {
    return baseRule.schemaPackage(schema) + '.yyy';
}

// @Override
remoteApiRule.target = function(api) {
    return api.httpMethod === 'get';
}
    
// =======================================================================================
//                                                                            Param/Return
//                                                                            ============
remoteApiRule.beanExtendsDefinitionGeneration = true;

// =======================================================================================
//                                                                                  Option
//                                                                                  ======
// @Override
remoteApiRule.typeMap = function() {
    var typeMap = baseRule.typeMap();
    typeMap['array'] = 'org.eclipse.collections.api.list.ImmutableList';
    return typeMap;
}
