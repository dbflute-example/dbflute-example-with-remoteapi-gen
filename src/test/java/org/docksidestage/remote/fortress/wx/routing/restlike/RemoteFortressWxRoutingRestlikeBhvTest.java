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
package org.docksidestage.remote.fortress.wx.routing.restlike;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.wx.routing.restlike.index.RemoteWxRoutingRestlikeDeleteParam;
import org.docksidestage.remote.fortress.wx.routing.restlike.index.RemoteWxRoutingRestlikeDeleteReturn;
import org.docksidestage.remote.fortress.wx.routing.restlike.index.RemoteWxRoutingRestlikeGetReturn;
import org.docksidestage.remote.fortress.wx.routing.restlike.index.RemoteWxRoutingRestlikeParam;
import org.docksidestage.remote.fortress.wx.routing.restlike.index.RemoteWxRoutingRestlikePutParam;
import org.docksidestage.remote.fortress.wx.routing.restlike.index.RemoteWxRoutingRestlikePutReturn;
import org.docksidestage.remote.fortress.wx.routing.restlike.index.RemoteWxRoutingRestlikeReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of wx.routing.restlike.
 * @author FreeGen
 */
public class RemoteFortressWxRoutingRestlikeBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressWxRoutingRestlikeBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestGet() {
        // ## Act ##
        RemoteWxRoutingRestlikeReturn returnBean = createBhv("{}").requestGet();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("form={}", returnBean.form);
    }

    public void test_requestGetFirst() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingRestlikeGetReturn returnBean = createBhv("{}").requestGet(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("form={}", returnBean.form);
    }

    public void test_requestPut() {
        // ## Arrange ##
        String first = "first";
        Consumer<RemoteWxRoutingRestlikePutParam> paramLambda = param -> {
            param.maihamaId = 1;
        };

        // ## Act ##
        RemoteWxRoutingRestlikePutReturn returnBean = createBhv("{}").requestPut(first, paramLambda);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("form={}", returnBean.form);
    }

    public void test_requestDelete() {
        // ## Arrange ##
        String first = "first";
        Consumer<RemoteWxRoutingRestlikeDeleteParam> paramLambda = param -> {
            param.maihamaId = 1;
        };

        // ## Act ##
        RemoteWxRoutingRestlikeDeleteReturn returnBean = createBhv("{}").requestDelete(first, paramLambda);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("form={}", returnBean.form);
    }

    public void test_requestPost() {
        // ## Arrange ##
        Consumer<RemoteWxRoutingRestlikeParam> paramLambda = param -> {
            param.maihamaId = 1;
        };

        // ## Act ##
        RemoteWxRoutingRestlikeReturn returnBean = createBhv("{}").requestPost(paramLambda);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("form={}", returnBean.form);
    }

    private RemoteFortressWxRoutingRestlikeBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressWxRoutingRestlikeBhv bhv = new RemoteFortressWxRoutingRestlikeBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
