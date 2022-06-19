/*
 * Copyright 2017-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.remote.tricky.schemaallof;

import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.util.DfCollectionUtil;
import org.dbflute.util.DfReflectionUtil;
import org.docksidestage.remote.tricky.schemaallof.simple.RemoteSchemaallofSimpleParam;
import org.docksidestage.remote.tricky.schemaallof.simple.RemoteSchemaallofSimpleReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.docksidestage.unit.helper.MockSupposedRequestHelper;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of schemaallof.
 * @author FreeGen
 */
public class RemoteTrickySchemaallofBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteTrickySchemaallofBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestSimple() {
        // ## Arrange ##
        Consumer<RemoteSchemaallofSimpleParam> paramLambda = param -> {
            param.allofProperty = new RemoteSchemaallofSimpleParam.SchemaallofSimpleSeaIdPart();
            param.allofProperty.seaId = 1;
        };
        Map<String, Object> returnMap = DfCollectionUtil.newLinkedHashMap();
        returnMap.put("allofProperty", DfCollectionUtil.newLinkedHashMap("seaId", 1));

        // ## Act ##
        RemoteSchemaallofSimpleReturn returnBean =
                createMockRemoteBehavior(() -> new RemoteTrickySchemaallofBhv(requestManager), returnMap, request -> {
                    new MockSupposedRequestHelper(requestManager, request).getJsonBody().alwaysPresent(jsonBody -> {
                        assertEquals("seaId", 1.0, ((Map<?, ?>) jsonBody.get("allofProperty")).get("seaId"));
                    });
                    return true;
                }).requestSimple(paramLambda);

        // ## Assert ##
        logger.debug("allofProperty.allofProperty={}", returnBean.allofProperty.seaId);

        assertEquals("allofProperty.allofProperty", ((Map<?, ?>) returnMap.get("allofProperty")).get("seaId"),
                returnBean.allofProperty.seaId);

        // p1us2er0 #9 Limit the generation target of property of bean of Param and return. (2022/06/19)
        assertNull(DfReflectionUtil.getPublicField(RemoteSchemaallofSimpleParam.SchemaallofSimpleSeaIdPart.class, "fieldNotGenerated"));
        assertNull(DfReflectionUtil.getPublicField(RemoteSchemaallofSimpleReturn.SchemaallofSimpleSeaIdPart.class, "fieldNotGenerated"));
    }
}
