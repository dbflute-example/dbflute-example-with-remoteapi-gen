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
package org.docksidestage.remote.tricky.definition;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.tricky.definition.less.RemoteDefinitionLessPostReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of definition.
 * @author FreeGen
 */
public class RemoteTrickyDefinitionBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteTrickyDefinitionBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestLessGet() {
        // ## Act ##
        createBhv(null).requestLessGet();
    }

    public void test_requestLessPost() {
        // ## Act ##
        RemoteDefinitionLessPostReturn returnBean = createBhv("{}").requestLessPost();

        // ## Assert ##
        logger.debug("simple={}", returnBean.simple);
    }

    private RemoteTrickyDefinitionBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteTrickyDefinitionBhv bhv = new RemoteTrickyDefinitionBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
