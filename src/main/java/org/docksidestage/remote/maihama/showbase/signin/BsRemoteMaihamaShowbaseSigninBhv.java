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
package org.docksidestage.remote.maihama.showbase.signin;

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.maihama.showbase.AbstractRemoteMaihamaShowbaseBhv;
import org.docksidestage.remote.maihama.showbase.signin.index.RemoteSigninParam;
import org.docksidestage.remote.maihama.showbase.signin.index.RemoteSigninReturn;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of signin.
 * @author FreeGen
 */
public abstract class BsRemoteMaihamaShowbaseSigninBhv extends AbstractRemoteMaihamaShowbaseBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemoteMaihamaShowbaseSigninBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /signin/. (auto-generated method)<br>
     * <pre>
     * url: /signin/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteSigninParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteSigninReturn request(Consumer<RemoteSigninParam> paramLambda) {
        return doRequest(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /signin/. (auto-generated method)<br>
     * <pre>
     * url: /signin/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteSigninParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteSigninReturn doRequest(Consumer<RemoteSigninParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteSigninParam param = new RemoteSigninParam();
        paramLambda.accept(param);
        return doRequestPost(RemoteSigninReturn.class, "/signin/", noMoreUrl(), param, rule -> {
            ruleOf(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /signin/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOf(FlutyRemoteApiRule rule) {
    }
}
