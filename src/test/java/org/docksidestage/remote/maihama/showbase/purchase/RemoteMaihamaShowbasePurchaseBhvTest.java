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
package org.docksidestage.remote.maihama.showbase.purchase;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.purchase.contract.RemotePurchaseContractParam;
import org.docksidestage.remote.maihama.showbase.purchase.contract.RemotePurchaseContractReturn;
import org.docksidestage.remote.maihama.showbase.purchase.count.RemotePurchaseCountParam;
import org.docksidestage.remote.maihama.showbase.purchase.count.RemotePurchaseCountReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of purchase.
 * @author FreeGen
 */
public class RemoteMaihamaShowbasePurchaseBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbasePurchaseBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestCount() {
        // ## Arrange ##
        Consumer<RemotePurchaseCountParam> paramLambda = param -> {
            param.productId = 1;
            param.purchaseCount = 1;
        };

        // ## Act ##
        RemotePurchaseCountReturn returnBean = createBhv("{}").requestCount(paramLambda);

        // ## Assert ##
        logger.debug("price={}", returnBean.price);
    }

    public void test_requestContract() {
        // ## Arrange ##
        Consumer<RemotePurchaseContractParam> paramLambda = param -> {
            param.productId = 1;
            param.purchaseCount = 1;
        };

        // ## Act ##
        RemotePurchaseContractReturn returnBean = createBhv("{}").requestContract(paramLambda);

        // ## Assert ##
        logger.debug("price={}", returnBean.price);
    }

    private RemoteMaihamaShowbasePurchaseBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbasePurchaseBhv bhv = new RemoteMaihamaShowbasePurchaseBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
