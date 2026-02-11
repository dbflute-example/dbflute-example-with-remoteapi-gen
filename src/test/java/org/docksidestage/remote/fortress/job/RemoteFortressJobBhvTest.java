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
package org.docksidestage.remote.fortress.job;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.fortress.job.execute.RemoteJobExecuteParam;
import org.docksidestage.remote.fortress.job.execute.RemoteJobExecuteReturn;
import org.docksidestage.remote.fortress.job.execute.nowait.RemoteJobExecuteNowaitParam;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of job.
 * @author FreeGen
 */
public class RemoteFortressJobBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressJobBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestExecute() {
        // ## Arrange ##
        String jobCode = "jobCode";
        Consumer<RemoteJobExecuteParam> paramLambda = param -> {
            param.executionDateTime = java.time.LocalDateTime.now();
            param.varyingParameter = new java.util.LinkedHashMap<String, Object>();
        };

        // ## Act ##
        RemoteJobExecuteReturn returnBean = createBhv("{}").requestExecute(jobCode, paramLambda);

        // ## Assert ##
        logger.debug("jobUnique={}", returnBean.jobUnique);
        logger.debug("jobTypeFqcn={}", returnBean.jobTypeFqcn);
        logger.debug("activationTime={}", returnBean.activationTime);
        logger.debug("beginTime={}", returnBean.beginTime);
        logger.debug("endTime={}", returnBean.endTime);
        logger.debug("endTitleRoll={}", returnBean.endTitleRoll);
        logger.debug("execResultType={}", returnBean.execResultType);
        logger.debug("errorEnding={}", returnBean.errorEnding);
        logger.debug("errorMessage={}", returnBean.errorMessage);
    }

    public void test_requestExecuteNowait() {
        // ## Arrange ##
        String jobCode = "jobCode";
        Consumer<RemoteJobExecuteNowaitParam> paramLambda = param -> {
            param.executionDateTime = java.time.LocalDateTime.now();
            param.varyingParameter = new java.util.LinkedHashMap<String, Object>();
        };

        // ## Act ##
        createBhv(null).requestExecuteNowait(jobCode, paramLambda);
    }

    public void test_requestStop() {
        // ## Arrange ##
        String jobCode = "jobCode";

        // ## Act ##
        createBhv(null).requestStop(jobCode);
    }

    private RemoteFortressJobBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressJobBhv bhv = new RemoteFortressJobBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
