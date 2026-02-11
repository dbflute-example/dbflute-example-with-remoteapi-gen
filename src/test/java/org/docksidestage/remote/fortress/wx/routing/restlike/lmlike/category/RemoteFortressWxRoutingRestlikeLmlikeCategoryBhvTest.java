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
package org.docksidestage.remote.fortress.wx.routing.restlike.lmlike.category;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.wx.routing.restlike.lmlike.category.index.RemoteWxRoutingRestlikeLmlikeCategoryReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of wx.routing.restlike.lmlike.category.
 * @author FreeGen
 */
public class RemoteFortressWxRoutingRestlikeLmlikeCategoryBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressWxRoutingRestlikeLmlikeCategoryBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Arrange ##
        org.docksidestage.dbflute.allcommon.CDef.MemberStatus memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.values()[0];
        Integer memberId = 1;

        // ## Act ##
        RemoteWxRoutingRestlikeLmlikeCategoryReturn returnBean = createBhv("{}").requestGet(memberStatus, memberId);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    private RemoteFortressWxRoutingRestlikeLmlikeCategoryBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressWxRoutingRestlikeLmlikeCategoryBhv bhv = new RemoteFortressWxRoutingRestlikeLmlikeCategoryBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
