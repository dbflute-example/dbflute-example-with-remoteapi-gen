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
package org.docksidestage.remote.petstore2.xxx.yyy.store;

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.petstore2.xxx.yyy.AbstractRemotePetstore2XxxBhv;
import org.docksidestage.remote.petstore2.xxx.yyy.store.order.RemoteStoreOrderReturn;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of store.
 * @author FreeGen
 */
public abstract class BsRemotePetstore2XxxStoreBhv extends AbstractRemotePetstore2XxxBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemotePetstore2XxxStoreBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /store/inventory. (auto-generated method)<br>
     * <pre>
     * url: /store/inventory
     * httpMethod: GET
     * </pre>
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public java.util.Map<String, Object> requestInventory() {
        return doRequestInventory(rule -> {});
    }

    /**
     * Request remote call to /store/inventory. (auto-generated method)<br>
     * <pre>
     * url: /store/inventory
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected java.util.Map<String, Object> doRequestInventory(Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestGet(new org.lastaflute.di.helper.misc.ParameterizedRef<java.util.Map<String, Object>>() {
        }.getType(), "/store/inventory", noMoreUrl(), noQuery(), rule -> {
            ruleOfInventory(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /store/inventory.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfInventory(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /store/order/{orderId}. (auto-generated method)<br>
     * <pre>
     * url: /store/order/{orderId}
     * httpMethod: GET
     * </pre>
     * @param orderId The value of path variable for orderId. (ID of pet that needs to be fetched) (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteStoreOrderReturn requestOrder(Long orderId) {
        return doRequestOrder(orderId, rule -> {});
    }

    /**
     * Request remote call to /store/order/{orderId}. (auto-generated method)<br>
     * <pre>
     * url: /store/order/{orderId}
     * httpMethod: GET
     * </pre>
     * @param orderId The value of path variable for orderId. (ID of pet that needs to be fetched) (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteStoreOrderReturn doRequestOrder(Long orderId, Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestGet(RemoteStoreOrderReturn.class, "/store/order/{orderId}", moreUrl(orderId), noQuery(), rule -> {
            ruleOfOrderOrderId(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /store/order/{orderId}.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfOrderOrderId(FlutyRemoteApiRule rule) {
    }
}
