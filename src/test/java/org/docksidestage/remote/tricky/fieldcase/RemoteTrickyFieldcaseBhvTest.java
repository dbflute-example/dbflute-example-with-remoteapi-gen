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
package org.docksidestage.remote.tricky.fieldcase;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvParam;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of fieldcase.
 * @author FreeGen
 */
public class RemoteTrickyFieldcaseBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteTrickyFieldcaseBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestNoconv() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNoconvParam> paramLambda = param -> {
            param.sea_id = 1;
            param.landName = "landName";
            param.piari = "piari";
            param.BONVO = "BONVO";
        };

        // ## Act ##
        RemoteFieldcaseNoconvReturn returnBean = createBhv("{}").requestNoconv(paramLambda);

        // ## Assert ##
        logger.debug("hangar_id={}", returnBean.hangar_id);
        logger.debug("onemanName={}", returnBean.onemanName);
        logger.debug("piari={}", returnBean.piari);
        logger.debug("BONVO={}", returnBean.BONVO);
    }

    private RemoteTrickyFieldcaseBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteTrickyFieldcaseBhv bhv = new RemoteTrickyFieldcaseBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
