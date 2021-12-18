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
package org.docksidestage.remote.petstore2.xxx.yyy.user;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.petstore2.xxx.yyy.user.index.RemoteUserReturn;
import org.docksidestage.remote.petstore2.xxx.yyy.user.login.RemoteUserLoginParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of user.
 * @author FreeGen
 */
public class RemotePetstore2XxxUserBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemotePetstore2XxxUserBhvTest.class);

    @Resource
    private RequestManager requestManager;

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

    public void test_request() {
        // ## Arrange ##
        String username = "username";

        // ## Act ##
        RemoteUserReturn returnBean = createBhv("{}").request(username);

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

    private RemotePetstore2XxxUserBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemotePetstore2XxxUserBhv bhv = new RemotePetstore2XxxUserBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
