// Based on ECMAScript5. Because Nashorn of java 8 is ECMAScript5.
// =======================================================================================
//                                                                              Definition
//                                                                              ==========

var remoteApiLogic = {

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
    /**
     * Return indent.
     * indent has 4 spaces.
     * @param {number} indentSize indent size.
     * @return {string} indent. (NotNull)
     */
    indent: function(indentSize) {
        // #for_now I want to set the initial value of indent to 0 size. by p1us2er0 (2022/05/04)
        // but it is not possible at this time due to a processing problem on the vm side.
        // Organize when refactoring the vm.
        var indent = '    ';
        for (var index = 0; index < indentSize; index++) {
            indent += '    ';
        }
        return indent;
    },

    /**
     * Optimizes and returns the import class list.
     * Unique and sort import class list. And return the import class list separated by top package.
     * @param {string[]} importClassList The list of import class(with package).
     * @param {string} currentPackage Package name of the class to declare import.
     * @param {string[]} importTopPackageOrderList The order list of top packages of import.
     * @return {string[][]} import class list separated by top package. (NotNull)
     */
    optimizeImportClassList: function(importClassList, currentPackage, importTopPackageOrderList) {
        // Unique importClass.
        var uniqueImportClassList = new java.util.ArrayList(new java.util.HashSet(importClassList));

        // Sort importClass.
        uniqueImportClassList.sort(function(preImportClass, currentImportClass) {
            // Sort at the top of the importClass package name.
            // Use importTopPackageOrderList. e.g. java, javax, junit, org, com ...
            preImportTopPackageOrderIndex = Number.MAX_VALUE;
            currentImportTopPackageOrderIndex = Number.MAX_VALUE;
            importTopPackageOrderList.forEach(function(importTopPackageOrder, importTopPackageOrderIndex) {
                if (importTopPackageOrder === preImportClass.substring(0, preImportClass.indexOf('.'))) {
                    preImportTopPackageOrderIndex = importTopPackageOrderIndex;
                }
                if (importTopPackageOrder === currentImportClass.substring(0, currentImportClass.indexOf('.'))) {
                    currentImportTopPackageOrderIndex = importTopPackageOrderIndex;
                }
            });

            if (preImportTopPackageOrderIndex != currentImportTopPackageOrderIndex) {
                return preImportTopPackageOrderIndex > currentImportTopPackageOrderIndex ? 1 : -1;
            }

            // Sort at the importClass package name.
            var prePackage = preImportClass.substring(0, preImportClass.lastIndexOf('.'));
            var currentPackage = currentImportClass.substring(0, currentImportClass.lastIndexOf('.'));
            var packageCompare = prePackage.localeCompare(currentPackage);
            if (packageCompare !== 0) {
                return packageCompare;
            }

            // Sort at the importClass class name.
            var preClass = preImportClass.substring(preImportClass.lastIndexOf('.'));
            var currentClass = currentImportClass.substring(currentImportClass.lastIndexOf('.'));
            var classCompare = preClass.localeCompare(currentClass);
            return classCompare;
        });

        // Assemble an import declaration.
        var optimizedImportClassList = [];
        var keepTopPackage = '';
        uniqueImportClassList.forEach(function(importClass) {
            // If importClass is the same as currentPackage, skip. (Because no import declaration is required).
            if (importClass.substring(0, importClass.lastIndexOf('.')) === currentPackage) {
                return;
            }

            // If the top Package changes, insert a blank line.
            if (importClass.substring(0, importClass.indexOf('.')) != keepTopPackage) {
                keepTopPackage = importClass.substring(0, importClass.indexOf('.'));
                optimizedImportClassList.push([]);
            }
            optimizedImportClassList[optimizedImportClassList.length - 1].push(importClass);
        });

        return optimizedImportClassList;
    }
};
