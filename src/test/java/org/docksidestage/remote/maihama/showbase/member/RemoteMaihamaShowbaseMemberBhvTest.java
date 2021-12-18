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
package org.docksidestage.remote.maihama.showbase.member;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.member.add.register.RemoteMemberAddRegisterParam;
import org.docksidestage.remote.maihama.showbase.member.add.register.RemoteMemberAddRegisterReturn;
import org.docksidestage.remote.maihama.showbase.member.edit.RemoteMemberEditReturn;
import org.docksidestage.remote.maihama.showbase.member.edit.update.RemoteMemberEditUpdateParam;
import org.docksidestage.remote.maihama.showbase.member.info.RemoteMemberInfoReturn;
import org.docksidestage.remote.maihama.showbase.member.list.RemoteMemberListParam;
import org.docksidestage.remote.maihama.showbase.member.list.RemoteMemberListReturn;
import org.docksidestage.remote.maihama.showbase.member.purchase.list.RemoteMemberPurchaseListReturn;
import org.docksidestage.remote.maihama.showbase.member.status.RemoteMemberStatusReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of member.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseMemberBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseMemberBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestInfo() {
        // ## Act ##
        RemoteMemberInfoReturn returnBean = createBhv("{}").requestInfo();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("memberStatusName={}", returnBean.memberStatusName);
    }

    public void test_requestStatus() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteMemberStatusReturn> list = createBhv("[]").requestStatus();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("key={}", returnBean.key);
            logger.debug("value={}", returnBean.value);
        });
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
        RemoteMemberAddRegisterReturn returnBean = createBhv("{}").requestAddRegister(paramLambda);

        // ## Assert ##
        logger.debug("purchaseCount={}", returnBean.purchaseCount);
        logger.debug("latestLoginDatetime={}", returnBean.latestLoginDatetime);
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("memberAccount={}", returnBean.memberAccount);
        logger.debug("memberStatusCode={}", returnBean.memberStatusCode);
        logger.debug("formalizedDatetime={}", returnBean.formalizedDatetime);
        logger.debug("birthdate={}", returnBean.birthdate);
        logger.debug("registerDatetime={}", returnBean.registerDatetime);
        logger.debug("registerUser={}", returnBean.registerUser);
        logger.debug("updateDatetime={}", returnBean.updateDatetime);
        logger.debug("updateUser={}", returnBean.updateUser);
        logger.debug("versionNo={}", returnBean.versionNo);
        logger.debug("memberStatus={}", returnBean.memberStatus);
        // #thinking p1us2er0 lasta-metaでネストしたプロパティが自動生成されてない可能性がある (2022/03/21)
        logger.debug("memberAddressAsValid={}", returnBean.memberAddressAsValid);
        logger.debug("memberLoginAsLatest={}", returnBean.memberLoginAsLatest);
        logger.debug("memberSecurityAsOne={}", returnBean.memberSecurityAsOne);
        logger.debug("memberServiceAsOne={}", returnBean.memberServiceAsOne);
        logger.debug("memberWithdrawalAsOne={}", returnBean.memberWithdrawalAsOne);
        logger.debug("memberAddressList={}", returnBean.memberAddressList);
        logger.debug("memberFollowingByMyMemberIdList={}", returnBean.memberFollowingByMyMemberIdList);
        logger.debug("memberFollowingByYourMemberIdList={}", returnBean.memberFollowingByYourMemberIdList);
        logger.debug("memberLoginList={}", returnBean.memberLoginList);
        logger.debug("purchaseList={}", returnBean.purchaseList);
        logger.debug("uniqueDrivenProperties={}", returnBean.uniqueDrivenProperties);
        logger.debug("modifiedProperties={}", returnBean.modifiedProperties);
        logger.debug("specifiedProperties={}", returnBean.specifiedProperties);
        logger.debug("derivedMap={}", returnBean.derivedMap);
        logger.debug("undefinedClassificationSelectAllowed={}", returnBean.undefinedClassificationSelectAllowed);
        logger.debug("createdBySelect={}", returnBean.createdBySelect);
    }

    public void test_requestEdit() {
        // ## Arrange ##
        Integer memberId = 1;

        // ## Act ##
        RemoteMemberEditReturn returnBean = createBhv("{}").requestEdit(memberId);

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("memberAccount={}", returnBean.memberAccount);
        logger.debug("memberStatus={}", returnBean.memberStatus);
        logger.debug("birthdate={}", returnBean.birthdate);
        logger.debug("versionNo={}", returnBean.versionNo);
    }

    public void test_requestEditUpdate() {
        // ## Arrange ##
        Consumer<RemoteMemberEditUpdateParam> paramLambda = param -> {
            param.memberId = 1;
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.birthdate = java.time.LocalDate.now();
            param.versionNo = 1L;
        };

        // ## Act ##
        createBhv(null).requestEditUpdate(paramLambda);
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
        RemoteMemberListReturn returnBean = createBhv("{}").requestList(paramLambda);

        // ## Assert ##
        logger.debug("pageSize={}", returnBean.pageSize);
        logger.debug("currentPageNumber={}", returnBean.currentPageNumber);
        logger.debug("allRecordCount={}", returnBean.allRecordCount);
        logger.debug("allPageCount={}", returnBean.allPageCount);
        logger.debug("rows={}", returnBean.rows);
        if (returnBean.rows != null) {
            returnBean.rows.forEach(row -> {
                logger.debug("row.memberId={}", row.memberId);
                logger.debug("row.memberName={}", row.memberName);
                logger.debug("row.memberStatusName={}", row.memberStatusName);
                logger.debug("row.formalizedDate={}", row.formalizedDate);
                logger.debug("row.updateDatetime={}", row.updateDatetime);
                logger.debug("row.withdrawalMember={}", row.withdrawalMember);
                logger.debug("row.purchaseCount={}", row.purchaseCount);
            });
        }
    }

    public void test_requestListPageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteMemberListParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.purchaseProductName = "purchaseProductName";
            param.unpaid = Boolean.TRUE;
            param.formalizedFrom = java.time.LocalDate.now();
            param.formalizedTo = java.time.LocalDate.now();
        };

        // ## Act ##
        RemoteMemberListReturn returnBean = createBhv("{}").requestList(pageNumber, paramLambda);

        // ## Assert ##
        logger.debug("pageSize={}", returnBean.pageSize);
        logger.debug("currentPageNumber={}", returnBean.currentPageNumber);
        logger.debug("allRecordCount={}", returnBean.allRecordCount);
        logger.debug("allPageCount={}", returnBean.allPageCount);
        logger.debug("rows={}", returnBean.rows);
        if (returnBean.rows != null) {
            returnBean.rows.forEach(row -> {
                logger.debug("row.memberId={}", row.memberId);
                logger.debug("row.memberName={}", row.memberName);
                logger.debug("row.memberStatusName={}", row.memberStatusName);
                logger.debug("row.formalizedDate={}", row.formalizedDate);
                logger.debug("row.updateDatetime={}", row.updateDatetime);
                logger.debug("row.withdrawalMember={}", row.withdrawalMember);
                logger.debug("row.purchaseCount={}", row.purchaseCount);
            });
        }
    }

    public void test_requestPurchaseList() {
        // ## Arrange ##
        Integer memberId = 1;

        // ## Act ##
        RemoteMemberPurchaseListReturn returnBean = createBhv("{}").requestPurchaseList(memberId);

        // ## Assert ##
        logger.debug("pageSize={}", returnBean.pageSize);
        logger.debug("currentPageNumber={}", returnBean.currentPageNumber);
        logger.debug("allRecordCount={}", returnBean.allRecordCount);
        logger.debug("allPageCount={}", returnBean.allPageCount);
        logger.debug("rows={}", returnBean.rows);
        if (returnBean.rows != null) {
            returnBean.rows.forEach(row -> {
                logger.debug("row.purchaseId={}", row.purchaseId);
                logger.debug("row.purchaseDatetime={}", row.purchaseDatetime);
                logger.debug("row.productName={}", row.productName);
                logger.debug("row.purchasePrice={}", row.purchasePrice);
                logger.debug("row.purchaseCount={}", row.purchaseCount);
                logger.debug("row.paymentComplete={}", row.paymentComplete);
            });
        }
    }

    public void test_requestPurchaseListPageNumberPageNumber() {
        // ## Arrange ##
        Integer memberId = 1;
        Integer pageNumber = 1;

        // ## Act ##
        RemoteMemberPurchaseListReturn returnBean = createBhv("{}").requestPurchaseList(memberId, pageNumber);

        // ## Assert ##
        logger.debug("pageSize={}", returnBean.pageSize);
        logger.debug("currentPageNumber={}", returnBean.currentPageNumber);
        logger.debug("allRecordCount={}", returnBean.allRecordCount);
        logger.debug("allPageCount={}", returnBean.allPageCount);
        logger.debug("rows={}", returnBean.rows);
        if (returnBean.rows != null) {
            returnBean.rows.forEach(row -> {
                logger.debug("row.purchaseId={}", row.purchaseId);
                logger.debug("row.purchaseDatetime={}", row.purchaseDatetime);
                logger.debug("row.productName={}", row.productName);
                logger.debug("row.purchasePrice={}", row.purchasePrice);
                logger.debug("row.purchaseCount={}", row.purchaseCount);
                logger.debug("row.paymentComplete={}", row.paymentComplete);
            });
        }
    }

    public void test_requestPurchaseListDelete() {
        // ## Arrange ##
        Long purchaseId = 1L;

        // ## Act ##
        createBhv(null).requestPurchaseListDelete(purchaseId);
    }

    private RemoteMaihamaShowbaseMemberBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseMemberBhv bhv = new RemoteMaihamaShowbaseMemberBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
