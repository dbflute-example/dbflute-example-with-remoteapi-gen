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
package org.docksidestage.remote.petstore.store;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.petstore.store.order.RemoteStoreOrderGetReturn;
import org.docksidestage.remote.petstore.store.order.RemoteStoreOrderParam;
import org.docksidestage.remote.petstore.store.order.RemoteStoreOrderReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of store.
 * @author FreeGen
 */
public class RemotePetstoreStoreBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemotePetstoreStoreBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestInventory() {
        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestInventory();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestOrder() {
        // ## Arrange ##
        Consumer<RemoteStoreOrderParam> paramLambda = param -> {
            param.id = 1L;
            param.petId = 1L;
            param.quantity = 1;
            param.shipDate = java.time.LocalDateTime.now();
            param.status = "status";
            param.complete = Boolean.TRUE;
        };

        // ## Act ##
        RemoteStoreOrderReturn returnBean = createBhv("{}").requestOrder(paramLambda);

        // ## Assert ##
        logger.debug("id={}", returnBean.id);
        logger.debug("petId={}", returnBean.petId);
        logger.debug("quantity={}", returnBean.quantity);
        logger.debug("shipDate={}", returnBean.shipDate);
        logger.debug("status={}", returnBean.status);
        logger.debug("complete={}", returnBean.complete);
    }

    public void test_requestOrderGet() {
        // ## Arrange ##
        Long orderId = 1L;

        // ## Act ##
        RemoteStoreOrderGetReturn returnBean = createBhv("{}").requestOrderGet(orderId);

        // ## Assert ##
        logger.debug("id={}", returnBean.id);
        logger.debug("petId={}", returnBean.petId);
        logger.debug("quantity={}", returnBean.quantity);
        logger.debug("shipDate={}", returnBean.shipDate);
        logger.debug("status={}", returnBean.status);
        logger.debug("complete={}", returnBean.complete);
    }

    public void test_requestOrderDelete() {
        // ## Arrange ##
        Long orderId = 1L;

        // ## Act ##
        createBhv(null).requestOrderDelete(orderId);
    }

    private RemotePetstoreStoreBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemotePetstoreStoreBhv bhv = new RemotePetstoreStoreBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
