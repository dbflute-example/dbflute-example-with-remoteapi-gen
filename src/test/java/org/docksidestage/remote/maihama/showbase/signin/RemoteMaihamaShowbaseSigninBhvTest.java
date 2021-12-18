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
package org.docksidestage.remote.maihama.showbase.signin;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.signin.index.RemoteSigninParam;
import org.docksidestage.remote.maihama.showbase.signin.index.RemoteSigninReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of signin.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseSigninBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseSigninBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Arrange ##
        Consumer<RemoteSigninParam> paramLambda = param -> {
            param.account = "account";
            param.password = "password";
        };

        // ## Act ##
        RemoteSigninReturn returnBean = createBhv("{}").request(paramLambda);

        // ## Assert ##
        logger.debug("token={}", returnBean.token);
    }

    private RemoteMaihamaShowbaseSigninBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseSigninBhv bhv = new RemoteMaihamaShowbaseSigninBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
