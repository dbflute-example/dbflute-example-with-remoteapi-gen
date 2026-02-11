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
package org.docksidestage.remote.maihama.showbase.wx;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.maihama.showbase.wx.faicli.RemoteWxFaicliParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.body.basic.RemoteWxRemogenBodyBasicParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.body.list.RemoteWxRemogenBodyListParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.list.basic.RemoteWxRemogenListBasicReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.list.genebean.RemoteWxRemogenListGenebeanReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.list.genestring.RemoteWxRemogenListGenestringReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.list.innergene.RemoteWxRemogenListInnergeneReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.RemoteWxRemogenMethodDeleteParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.RemoteWxRemogenMethodDeleteReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.RemoteWxRemogenMethodGetParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.RemoteWxRemogenMethodGetReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.RemoteWxRemogenMethodPostParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.RemoteWxRemogenMethodPostReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.noquery.RemoteWxRemogenMethodNoqueryReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformDeleteParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformDeleteReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformGetParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformGetReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.onbodyjson.RemoteWxRemogenMethodOnbodyjsonParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.onbodyjson.RemoteWxRemogenMethodOnbodyjsonReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.samename.RemoteWxRemogenMethodSamenameGetParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.samename.RemoteWxRemogenMethodSamenameGetReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.samename.RemoteWxRemogenMethodSamenamePostParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.method.samename.RemoteWxRemogenMethodSamenamePostReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.RemoteWxRemogenRoutingReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.amba.RemoteWxRemogenRoutingAmbaReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.amphi.theater.maihama.RemoteWxRemogenRoutingAmphiTheaterMaihamaReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.bonvo.RemoteWxRemogenRoutingBonvoReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.celeb.RemoteWxRemogenRoutingCelebReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.dohotel.RemoteWxRemogenRoutingDohotelFirstSecondParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.dohotel.RemoteWxRemogenRoutingDohotelParam;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.dohotel.RemoteWxRemogenRoutingDohotelReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.dstore.RemoteWxRemogenRoutingDstoreReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.land.RemoteWxRemogenRoutingLandReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.maihama.RemoteWxRemogenRoutingMaihamaReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.miraco.RemoteWxRemogenRoutingMiracoReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.piari.RemoteWxRemogenRoutingPiariReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.resola.RemoteWxRemogenRoutingResolaReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.routing.sea.RemoteWxRemogenRoutingSeaReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.suffix.allsuffix.RemoteWxRemogenSuffixAllsuffixReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.suffix.nosuffix.RemoteWxRemogenSuffixNosuffixReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.suffix.partonly.RemoteWxRemogenSuffixPartonlyReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.suffix.toponly.RemoteWxRemogenSuffixToponlyReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.tricky.nobody.RemoteWxRemogenTrickyNobodyReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.tricky.oddprop.RemoteWxRemogenTrickyOddpropReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.tricky.recycle.RemoteWxRemogenTrickyRecycleReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.tricky.selfref.RemoteWxRemogenTrickySelfrefReturn;
import org.docksidestage.remote.maihama.showbase.wx.remogen.tricky.suffixhell.RemoteWxRemogenTrickySuffixhellReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of wx.
 * @author FreeGen
 */
public class RemoteMaihamaShowbaseWxBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteMaihamaShowbaseWxBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestFaicli() {
        // ## Arrange ##
        Consumer<RemoteWxFaicliParam> paramLambda = param -> {
            param.sea = "sea";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestFaicli(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestFaicliUnknown() {
        // ## Act ##
        createBhv(null).requestFaicliUnknown();
    }

    public void test_requestFaicliEntity() {
        // ## Arrange ##
        String account = "account";

        // ## Act ##
        createBhv(null).requestFaicliEntity(account);
    }

    public void test_requestRemogenBodyBasic() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenBodyBasicParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamBody = "iamBody";
        };

        // ## Act ##
        createBhv(null).requestRemogenBodyBasic(paramLambda);
    }

    public void test_requestRemogenBodyList() {
        // ## Arrange ##
        org.eclipse.collections.api.list.ImmutableList<java.util.Map<String, Object>> bodyList =
                org.eclipse.collections.impl.factory.Lists.immutable.empty();
        Consumer<RemoteWxRemogenBodyListParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamBody = "iamBody";
        };

