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
package org.docksidestage.remote.maihama.showbase.withdrawal;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.withdrawal.done.RemoteWithdrawalDoneParam;
import org.docksidestage.remote.maihama.showbase.withdrawal.reason.RemoteWithdrawalReasonReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of withdrawal.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseWithdrawalBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseWithdrawalBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestReason() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWithdrawalReasonReturn> list = createBhv("[]").requestReason();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("key={}", returnBean.key);
            logger.debug("value={}", returnBean.value);
        });
    }

    public void test_requestDone() {
        // ## Arrange ##
        Consumer<RemoteWithdrawalDoneParam> paramLambda = param -> {
            param.selectedReason = org.docksidestage.dbflute.allcommon.CDef.WithdrawalReason.codeOf("SIT");
            param.reasonInput = "reasonInput";
        };

        // ## Act ##
        Integer returnBean = createBhv("1").requestDone(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    private RemoteMaihamaShowbaseWithdrawalBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseWithdrawalBhv bhv = new RemoteMaihamaShowbaseWithdrawalBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
