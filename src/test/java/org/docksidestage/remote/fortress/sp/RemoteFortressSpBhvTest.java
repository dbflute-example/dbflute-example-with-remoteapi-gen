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
package org.docksidestage.remote.fortress.sp;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.sp.wx.routing.mixworld.RemoteSpWxRoutingMixworldReturn;
import org.docksidestage.remote.fortress.sp.wx.routing.mixworld.maihama.RemoteSpWxRoutingMixworldMaihamaReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of sp.
 * @author FreeGen
 */
public class RemoteFortressSpBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressSpBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestWxRoutingMixworld() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteSpWxRoutingMixworldReturn returnBean = createBhv("{}").requestWxRoutingMixworld(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestWxRoutingMixworldSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteSpWxRoutingMixworldReturn returnBean = createBhv("{}").requestWxRoutingMixworld(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestWxRoutingMixworldMaihama() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteSpWxRoutingMixworldMaihamaReturn returnBean = createBhv("{}").requestWxRoutingMixworldMaihama(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    private RemoteFortressSpBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressSpBhv bhv = new RemoteFortressSpBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