        // ## Act ##
        createBhv(null).requestRemogenBodyList(bodyList, paramLambda);
    }

    public void test_requestRemogenListBasic() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWxRemogenListBasicReturn> list = createBhv("[]").requestRemogenListBasic();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("key={}", returnBean.key);
            logger.debug("value={}", returnBean.value);
        });
    }

    public void test_requestRemogenListGenebean() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWxRemogenListGenebeanReturn> list =
                createBhv("[]").requestRemogenListGenebean();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("key={}", returnBean.key);
            logger.debug("value={}", returnBean.value);
        });
    }

    public void test_requestRemogenListGenestring() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWxRemogenListGenestringReturn> list =
                createBhv("[]").requestRemogenListGenestring();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("key={}", returnBean.key);
            logger.debug("value={}", returnBean.value);
        });
    }

    public void test_requestRemogenListInnergene() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWxRemogenListInnergeneReturn> list =
                createBhv("[]").requestRemogenListInnergene();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("key={}", returnBean.key);
            logger.debug("value={}", returnBean.value);
        });
    }

    public void test_requestRemogenMethodGet() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodGetParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamForm = "iamForm";
        };

        // ## Act ##
        RemoteWxRemogenMethodGetReturn returnBean = createBhv("{}").requestRemogenMethodGet(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodPost() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodPostParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamBody = "iamBody";
        };

        // ## Act ##
        RemoteWxRemogenMethodPostReturn returnBean = createBhv("{}").requestRemogenMethodPost(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodDelete() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodDeleteParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamForm = "iamForm";
        };

        // ## Act ##
        RemoteWxRemogenMethodDeleteReturn returnBean = createBhv("{}").requestRemogenMethodDelete(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodOnbodyformGet() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodOnbodyformGetParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamForm = "iamForm";
        };

        // ## Act ##
        RemoteWxRemogenMethodOnbodyformGetReturn returnBean = createBhv("{}").requestRemogenMethodOnbodyformGet(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodOnbodyformDelete() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodOnbodyformDeleteParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamForm = "iamForm";
        };

        // ## Act ##
        RemoteWxRemogenMethodOnbodyformDeleteReturn returnBean = createBhv("{}").requestRemogenMethodOnbodyformDelete(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodOnbodyjson() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodOnbodyjsonParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamBody = "iamBody";
        };

        // ## Act ##
        RemoteWxRemogenMethodOnbodyjsonReturn returnBean = createBhv("{}").requestRemogenMethodOnbodyjson(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodSamenameGet() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodSamenameGetParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamForm = "iamForm";
        };

        // ## Act ##
        RemoteWxRemogenMethodSamenameGetReturn returnBean = createBhv("{}").requestRemogenMethodSamenameGet(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodSamenamePost() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenMethodSamenamePostParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.iamBody = "iamBody";
        };

        // ## Act ##
        RemoteWxRemogenMethodSamenamePostReturn returnBean = createBhv("{}").requestRemogenMethodSamenamePost(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenMethodNoquery() {
        // ## Act ##
        RemoteWxRemogenMethodNoqueryReturn returnBean = createBhv("{}").requestRemogenMethodNoquery();

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRemogenRouting() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRemogenRoutingReturn returnBean = createBhv("{}").requestRemogenRouting(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingMaihama() {
        // ## Act ##
        RemoteWxRemogenRoutingMaihamaReturn returnBean = createBhv("{}").requestRemogenRoutingMaihama();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingSea() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRemogenRoutingSeaReturn returnBean = createBhv("{}").requestRemogenRoutingSea(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingLand() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRemogenRoutingLandReturn returnBean = createBhv("{}").requestRemogenRoutingLand(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingPiari() {
        // ## Act ##
        RemoteWxRemogenRoutingPiariReturn returnBean = createBhv("{}").requestRemogenRoutingPiari();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingPiariFirst() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRemogenRoutingPiariReturn returnBean = createBhv("{}").requestRemogenRoutingPiari(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingDstore() {
        // ## Act ##
        RemoteWxRemogenRoutingDstoreReturn returnBean = createBhv("{}").requestRemogenRoutingDstore();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingDstoreFirst() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRemogenRoutingDstoreReturn returnBean = createBhv("{}").requestRemogenRoutingDstore(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingDstoreSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRemogenRoutingDstoreReturn returnBean = createBhv("{}").requestRemogenRoutingDstore(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingBonvo() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRemogenRoutingBonvoReturn returnBean = createBhv("{}").requestRemogenRoutingBonvo(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingBonvoSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRemogenRoutingBonvoReturn returnBean = createBhv("{}").requestRemogenRoutingBonvo(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingAmba() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRemogenRoutingAmbaReturn returnBean = createBhv("{}").requestRemogenRoutingAmba(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingAmbaThirdThirdThird() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        String third = "third";

        // ## Act ##
        RemoteWxRemogenRoutingAmbaReturn returnBean = createBhv("{}").requestRemogenRoutingAmba(first, second, third);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingMiraco() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        String third = "third";

        // ## Act ##
        RemoteWxRemogenRoutingMiracoReturn returnBean = createBhv("{}").requestRemogenRoutingMiraco(first, second, third);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingMiracoFourthFourthFourthFourth() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        String third = "third";
        String fourth = "fourth";

        // ## Act ##
        RemoteWxRemogenRoutingMiracoReturn returnBean = createBhv("{}").requestRemogenRoutingMiraco(first, second, third, fourth);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingDohotel() {
        // ## Arrange ##
        String first = "first";
        Consumer<RemoteWxRemogenRoutingDohotelParam> paramLambda = param -> {
            param.param = "param";
        };

        // ## Act ##
        RemoteWxRemogenRoutingDohotelReturn returnBean = createBhv("{}").requestRemogenRoutingDohotel(first, paramLambda);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingDohotelSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        Consumer<RemoteWxRemogenRoutingDohotelFirstSecondParam> paramLambda = param -> {
            param.param = "param";
        };

        // ## Act ##
        RemoteWxRemogenRoutingDohotelReturn returnBean = createBhv("{}").requestRemogenRoutingDohotel(first, second, paramLambda);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingCeleb() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRemogenRoutingCelebReturn returnBean = createBhv("{}").requestRemogenRoutingCeleb(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingCelebSecondSecond() {
        // ## Arrange ##
        Integer first = 1;
        Long second = 1L;

        // ## Act ##
        RemoteWxRemogenRoutingCelebReturn returnBean = createBhv("{}").requestRemogenRoutingCeleb(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingResola() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRemogenRoutingResolaReturn returnBean = createBhv("{}").requestRemogenRoutingResola(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenRoutingAmphiTheaterMaihama() {
        // ## Arrange ##
        Integer first = 1;
        String second = "second";

        // ## Act ##
        RemoteWxRemogenRoutingAmphiTheaterMaihamaReturn returnBean =
                createBhv("{}").requestRemogenRoutingAmphiTheaterMaihama(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRemogenSuffixAllsuffix() {
        // ## Act ##
        RemoteWxRemogenSuffixAllsuffixReturn returnBean = createBhv("{}").requestRemogenSuffixAllsuffix();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("resortPark={}", returnBean.resortPark);
        if (returnBean.resortPark != null) {
            logger.debug("resortPark.parkName={}", returnBean.resortPark.parkName);
            logger.debug("resortPark.showStages={}", returnBean.resortPark.showStages);
            if (returnBean.resortPark.showStages != null) {
                returnBean.resortPark.showStages.forEach(showStage -> {
                    logger.debug("resortPark.showStage[].stageName={}", showStage.stageName);
                });
            }
        }
    }

    public void test_requestRemogenSuffixNosuffix() {
        // ## Act ##
        RemoteWxRemogenSuffixNosuffixReturn returnBean = createBhv("{}").requestRemogenSuffixNosuffix();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("resortPark={}", returnBean.resortPark);
    }

    public void test_requestRemogenSuffixPartonly() {
        // ## Act ##
        RemoteWxRemogenSuffixPartonlyReturn returnBean = createBhv("{}").requestRemogenSuffixPartonly();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("resortPark={}", returnBean.resortPark);
        if (returnBean.resortPark != null) {
            logger.debug("resortPark.parkName={}", returnBean.resortPark.parkName);
            logger.debug("resortPark.showStages={}", returnBean.resortPark.showStages);
            if (returnBean.resortPark.showStages != null) {
                returnBean.resortPark.showStages.forEach(showStage -> {
                    logger.debug("resortPark.showStage[].stageName={}", showStage.stageName);
                });
            }
        }
    }

    public void test_requestRemogenSuffixToponly() {
        // ## Act ##
        RemoteWxRemogenSuffixToponlyReturn returnBean = createBhv("{}").requestRemogenSuffixToponly();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("resortPark={}", returnBean.resortPark);
        if (returnBean.resortPark != null) {
            logger.debug("resortPark.parkName={}", returnBean.resortPark.parkName);
            logger.debug("resortPark.showStages={}", returnBean.resortPark.showStages);
            if (returnBean.resortPark.showStages != null) {
                returnBean.resortPark.showStages.forEach(showStage -> {
                    logger.debug("resortPark.showStage[].stageName={}", showStage.stageName);
                });
            }
        }
    }

    public void test_requestRemogenTrickyAllnone() {
        // ## Act ##
        createBhv(null).requestRemogenTrickyAllnone();
    }

    public void test_requestRemogenTrickyNobody() {
        // ## Act ##
        RemoteWxRemogenTrickyNobodyReturn returnBean = createBhv("{}").requestRemogenTrickyNobody();

        // ## Assert ##
        logger.debug("key={}", returnBean.key);
        logger.debug("value={}", returnBean.value);
    }

    public void test_requestRemogenTrickyOddprop() {
        // ## Act ##
        RemoteWxRemogenTrickyOddpropReturn returnBean = createBhv("{}").requestRemogenTrickyOddprop();

        // ## Assert ##
        logger.debug("seaResult={}", returnBean.seaResult);
        logger.debug("landBeanCount={}", returnBean.landBeanCount);
        logger.debug("normalEntry={}", returnBean.normalEntry);
        logger.debug("beanEntry={}", returnBean.beanEntry);
        logger.debug("plainGenericEntry={}", returnBean.plainGenericEntry);
        logger.debug("genericEntry={}", returnBean.genericEntry);
    }

    public void test_requestRemogenTrickyRecycle() {
        // ## Act ##
        RemoteWxRemogenTrickyRecycleReturn returnBean = createBhv("{}").requestRemogenTrickyRecycle();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("firstPark={}", returnBean.firstPark);
        if (returnBean.firstPark != null) {
            logger.debug("firstPark.parkName={}", returnBean.firstPark.parkName);
            logger.debug("firstPark.showStages={}", returnBean.firstPark.showStages);
            if (returnBean.firstPark.showStages != null) {
                returnBean.firstPark.showStages.forEach(showStage -> {
                    logger.debug("firstPark.showStages[].stageName={}", showStage.stageName);
                });
            }
            logger.debug("firstPark.themeColor={}", returnBean.firstPark.themeColor);
            if (returnBean.firstPark.themeColor != null) {
                logger.debug("firstPark.themeColor.colorName={}", returnBean.firstPark.themeColor.colorName);
                logger.debug("firstPark.themeColor.rgb={}", returnBean.firstPark.themeColor.rgb);
            }
        }
        logger.debug("extendedAreas={}", returnBean.extendedAreas);
        if (returnBean.extendedAreas != null) {
            returnBean.extendedAreas.forEach(extendedArea -> {
                logger.debug("extendedAreas[].direction={}", extendedArea.direction);
                logger.debug("extendedAreas[].nextPark={}", extendedArea.nextPark);
                if (extendedArea.nextPark != null) {
                    logger.debug("extendedAreas[].nextPark.showStages={}", extendedArea.nextPark.showStages);
                    if (extendedArea.nextPark.showStages != null) {
                        extendedArea.nextPark.showStages.forEach(showStage -> {
                            logger.debug("extendedAreas[].nextPark.showStages[].stageName={}", showStage.stageName);
                        });
                    }
                    logger.debug("extendedAreas[].nextPark.themeColor={}", extendedArea.nextPark.themeColor);
                    if (extendedArea.nextPark.themeColor != null) {
                        logger.debug("extendedAreas[].nextPark.themeColor.colorName={}", extendedArea.nextPark.themeColor.colorName);
                        logger.debug("extendedAreas[].nextPark.themeColor.rgb={}", extendedArea.nextPark.themeColor.rgb);
                    }
                }
            });
        }
        logger.debug("departmentStore={}", returnBean.departmentStore);
        if (returnBean.departmentStore != null) {
            logger.debug("departmentStore.storeName={}", returnBean.departmentStore.storeName);
            logger.debug("departmentStore.shopCount={}", returnBean.departmentStore.shopCount);
            logger.debug("departmentStore.officialShop={}", returnBean.departmentStore.officialShop);
            if (returnBean.departmentStore.officialShop != null) {
                logger.debug("departmentStore.officialShop.shopName={}", returnBean.departmentStore.officialShop.shopName);
            }
            logger.debug("departmentStore.showStage={}", returnBean.departmentStore.showStage);
            if (returnBean.departmentStore.showStage != null) {
                logger.debug("departmentStore.showStage.stageName={}", returnBean.departmentStore.showStage.stageName);
            }
        }
        logger.debug("bigHotels={}", returnBean.bigHotels);
        if (returnBean.bigHotels != null) {
            returnBean.bigHotels.forEach(bigHotel -> {
                logger.debug("bigHotel[].hotelName={}", bigHotel.hotelName);
                logger.debug("bigHotel[].correspondingPark={}", bigHotel.correspondingPark);
                if (bigHotel.correspondingPark != null) {
                    logger.debug("bigHotel[].correspondingPark.parkName={}", bigHotel.correspondingPark.parkName);
                    logger.debug("bigHotel[].correspondingPark.showStages={}", bigHotel.correspondingPark.showStages);
                    if (bigHotel.correspondingPark.showStages != null) {
                        bigHotel.correspondingPark.showStages.forEach(showStage -> {
                            logger.debug("bigHotel[].correspondingPark.showStages[].stageName={}", showStage.stageName);
                        });
                    }
                    logger.debug("bigHotel[].correspondingPark.themeColor={}", bigHotel.correspondingPark.themeColor);
                    if (bigHotel.correspondingPark.themeColor != null) {
                        logger.debug("bigHotel[].correspondingPark.themeColor.colorName={}",
                                bigHotel.correspondingPark.themeColor.colorName);
                        logger.debug("bigHotel[].correspondingPark.themeColor.rgb={}", bigHotel.correspondingPark.themeColor.rgb);
                    }
                }
                logger.debug("bigHotel[].officialShop={}", bigHotel.officialShop);
                if (bigHotel.officialShop != null) {
                    logger.debug("bigHotel[].officialShop.shopName={}", bigHotel.officialShop.shopName);
                }
                logger.debug("bigHotel[].showStage={}", bigHotel.showStage);
                if (bigHotel.showStage != null) {
                    logger.debug("bigHotel[].showStage.stageName={}", bigHotel.showStage.stageName);
                }
                logger.debug("bigHotel[].themeColor={}", bigHotel.themeColor);
                if (bigHotel.themeColor != null) {
                    logger.debug("bigHotel[].themeColor.colorName={}", bigHotel.themeColor.colorName);
                    logger.debug("bigHotel[].themeColor.rgb={}", bigHotel.themeColor.rgb);

                }
            });
        }
    }

    public void test_requestRemogenTrickySelfref() {
        // ## Act ##
        RemoteWxRemogenTrickySelfrefReturn returnBean = createBhv("{}").requestRemogenTrickySelfref();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("resortPark={}", returnBean.resortPark);
        if (returnBean.resortPark != null) {
            logger.debug("resortPark.parkName={}", returnBean.resortPark.parkName);
            logger.debug("resortPark.parentPark={}", returnBean.resortPark.parentPark);
            if (returnBean.resortPark.parentPark != null) {
                logger.debug("resortPark.parentPark.parkName={}", returnBean.resortPark.parentPark.parkName);
                logger.debug("resortPark.parentPark.parentPark={}", returnBean.resortPark.parentPark.parentPark);
            }
        }
        logger.debug("extendedArea={}", returnBean.extendedArea);
        if (returnBean.extendedArea != null) {
            logger.debug("extendedArea.areaName={}", returnBean.extendedArea.areaName);
            logger.debug("extendedArea.parkingArea={}", returnBean.extendedArea.parkingArea);
            if (returnBean.extendedArea.parkingArea != null) {
                logger.debug("extendedArea.parkingArea.areaName={}", returnBean.extendedArea.parkingArea.areaName);
                logger.debug("extendedArea.parkingArea.internalArea={}", returnBean.extendedArea.parkingArea.internalArea);
            }
        }
    }

    public void test_requestRemogenTrickySuffixhell() {
        // ## Act ##
        RemoteWxRemogenTrickySuffixhellReturn returnBean = createBhv("{}").requestRemogenTrickySuffixhell();

        // ## Assert ##
        logger.debug("resortName={}", returnBean.resortName);
        logger.debug("hellSea={}", returnBean.hellSea);
        if (returnBean.hellSea != null) {
            logger.debug("hellSea.parkName={}", returnBean.hellSea.parkName);
            logger.debug("hellSea.hellSeaResult={}", returnBean.hellSea.hellSeaResult);
            if (returnBean.hellSea.hellSeaResult != null) {
                returnBean.hellSea.hellSeaResult.forEach(row -> {
                    logger.debug("hellSea.hellSeaResult[].stageName={}", row.stageName);
                });
            }
        }
        logger.debug("hellLand={}", returnBean.hellLand);
        if (returnBean.hellLand != null) {
            logger.debug("hellLand.parkName={}", returnBean.hellLand.parkName);
            logger.debug("hellLand.hellLandPart={}", returnBean.hellLand.hellLandPart);
            if (returnBean.hellLand.hellLandPart != null) {
                logger.debug("hellLand.hellLandPart.stageName={}", returnBean.hellLand.hellLandPart.stageName);
            }
        }
    }

    private RemoteMaihamaShowbaseWxBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteMaihamaShowbaseWxBhv bhv = new RemoteMaihamaShowbaseWxBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
