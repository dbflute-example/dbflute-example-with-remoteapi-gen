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
package org.docksidestage.remote.maihama.showbase.signup;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.signup.index.RemoteSignupParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The behavior test for remote API of signup.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseSignupBhvTest extends UnitRemoteapigenTestCase {

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Arrange ##
        Consumer<RemoteSignupParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.password = "password";
            param.reminderQuestion = "reminderQuestion";
            param.reminderAnswer = "reminderAnswer";
        };

        // ## Act ##
        createBhv(null).request(paramLambda);
    }

    public void test_requestRegister() {
        // ## Arrange ##
        String account = "account";
        String token = "token";

        // ## Act ##
        createBhv(null).requestRegister(account, token);
    }

    private RemoteMaihamaShowbaseSignupBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseSignupBhv bhv = new RemoteMaihamaShowbaseSignupBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
