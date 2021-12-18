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
package org.docksidestage.remote.fortress.products.purchases.sea;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.products.purchases.sea.index.RemoteProductsPurchasesSeaParam;
import org.docksidestage.remote.fortress.products.purchases.sea.index.RemoteProductsPurchasesSeaReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of products.purchases.sea.
 * @author FreeGen
 */
public class RemoteFortressProductsPurchasesSeaBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressProductsPurchasesSeaBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Arrange ##
        Integer productId = 1;
        Consumer<RemoteProductsPurchasesSeaParam> paramLambda = param -> {
            param.memberName = "memberName";
        };

        // ## Act ##
        RemoteProductsPurchasesSeaReturn returnBean = createBhv("{}").requestGet(productId, paramLambda);

        // ## Assert ##
        logger.debug("rows={}", returnBean.rows);
        if (returnBean.rows != null) {
            returnBean.rows.forEach(row -> {
                logger.debug("row.purchaseId={}", row.purchaseId);
                logger.debug("row.memberName={}", row.memberName);
                logger.debug("row.productName={}", row.productName);
            });
        }
    }

    private RemoteFortressProductsPurchasesSeaBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressProductsPurchasesSeaBhv bhv = new RemoteFortressProductsPurchasesSeaBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
