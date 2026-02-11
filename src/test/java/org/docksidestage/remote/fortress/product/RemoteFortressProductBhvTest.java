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
package org.docksidestage.remote.fortress.product;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.product.list.RemoteProductListPagenumberParam;
import org.docksidestage.remote.fortress.product.list.RemoteProductListParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The behavior test for remote API of product.
 * @author FreeGen
 */
public class RemoteFortressProductBhvTest extends UnitRemoteapigenTestCase {

    @Resource
    private RequestManager requestManager;

    public void test_requestDetail() {
        // ## Arrange ##
        Integer productId = 1;

        // ## Act ##
        createBhv(null).requestDetail(productId);
    }

    public void test_requestList() {
        // ## Arrange ##
        Consumer<RemoteProductListParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestList(paramLambda);
    }

    public void test_requestListPageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteProductListPagenumberParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestList(pageNumber, paramLambda);
    }

    private RemoteFortressProductBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressProductBhv bhv = new RemoteFortressProductBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
