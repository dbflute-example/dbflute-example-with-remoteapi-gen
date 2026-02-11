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
package org.docksidestage.remote.fortress.withdrawal;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.withdrawal.confirm.RemoteWithdrawalConfirmParam;
import org.docksidestage.remote.fortress.withdrawal.done.RemoteWithdrawalDoneParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The behavior test for remote API of withdrawal.
 * @author FreeGen
 */
public class RemoteFortressWithdrawalBhvTest extends UnitRemoteapigenTestCase {

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Act ##
        createBhv(null).request();
    }

    public void test_requestConfirm() {
        // ## Arrange ##
        Consumer<RemoteWithdrawalConfirmParam> paramLambda = param -> {
            param.selectedReason = "selectedReason";
            param.reasonInput = "reasonInput";
        };

        // ## Act ##
        createBhv(null).requestConfirm(paramLambda);
    }

    public void test_requestDone() {
        // ## Arrange ##
        Consumer<RemoteWithdrawalDoneParam> paramLambda = param -> {
            param.selectedReason = "selectedReason";
            param.reasonInput = "reasonInput";
        };

        // ## Act ##
        createBhv(null).requestDone(paramLambda);
    }

    private RemoteFortressWithdrawalBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressWithdrawalBhv bhv = new RemoteFortressWithdrawalBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
