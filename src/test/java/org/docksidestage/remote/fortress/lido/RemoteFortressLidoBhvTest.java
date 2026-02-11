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
package org.docksidestage.remote.fortress.lido;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.lido.auth.signin.RemoteLidoAuthSigninParam;
import org.docksidestage.remote.fortress.lido.auth.signup.RemoteLidoAuthSignupParam;
import org.docksidestage.remote.fortress.lido.following.delete.RemoteLidoFollowingDeleteParam;
import org.docksidestage.remote.fortress.lido.following.delete.RemoteLidoFollowingDeleteReturn;
import org.docksidestage.remote.fortress.lido.following.list.RemoteLidoFollowingListParam;
import org.docksidestage.remote.fortress.lido.following.list.RemoteLidoFollowingListReturn;
import org.docksidestage.remote.fortress.lido.following.register.RemoteLidoFollowingRegisterParam;
import org.docksidestage.remote.fortress.lido.following.register.RemoteLidoFollowingRegisterReturn;
import org.docksidestage.remote.fortress.lido.mypage.RemoteLidoMypageReturn;
import org.docksidestage.remote.fortress.lido.product.detail.RemoteLidoProductDetailReturn;
import org.docksidestage.remote.fortress.lido.product.list.RemoteLidoProductListParam;
import org.docksidestage.remote.fortress.lido.product.list.RemoteLidoProductListReturn;
import org.docksidestage.remote.fortress.lido.product.price.update.RemoteLidoProductPriceUpdateParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of lido.
 * @author FreeGen
 */
public class RemoteFortressLidoBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressLidoBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestAuthSignin() {
        // ## Arrange ##
        Consumer<RemoteLidoAuthSigninParam> paramLambda = param -> {
            param.account = "account";
            param.password = "password";
        };

        // ## Act ##
        createBhv(null).requestAuthSignin(paramLambda);
    }

    public void test_requestAuthSignout() {
        // ## Act ##
        createBhv(null).requestAuthSignout();
    }

    public void test_requestAuthSignup() {
        // ## Arrange ##
        Consumer<RemoteLidoAuthSignupParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.password = "password";
            param.reminderQuestion = "reminderQuestion";
            param.reminderAnswer = "reminderAnswer";
        };

        // ## Act ##
        createBhv(null).requestAuthSignup(paramLambda);
    }

    public void test_requestAuthRegister() {
        // ## Arrange ##
        String account = "account";
        String token = "token";

        // ## Act ##
        createBhv(null).requestAuthRegister(account, token);
    }

    public void test_requestFollowingList() {
        // ## Arrange ##
        Consumer<RemoteLidoFollowingListParam> paramLambda = param -> {
            param.limit = 1;
            param.memberPrefix = "memberPrefix";
            param.fromPurchasePrice = 1;
            param.livesChiba = Boolean.TRUE;
        };

        // ## Act ##
        RemoteLidoFollowingListReturn returnBean = createBhv("{}").requestFollowingList(paramLambda);

        // ## Assert ##
        logger.debug("followings={}", returnBean.followings);
        if (returnBean.followings != null) {
            returnBean.followings.forEach(following -> {
                logger.debug("followings.memberId={}", following.memberId);
                logger.debug("followings.memberName={}", following.memberName);
                logger.debug("followings.memberStatusCode={}", following.memberStatusCode);
            });
        }
        logger.debug("followers={}", returnBean.followers);
        if (returnBean.followers != null) {
            returnBean.followers.forEach(follower -> {
                logger.debug("follower.memberId={}", follower.memberId);
                logger.debug("follower.memberName={}", follower.memberName);
                logger.debug("follower.memberStatusCode={}", follower.memberStatusCode);
            });
        }
    }

    public void test_requestFollowingRegister() {
        // ## Arrange ##
        Consumer<RemoteLidoFollowingRegisterParam> paramLambda = param -> {
            param.myMemberId = 1;
            param.yourMemberId = 1;
        };

        // ## Act ##
        RemoteLidoFollowingRegisterReturn returnBean = createBhv("{}").requestFollowingRegister(paramLambda);

        // ## Assert ##
        logger.debug("followingCount={}", returnBean.followingCount);
    }

    public void test_requestFollowingDelete() {
        // ## Arrange ##
        Consumer<RemoteLidoFollowingDeleteParam> paramLambda = param -> {
            param.myMemberId = 1;
            param.yourMemberId = 1;
        };

        // ## Act ##
        RemoteLidoFollowingDeleteReturn returnBean = createBhv("{}").requestFollowingDelete(paramLambda);

        // ## Assert ##
        logger.debug("followingCount={}", returnBean.followingCount);
    }

    public void test_requestMypage() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteLidoMypageReturn> list = createBhv("[]").requestMypage();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("productName={}", returnBean.productName);
            logger.debug("regularPrice={}", returnBean.regularPrice);
        });
    }

    public void test_requestProductDetail() {
        // ## Arrange ##
        Integer productId = 1;

        // ## Act ##
        RemoteLidoProductDetailReturn returnBean = createBhv("{}").requestProductDetail(productId);

        // ## Assert ##
        logger.debug("productId={}", returnBean.productId);
        logger.debug("productName={}", returnBean.productName);
        logger.debug("categoryName={}", returnBean.categoryName);
        logger.debug("regularPrice={}", returnBean.regularPrice);
        logger.debug("productHandleCode={}", returnBean.productHandleCode);
    }

    public void test_requestProductList() {
        // ## Arrange ##
        Consumer<RemoteLidoProductListParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        RemoteLidoProductListReturn returnBean = createBhv("{}").requestProductList(paramLambda);

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
                logger.debug("row.productStatusName={}", row.productStatusName);
                logger.debug("row.regularPrice={}", row.regularPrice);
                logger.debug("row.popular={}", row.popular);
                logger.debug("row.purchaseDate={}", row.purchaseDate);
            });
        }
    }

    public void test_requestProductListPageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteLidoProductListParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        RemoteLidoProductListReturn returnBean = createBhv("{}").requestProductList(pageNumber, paramLambda);

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
                logger.debug("row.productStatusName={}", row.productStatusName);
                logger.debug("row.regularPrice={}", row.regularPrice);
                logger.debug("row.popular={}", row.popular);
                logger.debug("row.purchaseDate={}", row.purchaseDate);
            });
        }
    }

    public void test_requestProductPriceUpdate() {
        // ## Arrange ##
        Integer productId = 1;
        Consumer<RemoteLidoProductPriceUpdateParam> paramLambda = param -> {
            param.regularPrice = 1;
        };

        // ## Act ##
        createBhv(null).requestProductPriceUpdate(productId, paramLambda);
    }

    private RemoteFortressLidoBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressLidoBhv bhv = new RemoteFortressLidoBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
