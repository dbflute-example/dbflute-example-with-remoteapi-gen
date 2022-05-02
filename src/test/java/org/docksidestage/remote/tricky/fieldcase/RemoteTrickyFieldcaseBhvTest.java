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
package org.docksidestage.remote.tricky.fieldcase;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.dbflute.remoteapi.mock.supporter.MockFreedomResponse.MockRequestDeterminer;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharGetParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharGetReturn;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPostParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPostReturn;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPutParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPutReturn;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvParam;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of fieldcase.
 * @author FreeGen
 */
public class RemoteTrickyFieldcaseBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteTrickyFieldcaseBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestNoconv() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNoconvParam> paramLambda = param -> {
            param.sea_id = 1;
            param.landName = "landName";
            param.piari = "piari";
            param.BONVO = "BONVO";
        };

        // ## Act ##
        RemoteFieldcaseNoconvReturn returnBean = createBhv("{}").requestNoconv(paramLambda);

        // ## Assert ##
        logger.debug("hangar_id={}", returnBean.hangar_id);
        logger.debug("onemanName={}", returnBean.onemanName);
        logger.debug("piari={}", returnBean.piari);
        logger.debug("BONVO={}", returnBean.BONVO);
    }

    public void test_requestNgcharGet() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNgcharGetParam> paramLambda = param -> {
            param.seaid = 1;
            param.landName = "land-Name";
            param.onePiari = "1Piari";
        };

        // ## Act ##
        RemoteFieldcaseNgcharGetReturn returnBean =
                createBhv("{ \"hangar*id\": 1, \"oneman-name\": \"oneman-name\", \"1Piari\": \"1Piari\" }", request -> {
                    //request.getParam().alwaysPresent(param -> {
                    // p1us2er0 Check the mapping of customized fields. (2022/05/02)
                    //@SuppressWarnings("unchecked")
                    //Map<String, Object> requestMap = this.requestManager.getJsonManager().fromJson(param, HashMap.class);
                    //assertEquals("sea*id", 1, requestMap.get("sea*id"));
                    //assertEquals("land-Name", "land-Name", requestMap.get("land-Name"));
                    //assertEquals("1Piari", "1Piari", requestMap.get("1Piari"));
                    //});
                    return true;
                }).requestNgcharGet(paramLambda);

        // ## Assert ##
        logger.debug("hangarid={}", returnBean.hangarid);
        logger.debug("onemanname={}", returnBean.onemanname);
        logger.debug("onePiari", returnBean.onePiari);

        // p1us2er0 Check the mapping of customized fields. (2022/05/02)
        assertEquals("hangarid", 1, returnBean.hangarid);
        assertEquals("onemanname", "oneman-name", returnBean.onemanname);
        assertEquals("onePiari", "1Piari", returnBean.onePiari);
    }

    public void test_requestNgcharPost() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNgcharPostParam> paramLambda = param -> {
            param.seaid = 1;
            param.landName = "land-Name";
            param.onePiari = "1Piari";
        };

        // ## Act ##
        RemoteFieldcaseNgcharPostReturn returnBean =
                createBhv("{ \"hangar*id\": 1, \"oneman-name\": \"oneman-name\", \"1Piari\": \"1Piari\" }", request -> {
                    //request.getParam().alwaysPresent(param -> {
                    // p1us2er0 Check the mapping of customized fields. (2022/05/02)
                    //@SuppressWarnings("unchecked")
                    //Map<String, Object> requestMap = this.requestManager.getJsonManager().fromJson(param, HashMap.class);
                    //assertEquals("sea*id", 1, requestMap.get("sea*id"));
                    //assertEquals("land-Name", "land-Name", requestMap.get("land-Name"));
                    //assertEquals("1Piari", "1Piari", requestMap.get("1Piari"));
                    //});
                    return true;
                }).requestNgcharPost(paramLambda);

        // ## Assert ##
        logger.debug("hangarid={}", returnBean.hangarid);
        logger.debug("onemanname={}", returnBean.onemanname);
        logger.debug("onePiari", returnBean.onePiari);

        // p1us2er0 Check the mapping of customized fields. (2022/05/02)
        assertEquals("hangarid", 1, returnBean.hangarid);
        assertEquals("onemanname", "oneman-name", returnBean.onemanname);
        assertEquals("onePiari", "1Piari", returnBean.onePiari);
    }

    public void test_requestNgcharPut() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNgcharPutParam> paramLambda = param -> {
            param.seaid = 1;
            param.landName = "land-Name";
            param.onePiari = "1Piari";
        };

        // ## Act ##
        RemoteFieldcaseNgcharPutReturn returnBean =
                createBhv("{ \"hangar*id\": 1, \"oneman-name\": \"oneman-name\", \"1Piari\": \"1Piari\" }", request -> {
                    request.getBody().alwaysPresent(body -> {
                        // p1us2er0 Check the mapping of customized fields. (2022/05/02)
                        @SuppressWarnings("unchecked")
                        Map<String, Object> requestMap = this.requestManager.getJsonManager().fromJson(body, HashMap.class);
                        System.out.println(requestMap);
                        assertEquals("sea*id", 1.0, requestMap.get("sea*id"));
                        assertEquals("land-Name", "land-Name", requestMap.get("land-Name"));
                        assertEquals("1Piari", "1Piari", requestMap.get("1Piari"));
                    });
                    return true;
                }).requestNgcharPut(paramLambda);

        // ## Assert ##
        logger.debug("hangarid={}", returnBean.hangarid);
        logger.debug("onemanname={}", returnBean.onemanname);
        logger.debug("onePiari", returnBean.onePiari);

        // p1us2er0 Check the mapping of customized fields. (2022/05/02)
        assertEquals("hangarid", 1, returnBean.hangarid);
        assertEquals("onemanname", "oneman-name", returnBean.onemanname);
        assertEquals("onePiari", "1Piari", returnBean.onePiari);
    }

    private RemoteTrickyFieldcaseBhv createBhv(String json) {
        return createBhv(json, request -> true);
    }

    private RemoteTrickyFieldcaseBhv createBhv(String json, MockRequestDeterminer requestLambda) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(requestLambda);
            } else {
                response.asJsonDirectly(json, requestLambda);
            }
        });
        registerMock(client);
        RemoteTrickyFieldcaseBhv bhv = new RemoteTrickyFieldcaseBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
