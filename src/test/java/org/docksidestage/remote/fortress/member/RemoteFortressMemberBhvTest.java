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
package org.docksidestage.remote.fortress.member;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.member.add.register.RemoteMemberAddRegisterParam;
import org.docksidestage.remote.fortress.member.edit.update.RemoteMemberEditUpdateParam;
import org.docksidestage.remote.fortress.member.edit.withdrawal.RemoteMemberEditWithdrawalParam;
import org.docksidestage.remote.fortress.member.list.RemoteMemberListPagenumberParam;
import org.docksidestage.remote.fortress.member.list.RemoteMemberListParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The behavior test for remote API of member.
 * @author FreeGen
 */
public class RemoteFortressMemberBhvTest extends UnitRemoteapigenTestCase {

    @Resource
    private RequestManager requestManager;

    public void test_requestAdd() {
        // ## Act ##
        createBhv(null).requestAdd();
    }

    public void test_requestAddRegister() {
        // ## Arrange ##
        Consumer<RemoteMemberAddRegisterParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
        };

        // ## Act ##
        createBhv(null).requestAddRegister(paramLambda);
    }

    public void test_requestEdit() {
        // ## Arrange ##
        Integer memberId = 1;

        // ## Act ##
        createBhv(null).requestEdit(memberId);
    }

    public void test_requestEditUpdate() {
        // ## Arrange ##
        Consumer<RemoteMemberEditUpdateParam> paramLambda = param -> {
            param.memberId = 1;
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.formalizedDate = java.time.LocalDate.now();
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.latestLoginDatetime = java.time.LocalDateTime.now();
            param.updateDatetime = java.time.LocalDateTime.now();
            param.previousStatus = "previousStatus";
            param.versionNo = 1L;
        };

        // ## Act ##
        createBhv(null).requestEditUpdate(paramLambda);
    }

    public void test_requestEditWithdrawal() {
        // ## Arrange ##
        Consumer<RemoteMemberEditWithdrawalParam> paramLambda = param -> {
            param.memberId = 1;
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.formalizedDate = java.time.LocalDate.now();
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.latestLoginDatetime = java.time.LocalDateTime.now();
            param.updateDatetime = java.time.LocalDateTime.now();
            param.previousStatus = "previousStatus";
            param.versionNo = 1L;
        };

        // ## Act ##
        createBhv(null).requestEditWithdrawal(paramLambda);
    }

    public void test_requestList() {
        // ## Arrange ##
        Consumer<RemoteMemberListParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.purchaseProductName = "purchaseProductName";
            param.unpaid = Boolean.TRUE;
            param.formalizedFrom = java.time.LocalDate.now();
            param.formalizedTo = java.time.LocalDate.now();
        };

        // ## Act ##
        createBhv(null).requestList(paramLambda);
    }

    public void test_requestListPageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteMemberListPagenumberParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.purchaseProductName = "purchaseProductName";
            param.unpaid = Boolean.TRUE;
            param.formalizedFrom = java.time.LocalDate.now();
            param.formalizedTo = java.time.LocalDate.now();
        };

        // ## Act ##
        createBhv(null).requestList(pageNumber, paramLambda);
    }

    private RemoteFortressMemberBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressMemberBhv bhv = new RemoteFortressMemberBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
