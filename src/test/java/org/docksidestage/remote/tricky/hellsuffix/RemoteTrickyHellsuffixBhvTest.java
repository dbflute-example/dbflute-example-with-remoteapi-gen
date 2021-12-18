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
package org.docksidestage.remote.tricky.hellsuffix;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.tricky.hellsuffix.reservedsuffixjust.RemoteHellsuffixReservedsuffixjustReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of hellsuffix.
 * @author FreeGen
 */
public class RemoteTrickyHellsuffixBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteTrickyHellsuffixBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestReservedsuffixjust() {
        // ## Act ##
        RemoteHellsuffixReservedsuffixjustReturn returnBean = createBhv("{}").requestReservedsuffixjust();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("hellSuffixes={}", returnBean.hellSuffixes);
        if (returnBean.hellSuffixes != null) {
            returnBean.hellSuffixes.forEach(hellSuffixe -> {
                logger.debug("hellSuffixes.parkName={}", hellSuffixe.parkName);
                logger.debug("hellSuffixes.reservedSuffixJustResult={}", hellSuffixe.reservedSuffixJustResult);
                if (hellSuffixe.reservedSuffixJustResult != null) {
                    logger.debug("hellSuffixes.reservedSuffixJustResult.stageName={}", hellSuffixe.reservedSuffixJustResult.stageName);
                }
            });
        }
    }

    private RemoteTrickyHellsuffixBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteTrickyHellsuffixBhv bhv = new RemoteTrickyHellsuffixBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
