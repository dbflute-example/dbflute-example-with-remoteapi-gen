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
package org.docksidestage.remote.petstore.user;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.petstore.user.createwitharray.RemoteUserCreatewitharrayParam;
import org.docksidestage.remote.petstore.user.createwithlist.RemoteUserCreatewithlistParam;
import org.docksidestage.remote.petstore.user.index.RemoteUserGetReturn;
import org.docksidestage.remote.petstore.user.index.RemoteUserParam;
import org.docksidestage.remote.petstore.user.index.RemoteUserPutParam;
import org.docksidestage.remote.petstore.user.login.RemoteUserLoginParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of user.
 * @author FreeGen
 */
public class RemotePetstoreUserBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemotePetstoreUserBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Arrange ##
        Consumer<RemoteUserParam> paramLambda = param -> {
            param.id = 1L;
            param.username = "username";
            param.firstName = "firstName";
            param.lastName = "lastName";
            param.email = "email";
            param.password = "password";
            param.phone = "phone";
            param.userStatus = 1;
        };

        // ## Act ##
        createBhv(null).request(paramLambda);
    }

    public void test_requestCreatewitharray() {
        // ## Arrange ##
        Consumer<java.util.List<RemoteUserCreatewitharrayParam>> paramLambda = param -> {
            RemoteUserCreatewitharrayParam rowParam = new RemoteUserCreatewitharrayParam();
            rowParam.id = 1L;
            rowParam.username = "username";
            rowParam.firstName = "firstName";
            rowParam.lastName = "lastName";
            rowParam.email = "email";
            rowParam.password = "password";
            rowParam.phone = "phone";
            rowParam.userStatus = 1;
            param.add(rowParam);
        };

        // ## Act ##
        createBhv(null).requestCreatewitharray(paramLambda);
    }

    public void test_requestCreatewithlist() {
        // ## Arrange ##
        Consumer<java.util.List<RemoteUserCreatewithlistParam>> paramLambda = param -> {
            RemoteUserCreatewithlistParam rowParam = new RemoteUserCreatewithlistParam();
            rowParam.id = 1L;
            rowParam.username = "username";
            rowParam.firstName = "firstName";
            rowParam.lastName = "lastName";
            rowParam.email = "email";
            rowParam.password = "password";
            rowParam.phone = "phone";
            rowParam.userStatus = 1;
            param.add(rowParam);
        };

        // ## Act ##
        createBhv(null).requestCreatewithlist(paramLambda);
    }

    public void test_requestLogin() {
        // ## Arrange ##
        Consumer<RemoteUserLoginParam> paramLambda = param -> {
            param.username = "username";
            param.password = "password";
        };

        // ## Act ##
        String returnBean = createBhv("String").requestLogin(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestLogout() {
        // ## Act ##
        createBhv(null).requestLogout();
    }

    public void test_requestGet() {
        // ## Arrange ##
        String username = "username";

        // ## Act ##
        RemoteUserGetReturn returnBean = createBhv("{}").requestGet(username);

        // ## Assert ##
        logger.debug("id={}", returnBean.id);
        logger.debug("username={}", returnBean.username);
        logger.debug("firstName={}", returnBean.firstName);
        logger.debug("lastName={}", returnBean.lastName);
        logger.debug("email={}", returnBean.email);
        logger.debug("password={}", returnBean.password);
        logger.debug("phone={}", returnBean.phone);
        logger.debug("userStatus={}", returnBean.userStatus);
    }

    public void test_requestPut() {
        // ## Arrange ##
        String username = "username";
        Consumer<RemoteUserPutParam> paramLambda = param -> {
            param.id = 1L;
            param.username = "username";
            param.firstName = "firstName";
            param.lastName = "lastName";
            param.email = "email";
            param.password = "password";
            param.phone = "phone";
            param.userStatus = 1;
        };

        // ## Act ##
        createBhv(null).requestPut(username, paramLambda);
    }

    public void test_requestDelete() {
        // ## Arrange ##
        String username = "username";

        // ## Act ##
        createBhv(null).requestDelete(username);
    }

    private RemotePetstoreUserBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemotePetstoreUserBhv bhv = new RemotePetstoreUserBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
