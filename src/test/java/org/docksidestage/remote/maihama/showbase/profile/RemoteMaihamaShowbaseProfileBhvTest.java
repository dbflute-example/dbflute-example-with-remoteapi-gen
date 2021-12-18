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
package org.docksidestage.remote.maihama.showbase.profile;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.profile.index.RemoteProfileReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of profile.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseProfileBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseProfileBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Act ##
        RemoteProfileReturn returnBean = createBhv("{}").request();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("memberStatusName={}", returnBean.memberStatusName);
        logger.debug("servicePointCount={}", returnBean.servicePointCount);
        logger.debug("serviceRankName={}", returnBean.serviceRankName);
        logger.debug("purchaseList={}", returnBean.purchaseList);
        if (returnBean.purchaseList != null) {
            returnBean.purchaseList.forEach(purchase -> {
                logger.debug("purchase.productName={}", purchase.productName);
                logger.debug("purchase.regularPrice={}", purchase.regularPrice);
                logger.debug("purchase.purchaseDateTime={}", purchase.purchaseDateTime);
            });
        }
    }

    private RemoteMaihamaShowbaseProfileBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseProfileBhv bhv = new RemoteMaihamaShowbaseProfileBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
