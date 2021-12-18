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
package org.docksidestage.remote.maihama.showbase.products;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.products.index.RemoteProductsGetParam;
import org.docksidestage.remote.maihama.showbase.products.index.RemoteProductsGetReturn;
import org.docksidestage.remote.maihama.showbase.products.index.RemoteProductsPostParam;
import org.docksidestage.remote.maihama.showbase.products.index.RemoteProductsProductidGetReturn;
import org.docksidestage.remote.maihama.showbase.products.index.RemoteProductsPutParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of products.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseProductsBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseProductsBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Arrange ##
        Consumer<RemoteProductsGetParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteProductsGetReturn> list = createBhv("[]").requestGet(paramLambda);

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

    public void test_requestPost() {
        // ## Arrange ##
        Consumer<RemoteProductsPostParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.values()[0];
            param.productCategory = "productCategory";
            param.regularPrice = 1;
        };

        // ## Act ##
        createBhv(null).requestPost(paramLambda);
    }

    public void test_requestGetProductId() {
        // ## Arrange ##
        Integer productId = 1;

        // ## Act ##
        RemoteProductsProductidGetReturn returnBean = createBhv("{}").requestGet(productId);

        // ## Assert ##
        logger.debug("productId={}", returnBean.productId);
        logger.debug("productName={}", returnBean.productName);
        logger.debug("productStatus={}", returnBean.productStatus);
        logger.debug("pastProductStatuses={}", returnBean.pastProductStatuses);
        if (returnBean.pastProductStatuses != null) {
            returnBean.pastProductStatuses.forEach(pastProductStatuse -> {
                logger.debug("pastProductStatuse={}", pastProductStatuse);
            });
        }
        logger.debug("purchasedMemberIds={}", returnBean.purchasedMemberIds);
        if (returnBean.purchasedMemberIds != null) {
            returnBean.purchasedMemberIds.forEach(purchasedMemberId -> {
                logger.debug("purchasedMemberId={}", purchasedMemberId);
            });
        }
        logger.debug("productCategory={}", returnBean.productCategory);
        logger.debug("regularPrice={}", returnBean.regularPrice);
        logger.debug("latestPurchaseDate={}", returnBean.latestPurchaseDate);
    }

    public void test_requestPut() {
        // ## Arrange ##
        Integer productId = 1;
        Consumer<RemoteProductsPutParam> paramLambda = param -> {
            param.productId = 1;
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.values()[0];
            param.productCategory = "productCategory";
            param.regularPrice = 1;
        };

        // ## Act ##
        createBhv(null).requestPut(productId, paramLambda);
    }

    public void test_requestDelete() {
        // ## Arrange ##
        Integer productId = 1;

        // ## Act ##
        createBhv(null).requestDelete(productId);
    }

    private RemoteMaihamaShowbaseProductsBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseProductsBhv bhv = new RemoteMaihamaShowbaseProductsBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
