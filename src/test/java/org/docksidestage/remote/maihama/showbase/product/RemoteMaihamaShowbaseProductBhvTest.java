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
package org.docksidestage.remote.maihama.showbase.product;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.product.detail.RemoteProductDetailReturn;
import org.docksidestage.remote.maihama.showbase.product.list.search.RemoteProductListSearchParam;
import org.docksidestage.remote.maihama.showbase.product.list.search.RemoteProductListSearchReturn;
import org.docksidestage.remote.maihama.showbase.product.list.status.RemoteProductListStatusReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of product.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseProductBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseProductBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestDetail() {
        // ## Arrange ##
        Integer productId = 1;

        // ## Act ##
        RemoteProductDetailReturn returnBean = createBhv("{}").requestDetail(productId);

        // ## Assert ##
        logger.debug("productId={}", returnBean.productId);
        logger.debug("productName={}", returnBean.productName);
        logger.debug("categoryName={}", returnBean.categoryName);
        logger.debug("regularPrice={}", returnBean.regularPrice);
        logger.debug("productHandleCode={}", returnBean.productHandleCode);
    }

    public void test_requestListSearch() {
        // ## Arrange ##
        Consumer<RemoteProductListSearchParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        RemoteProductListSearchReturn returnBean = createBhv("{}").requestListSearch(paramLambda);

        // ## Assert ##
        logger.debug("pageSize={}", returnBean.pageSize);
        logger.debug("currentPageNumber={}", returnBean.currentPageNumber);
        logger.debug("allRecordCount={}", returnBean.allRecordCount);
        logger.debug("allPageCount={}", returnBean.allPageCount);
        logger.debug("rows={}", returnBean.rows);
        if (returnBean.rows != null) {
            returnBean.rows.forEach(row -> {
                logger.debug("row.productId={}", row.productId);
                logger.debug("row.productName={}", row.productName);
                logger.debug("row.productStatus={}", row.productStatus);
                logger.debug("row.productCategory={}", row.productCategory);
                logger.debug("row.regularPrice={}", row.regularPrice);
                logger.debug("row.latestPurchaseDate={}", row.latestPurchaseDate);
            });
        }
    }

    public void test_requestListSearchPageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteProductListSearchParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        RemoteProductListSearchReturn returnBean = createBhv("{}").requestListSearch(pageNumber, paramLambda);

        // ## Assert ##
        logger.debug("pageSize={}", returnBean.pageSize);
        logger.debug("currentPageNumber={}", returnBean.currentPageNumber);
        logger.debug("allRecordCount={}", returnBean.allRecordCount);
        logger.debug("allPageCount={}", returnBean.allPageCount);
        logger.debug("rows={}", returnBean.rows);
        if (returnBean.rows != null) {
            returnBean.rows.forEach(row -> {
                logger.debug("row.productId={}", row.productId);
                logger.debug("row.productName={}", row.productName);
                logger.debug("row.productStatus={}", row.productStatus);
                logger.debug("row.productCategory={}", row.productCategory);
                logger.debug("row.regularPrice={}", row.regularPrice);
                logger.debug("row.latestPurchaseDate={}", row.latestPurchaseDate);
            });
        }
    }

    public void test_requestListStatus() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteProductListStatusReturn> list = createBhv("[]").requestListStatus();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("key={}", returnBean.key);
            logger.debug("value={}", returnBean.value);
        });
    }

    private RemoteMaihamaShowbaseProductBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseProductBhv bhv = new RemoteMaihamaShowbaseProductBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
