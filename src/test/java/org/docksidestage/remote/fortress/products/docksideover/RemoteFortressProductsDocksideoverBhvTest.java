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
package org.docksidestage.remote.fortress.products.docksideover;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.products.docksideover.index.RemoteProductsDocksideoverParam;
import org.docksidestage.remote.fortress.products.docksideover.index.RemoteProductsDocksideoverReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of products.docksideover.
 * @author FreeGen
 */
public class RemoteFortressProductsDocksideoverBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressProductsDocksideoverBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Arrange ##
        Consumer<RemoteProductsDocksideoverParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteProductsDocksideoverReturn> list = createBhv("[]").requestGet(paramLambda);

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("productId={}", returnBean.productId);
            logger.debug("productName={}", returnBean.productName);
            logger.debug("productStatus={}", returnBean.productStatus);
            logger.debug("productCategory={}", returnBean.productCategory);
            logger.debug("regularPrice={}", returnBean.regularPrice);
            logger.debug("latestPurchaseDate={}", returnBean.latestPurchaseDate);
        });
    }

    private RemoteFortressProductsDocksideoverBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressProductsDocksideoverBhv bhv = new RemoteFortressProductsDocksideoverBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
