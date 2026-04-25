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
package org.docksidestage.remote.tricky.fieldcase;

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.tricky.AbstractRemoteTrickyBhv;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharGetParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharGetReturn;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPostParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPostReturn;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPutParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPutReturn;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvParam;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvReturn;
import org.docksidestage.remote.tricky.fieldcase.numbercamel.RemoteFieldcaseNumbercamelGetParam;
import org.docksidestage.remote.tricky.fieldcase.numbercamel.RemoteFieldcaseNumbercamelGetReturn;
import org.docksidestage.remote.tricky.fieldcase.numbercamel.RemoteFieldcaseNumbercamelPostParam;
import org.docksidestage.remote.tricky.fieldcase.numbercamel.RemoteFieldcaseNumbercamelPostReturn;
import org.docksidestage.remote.tricky.fieldcase.numbercamel.RemoteFieldcaseNumbercamelPutParam;
import org.docksidestage.remote.tricky.fieldcase.numbercamel.RemoteFieldcaseNumbercamelPutReturn;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of fieldcase.
 * @author FreeGen
 */
public abstract class BsRemoteTrickyFieldcaseBhv extends AbstractRemoteTrickyBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemoteTrickyFieldcaseBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /fieldcase/noconv/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/noconv/
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNoconvParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteFieldcaseNoconvReturn requestNoconv(Consumer<RemoteFieldcaseNoconvParam> paramLambda) {
        return doRequestNoconv(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /fieldcase/noconv/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/noconv/
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNoconvParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteFieldcaseNoconvReturn doRequestNoconv(Consumer<RemoteFieldcaseNoconvParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteFieldcaseNoconvParam param = new RemoteFieldcaseNoconvParam();
        paramLambda.accept(param);
        return doRequestGet(RemoteFieldcaseNoconvReturn.class, "/fieldcase/noconv/", noMoreUrl(), query(param), rule -> {
            ruleOfNoconv(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /fieldcase/noconv/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfNoconv(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /fieldcase/ngchar/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/ngchar/
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNgcharGetParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteFieldcaseNgcharGetReturn requestNgcharGet(Consumer<RemoteFieldcaseNgcharGetParam> paramLambda) {
        return doRequestNgcharGet(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /fieldcase/ngchar/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/ngchar/
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNgcharGetParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteFieldcaseNgcharGetReturn doRequestNgcharGet(Consumer<RemoteFieldcaseNgcharGetParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteFieldcaseNgcharGetParam param = new RemoteFieldcaseNgcharGetParam();
        paramLambda.accept(param);
        return doRequestGet(RemoteFieldcaseNgcharGetReturn.class, "/fieldcase/ngchar/", noMoreUrl(), query(param), rule -> {
            ruleOfNgcharGet(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /fieldcase/ngchar/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfNgcharGet(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /fieldcase/ngchar/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/ngchar/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNgcharPostParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteFieldcaseNgcharPostReturn requestNgcharPost(Consumer<RemoteFieldcaseNgcharPostParam> paramLambda) {
        return doRequestNgcharPost(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /fieldcase/ngchar/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/ngchar/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNgcharPostParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteFieldcaseNgcharPostReturn doRequestNgcharPost(Consumer<RemoteFieldcaseNgcharPostParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteFieldcaseNgcharPostParam param = new RemoteFieldcaseNgcharPostParam();
        paramLambda.accept(param);
        return doRequestPost(RemoteFieldcaseNgcharPostReturn.class, "/fieldcase/ngchar/", noMoreUrl(), param, rule -> {
            rule.sendBodyBy(
                    new org.lastaflute.remoteapi.sender.body.LaFormSender(new org.dbflute.remoteapi.mapping.FlVacantMappingPolicy()));
            ruleOfNgcharPost(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /fieldcase/ngchar/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfNgcharPost(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /fieldcase/ngchar/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/ngchar/
     * httpMethod: PUT
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNgcharPutParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteFieldcaseNgcharPutReturn requestNgcharPut(Consumer<RemoteFieldcaseNgcharPutParam> paramLambda) {
        return doRequestNgcharPut(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /fieldcase/ngchar/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/ngchar/
     * httpMethod: PUT
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNgcharPutParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteFieldcaseNgcharPutReturn doRequestNgcharPut(Consumer<RemoteFieldcaseNgcharPutParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteFieldcaseNgcharPutParam param = new RemoteFieldcaseNgcharPutParam();
        paramLambda.accept(param);
        return doRequestPut(RemoteFieldcaseNgcharPutReturn.class, "/fieldcase/ngchar/", noMoreUrl(), param, rule -> {
            ruleOfNgcharPut(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /fieldcase/ngchar/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfNgcharPut(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /fieldcase/numbercamel/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/numbercamel/
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNumbercamelGetParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteFieldcaseNumbercamelGetReturn requestNumbercamelGet(Consumer<RemoteFieldcaseNumbercamelGetParam> paramLambda) {
        return doRequestNumbercamelGet(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /fieldcase/numbercamel/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/numbercamel/
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNumbercamelGetParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteFieldcaseNumbercamelGetReturn doRequestNumbercamelGet(Consumer<RemoteFieldcaseNumbercamelGetParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteFieldcaseNumbercamelGetParam param = new RemoteFieldcaseNumbercamelGetParam();
        paramLambda.accept(param);
        return doRequestGet(RemoteFieldcaseNumbercamelGetReturn.class, "/fieldcase/numbercamel/", noMoreUrl(), query(param), rule -> {
            ruleOfNumbercamelGet(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /fieldcase/numbercamel/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfNumbercamelGet(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /fieldcase/numbercamel/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/numbercamel/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNumbercamelPostParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteFieldcaseNumbercamelPostReturn requestNumbercamelPost(Consumer<RemoteFieldcaseNumbercamelPostParam> paramLambda) {
        return doRequestNumbercamelPost(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /fieldcase/numbercamel/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/numbercamel/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNumbercamelPostParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteFieldcaseNumbercamelPostReturn doRequestNumbercamelPost(Consumer<RemoteFieldcaseNumbercamelPostParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteFieldcaseNumbercamelPostParam param = new RemoteFieldcaseNumbercamelPostParam();
        paramLambda.accept(param);
        return doRequestPost(RemoteFieldcaseNumbercamelPostReturn.class, "/fieldcase/numbercamel/", noMoreUrl(), param, rule -> {
            rule.sendBodyBy(
                    new org.lastaflute.remoteapi.sender.body.LaFormSender(new org.dbflute.remoteapi.mapping.FlVacantMappingPolicy()));
            ruleOfNumbercamelPost(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /fieldcase/numbercamel/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfNumbercamelPost(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /fieldcase/numbercamel/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/numbercamel/
     * httpMethod: PUT
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNumbercamelPutParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemoteFieldcaseNumbercamelPutReturn requestNumbercamelPut(Consumer<RemoteFieldcaseNumbercamelPutParam> paramLambda) {
        return doRequestNumbercamelPut(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /fieldcase/numbercamel/. (auto-generated method)<br>
     * <pre>
     * url: /fieldcase/numbercamel/
     * httpMethod: PUT
     * </pre>
     * @param paramLambda The callback for RemoteFieldcaseNumbercamelPutParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemoteFieldcaseNumbercamelPutReturn doRequestNumbercamelPut(Consumer<RemoteFieldcaseNumbercamelPutParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteFieldcaseNumbercamelPutParam param = new RemoteFieldcaseNumbercamelPutParam();
        paramLambda.accept(param);
        return doRequestPut(RemoteFieldcaseNumbercamelPutReturn.class, "/fieldcase/numbercamel/", noMoreUrl(), param, rule -> {
            ruleOfNumbercamelPut(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /fieldcase/numbercamel/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfNumbercamelPut(FlutyRemoteApiRule rule) {
    }
}
