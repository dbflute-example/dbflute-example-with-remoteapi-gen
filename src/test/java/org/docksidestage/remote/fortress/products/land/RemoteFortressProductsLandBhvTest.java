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
package org.docksidestage.remote.fortress.products.land;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.products.land.index.RemoteProductsLandReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of products.land.
 * @author FreeGen
 */
public class RemoteFortressProductsLandBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressProductsLandBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Arrange ##
        Integer productId = 1;

        // ## Act ##
        RemoteProductsLandReturn returnBean = createBhv("{}").requestGet(productId);

        // ## Assert ##
        logger.debug("productId={}", returnBean.productId);
        logger.debug("productName={}", returnBean.productName);
        logger.debug("productStatus={}", returnBean.productStatus);
        logger.debug("productCategory={}", returnBean.productCategory);
        logger.debug("regularPrice={}", returnBean.regularPrice);
        logger.debug("latestPurchaseDate={}", returnBean.latestPurchaseDate);
    }

    private RemoteFortressProductsLandBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressProductsLandBhv bhv = new RemoteFortressProductsLandBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
