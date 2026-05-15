/*
 * Copyright 2017-2026 the original author or authors.
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
package org.docksidestage.remote.fortress.members;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.members.index.RemoteMembersDeleteParam;
import org.docksidestage.remote.fortress.members.index.RemoteMembersParam;
import org.docksidestage.remote.fortress.members.index.RemoteMembersPutParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of members.
 * @author FreeGen
 */
public class RemoteFortressMembersBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressMembersBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Act ##
        String returnBean = createBhv("mysticOneman").request();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestGet() {
        // ## Arrange ##
        Integer memberId = 1;

        // ## Act ##
        String returnBean = createBhv("mysticOneman").requestGet(memberId);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestPut() {
        // ## Arrange ##
        Integer memberId = 1;
        Consumer<RemoteMembersPutParam> paramLambda = param -> {
            param.memberId = 1;
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.typeFailureInteger = 1;
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.latestLoginDatetime = java.time.LocalDateTime.now();
            param.updateDatetime = java.time.LocalDateTime.now();
            param.previousStatus = "previousStatus";
            param.versionNo = 1L;
        };

        // ## Act ##
        String returnBean = createBhv("mysticOneman").requestPut(memberId, paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestDelete() {
        // ## Arrange ##
        Integer memberId = 1;
        Consumer<RemoteMembersDeleteParam> paramLambda = param -> {
            param.memberId = 1;
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.typeFailureInteger = 1;
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.latestLoginDatetime = java.time.LocalDateTime.now();
            param.updateDatetime = java.time.LocalDateTime.now();
            param.previousStatus = "previousStatus";
            param.versionNo = 1L;
        };

        // ## Act ##
        String returnBean = createBhv("mysticOneman").requestDelete(memberId, paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestPost() {
        // ## Arrange ##
        Consumer<RemoteMembersParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
        };

        // ## Act ##
        String returnBean = createBhv("mysticOneman").requestPost(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    private RemoteFortressMembersBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressMembersBhv bhv = new RemoteFortressMembersBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
