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
package org.docksidestage.remote.tricky.urlcharacter;

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.tricky.AbstractRemoteTrickyBhv;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of urlcharacter.
 * @author FreeGen
 */
public abstract class BsRemoteTrickyUrlcharacterBhv extends AbstractRemoteTrickyBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemoteTrickyUrlcharacterBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /urlcharacter/hyphen-hyphen/. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/hyphen-hyphen/
     * httpMethod: GET
     * </pre>
     */
    public void requestHyphenhyphen() {
        doRequestHyphenhyphen(rule -> {});
    }

    /**
     * Request remote call to /urlcharacter/hyphen-hyphen/. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/hyphen-hyphen/
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestHyphenhyphen(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/urlcharacter/hyphen-hyphen/", noMoreUrl(), noQuery(), rule -> {
            ruleOfHyphenhyphen(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /urlcharacter/hyphen-hyphen/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfHyphenhyphen(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /urlcharacter/dot.dot/. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/dot.dot/
     * httpMethod: GET
     * </pre>
     */
    public void requestDotdot() {
        doRequestDotdot(rule -> {});
    }

    /**
     * Request remote call to /urlcharacter/dot.dot/. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/dot.dot/
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestDotdot(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/urlcharacter/dot.dot/", noMoreUrl(), noQuery(), rule -> {
            ruleOfDotdot(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /urlcharacter/dot.dot/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfDotdot(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /urlcharacter/dot.dot.dot/. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/dot.dot.dot/
     * httpMethod: GET
     * </pre>
     */
    public void requestDotdotdot() {
        doRequestDotdotdot(rule -> {});
    }

    /**
     * Request remote call to /urlcharacter/dot.dot.dot/. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/dot.dot.dot/
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestDotdotdot(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/urlcharacter/dot.dot.dot/", noMoreUrl(), noQuery(), rule -> {
            ruleOfDotdotdot(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /urlcharacter/dot.dot.dot/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfDotdotdot(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /urlcharacter/file.pdf. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/file.pdf
     * httpMethod: GET
     * </pre>
     */
    public void requestFilepdf() {
        doRequestFilepdf(rule -> {});
    }

    /**
     * Request remote call to /urlcharacter/file.pdf. (auto-generated method)<br>
     * <pre>
     * url: /urlcharacter/file.pdf
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestFilepdf(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/urlcharacter/file.pdf", noMoreUrl(), noQuery(), rule -> {
            ruleOfFilepdf(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /urlcharacter/file.pdf.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfFilepdf(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /url.character/dot. (auto-generated method)<br>
     * <pre>
     * url: /url.character/dot
     * httpMethod: GET
     * </pre>
     */
    public void requestDot() {
        doRequestDot(rule -> {});
    }

    /**
     * Request remote call to /url.character/dot. (auto-generated method)<br>
     * <pre>
     * url: /url.character/dot
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     */
    protected void doRequestDot(Consumer<FlutyRemoteApiRule> ruleLambda) {
        doRequestGet(void.class, "/url.character/dot", noMoreUrl(), noQuery(), rule -> {
            ruleOfDot(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /url.character/dot.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfDot(FlutyRemoteApiRule rule) {
    }
}
