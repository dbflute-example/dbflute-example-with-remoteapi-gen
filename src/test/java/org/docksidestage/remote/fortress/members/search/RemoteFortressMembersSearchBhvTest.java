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
package org.docksidestage.remote.fortress.members.search;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.members.search.index.RemoteMembersSearchParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The behavior test for remote API of members.search.
 * @author FreeGen
 */
public class RemoteFortressMembersSearchBhvTest extends UnitRemoteapigenTestCase {

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Arrange ##
        Consumer<RemoteMembersSearchParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.purchaseProductName = "purchaseProductName";
            param.unpaid = Boolean.TRUE;
            param.formalizedFrom = java.time.LocalDate.now();
            param.formalizedTo = java.time.LocalDate.now();
            param.pageNumber = 1;
        };

        // ## Act ##
        createBhv(null).requestGet(paramLambda);
    }

    private RemoteFortressMembersSearchBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressMembersSearchBhv bhv = new RemoteFortressMembersSearchBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
