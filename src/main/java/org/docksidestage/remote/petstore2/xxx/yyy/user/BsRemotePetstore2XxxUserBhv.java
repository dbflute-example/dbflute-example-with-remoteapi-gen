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
package org.docksidestage.remote.petstore2.xxx.yyy.user;

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.petstore2.xxx.yyy.AbstractRemotePetstore2XxxBhv;
import org.docksidestage.remote.petstore2.xxx.yyy.user.index.RemoteUserReturn;
import org.docksidestage.remote.petstore2.xxx.yyy.user.login.RemoteUserLoginParam;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of user.
 * @author FreeGen
 */
public abstract class BsRemotePetstore2XxxUserBhv extends AbstractRemotePetstore2XxxBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemotePetstore2XxxUserBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /user/login. (auto-generated method)<br>
     * <pre>
     * url: /user/login
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteUserLoginParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public String requestLogin(Consumer<RemoteUserLoginParam> paramLambda) {
        return doRequestLogin(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /user/login. (auto-generated method)<br>
     * <pre>
     * url: /user/login
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteUserLoginParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected String doRequestLogin(Consumer<RemoteUserLoginParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteUserLoginParam param = new RemoteUserLoginParam();
        paramLambda.accept(param);
        return doRequestGet(String.class, "/user/login", noMoreUrl(), query(param), rule -> {
            ruleOfLogin(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /user/login.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfLogin(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /user/logout. (auto-generated method)<br>
     * <pre>
     * url: /user/logout
     * httpMethod: GET
     * </pre>
     */
    public void requestLogout() {
        doRequestLogout(rule -> {});
    }

    /**
     * Request remote call to /user/logout. (auto-generated method)<br>
     * <pre>
     * url: /user/logout
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestLogout(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/user/logout", noMoreUrl(), noQuery(), rule -> {
            ruleOfLogout(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /user/logout.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfLogout(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /user/{username}. (auto-generated method)<br>
     * <pre>
     * url: /user/{username}
     * httpMethod: GET
     * </pre>
     * @param username The value of path variable for username. (The name that needs to be fetched. Use user1 for testing. ) (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteUserReturn request(String username) {
        return doRequest(username, rule -> {});
    }

    /**
     * Request remote call to /user/{username}. (auto-generated method)<br>
     * <pre>
     * url: /user/{username}
     * httpMethod: GET
     * </pre>
     * @param username The value of path variable for username. (The name that needs to be fetched. Use user1 for testing. ) (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteUserReturn doRequest(String username, Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestGet(RemoteUserReturn.class, "/user/{username}", moreUrl(username), noQuery(), rule -> {
            ruleOfUsername(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /user/{username}.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfUsername(FlutyRemoteApiRule rule) {
    }
}
