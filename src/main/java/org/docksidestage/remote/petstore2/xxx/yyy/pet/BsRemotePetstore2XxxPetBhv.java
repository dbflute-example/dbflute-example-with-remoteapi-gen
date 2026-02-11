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
package org.docksidestage.remote.petstore2.xxx.yyy.pet;

import java.util.function.Consumer;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.docksidestage.remote.petstore2.xxx.yyy.AbstractRemotePetstore2XxxBhv;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbystatus.RemotePetFindbystatusParam;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbystatus.RemotePetFindbystatusReturn;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbytags.RemotePetFindbytagsParam;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbytags.RemotePetFindbytagsReturn;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.index.RemotePetReturn;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class as generation gap for remote API of pet.
 * @author FreeGen
 */
public abstract class BsRemotePetstore2XxxPetBhv extends AbstractRemotePetstore2XxxBhv {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public BsRemotePetstore2XxxPetBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    /**
     * Request remote call to /pet/findByStatus. (auto-generated method)<br>
     * <pre>
     * url: /pet/findByStatus
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemotePetFindbystatusParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public org.eclipse.collections.api.list.ImmutableList<RemotePetFindbystatusReturn> requestFindbystatus(Consumer<RemotePetFindbystatusParam> paramLambda) {
        return doRequestFindbystatus(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /pet/findByStatus. (auto-generated method)<br>
     * <pre>
     * url: /pet/findByStatus
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemotePetFindbystatusParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected org.eclipse.collections.api.list.ImmutableList<RemotePetFindbystatusReturn> doRequestFindbystatus(Consumer<RemotePetFindbystatusParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemotePetFindbystatusParam param = new RemotePetFindbystatusParam();
        paramLambda.accept(param);
        return doRequestGet(new org.lastaflute.di.helper.misc.ParameterizedRef<org.eclipse.collections.api.list.ImmutableList<RemotePetFindbystatusReturn>>() {
        }.getType(), "/pet/findByStatus", noMoreUrl(), query(param), rule -> {
            ruleOfFindbystatus(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /pet/findByStatus.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfFindbystatus(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /pet/findByTags. (auto-generated method)<br>
     * <pre>
     * url: /pet/findByTags
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemotePetFindbytagsParam. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public org.eclipse.collections.api.list.ImmutableList<RemotePetFindbytagsReturn> requestFindbytags(Consumer<RemotePetFindbytagsParam> paramLambda) {
        return doRequestFindbytags(paramLambda, rule -> {});
    }

    /**
     * Request remote call to /pet/findByTags. (auto-generated method)<br>
     * <pre>
     * url: /pet/findByTags
     * httpMethod: GET
     * </pre>
     * @param paramLambda The callback for RemotePetFindbytagsParam. (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected org.eclipse.collections.api.list.ImmutableList<RemotePetFindbytagsReturn> doRequestFindbytags(Consumer<RemotePetFindbytagsParam> paramLambda, Consumer<FlutyRemoteApiRule> ruleLambda) {
        RemotePetFindbytagsParam param = new RemotePetFindbytagsParam();
        paramLambda.accept(param);
        return doRequestGet(new org.lastaflute.di.helper.misc.ParameterizedRef<org.eclipse.collections.api.list.ImmutableList<RemotePetFindbytagsReturn>>() {
        }.getType(), "/pet/findByTags", noMoreUrl(), query(param), rule -> {
            ruleOfFindbytags(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /pet/findByTags.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfFindbytags(FlutyRemoteApiRule rule) {
    }

    /**
     * Request remote call to /pet/{petId}. (auto-generated method)<br>
     * <pre>
     * url: /pet/{petId}
     * httpMethod: GET
     * </pre>
     * @param petId The value of path variable for petId. (ID of pet to return) (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    public RemotePetReturn request(Long petId) {
        return doRequest(petId, rule -> {});
    }

    /**
     * Request remote call to /pet/{petId}. (auto-generated method)<br>
     * <pre>
     * url: /pet/{petId}
     * httpMethod: GET
     * </pre>
     * @param petId The value of path variable for petId. (ID of pet to return) (NotNull)
     * @param ruleLambda The callback for setting rule as dynamic requirement. (NotNull)
     * @return The bean object as return type, receiving response body. (NotNull)
     */
    protected RemotePetReturn doRequest(Long petId, Consumer<FlutyRemoteApiRule> ruleLambda) {
        return doRequestGet(RemotePetReturn.class, "/pet/{petId}", moreUrl(petId), noQuery(), rule -> {
            ruleOfPetId(rule);
            ruleLambda.accept(rule);
        });
    }

    /**
     * Set up method-level rule of /pet/{petId}.<br>
     * @param rule The rule that class default rule is already set. (NotNull)
     */
    protected void ruleOfPetId(FlutyRemoteApiRule rule) {
    }
}
