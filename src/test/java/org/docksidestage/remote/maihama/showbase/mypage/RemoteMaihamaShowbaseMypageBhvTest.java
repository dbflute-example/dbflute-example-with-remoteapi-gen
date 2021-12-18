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
package org.docksidestage.remote.maihama.showbase.mypage;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.mypage.index.RemoteMypageReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of mypage.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseMypageBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseMypageBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Act ##
        RemoteMypageReturn returnBean = createBhv("{}").request();

        // ## Assert ##
        logger.debug("recentProducts={}", returnBean.recentProducts);
        if (returnBean.recentProducts != null) {
            returnBean.recentProducts.forEach(recentProduct -> {
                logger.debug("recentProduct.productName={}", recentProduct.productName);
                logger.debug("recentProduct.regularPrice={}", recentProduct.regularPrice);
            });
        }
        logger.debug("highPriceProducts={}", returnBean.highPriceProducts);
        if (returnBean.highPriceProducts != null) {
            returnBean.highPriceProducts.forEach(highPriceProduct -> {
                logger.debug("highPriceProduct.productName={}", highPriceProduct.productName);
                logger.debug("highPriceProduct.regularPrice={}", highPriceProduct.regularPrice);
            });
        }
    }

    private RemoteMaihamaShowbaseMypageBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseMypageBhv bhv = new RemoteMaihamaShowbaseMypageBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
