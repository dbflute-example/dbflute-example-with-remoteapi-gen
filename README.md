DBFlute Example with remoteapi-gen
=======================
example project for DBFlute with remoteapi-gen

# For RemoteApiGen users

## How to use RemoteApiGen
1. Download remoteapigen-freegen.zip from release tag
2. extract it and locate it under your freegen directory  
(if old version module exists, replace it)
3. [How to use RemoteApiGen](dbflute_maihamadb/freegen/remoteapi/README.md)


```
dbflute_[appdb]
 |-dfprop
 |-...
 |-freegen
 | |-remoteapi // locate it here
 | |  |-container
 | |  |-doc
 | |  |-ControlFreeGenRemoteApiJava.js
 | |  |-...
 | |  |-freegen-module.properties
 | |  |-...
 | |
 | |-ControlFreeGen.vm
```

# For committers or contributors

## Release Engineering

### Github release
1. Remove snapshot version for release at freegen-module.properties
2. Add tag on release commit
3. Edit tag and upload "remoteapigen-freegen.zip"
4. Publish tag to release
5. Increment version as snapshot for next version development

How to make remoteapigen-freegen.zip:

```
freegen
 |-remoteapi // zip this directory
 |  |-container
 |  |-doc
 |  |-ControlFreeGenRemoteApiJava.js
 |  |-...
```  
