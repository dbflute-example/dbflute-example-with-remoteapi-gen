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
package org.docksidestage.remote.maihama.showbase;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The behavior test for remote API of .
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseBhvTest extends UnitRemoteapigenTestCase {

    @Resource
    private RequestManager requestManager;

    public void test_request() {
        // ## Act ##
        createBhv(null).request();
    }

    private RemoteMaihamaShowbaseBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseBhv bhv = new RemoteMaihamaShowbaseBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
