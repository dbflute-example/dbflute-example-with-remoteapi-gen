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

import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.util.DfCollectionUtil;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharGetParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharGetReturn;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPostParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPostReturn;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPutParam;
import org.docksidestage.remote.tricky.fieldcase.ngchar.RemoteFieldcaseNgcharPutReturn;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvParam;
import org.docksidestage.remote.tricky.fieldcase.noconv.RemoteFieldcaseNoconvReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.docksidestage.unit.helper.MockSupposedRequestHelper;
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
        RemoteFieldcaseNoconvReturn returnBean =
                createBhv(() -> new RemoteTrickyFieldcaseBhv(requestManager), new RemoteFieldcaseNoconvReturn()).requestNoconv(paramLambda);

        // ## Assert ##
        logger.debug("hangar_id={}", returnBean.hangar_id);
        logger.debug("onemanName={}", returnBean.onemanName);
        logger.debug("piari={}", returnBean.piari);
        logger.debug("BONVO={}", returnBean.BONVO);
    }

    // p1us2er0 Check the mapping of customized fields. (2022/05/02)
    public void test_requestNgcharGet() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNgcharGetParam> paramLambda = param -> {
            param.seaid = 1;
            param.landName = "land-Name";
            param.onePiari = "1Piari";
            param.unchanged = "unchanged";
        };
        Map<String, Object> returnMap = DfCollectionUtil.newLinkedHashMap();
        returnMap.put("hangar*id", 1);
        returnMap.put("oneman-name", "oneman-name");
        returnMap.put("1Piari", "1Piari");
        returnMap.put("unchanged", "unchanged");

        // ## Act ##
        RemoteFieldcaseNgcharGetReturn returnBean = createBhv(() -> new RemoteTrickyFieldcaseBhv(requestManager), returnMap, request -> {
            new MockSupposedRequestHelper(requestManager, request).getQuery().alwaysPresent(query -> {
                assertEquals("sea*id", "1", query.get("sea*id"));
                assertEquals("land-Name", "land-Name", query.get("land-Name"));
                assertEquals("1Piari", "1Piari", query.get("1Piari"));
                assertEquals("unchanged", "unchanged", query.get("unchanged"));
            });
            return true;
        }).requestNgcharGet(paramLambda);

        // ## Assert ##
        logger.debug("hangarid={}", returnBean.hangarid);
        logger.debug("onemanname={}", returnBean.onemanname);
        logger.debug("onePiari", returnBean.onePiari);
        logger.debug("unchanged", returnBean.unchanged);
        logger.debug("unchanged", returnBean.unchanged);

        assertEquals("hangarid", returnMap.get("hangar*id"), returnBean.hangarid);
        assertEquals("onemanname", returnMap.get("oneman-name"), returnBean.onemanname);
        assertEquals("onePiari", returnMap.get("1Piari"), returnBean.onePiari);
        assertEquals("unchanged", returnMap.get("unchanged"), returnBean.unchanged);
    }

    // p1us2er0 Check the mapping of customized fields. (2022/05/02)
    public void test_requestNgcharPost() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNgcharPostParam> paramLambda = param -> {
            param.seaid = 1;
            param.landName = "land-Name";
            param.onePiari = "1Piari";
            param.unchanged = "unchanged";
        };
        Map<String, Object> returnMap = DfCollectionUtil.newLinkedHashMap();
        returnMap.put("hangar*id", 1);
        returnMap.put("oneman-name", "oneman-name");
        returnMap.put("1Piari", "1Piari");
        returnMap.put("unchanged", "unchanged");

        // ## Act ##
        RemoteFieldcaseNgcharPostReturn returnBean = createBhv(() -> new RemoteTrickyFieldcaseBhv(requestManager), returnMap, request -> {
            new MockSupposedRequestHelper(requestManager, request).getForm().alwaysPresent(form -> {
                assertEquals("sea*id", "1", form.get("sea*id"));
                assertEquals("land-Name", "land-Name", form.get("land-Name"));
                assertEquals("1Piari", "1Piari", form.get("1Piari"));
                assertEquals("unchanged", "unchanged", form.get("unchanged"));
            });
            return true;
        }).requestNgcharPost(paramLambda);

        // ## Assert ##
        logger.debug("hangarid={}", returnBean.hangarid);
        logger.debug("onemanname={}", returnBean.onemanname);
        logger.debug("onePiari", returnBean.onePiari);
        logger.debug("unchanged", returnBean.unchanged);

        assertEquals("hangarid", returnMap.get("hangar*id"), returnBean.hangarid);
        assertEquals("onemanname", returnMap.get("oneman-name"), returnBean.onemanname);
        assertEquals("onePiari", returnMap.get("1Piari"), returnBean.onePiari);
        assertEquals("unchanged", returnMap.get("unchanged"), returnBean.unchanged);
    }

    // p1us2er0 Check the mapping of customized fields. (2022/05/02)
    public void test_requestNgcharPut() {
        // ## Arrange ##
        Consumer<RemoteFieldcaseNgcharPutParam> paramLambda = param -> {
            param.seaid = 1;
            param.landName = "land-Name";
            param.onePiari = "1Piari";
            param.unchanged = "unchanged";
        };
        Map<String, Object> returnMap = DfCollectionUtil.newLinkedHashMap();
        returnMap.put("hangar*id", 1);
        returnMap.put("oneman-name", "oneman-name");
        returnMap.put("1Piari", "1Piari");
        returnMap.put("unchanged", "unchanged");

        // ## Act ##
        RemoteFieldcaseNgcharPutReturn returnBean = createBhv(() -> new RemoteTrickyFieldcaseBhv(requestManager), returnMap, request -> {
            new MockSupposedRequestHelper(requestManager, request).getJsonBody().alwaysPresent(jsonBody -> {
                assertEquals("sea*id", 1.0, jsonBody.get("sea*id"));
                assertEquals("land-Name", "land-Name", jsonBody.get("land-Name"));
                assertEquals("1Piari", "1Piari", jsonBody.get("1Piari"));
                assertEquals("unchanged", "unchanged", jsonBody.get("unchanged"));
            });
            return true;
        }).requestNgcharPut(paramLambda);

        // ## Assert ##
        logger.debug("hangarid={}", returnBean.hangarid);
        logger.debug("onemanname={}", returnBean.onemanname);
        logger.debug("onePiari", returnBean.onePiari);
        logger.debug("unchanged", returnBean.unchanged);

        assertEquals("hangarid", returnMap.get("hangar*id"), returnBean.hangarid);
        assertEquals("onemanname", returnMap.get("oneman-name"), returnBean.onemanname);
        assertEquals("onePiari", returnMap.get("1Piari"), returnBean.onePiari);
        assertEquals("unchanged", returnMap.get("unchanged"), returnBean.unchanged);
    }
}
