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

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.tricky.AbstractRemoteTrickyBhv;
import org.docksidestage.remote.tricky.definition.less.RemoteDefinitionLessPostReturn;
import org.docksidestage.remote.tricky.definition.refschema.RemoteDefinitionRefschemaPostReturn;
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
     */
    public void requestLessGet() {
        doRequestLessGet(rule -> {});
    }

    /**
     * Request remote call to /definition/less/. (auto-generated method)<br>
     * <pre>
     * url: /definition/less/
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestLessGet(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/definition/less/", noMoreUrl(), noQuery(), rule -> {
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
     * Request remote call to /definition/refschema/. (auto-generated method)<br>
     * <pre>
     * url: /definition/refschema/
     * httpMethod: GET
     * </pre>
     */
    public void requestRefschemaGet() {
        doRequestRefschemaGet(rule -> {});
    }

    /**
     * Request remote call to /definition/refschema/. (auto-generated method)<br>
     * <pre>
     * url: /definition/refschema/
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestRefschemaGet(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/definition/refschema/", noMoreUrl(), noQuery(), rule -> {
            ruleOfRefschemaGet(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /definition/refschema/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfRefschemaGet(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /definition/refschema/. (auto-generated method)<br>
     * <pre>
     * url: /definition/refschema/
     * httpMethod: POST
     * </pre>
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteDefinitionRefschemaPostReturn requestRefschemaPost() {
        return doRequestRefschemaPost(rule -> {});
    }

    /**
     * Request remote call to /definition/refschema/. (auto-generated method)<br>
     * <pre>
     * url: /definition/refschema/
     * httpMethod: POST
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteDefinitionRefschemaPostReturn doRequestRefschemaPost(Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestPost(RemoteDefinitionRefschemaPostReturn.class, "/definition/refschema/", noMoreUrl(), noRequestBody(), rule -> {
            ruleOfRefschemaPost(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /definition/refschema/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfRefschemaPost(FlutyRemoteApiRule rule) {
    }
}
