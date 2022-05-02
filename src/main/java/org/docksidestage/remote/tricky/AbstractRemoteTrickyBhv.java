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
package org.docksidestage.remote.tricky;

import org.dbflute.remoteapi.FlutyRemoteApiRule;
import org.lastaflute.core.json.JsonMappingOption;
import org.lastaflute.remoteapi.mapping.LaVacantMappingPolicy;
import org.lastaflute.remoteapi.receiver.LaJsonReceiver;
import org.lastaflute.remoteapi.sender.body.LaJsonSender;
import org.lastaflute.remoteapi.sender.query.LaQuerySender;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * The base class of all remote API behaviors as RemoteApiTricky.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author FreeGen
 */
public abstract class AbstractRemoteTrickyBhv extends org.lastaflute.remoteapi.LastaRemoteBehavior {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * @param requestManager The manager of request, LastaFlute component. (NotNull)
     */
    public AbstractRemoteTrickyBhv(RequestManager requestManager) {
        super(requestManager);
    }

    // ===================================================================================
    //                                                                          Initialize
    //                                                                          ==========
    @Override
    protected void yourDefaultRule(FlutyRemoteApiRule rule) {
        JsonMappingOption mappingOption = new JsonMappingOption();
        rule.sendQueryBy(new LaQuerySender(new LaVacantMappingPolicy()));
        rule.sendBodyBy(new LaJsonSender(requestManager, mappingOption));
        rule.receiveBodyBy(new LaJsonReceiver(requestManager, mappingOption));
        rule.getValidatorOption().suppressParam().suppressReturn();
    }

    @Override
    protected String getUrlBase() {
        return "http://localhost:8000/dummy";
    }
}