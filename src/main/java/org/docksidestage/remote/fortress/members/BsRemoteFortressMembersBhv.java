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
package org.docksidestage.remote.fortress.members;

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.fortress.AbstractRemoteFortressBhv;
import org.docksidestage.remote.fortress.members.index.RemoteMembersDeleteParam;
import org.docksidestage.remote.fortress.members.index.RemoteMembersPostParam;
import org.docksidestage.remote.fortress.members.index.RemoteMembersPutParam;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of members.
 * @author FreeGen
 */
public abstract class BsRemoteFortressMembersBhv extends AbstractRemoteFortressBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemoteFortressMembersBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /members. (auto-generated method)<br>
     * <pre>
     * url: /members
     * httpMethod: GET
     * </pre>
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public String request() {
        return doRequest(rule -> {});
    }

    /**
     * Request remote call to /members. (auto-generated method)<br>
     * <pre>
     * url: /members
     * httpMethod: GET
     * </pre>
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected String doRequest(Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestGet(String.class, "/members", noMoreUrl(), noQuery(), rule -> {
            ruleOf(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /members.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOf(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /members/{memberId}. (auto-generated method)<br>
     * <pre>
     * url: /members/{memberId}
     * httpMethod: GET
     * </pre>
     * @param memberId The value of path variable for memberId. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public String requestGet(Integer memberId) {
        return doRequestGet(memberId, rule -> {});
    }

    /**
     * Request remote call to /members/{memberId}. (auto-generated method)<br>
     * <pre>
     * url: /members/{memberId}
     * httpMethod: GET
     * </pre>
     * @param memberId The value of path variable for memberId. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected String doRequestGet(Integer memberId, Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestGet(String.class, "/members/{memberId}", moreUrl(memberId), noQuery(), rule -> {
            ruleOfGetMemberId(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /members/{memberId}.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfGetMemberId(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /members/{memberId}. (auto-generated method)<br>
     * <pre>
     * url: /members/{memberId}
     * httpMethod: PUT
     * </pre>
     * @param memberId The value of path variable for memberId. (NotNull)
     * @param paramLambda The callback for RemoteMembersPutParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public String requestPut(Integer memberId, Consumer<RemoteMembersPutParam> paramLambda) {
        return doRequestPut(memberId, paramLambda, rule -> {});
    }

    /**
     * Request remote call to /members/{memberId}. (auto-generated method)<br>
     * <pre>
     * url: /members/{memberId}
     * httpMethod: PUT
     * </pre>
     * @param memberId The value of path variable for memberId. (NotNull)
     * @param paramLambda The callback for RemoteMembersPutParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected String doRequestPut(Integer memberId, Consumer<RemoteMembersPutParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteMembersPutParam param = new RemoteMembersPutParam();
        paramLambda.accept(param);
        return doRequestPut(String.class, "/members/{memberId}", moreUrl(memberId), param, rule -> {
            rule.sendBodyBy(
                    new org.lastaflute.remoteapi.sender.body.LaFormSender(new org.dbflute.remoteapi.mapping.FlVacantMappingPolicy()));
            ruleOfPutMemberId(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /members/{memberId}.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfPutMemberId(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /members/{memberId}. (auto-generated method)<br>
     * <pre>
     * url: /members/{memberId}
     * httpMethod: DELETE
     * </pre>
     * @param memberId The value of path variable for memberId. (NotNull)
     * @param paramLambda The callback for RemoteMembersDeleteParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public String requestDelete(Integer memberId, Consumer<RemoteMembersDeleteParam> paramLambda) {
        return doRequestDelete(memberId, paramLambda, rule -> {});
    }

    /**
     * Request remote call to /members/{memberId}. (auto-generated method)<br>
     * <pre>
     * url: /members/{memberId}
     * httpMethod: DELETE
     * </pre>
     * @param memberId The value of path variable for memberId. (NotNull)
     * @param paramLambda The callback for RemoteMembersDeleteParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected String doRequestDelete(Integer memberId, Consumer<RemoteMembersDeleteParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteMembersDeleteParam param = new RemoteMembersDeleteParam();
        paramLambda.accept(param);
        return doRequestDelete(String.class, "/members/{memberId}", moreUrl(memberId), query(param), rule -> {
            ruleOfDeleteMemberId(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /members/{memberId}.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfDeleteMemberId(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /members/. (auto-generated method)<br>
     * <pre>
     * url: /members/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteMembersPostParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public String requestPost(Consumer<RemoteMembersPostParam> paramLambda) {
        return doRequestPost(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /members/. (auto-generated method)<br>
     * <pre>
     * url: /members/
     * httpMethod: POST
     * </pre>
     * @param paramLambda The callback for RemoteMembersPostParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected String doRequestPost(Consumer<RemoteMembersPostParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemoteMembersPostParam param = new RemoteMembersPostParam();
        paramLambda.accept(param);
        return doRequestPost(String.class, "/members/", noMoreUrl(), param, rule -> {
            rule.sendBodyBy(
                    new org.lastaflute.remoteapi.sender.body.LaFormSender(new org.dbflute.remoteapi.mapping.FlVacantMappingPolicy()));
            ruleOfPost(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /members/.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfPost(FlutyRemoteApiRule rule) {
    }
}
