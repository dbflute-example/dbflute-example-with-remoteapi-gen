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
package org.docksidestage.unit;

import java.util.function.Supplier;

import javax.annotation.Resource;

import org.dbflute.remoteapi.FlutyRemoteBehavior;
import org.dbflute.remoteapi.mock.MockHttpClient;
import org.dbflute.remoteapi.mock.supporter.MockFreedomResponse.MockRequestDeterminer;
import org.dbflute.utflute.lastaflute.WebContainerTestCase;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * Use like this:
 * <pre>
 * YourTest extends {@link UnitRemoteapigenTestCase} {
 *
 *     public void test_yourMethod() {
 *         <span style="color: #3F7E5E">// ## Arrange ##</span>
 *         YourAction action = new YourAction();
 *         <span style="color: #FD4747">inject</span>(action);
 *
 *         <span style="color: #3F7E5E">// ## Act ##</span>
 *         action.submit();
 *
 *         <span style="color: #3F7E5E">// ## Assert ##</span>
 *         assertTrue(action...);
 *     }
 * }
 * </pre>
 * @author jflute
 */
public abstract class UnitRemoteapigenTestCase extends WebContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private RequestManager requestManager;

    // ===================================================================================
    //                                                                               Mock
    //                                                                              ======
    protected String derivedResopnsePath(Class<?> responseClass) {
        return derivedResopnsePath(responseClass, "", ".json");
    }

    protected String derivedResopnsePath(Class<?> responseClass, String pathPart) {
        return derivedResopnsePath(responseClass, "_", pathPart);
    }

    protected String derivedResopnsePath(Class<?> responseClass, String separator, String pathPart) {
        return responseClass.getName().replace(".", "/") + separator + pathPart;
    }

    /**
     * create Mock Remote Behavior.
     * <pre>
     * e.g.
     * RemoteAbcDefReturn returnBean = createMockRemoteBehavior(() -> new RemoteAbcBhv(requestManager), response, request -> {
     *     // assert request 
     *     return true;
     * }).requestNoconv(paramLambda);
     * </pre>
     * @param <BEHAVIOR> The remote behavior to create
     * @param newBehaviorLambda The callback for create remote behavior. (NotNull)
     * @param response The response returned by the method call of the created remote behavior. (NullAllowed)
     * @param requestLambda The callback for determination of corresponding request. (NotNull)
     * @return The Created remote behavior. (NotNull)
     */
    protected <BEHAVIOR extends FlutyRemoteBehavior> BEHAVIOR createMockRemoteBehavior(Supplier<BEHAVIOR> newBehaviorLambda,
            Object resopnse, MockRequestDeterminer requestLambda) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (resopnse == null) {
                response.asJsonNoContent(requestLambda);
            } else {
                if (resopnse instanceof String) {
                    response.asJsonDirectly((String) resopnse, requestLambda);
                } else {
                    response.asJsonDirectly(requestManager.getJsonManager().toJson(resopnse), requestLambda);
                }
            }
        });
        registerMock(client);
        BEHAVIOR behavior = newBehaviorLambda.get();
        inject(behavior);
        return behavior;
    }
}
