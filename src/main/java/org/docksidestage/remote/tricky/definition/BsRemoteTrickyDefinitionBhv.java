/*
 * Copyright 2017-2026 the original author or authors.
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

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.tricky.AbstractRemoteTrickyBhv;
import org.docksidestage.remote.tricky.definition.less.RemoteDefinitionLessGetReturn;
import org.docksidestage.remote.tricky.definition.less.RemoteDefinitionLessPostReturn;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of definition.
 * @author FreeGen
 */
public abstract class BsRemoteTrickyDefinitionBhv extends AbstractRemoteTrickyBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemoteTrickyDefinitionBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /definition/less/. (auto-generated method)<br>
     * <pre>
     * url: /definition/less/
     * httpMethod: GET
     * </pre>
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteDefinitionLessGetReturn requestLessGet() {
        return doRequestLessGet(rule -> {});
    }

    /**
     * Request remote call to /definition/less/. (auto-generated method)<br>
     * <pre>
     * url: /definition/less/
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteDefinitionLessGetReturn doRequestLessGet(Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestGet(RemoteDefinitionLessGetReturn.class, "/definition/less/", noMoreUrl(), noQuery(), rule -> {
            ruleOfLessGet(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /definition/less/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfLessGet(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /definition/less/. (auto-generated method)<br>
     * <pre>
     * url: /definition/less/
     * httpMethod: POST
     * </pre>
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteDefinitionLessPostReturn requestLessPost() {
        return doRequestLessPost(rule -> {});
    }

    /**
     * Request remote call to /definition/less/. (auto-generated method)<br>
     * <pre>
     * url: /definition/less/
     * httpMethod: POST
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteDefinitionLessPostReturn doRequestLessPost(Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestPost(RemoteDefinitionLessPostReturn.class, "/definition/less/", noMoreUrl(), noRequestBody(), rule -> {
            ruleOfLessPost(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /definition/less/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfLessPost(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /definition/less/. (auto-generated method)<br>
     * <pre>
     * url: /definition/less/
     * httpMethod: PUT
     * </pre>
     */
    public void requestLessPut() {
        doRequestLessPut(rule -> {});
    }

    /**
     * Request remote call to /definition/less/. (auto-generated method)<br>
     * <pre>
     * url: /definition/less/
     * httpMethod: PUT
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestLessPut(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestPut(void.class, "/definition/less/", noMoreUrl(), noRequestBody(), rule -> {
            ruleOfLessPut(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /definition/less/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfLessPut(FlutyRemoteApiRule rule) {
    }
}
