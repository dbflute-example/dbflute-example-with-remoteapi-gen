/*
 * Copyright 2017-2026 the original author or authors.
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
package org.docksidestage.remote.fortress.onparade;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.onparade.index.RemoteOnparadePagenumberParam;
import org.docksidestage.remote.fortress.onparade.index.RemoteOnparadeParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of onparade.
 * @author FreeGen
 */
public class RemoteFortressOnparadeBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressOnparadeBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Arrange ##
        Consumer<RemoteOnparadeParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
            param.nested = "nested";
            param.nestedList = org.eclipse.collections.impl.factory.Lists.immutable.of("nestedList");
            param.keyValues = "keyValues";
        };

        // ## Act ##
        String returnBean = createBhv("mysticOneman").request(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestPageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteOnparadePagenumberParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
            param.nested = "nested";
            param.nestedList = org.eclipse.collections.impl.factory.Lists.immutable.of("nestedList");
            param.keyValues = "keyValues";
        };

        // ## Act ##
        String returnBean = createBhv("mysticOneman").request(pageNumber, paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    private RemoteFortressOnparadeBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressOnparadeBhv bhv = new RemoteFortressOnparadeBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
