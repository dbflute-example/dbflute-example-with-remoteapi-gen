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
package org.docksidestage.remote.fortress.products.purchases;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.products.purchases.index.RemoteProductsProductidPurchasesPurchaseidReturn;
import org.docksidestage.remote.fortress.products.purchases.index.RemoteProductsPurchasesParam;
import org.docksidestage.remote.fortress.products.purchases.index.RemoteProductsPurchasesReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of products.purchases.
 * @author FreeGen
 */
public class RemoteFortressProductsPurchasesBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressProductsPurchasesBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Arrange ##
        Integer productId = 1;
        Consumer<RemoteProductsPurchasesParam> paramLambda = param -> {
            param.memberName = "memberName";
        };

        // ## Act ##
        RemoteProductsPurchasesReturn returnBean = createBhv("{}").requestGet(productId, paramLambda);

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

    public void test_requestGetPurchaseIdPurchaseId() {
        // ## Arrange ##
        Integer productId = 1;
        Long purchaseId = 1L;

        // ## Act ##
        RemoteProductsProductidPurchasesPurchaseidReturn returnBean = createBhv("{}").requestGet(productId, purchaseId);

        // ## Assert ##
        logger.debug("purchaseId={}", returnBean.purchaseId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("productName={}", returnBean.productName);
    }

    private RemoteFortressProductsPurchasesBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressProductsPurchasesBhv bhv = new RemoteFortressProductsPurchasesBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
