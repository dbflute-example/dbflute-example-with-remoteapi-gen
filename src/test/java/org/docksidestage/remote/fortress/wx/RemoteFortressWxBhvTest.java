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
package org.docksidestage.remote.fortress.wx;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.exception.RemoteApiResponseParseFailureException;
import org.dbflute.remoteapi.mock.MockHttpClient;
import org.dbflute.util.DfCollectionUtil;
import org.docksidestage.remote.fortress.wx.lastadoc.RemoteWxLastadocParam;
import org.docksidestage.remote.fortress.wx.lastadoc.apiemptybody.RemoteWxLastadocApiemptybodyParam;
import org.docksidestage.remote.fortress.wx.login.surprised.signin.RemoteWxLoginSurprisedSigninParam;
import org.docksidestage.remote.fortress.wx.message.RemoteWxMessagePagenumberParam;
import org.docksidestage.remote.fortress.wx.message.RemoteWxMessageParam;
import org.docksidestage.remote.fortress.wx.namedcls.RemoteWxNamedclsParam;
import org.docksidestage.remote.fortress.wx.namedcls.RemoteWxNamedclsReturn;
import org.docksidestage.remote.fortress.wx.remogen.body.basic.RemoteWxRemogenBodyBasicParam;
import org.docksidestage.remote.fortress.wx.remogen.body.list.RemoteWxRemogenBodyListParam;
import org.docksidestage.remote.fortress.wx.remogen.list.basic.RemoteWxRemogenListBasicReturn;
import org.docksidestage.remote.fortress.wx.remogen.list.genebean.RemoteWxRemogenListGenebeanReturn;
import org.docksidestage.remote.fortress.wx.remogen.list.genestring.RemoteWxRemogenListGenestringReturn;
import org.docksidestage.remote.fortress.wx.remogen.list.innergene.RemoteWxRemogenListInnergeneReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.RemoteWxRemogenMethodDeleteParam;
import org.docksidestage.remote.fortress.wx.remogen.method.RemoteWxRemogenMethodDeleteReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.RemoteWxRemogenMethodGetParam;
import org.docksidestage.remote.fortress.wx.remogen.method.RemoteWxRemogenMethodGetReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.RemoteWxRemogenMethodPostParam;
import org.docksidestage.remote.fortress.wx.remogen.method.RemoteWxRemogenMethodPostReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.noquery.RemoteWxRemogenMethodNoqueryReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformDeleteParam;
import org.docksidestage.remote.fortress.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformDeleteReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformGetParam;
import org.docksidestage.remote.fortress.wx.remogen.method.onbodyform.RemoteWxRemogenMethodOnbodyformGetReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.onbodyjson.RemoteWxRemogenMethodOnbodyjsonParam;
import org.docksidestage.remote.fortress.wx.remogen.method.onbodyjson.RemoteWxRemogenMethodOnbodyjsonReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.samename.RemoteWxRemogenMethodSamenameGetParam;
import org.docksidestage.remote.fortress.wx.remogen.method.samename.RemoteWxRemogenMethodSamenameGetReturn;
import org.docksidestage.remote.fortress.wx.remogen.method.samename.RemoteWxRemogenMethodSamenamePostParam;
import org.docksidestage.remote.fortress.wx.remogen.method.samename.RemoteWxRemogenMethodSamenamePostReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.RemoteWxRemogenRoutingReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.amba.RemoteWxRemogenRoutingAmbaReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.amphi.theater.maihama.RemoteWxRemogenRoutingAmphiTheaterMaihamaReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.bonvo.RemoteWxRemogenRoutingBonvoReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.celeb.RemoteWxRemogenRoutingCelebReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.dohotel.RemoteWxRemogenRoutingDohotelFirstSecondParam;
import org.docksidestage.remote.fortress.wx.remogen.routing.dohotel.RemoteWxRemogenRoutingDohotelParam;
import org.docksidestage.remote.fortress.wx.remogen.routing.dohotel.RemoteWxRemogenRoutingDohotelReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.dstore.RemoteWxRemogenRoutingDstoreReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.land.RemoteWxRemogenRoutingLandReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.maihama.RemoteWxRemogenRoutingMaihamaReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.miraco.RemoteWxRemogenRoutingMiracoReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.piari.RemoteWxRemogenRoutingPiariReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.resola.RemoteWxRemogenRoutingResolaReturn;
import org.docksidestage.remote.fortress.wx.remogen.routing.sea.RemoteWxRemogenRoutingSeaReturn;
import org.docksidestage.remote.fortress.wx.remogen.suffix.allsuffix.RemoteWxRemogenSuffixAllsuffixReturn;
import org.docksidestage.remote.fortress.wx.remogen.suffix.nosuffix.RemoteWxRemogenSuffixNosuffixReturn;
import org.docksidestage.remote.fortress.wx.remogen.suffix.partonly.RemoteWxRemogenSuffixPartonlyReturn;
import org.docksidestage.remote.fortress.wx.remogen.suffix.toponly.RemoteWxRemogenSuffixToponlyReturn;
import org.docksidestage.remote.fortress.wx.remogen.tricky.nobody.RemoteWxRemogenTrickyNobodyReturn;
import org.docksidestage.remote.fortress.wx.remogen.tricky.oddprop.RemoteWxRemogenTrickyOddpropReturn;
import org.docksidestage.remote.fortress.wx.remogen.tricky.recycle.RemoteWxRemogenTrickyRecycleReturn;
import org.docksidestage.remote.fortress.wx.remogen.tricky.selfref.RemoteWxRemogenTrickySelfrefReturn;
import org.docksidestage.remote.fortress.wx.remogen.tricky.suffixhell.RemoteWxRemogenTrickySuffixhellReturn;
import org.docksidestage.remote.fortress.wx.remoteapi.rmhangar.mypage.RemoteWxRemoteapiRmhangarMypageReturn;
import org.docksidestage.remote.fortress.wx.remoteapi.rmhangar.translate.RemoteWxRemoteapiRmhangarTranslateParam;
import org.docksidestage.remote.fortress.wx.remoteapi.rmharbor.lido.mypage.RemoteWxRemoteapiRmharborLidoMypageReturn;
import org.docksidestage.remote.fortress.wx.remoteapi.rmharbor.lido.signin.RemoteWxRemoteapiRmharborLidoSigninParam;
import org.docksidestage.remote.fortress.wx.remoteapi.rmharbor.serh.product.RemoteWxRemoteapiRmharborSerhProductParam;
import org.docksidestage.remote.fortress.wx.remoteapi.rmharbor.serh.signin.RemoteWxRemoteapiRmharborSerhSigninParam;
import org.docksidestage.remote.fortress.wx.remoteapi.rmharbor.via.mypage.RemoteWxRemoteapiRmharborViaMypageReturn;
import org.docksidestage.remote.fortress.wx.remoteapi.rmshowbase.remogen.resola.RemoteWxRemoteapiRmshowbaseRemogenResolaReturn;
import org.docksidestage.remote.fortress.wx.request.form.RemoteWxRequestFormParam;
import org.docksidestage.remote.fortress.wx.request.form.RemoteWxRequestFormReturn;
import org.docksidestage.remote.fortress.wx.request.form.eccolle.RemoteWxRequestFormEccolleParam;
import org.docksidestage.remote.fortress.wx.request.form.eccolle.RemoteWxRequestFormEccolleReturn;
import org.docksidestage.remote.fortress.wx.request.form.swagger.RemoteWxRequestFormSwaggerParam;
import org.docksidestage.remote.fortress.wx.request.form.swagger.RemoteWxRequestFormSwaggerReturn;
import org.docksidestage.remote.fortress.wx.request.json.body.RemoteWxRequestJsonBodyParam;
import org.docksidestage.remote.fortress.wx.request.json.body.clienterror.RemoteWxRequestJsonBodyClienterrorParam;
import org.docksidestage.remote.fortress.wx.request.json.body.list.RemoteWxRequestJsonBodyListParam;
import org.docksidestage.remote.fortress.wx.request.json.body.swagger.RemoteWxRequestJsonBodySwaggerParam;
import org.docksidestage.remote.fortress.wx.request.json.body.systemerror.RemoteWxRequestJsonBodySystemerrorParam;
import org.docksidestage.remote.fortress.wx.request.json.body.validated.RemoteWxRequestJsonBodyValidatedParam;
import org.docksidestage.remote.fortress.wx.request.json.body.validatedlonely.RemoteWxRequestJsonBodyValidatedlonelyParam;
import org.docksidestage.remote.fortress.wx.request.json.body.validatedlonelylist.RemoteWxRequestJsonBodyValidatedlonelylistParam;
import org.docksidestage.remote.fortress.wx.request.json.prop.RemoteWxRequestJsonPropParam;
import org.docksidestage.remote.fortress.wx.request.json.prop.json.RemoteWxRequestJsonPropJsonParam;
import org.docksidestage.remote.fortress.wx.request.json.prop.json.RemoteWxRequestJsonPropJsonReturn;
import org.docksidestage.remote.fortress.wx.request.multipart.upload.RemoteWxRequestMultipartUploadParam;
import org.docksidestage.remote.fortress.wx.request.pathvar.cls.RemoteWxRequestPathvarClsReturn;
import org.docksidestage.remote.fortress.wx.request.pathvar.nameof.RemoteWxRequestPathvarNameofReturn;
import org.docksidestage.remote.fortress.wx.request.pathvar.optional.onparade.RemoteWxRequestPathvarOptionalOnparadeReturn;
import org.docksidestage.remote.fortress.wx.request.pathvar.string.RemoteWxRequestPathvarStringReturn;
import org.docksidestage.remote.fortress.wx.response.html.add.register.RemoteWxResponseHtmlAddRegisterParam;
import org.docksidestage.remote.fortress.wx.response.html.edit.update.RemoteWxResponseHtmlEditUpdateParam;
import org.docksidestage.remote.fortress.wx.response.html.edit.withdrawal.RemoteWxResponseHtmlEditWithdrawalParam;
import org.docksidestage.remote.fortress.wx.response.html.list.RemoteWxResponseHtmlListPagenumberParam;
import org.docksidestage.remote.fortress.wx.response.html.list.RemoteWxResponseHtmlListParam;
import org.docksidestage.remote.fortress.wx.response.json.RemoteWxResponseJsonReturn;
import org.docksidestage.remote.fortress.wx.response.json.eccolle.list.RemoteWxResponseJsonEccolleListReturn;
import org.docksidestage.remote.fortress.wx.response.json.eccolle.listempty.RemoteWxResponseJsonEccolleListemptyReturn;
import org.docksidestage.remote.fortress.wx.response.json.eccolle.map.RemoteWxResponseJsonEccolleMapReturn;
import org.docksidestage.remote.fortress.wx.response.json.justified.RemoteWxResponseJsonJustifiedReturn;
import org.docksidestage.remote.fortress.wx.response.json.justified.named.RemoteWxResponseJsonJustifiedNamedReturn;
import org.docksidestage.remote.fortress.wx.response.json.switched.engine.RemoteWxResponseJsonSwitchedEngineReturn;
import org.docksidestage.remote.fortress.wx.response.json.switched.mapping.RemoteWxResponseJsonSwitchedMappingReturn;
import org.docksidestage.remote.fortress.wx.response.json.switched.none.RemoteWxResponseJsonSwitchedNoneReturn;
import org.docksidestage.remote.fortress.wx.response.stream.api.validationerror.RemoteWxResponseStreamApiValidationerrorParam;
import org.docksidestage.remote.fortress.wx.response.stream.validationerror.RemoteWxResponseStreamValidationerrorParam;
import org.docksidestage.remote.fortress.wx.rmshowbase.remogen.method.delete.RemoteWxRmshowbaseRemogenMethodDeleteReturn;
import org.docksidestage.remote.fortress.wx.routing.RemoteWxRoutingReturn;
import org.docksidestage.remote.fortress.wx.routing.amba.RemoteWxRoutingAmbaReturn;
import org.docksidestage.remote.fortress.wx.routing.amphi.theater.maihama.RemoteWxRoutingAmphiTheaterMaihamaReturn;
import org.docksidestage.remote.fortress.wx.routing.bonvo.RemoteWxRoutingBonvoReturn;
import org.docksidestage.remote.fortress.wx.routing.celeb.RemoteWxRoutingCelebReturn;
import org.docksidestage.remote.fortress.wx.routing.dohotel.RemoteWxRoutingDohotelFirstSecondParam;
import org.docksidestage.remote.fortress.wx.routing.dohotel.RemoteWxRoutingDohotelParam;
import org.docksidestage.remote.fortress.wx.routing.dohotel.RemoteWxRoutingDohotelReturn;
import org.docksidestage.remote.fortress.wx.routing.dstore.RemoteWxRoutingDstoreReturn;
import org.docksidestage.remote.fortress.wx.routing.land.RemoteWxRoutingLandReturn;
import org.docksidestage.remote.fortress.wx.routing.maihama.RemoteWxRoutingMaihamaReturn;
import org.docksidestage.remote.fortress.wx.routing.miraco.RemoteWxRoutingMiracoReturn;
import org.docksidestage.remote.fortress.wx.routing.mixworld.RemoteWxRoutingMixworldReturn;
import org.docksidestage.remote.fortress.wx.routing.mixworld.maihama.RemoteWxRoutingMixworldMaihamaReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.basic.RemoteWxRoutingNearpathBasicReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.basic.number.RemoteWxRoutingNearpathBasicNumberReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.basic.string.RemoteWxRoutingNearpathBasicStringReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword01.str2num.RemoteWxRoutingNearpathByword01Str2numReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword01.str2num.named.RemoteWxRoutingNearpathByword01Str2numNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword02.num2str.RemoteWxRoutingNearpathByword02Num2strReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword02.num2str.named.RemoteWxRoutingNearpathByword02Num2strNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword05.optstr2num.RemoteWxRoutingNearpathByword05Optstr2numReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword05.optstr2num.named.RemoteWxRoutingNearpathByword05Optstr2numNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword10.optstr4str2num.RemoteWxRoutingNearpathByword10Optstr4str2numReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword10.optstr4str2num.named.RemoteWxRoutingNearpathByword10Optstr4str2numNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword11.optstr4numtostr.RemoteWxRoutingNearpathByword11Optstr4numtostrReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword11.optstr4numtostr.named.RemoteWxRoutingNearpathByword11Optstr4numtostrNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword12.optstr4cls2str.RemoteWxRoutingNearpathByword12Optstr4cls2strReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword12.optstr4cls2str.named.RemoteWxRoutingNearpathByword12Optstr4cls2strNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword13.optstr4cls2num.RemoteWxRoutingNearpathByword13Optstr4cls2numReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword13.optstr4cls2num.named.RemoteWxRoutingNearpathByword13Optstr4cls2numNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword15.optnum4str2num.RemoteWxRoutingNearpathByword15Optnum4str2numReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword15.optnum4str2num.named.RemoteWxRoutingNearpathByword15Optnum4str2numNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword16.optnum4num2str.RemoteWxRoutingNearpathByword16Optnum4num2strReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.byword16.optnum4num2str.named.RemoteWxRoutingNearpathByword16Optnum4num2strNamedReturn;
import org.docksidestage.remote.fortress.wx.routing.nearpath.shadowed.method.RemoteWxRoutingNearpathShadowedMethodReturn;
import org.docksidestage.remote.fortress.wx.routing.piari.RemoteWxRoutingPiariReturn;
import org.docksidestage.remote.fortress.wx.routing.reqparam.RemoteWxRoutingReqparamParam;
import org.docksidestage.remote.fortress.wx.routing.reqparam.conflict.RemoteWxRoutingReqparamConflictParam;
import org.docksidestage.remote.fortress.wx.routing.resola.RemoteWxRoutingResolaReturn;
import org.docksidestage.remote.fortress.wx.routing.sea.RemoteWxRoutingSeaReturn;
import org.docksidestage.remote.fortress.wx.routing.wording.RemoteWxRoutingWordingReturn;
import org.docksidestage.remote.fortress.wx.routing.wording.land.RemoteWxRoutingWordingLandReturn;
import org.docksidestage.remote.fortress.wx.routing.wording.piari.plaza.RemoteWxRoutingWordingPiariPlazaReturn;
import org.docksidestage.remote.fortress.wx.routing.wording.sea.RemoteWxRoutingWordingSeaReturn;
import org.docksidestage.remote.fortress.wx.thymeleaf.parade.RemoteWxThymeleafParadePagenumberParam;
import org.docksidestage.remote.fortress.wx.thymeleaf.parade.RemoteWxThymeleafParadeParam;
import org.docksidestage.remote.fortress.wx.transaction.memories.fail.RemoteWxTransactionMemoriesFailParam;
import org.docksidestage.remote.fortress.wx.transaction.memories.failasync.RemoteWxTransactionMemoriesFailasyncParam;
import org.docksidestage.remote.fortress.wx.validator.RemoteWxValidatorParam;
import org.docksidestage.remote.fortress.wx.validator.custom.RemoteWxValidatorCustomParam;
import org.docksidestage.remote.fortress.wx.validator.genericform.RemoteWxValidatorGenericformParam;
import org.docksidestage.remote.fortress.wx.validator.groupingjson.RemoteWxValidatorGroupingjsonReturn;
import org.docksidestage.remote.fortress.wx.validator.groups.response.dockside.RemoteWxValidatorGroupsResponseDocksideReturn;
import org.docksidestage.remote.fortress.wx.validator.groups.response.hangar.RemoteWxValidatorGroupsResponseHangarReturn;
import org.docksidestage.remote.fortress.wx.validator.groups.response.usedefault.RemoteWxValidatorGroupsResponseUsedefaultReturn;
import org.docksidestage.remote.fortress.wx.validator.listjson.RemoteWxValidatorListjsonParam;
import org.docksidestage.remote.fortress.wx.validator.listjson.RemoteWxValidatorListjsonReturn;
import org.docksidestage.remote.fortress.wx.validator.wholejson.RemoteWxValidatorWholejsonParam;
import org.docksidestage.remote.fortress.wx.validator.wholejson.RemoteWxValidatorWholejsonReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of wx.
 * @author FreeGen
 */
public class RemoteFortressWxBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemoteFortressWxBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestAppexBasic() {
        // ## Act ##
        createBhv(null).requestAppexBasic();
    }

    public void test_requestAppexBasicWithoutinfo() {
        // ## Act ##
        createBhv(null).requestAppexBasicWithoutinfo();
    }

    public void test_requestAppexBasicLoginfailure() {
        // ## Act ##
        createBhv(null).requestAppexBasicLoginfailure();
    }

    public void test_requestAppexBasicAlreadydeleted() {
        // ## Act ##
        createBhv(null).requestAppexBasicAlreadydeleted();
    }

    public void test_requestAppexHandlerAlreadydeleted() {
        // ## Act ##
        createBhv(null).requestAppexHandlerAlreadydeleted();
    }

    public void test_requestAppexHandlerJson() {
        // ## Act ##
        createBhv(null).requestAppexHandlerJson();
    }

    public void test_requestAppexMessageJson() {
        // ## Act ##
        String returnBean = createBhv("String").requestAppexMessageJson();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestAppexMessageJsonDirect() {
        // ## Act ##
        String returnBean = createBhv("String").requestAppexMessageJsonDirect();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestAppexMessageJsonNovalues() {
        // ## Act ##
        String returnBean = createBhv("String").requestAppexMessageJsonNovalues();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestBizpkgOnionarc() {
        // ## Act ##
        createBhv(null).requestBizpkgOnionarc();
    }

    public void test_requestConfig() {
        // ## Act ##
        String returnBean = createBhv("String").requestConfig();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestDeftestNinjaSea() {
        // ## Act ##
        createBhv(null).requestDeftestNinjaSea();
    }

    public void test_requestJobSea() {
        // ## Arrange ##
        String stage = "stage";
        String jobUnique = "jobUnique";

        // ## Act ##
        createBhv(null).requestJobSea(stage, jobUnique);
    }

    public void test_requestJobAmba() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        createBhv(null).requestJobAmba(first);
    }

    public void test_requestLastadoc() {
        // ## Arrange ##
        Consumer<RemoteWxLastadocParam> paramLambda = param -> {
            param.sea = "sea";
            param.amba = "amba";
            param.miraco = "miraco";
            param.dohotel = "dohotel";
            param.white = "white";
            param.fullName = "fullName";
        };

        // ## Act ##
        String returnBean = createBhv("String").requestLastadoc(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestLastadocApiemptybody() {
        // ## Arrange ##
        Consumer<RemoteWxLastadocApiemptybodyParam> paramLambda = param -> {};

        // ## Act ##
        createBhv(null).requestLastadocApiemptybody(paramLambda);
    }

    public void test_requestLoginSurprised() {
        // ## Act ##
        createBhv(null).requestLoginSurprised();
    }

    public void test_requestLoginSurprisedSignin() {
        // ## Arrange ##
        Consumer<RemoteWxLoginSurprisedSigninParam> paramLambda = param -> {
            param.account = "account";
            param.password = "password";
            param.rememberMe = Boolean.TRUE;
        };

        // ## Act ##
        createBhv(null).requestLoginSurprisedSignin(paramLambda);
    }

    public void test_requestLoginSurprisedRequired() {
        // ## Act ##
        createBhv(null).requestLoginSurprisedRequired();
    }

    public void test_requestMail() {
        // ## Act ##
        String returnBean = createBhv("String").requestMail();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestMailBasic() {
        // ## Act ##
        String returnBean = createBhv("String").requestMailBasic();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestMailEntity() {
        // ## Act ##
        String returnBean = createBhv("String").requestMailEntity();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestMailEntitylist() {
        // ## Act ##
        String returnBean = createBhv("String").requestMailEntitylist();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestMailLoopbeans() {
        // ## Act ##
        String returnBean = createBhv("String").requestMailLoopbeans();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestMailRemoteapi() {
        // ## Act ##
        String returnBean = createBhv("String").requestMailRemoteapi();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestMessage() {
        // ## Arrange ##
        Consumer<RemoteWxMessageParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestMessage(paramLambda);
    }

    public void test_requestMessagePageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteWxMessagePagenumberParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestMessage(pageNumber, paramLambda);
    }

    public void test_requestNamedcls() {
        // ## Arrange ##
        Consumer<RemoteWxNamedclsParam> paramLambda = param -> {
            param.status = "status";
            param.sea = "sea";
            param.land = "land";
        };

        // ## Act ##
        RemoteWxNamedclsReturn returnBean = createBhv("{}").requestNamedcls(paramLambda);

        // ## Assert ##
        logger.debug("status={}", returnBean.status);
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
    }

    public void test_requestRemogenBodyBasic() {
        // ## Arrange ##
        Consumer<RemoteWxRemogenBodyBasicParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = "dstore";
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
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = "dstore";
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
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = "dstore";
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
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = "dstore";
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
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = "dstore";
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
                    logger.debug("resortPark.showStages[].stageName={}", showStage.stageName);
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
                    logger.debug("resortPark.showStages[].stageName={}", showStage.stageName);
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
                    logger.debug("resortPark.showStages[].stageName={}", showStage.stageName);
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
        // #thinking p1us2er0 lasta-metaでネストしたプロパティが自動生成されてない可能性がある (2022/03/21)
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
            logger.debug("resortPark.extendedArea.areaName={}", returnBean.extendedArea.areaName);
            logger.debug("resortPark.extendedArea.parkingArea={}", returnBean.extendedArea.parkingArea);
            if (returnBean.extendedArea.parkingArea != null) {
                logger.debug("resortPark.extendedArea.parkingArea.areaName={}", returnBean.extendedArea.parkingArea.areaName);
                logger.debug("resortPark.extendedArea.parkingArea.internalArea={}", returnBean.extendedArea.parkingArea.internalArea);
                if (returnBean.extendedArea.parkingArea.internalArea != null) {
                    logger.debug("resortPark.extendedArea.parkingArea.internalArea.areaName={}",
                            returnBean.extendedArea.parkingArea.internalArea.areaName);
                    logger.debug("resortPark.extendedArea.parkingArea.internalArea.parkingArea={}",
                            returnBean.extendedArea.parkingArea.internalArea.parkingArea);
                }
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
            logger.debug("hellLandparkName.={}", returnBean.hellLand.parkName);
            logger.debug("hellLand.hellLandPart={}", returnBean.hellLand.hellLandPart);
            if (returnBean.hellLand.hellLandPart != null) {
                logger.debug("hellLand.hellLandPart.stageName={}", returnBean.hellLand.hellLandPart.stageName);
            }
        }
    }

    public void test_requestRemoteapiRmhangarMypage() {
        // ## Act ##
        RemoteWxRemoteapiRmhangarMypageReturn returnBean = createBhv("{}").requestRemoteapiRmhangarMypage();

        // ## Assert ##
        logger.debug("recentProducts={}", returnBean.recentProducts);
        if (returnBean.recentProducts != null) {
            returnBean.recentProducts.forEach(recentProduct -> {
                logger.debug("recentProduct.productName={}", recentProduct.productName);
                logger.debug("recentProduct.regularPrice={}", recentProduct.regularPrice);
            });
        }
        logger.debug("highPriceProducts={}", returnBean.highPriceProducts);
        if (returnBean.highPriceProducts != null) {
            returnBean.highPriceProducts.forEach(highPriceProduct -> {
                logger.debug("highPriceProduct.productName={}", highPriceProduct.productName);
                logger.debug("highPriceProduct.regularPrice={}", highPriceProduct.regularPrice);
            });
        }
    }

    public void test_requestRemoteapiRmhangarTranslate() {
        // ## Arrange ##
        Consumer<RemoteWxRemoteapiRmhangarTranslateParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestRemoteapiRmhangarTranslate(paramLambda);
    }

    public void test_requestRemoteapiRmharborLidoSignin() {
        // ## Arrange ##
        Consumer<RemoteWxRemoteapiRmharborLidoSigninParam> paramLambda = param -> {
            param.account = "account";
            param.password = "password";
            param.rememberMe = Boolean.TRUE;
        };

        // ## Act ##
        createBhv(null).requestRemoteapiRmharborLidoSignin(paramLambda);
    }

    public void test_requestRemoteapiRmharborLidoMypage() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWxRemoteapiRmharborLidoMypageReturn> list =
                createBhv("[]").requestRemoteapiRmharborLidoMypage();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("productName={}", returnBean.productName);
            logger.debug("regularPrice={}", returnBean.regularPrice);
        });
    }

    public void test_requestRemoteapiRmharborSerhProduct() {
        // ## Arrange ##
        Consumer<RemoteWxRemoteapiRmharborSerhProductParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestRemoteapiRmharborSerhProduct(paramLambda);
    }

    public void test_requestRemoteapiRmharborSerhSignin() {
        // ## Arrange ##
        Consumer<RemoteWxRemoteapiRmharborSerhSigninParam> paramLambda = param -> {
            param.account = "account";
            param.password = "password";
            param.rememberMe = Boolean.TRUE;
        };

        // ## Act ##
        createBhv(null).requestRemoteapiRmharborSerhSignin(paramLambda);
    }

    public void test_requestRemoteapiRmharborViaMypage() {
        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWxRemoteapiRmharborViaMypageReturn> list =
                createBhv("[]").requestRemoteapiRmharborViaMypage();

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("productName={}", returnBean.productName);
            logger.debug("regularPrice={}", returnBean.regularPrice);
        });
    }

    public void test_requestRemoteapiRmshowbaseRemogenResola() {
        // ## Act ##
        // #thinking p1us2er0 Returnクラスに継承クラスがある場合で、 Returnクラスと継承クラスで同名のフィールドが存在するとgsonでエラーになる。 (2022/03/21)
        try {
            RemoteWxRemoteapiRmshowbaseRemogenResolaReturn returnBean = createBhv("{}").requestRemoteapiRmshowbaseRemogenResola();
            // ## Assert ##
            logger.debug("method={}", returnBean.method);
            logger.debug("first={}", returnBean.first);
            logger.debug("second={}", returnBean.second);
            logger.debug("headerMap={}", returnBean.headerMap);
        } catch (RemoteApiResponseParseFailureException e) {
            if (!e.getCause().getMessage().contains("declares multiple JSON fields named headerMap")) {
                throw e;
            }
        }
    }

    public void test_requestRmshowbaseRemogenMethodDelete() {
        // ## Act ##
        RemoteWxRmshowbaseRemogenMethodDeleteReturn returnBean = createBhv("{}").requestRmshowbaseRemogenMethodDelete();

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("iamResult={}", returnBean.iamResult);
    }

    public void test_requestRequestForm() {
        // ## Arrange ##
        Consumer<RemoteWxRequestFormParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
        };

        // ## Act ##
        RemoteWxRequestFormReturn returnBean = createBhv("{}").requestRequestForm(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        logger.debug("land={}", returnBean.land);
        logger.debug("piari={}", returnBean.piari);
        logger.debug("bonvo={}", returnBean.bonvo);
        logger.debug("dstore={}", returnBean.dstore);
    }

    public void test_requestRequestFormEccolle() {
        // ## Arrange ##
        Consumer<RemoteWxRequestFormEccolleParam> paramLambda = param -> {
            param.sea = org.eclipse.collections.impl.factory.Lists.immutable.of("sea");
            param.land = org.eclipse.collections.impl.factory.Lists.immutable.of("land");
            param.piari = org.eclipse.collections.impl.factory.Lists.immutable.of("piari");
            param.bonvo = org.eclipse.collections.impl.factory.Lists.immutable.of("bonvo");
            param.dstore = org.eclipse.collections.impl.factory.Lists.immutable.of("dstore");
            param.amba = org.eclipse.collections.impl.factory.Lists.immutable.of("amba");
        };

        // ## Act ##
        RemoteWxRequestFormEccolleReturn returnBean = createBhv("{}").requestRequestFormEccolle(paramLambda);

        // ## Assert ##
        logger.debug("sea={}", returnBean.sea);
        if (returnBean.sea != null) {
            returnBean.sea.forEach(row -> {
                logger.debug("sea[]={}", row);
            });
        }
        logger.debug("land={}", returnBean.land);
        if (returnBean.land != null) {
            returnBean.land.forEach(row -> {
                logger.debug("land[]={}", row);
            });
        }
        logger.debug("piari={}", returnBean.piari);
        if (returnBean.piari != null) {
            returnBean.piari.forEach(row -> {
                logger.debug("piari[]={}", row);
            });
        }
        logger.debug("bonvo={}", returnBean.bonvo);
        if (returnBean.bonvo != null) {
            returnBean.bonvo.forEach(row -> {
                logger.debug("bonvo[]={}", row);
            });
        }
        logger.debug("dstore={}", returnBean.dstore);
        if (returnBean.dstore != null) {
            returnBean.dstore.forEach(row -> {
                logger.debug("dstore[].walt={}", row.walt);
            });
        }
        logger.debug("amba={}", returnBean.amba);
        if (returnBean.amba != null) {
            returnBean.amba.forEach(row -> {
                logger.debug("amba[].chef={}", row.chef);
            });
        }
    }

    public void test_requestRequestFormSwagger() {
        // ## Arrange ##
        Consumer<RemoteWxRequestFormSwaggerParam> paramLambda = param -> {
            param.seaPlain = "seaPlain";
            param.seaRequired = "seaRequired";
            param.seaLength = "seaLength";
            param.seaSize = "seaSize";
            param.seaPatternKana = "seaPatternKana";
            param.seaPatternPhone = "seaPatternPhone";
            param.seaEmail = "seaEmail";
            param.seaStringCustomOne = "seaStringCustomOne";
            param.seaStringCustomTwo = "seaStringCustomTwo";
            param.seaWhole = "seaWhole";
            param.landPlain = 1;
            param.landRequired = 1;
            param.landMinMax = 1;
            param.landIntegerCustomOne = "landIntegerCustomOne";
            param.landIntegerCustomTwo = "landIntegerCustomTwo";
            param.landWhole = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = "miraco";
            param.white = "white";
        };

        // ## Act ##
        RemoteWxRequestFormSwaggerReturn returnBean = createBhv("{}").requestRequestFormSwagger(paramLambda);

        // ## Assert ##
        logger.debug("seaPlain={}", returnBean.seaPlain);
        logger.debug("seaRequired={}", returnBean.seaRequired);
        logger.debug("seaLength={}", returnBean.seaLength);
        logger.debug("seaSize={}", returnBean.seaSize);
        logger.debug("seaPatternKana={}", returnBean.seaPatternKana);
        logger.debug("seaPatternPhone={}", returnBean.seaPatternPhone);
        logger.debug("seaEmail={}", returnBean.seaEmail);
        logger.debug("seaStringCustomOne={}", returnBean.seaStringCustomOne);
        logger.debug("seaStringCustomTwo={}", returnBean.seaStringCustomTwo);
        logger.debug("seaWhole={}", returnBean.seaWhole);
        logger.debug("landPlain={}", returnBean.landPlain);
        logger.debug("landRequired={}", returnBean.landRequired);
        logger.debug("landMinMax={}", returnBean.landMinMax);
        logger.debug("landIntegerCustomOne={}", returnBean.landIntegerCustomOne);
        logger.debug("landIntegerCustomTwo={}", returnBean.landIntegerCustomTwo);
        logger.debug("landWhole={}", returnBean.landWhole);
        logger.debug("piari={}", returnBean.piari);
        logger.debug("bonvo={}", returnBean.bonvo);
        logger.debug("dstore={}", returnBean.dstore);
        logger.debug("amba={}", returnBean.amba);
        logger.debug("miraco={}", returnBean.miraco);
        if (returnBean.miraco != null) {
            logger.debug("miraco.sta={}", returnBean.miraco.sta);
        }
        logger.debug("white={}", returnBean.white);
        if (returnBean.white != null) {
            logger.debug("white.formatBodying={}", returnBean.white.formatBodying);
        }
    }

    public void test_requestRequestJsonBody() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonBodyParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodyParam.MiracoPart();
            param.miraco.sta = "sta";
            param.white = new RemoteWxRequestJsonBodyParam.WhitePart();
            param.white.formatBodying = "formatBodying";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBody(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonBodyList() {
        // ## Arrange ##
        org.eclipse.collections.api.list.ImmutableList<java.util.Map<String, Object>> body =
                org.eclipse.collections.impl.factory.Lists.immutable.empty();
        Consumer<RemoteWxRequestJsonBodyListParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodyListParam.MiracoPart();
            param.miraco.sta = "sta";
            param.white = new RemoteWxRequestJsonBodyListParam.WhitePart();
            param.white.formatBodying = "formatBodying";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBodyList(body, paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonBodyClienterror() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonBodyClienterrorParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodyClienterrorParam.MiracoPart();
            param.miraco.sta = "sta";
            param.white = new RemoteWxRequestJsonBodyClienterrorParam.WhitePart();
            param.white.formatBodying = "formatBodying";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBodyClienterror(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonBodySystemerror() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonBodySystemerrorParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodySystemerrorParam.MiracoPart();
            param.miraco.sta = "sta";
            param.white = new RemoteWxRequestJsonBodySystemerrorParam.WhitePart();
            param.white.formatBodying = "formatBodying";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBodySystemerror(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonBodyValidated() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonBodyValidatedParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodyValidatedParam.MiracoPart();
            param.miraco.sta = "sta";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBodyValidated(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonBodyValidatedlonely() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonBodyValidatedlonelyParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodyValidatedlonelyParam.MiracoPart();
            param.miraco.sta = "sta";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBodyValidatedlonely(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonBodyValidatedlonelylist() {
        // ## Arrange ##
        org.eclipse.collections.api.list.ImmutableList<java.util.Map<String, Object>> bodyList =
                org.eclipse.collections.impl.factory.Lists.immutable.empty();
        Consumer<RemoteWxRequestJsonBodyValidatedlonelylistParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodyValidatedlonelylistParam.MiracoPart();
            param.miraco.sta = "sta";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBodyValidatedlonelylist(bodyList, paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonBodySwagger() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonBodySwaggerParam> paramLambda = param -> {
            param.seaPlain = "seaPlain";
            param.seaRequired = "seaRequired";
            param.seaLength = "seaLength";
            param.seaSize = "seaSize";
            param.seaPatternKana = "seaPatternKana";
            param.seaPatternPhone = "seaPatternPhone";
            param.seaEmail = "seaEmail";
            param.seaStringCustomOne = "seaStringCustomOne";
            param.seaStringCustomTwo = "seaStringCustomTwo";
            param.seaWhole = "seaWhole";
            param.landPlain = 1;
            param.landRequired = 1;
            param.landMinMax = 1;
            param.landIntegerCustomOne = "landIntegerCustomOne";
            param.landIntegerCustomTwo = "landIntegerCustomTwo";
            param.landWhole = 1;
            param.piari = java.time.LocalDate.now();
            param.bonvo = java.time.LocalDateTime.now();
            param.dstore = Boolean.TRUE;
            param.amba = "amba";
            param.miraco = new RemoteWxRequestJsonBodySwaggerParam.MiracoPart();
            param.miraco.sta = "sta";
            param.white = new RemoteWxRequestJsonBodySwaggerParam.WhitePart();
            param.white.formatBodying = "formatBodying";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonBodySwagger(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonProp() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonPropParam> paramLambda = param -> {
            param.param = "param";
            param.listParam = "listParam";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRequestJsonProp(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRequestJsonPropJson() {
        // ## Arrange ##
        Consumer<RemoteWxRequestJsonPropJsonParam> paramLambda = param -> {
            param.strList = "strList";
        };

        // ## Act ##
        RemoteWxRequestJsonPropJsonReturn returnBean = createBhv("{}").requestRequestJsonPropJson(paramLambda);

        // ## Assert ##
        logger.debug("strList={}", returnBean.strList);
    }

    public void test_requestRequestMultipart() {
        // ## Act ##
        createBhv(null).requestRequestMultipart();
    }

    public void test_requestRequestMultipartUpload() {
        // ## Arrange ##
        Consumer<RemoteWxRequestMultipartUploadParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = 1;
            param.uploadedFile = new org.lastaflute.web.ruts.multipart.MultipartFormFile() {
                @Override
                public byte[] getFileData() throws java.io.IOException {
                    return null;
                }

                @Override
                public java.io.InputStream getInputStream() throws java.io.IOException {
                    return null;
                }

                @Override
                public String getContentType() {
                    return null;
                }

                @Override
                public int getFileSize() {
                    return 0;
                }

                @Override
                public String getFileName() {
                    return null;
                }

                @Override
                public void destroy() {
                }
            };
        };

        // ## Act ##
        createBhv(null).requestRequestMultipartUpload(paramLambda);
    }

    public void test_requestRequestPathvarString() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRequestPathvarStringReturn returnBean = createBhv("{}").requestRequestPathvarString(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("third={}", returnBean.third);
    }

    public void test_requestRequestPathvarCls() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRequestPathvarClsReturn returnBean = createBhv("{}").requestRequestPathvarCls(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("third={}", returnBean.third);
    }

    public void test_requestRequestPathvarNameof() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRequestPathvarNameofReturn returnBean = createBhv("{}").requestRequestPathvarNameof(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("third={}", returnBean.third);
    }

    public void test_requestRequestPathvarOptionalOnparade() {
        // ## Act ##
        RemoteWxRequestPathvarOptionalOnparadeReturn returnBean = createBhv("{}").requestRequestPathvarOptionalOnparade();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("third={}", returnBean.third);
    }

    public void test_requestRequestPathvarOptionalOnparadeFirst() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRequestPathvarOptionalOnparadeReturn returnBean = createBhv("{}").requestRequestPathvarOptionalOnparade(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("third={}", returnBean.third);
    }

    public void test_requestRequestPathvarOptionalOnparadeSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRequestPathvarOptionalOnparadeReturn returnBean = createBhv("{}").requestRequestPathvarOptionalOnparade(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("third={}", returnBean.third);
    }

    public void test_requestRequestPathvarOptionalOnparadeThirdThirdThird() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        String third = "third";

        // ## Act ##
        RemoteWxRequestPathvarOptionalOnparadeReturn returnBean =
                createBhv("{}").requestRequestPathvarOptionalOnparade(first, second, third);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
        logger.debug("third={}", returnBean.third);
    }

    public void test_requestResponseHtmlEmpty() {
        // ## Act ##
        createBhv(null).requestResponseHtmlEmpty();
    }

    public void test_requestResponseHtmlEmptyCommitted() {
        // ## Act ##
        createBhv(null).requestResponseHtmlEmptyCommitted();
    }

    public void test_requestResponseHtmlAdd() {
        // ## Act ##
        createBhv(null).requestResponseHtmlAdd();
    }

    public void test_requestResponseHtmlAddRegister() {
        // ## Arrange ##
        Consumer<RemoteWxResponseHtmlAddRegisterParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
        };

        // ## Act ##
        createBhv(null).requestResponseHtmlAddRegister(paramLambda);
    }

    public void test_requestResponseHtmlEdit() {
        // ## Arrange ##
        Integer memberId = 1;

        // ## Act ##
        createBhv(null).requestResponseHtmlEdit(memberId);
    }

    public void test_requestResponseHtmlEditUpdate() {
        // ## Arrange ##
        Consumer<RemoteWxResponseHtmlEditUpdateParam> paramLambda = param -> {
            param.memberId = 1;
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.formalizedDate = java.time.LocalDate.now();
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.latestLoginDatetime = java.time.LocalDateTime.now();
            param.updateDatetime = java.time.LocalDateTime.now();
            param.previousStatus = "previousStatus";
            param.versionNo = 1L;
        };

        // ## Act ##
        createBhv(null).requestResponseHtmlEditUpdate(paramLambda);
    }

    public void test_requestResponseHtmlEditWithdrawal() {
        // ## Arrange ##
        Consumer<RemoteWxResponseHtmlEditWithdrawalParam> paramLambda = param -> {
            param.memberId = 1;
            param.memberName = "memberName";
            param.memberAccount = "memberAccount";
            param.birthdate = java.time.LocalDate.now();
            param.formalizedDate = java.time.LocalDate.now();
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.latestLoginDatetime = java.time.LocalDateTime.now();
            param.updateDatetime = java.time.LocalDateTime.now();
            param.previousStatus = "previousStatus";
            param.versionNo = 1L;
        };

        // ## Act ##
        createBhv(null).requestResponseHtmlEditWithdrawal(paramLambda);
    }

    public void test_requestResponseHtmlList() {
        // ## Arrange ##
        Consumer<RemoteWxResponseHtmlListParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.purchaseProductName = "purchaseProductName";
            param.unpaid = Boolean.TRUE;
            param.formalizedFrom = java.time.LocalDate.now();
            param.formalizedTo = java.time.LocalDate.now();
        };

        // ## Act ##
        createBhv(null).requestResponseHtmlList(paramLambda);
    }

    public void test_requestResponseHtmlListPageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteWxResponseHtmlListPagenumberParam> paramLambda = param -> {
            param.memberName = "memberName";
            param.memberStatus = org.docksidestage.dbflute.allcommon.CDef.MemberStatus.codeOf("FML");
            param.purchaseProductName = "purchaseProductName";
            param.unpaid = Boolean.TRUE;
            param.formalizedFrom = java.time.LocalDate.now();
            param.formalizedTo = java.time.LocalDate.now();
        };

        // ## Act ##
        createBhv(null).requestResponseHtmlList(pageNumber, paramLambda);
    }

    public void test_requestResponseJson() {
        // ## Act ##
        RemoteWxResponseJsonReturn returnBean = createBhv("{}").requestResponseJson();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("birthdate={}", returnBean.birthdate);
    }

    public void test_requestResponseJsonEmptybody() {
        // ## Act ##
        createBhv(null).requestResponseJsonEmptybody();
    }

    public void test_requestResponseJsonStrval() {
        // ## Act ##
        String returnBean = createBhv("String").requestResponseJsonStrval();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestResponseJsonIntval() {
        // ## Act ##
        Integer returnBean = createBhv("1").requestResponseJsonIntval();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestResponseJsonDirectly() {
        // ## Act ##
        String returnBean = createBhv("String").requestResponseJsonDirectly();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestResponseJsonEccolleList() {
        // ## Act ##
        RemoteWxResponseJsonEccolleListReturn returnBean = createBhv("{}").requestResponseJsonEccolleList();

        // ## Assert ##
        logger.debug("list={}", returnBean.list);
        if (returnBean.list != null) {
            returnBean.list.forEach(row -> {
                logger.debug("list[]={}", row);
            });
        }
    }

    public void test_requestResponseJsonEccolleListempty() {
        // ## Act ##
        RemoteWxResponseJsonEccolleListemptyReturn returnBean = createBhv("{}").requestResponseJsonEccolleListempty();

        // ## Assert ##
        logger.debug("list={}", returnBean.list);
        if (returnBean.list != null) {
            returnBean.list.forEach(row -> {
                logger.debug("list[]={}", row);
            });
        }
    }

    public void test_requestResponseJsonEccolleMap() {
        // ## Act ##
        RemoteWxResponseJsonEccolleMapReturn returnBean = createBhv("{}").requestResponseJsonEccolleMap();

        // ## Assert ##
        logger.debug("map={}", returnBean.map);
        if (returnBean.map != null) {
            returnBean.map.forEach(row -> {
                logger.debug("map[]={}", row);
            });
        }
    }

    public void test_requestResponseJsonJustified() {
        // ## Act ##
        RemoteWxResponseJsonJustifiedReturn returnBean = createBhv("{}").requestResponseJsonJustified();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("birthdate={}", returnBean.birthdate);
        logger.debug("showbaseNow={}", returnBean.showbaseNow);
    }

    public void test_requestResponseJsonJustifiedNamed() {
        // ## Act ##
        RemoteWxResponseJsonJustifiedNamedReturn returnBean = createBhv("{}").requestResponseJsonJustifiedNamed();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("birthdate={}", returnBean.birthdate);
        logger.debug("showbaseNow={}", returnBean.showbaseNow);
    }

    public void test_requestResponseJsonSwitchedEngine() {
        // ## Act ##
        RemoteWxResponseJsonSwitchedEngineReturn returnBean = createBhv("{}").requestResponseJsonSwitchedEngine();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("birthdate={}", returnBean.birthdate);
        logger.debug("showbaseNow={}", returnBean.showbaseNow);
    }

    public void test_requestResponseJsonSwitchedMapping() {
        // ## Act ##
        RemoteWxResponseJsonSwitchedMappingReturn returnBean = createBhv("{}").requestResponseJsonSwitchedMapping();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("birthdate={}", returnBean.birthdate);
        logger.debug("showbaseNow={}", returnBean.showbaseNow);
    }

    public void test_requestResponseJsonSwitchedNone() {
        // ## Act ##
        RemoteWxResponseJsonSwitchedNoneReturn returnBean = createBhv("{}").requestResponseJsonSwitchedNone();

        // ## Assert ##
        logger.debug("memberId={}", returnBean.memberId);
        logger.debug("memberName={}", returnBean.memberName);
        logger.debug("birthdate={}", returnBean.birthdate);
        logger.debug("showbaseNow={}", returnBean.showbaseNow);
    }

    public void test_requestResponseStreamSmall() {
        // ## Act ##
        createBhv(null).requestResponseStreamSmall();
    }

    public void test_requestResponseStreamLarge() {
        // ## Act ##
        createBhv(null).requestResponseStreamLarge();
    }

    public void test_requestResponseStreamOutput() {
        // ## Act ##
        createBhv(null).requestResponseStreamOutput();
    }

    public void test_requestResponseStreamCursortsv() {
        // ## Act ##
        createBhv(null).requestResponseStreamCursortsv();
    }

    public void test_requestResponseStreamUpdateplain() {
        // ## Act ##
        createBhv(null).requestResponseStreamUpdateplain();
    }

    public void test_requestResponseStreamUpdatetx() {
        // ## Act ##
        createBhv(null).requestResponseStreamUpdatetx();
    }

    public void test_requestResponseStreamJapanese() {
        // ## Act ##
        createBhv(null).requestResponseStreamJapanese();
    }

    public void test_requestResponseStreamValidationerror() {
        // ## Arrange ##
        Consumer<RemoteWxResponseStreamValidationerrorParam> paramLambda = param -> {
            param.land = "land";
        };

        // ## Act ##
        createBhv(null).requestResponseStreamValidationerror(paramLambda);
    }

    public void test_requestResponseStreamWithbizex() {
        // ## Act ##
        createBhv(null).requestResponseStreamWithbizex();
    }

    public void test_requestResponseStreamWithbizexapi() {
        // ## Act ##
        createBhv(null).requestResponseStreamWithbizexapi();
    }

    public void test_requestResponseStreamApiValidationerror() {
        // ## Arrange ##
        Consumer<RemoteWxResponseStreamApiValidationerrorParam> paramLambda = param -> {
            param.land = "land";
        };

        // ## Act ##
        createBhv(null).requestResponseStreamApiValidationerror(paramLambda);
    }

    public void test_requestResponseStreamApiWithbizex() {
        // ## Act ##
        createBhv(null).requestResponseStreamApiWithbizex();
    }

    public void test_requestResponseTransitionForward() {
        // ## Act ##
        createBhv(null).requestResponseTransitionForward();
    }

    public void test_requestResponseTransitionRedirect() {
        // ## Act ##
        createBhv(null).requestResponseTransitionRedirect();
    }

    public void test_requestResponseTransitionRedirectPermanently() {
        // ## Act ##
        createBhv(null).requestResponseTransitionRedirectPermanently();
    }

    public void test_requestResponseTransitionRedirectPermanentlySsl() {
        // ## Act ##
        createBhv(null).requestResponseTransitionRedirectPermanentlySsl();
    }

    public void test_requestResponseTransitionRedirectTemporary() {
        // ## Act ##
        createBhv(null).requestResponseTransitionRedirectTemporary();
    }

    public void test_requestRouting() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingReturn returnBean = createBhv("{}").requestRouting(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingMaihama() {
        // ## Act ##
        RemoteWxRoutingMaihamaReturn returnBean = createBhv("{}").requestRoutingMaihama();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingSea() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingSeaReturn returnBean = createBhv("{}").requestRoutingSea(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingLand() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingLandReturn returnBean = createBhv("{}").requestRoutingLand(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingPiari() {
        // ## Act ##
        RemoteWxRoutingPiariReturn returnBean = createBhv("{}").requestRoutingPiari();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingPiariFirst() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingPiariReturn returnBean = createBhv("{}").requestRoutingPiari(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingDstore() {
        // ## Act ##
        RemoteWxRoutingDstoreReturn returnBean = createBhv("{}").requestRoutingDstore();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingDstoreFirst() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingDstoreReturn returnBean = createBhv("{}").requestRoutingDstore(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingDstoreSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingDstoreReturn returnBean = createBhv("{}").requestRoutingDstore(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingBonvo() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingBonvoReturn returnBean = createBhv("{}").requestRoutingBonvo(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingBonvoSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingBonvoReturn returnBean = createBhv("{}").requestRoutingBonvo(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingAmba() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingAmbaReturn returnBean = createBhv("{}").requestRoutingAmba(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingAmbaThirdThirdThird() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        String third = "third";

        // ## Act ##
        RemoteWxRoutingAmbaReturn returnBean = createBhv("{}").requestRoutingAmba(first, second, third);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingMiraco() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        String third = "third";

        // ## Act ##
        RemoteWxRoutingMiracoReturn returnBean = createBhv("{}").requestRoutingMiraco(first, second, third);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingMiracoFourthFourthFourthFourth() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        String third = "third";
        String fourth = "fourth";

        // ## Act ##
        RemoteWxRoutingMiracoReturn returnBean = createBhv("{}").requestRoutingMiraco(first, second, third, fourth);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingDohotel() {
        // ## Arrange ##
        String first = "first";
        Consumer<RemoteWxRoutingDohotelParam> paramLambda = param -> {
            param.param = "param";
        };

        // ## Act ##
        RemoteWxRoutingDohotelReturn returnBean = createBhv("{}").requestRoutingDohotel(first, paramLambda);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingDohotelSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";
        Consumer<RemoteWxRoutingDohotelFirstSecondParam> paramLambda = param -> {
            param.param = "param";
        };

        // ## Act ##
        RemoteWxRoutingDohotelReturn returnBean = createBhv("{}").requestRoutingDohotel(first, second, paramLambda);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingCeleb() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingCelebReturn returnBean = createBhv("{}").requestRoutingCeleb(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingCelebSecondSecond() {
        // ## Arrange ##
        Integer first = 1;
        Long second = 1L;

        // ## Act ##
        RemoteWxRoutingCelebReturn returnBean = createBhv("{}").requestRoutingCeleb(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingResola() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingResolaReturn returnBean = createBhv("{}").requestRoutingResola(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingAmphiTheaterMaihama() {
        // ## Arrange ##
        Integer first = 1;
        String second = "second";

        // ## Act ##
        RemoteWxRoutingAmphiTheaterMaihamaReturn returnBean = createBhv("{}").requestRoutingAmphiTheaterMaihama(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingWording() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingWordingReturn returnBean = createBhv("{}").requestRoutingWording(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingWordingSea() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingWordingSeaReturn returnBean = createBhv("{}").requestRoutingWordingSea(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingWordingLand() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingWordingLandReturn returnBean = createBhv("{}").requestRoutingWordingLand(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingWordingPiariPlaza() {
        // ## Act ##
        RemoteWxRoutingWordingPiariPlazaReturn returnBean = createBhv("{}").requestRoutingWordingPiariPlaza();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingMixworld() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingMixworldReturn returnBean = createBhv("{}").requestRoutingMixworld(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingMixworldSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingMixworldReturn returnBean = createBhv("{}").requestRoutingMixworld(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingMixworldMaihama() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingMixworldMaihamaReturn returnBean = createBhv("{}").requestRoutingMixworldMaihama(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathBasic() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathBasicReturn returnBean = createBhv("{}").requestRoutingNearpathBasic(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathBasicString() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathBasicStringReturn returnBean = createBhv("{}").requestRoutingNearpathBasicString(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathBasicNumber() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathBasicNumberReturn returnBean = createBhv("{}").requestRoutingNearpathBasicNumber(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword01Str2num() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword01Str2numReturn returnBean = createBhv("{}").requestRoutingNearpathByword01Str2num(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword01Str2numNamed() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword01Str2numNamedReturn returnBean = createBhv("{}").requestRoutingNearpathByword01Str2numNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword02Num2str() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword02Num2strReturn returnBean = createBhv("{}").requestRoutingNearpathByword02Num2str(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword02Num2strNamed() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword02Num2strNamedReturn returnBean = createBhv("{}").requestRoutingNearpathByword02Num2strNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword05Optstr2num() {
        // ## Act ##
        RemoteWxRoutingNearpathByword05Optstr2numReturn returnBean = createBhv("{}").requestRoutingNearpathByword05Optstr2num();

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword05Optstr2numFirst() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword05Optstr2numReturn returnBean = createBhv("{}").requestRoutingNearpathByword05Optstr2num(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword05Optstr2numNamed() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword05Optstr2numNamedReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword05Optstr2numNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword10Optstr4str2num() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword10Optstr4str2numReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword10Optstr4str2num(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword10Optstr4str2numSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingNearpathByword10Optstr4str2numReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword10Optstr4str2num(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword10Optstr4str2numNamed() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword10Optstr4str2numNamedReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword10Optstr4str2numNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword11Optstr4numtostr() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword11Optstr4numtostrReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword11Optstr4numtostr(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword11Optstr4numtostrSecondSecond() {
        // ## Arrange ##
        Integer first = 1;
        String second = "second";

        // ## Act ##
        RemoteWxRoutingNearpathByword11Optstr4numtostrReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword11Optstr4numtostr(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword11Optstr4numtostrNamed() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword11Optstr4numtostrNamedReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword11Optstr4numtostrNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword12Optstr4cls2str() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword12Optstr4cls2strReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword12Optstr4cls2str(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword12Optstr4cls2strSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingNearpathByword12Optstr4cls2strReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword12Optstr4cls2str(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword12Optstr4cls2strNamed() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword12Optstr4cls2strNamedReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword12Optstr4cls2strNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword13Optstr4cls2num() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword13Optstr4cls2numReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword13Optstr4cls2num(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword13Optstr4cls2numSecondSecond() {
        // ## Arrange ##
        String first = "first";
        String second = "second";

        // ## Act ##
        RemoteWxRoutingNearpathByword13Optstr4cls2numReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword13Optstr4cls2num(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword13Optstr4cls2numNamed() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword13Optstr4cls2numNamedReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword13Optstr4cls2numNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword15Optnum4str2num() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword15Optnum4str2numReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword15Optnum4str2num(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword15Optnum4str2numSecondSecond() {
        // ## Arrange ##
        String first = "first";
        Integer second = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword15Optnum4str2numReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword15Optnum4str2num(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword15Optnum4str2numNamed() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword15Optnum4str2numNamedReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword15Optnum4str2numNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword16Optnum4num2str() {
        // ## Arrange ##
        Integer first = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword16Optnum4num2strReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword16Optnum4num2str(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword16Optnum4num2strSecondSecond() {
        // ## Arrange ##
        Integer first = 1;
        Integer second = 1;

        // ## Act ##
        RemoteWxRoutingNearpathByword16Optnum4num2strReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword16Optnum4num2str(first, second);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathByword16Optnum4num2strNamed() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathByword16Optnum4num2strNamedReturn returnBean =
                createBhv("{}").requestRoutingNearpathByword16Optnum4num2strNamed(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingNearpathShadowedMethod() {
        // ## Arrange ##
        String first = "first";

        // ## Act ##
        RemoteWxRoutingNearpathShadowedMethodReturn returnBean = createBhv("{}").requestRoutingNearpathShadowedMethod(first);

        // ## Assert ##
        logger.debug("method={}", returnBean.method);
        logger.debug("first={}", returnBean.first);
        logger.debug("second={}", returnBean.second);
    }

    public void test_requestRoutingReqparam() {
        // ## Arrange ##
        Consumer<RemoteWxRoutingReqparamParam> paramLambda = param -> {
            param.land = "land";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRoutingReqparam(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRoutingReqparamSea() {
        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRoutingReqparamSea();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRoutingReqparamConflict() {
        // ## Arrange ##
        Consumer<RemoteWxRoutingReqparamConflictParam> paramLambda = param -> {
            param.sea = "sea";
        };

        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRoutingReqparamConflict(paramLambda);

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRoutingReqparamConflictSea() {
        // ## Act ##
        java.util.Map<String, Object> returnBean = createBhv("{}").requestRoutingReqparamConflictSea();

        // ## Assert ##
        logger.debug("returnBean={}", returnBean);
    }

    public void test_requestRoutingRestfulDummy() {
        // ## Act ##
        createBhv(null).requestRoutingRestfulDummy();
    }

    public void test_requestThymeleafParade() {
        // ## Arrange ##
        Consumer<RemoteWxThymeleafParadeParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.mutableStatusList = org.eclipse.collections.impl.factory.Lists.immutable.of("mutableStatusList");
            param.immutableStatusList = org.eclipse.collections.impl.factory.Lists.immutable.of("immutableStatusList");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestThymeleafParade(paramLambda);
    }

    public void test_requestThymeleafParadePageNumber() {
        // ## Arrange ##
        Integer pageNumber = 1;
        Consumer<RemoteWxThymeleafParadePagenumberParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.mutableStatusList = org.eclipse.collections.impl.factory.Lists.immutable.of("mutableStatusList");
            param.immutableStatusList = org.eclipse.collections.impl.factory.Lists.immutable.of("immutableStatusList");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestThymeleafParade(pageNumber, paramLambda);
    }

    public void test_requestTransactionMemoriesFail() {
        // ## Arrange ##
        Consumer<RemoteWxTransactionMemoriesFailParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestTransactionMemoriesFail(paramLambda);
    }

    public void test_requestTransactionMemoriesFailasync() {
        // ## Arrange ##
        Consumer<RemoteWxTransactionMemoriesFailasyncParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
        };

        // ## Act ##
        createBhv(null).requestTransactionMemoriesFailasync(paramLambda);
    }

    public void test_requestValidator() {
        // ## Arrange ##
        Consumer<RemoteWxValidatorParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
            param.seaString = "seaString";
            param.seaInteger = 1;
            param.seaLong = 1L;
            param.seaFloat = 1F;
            param.seaDouble = 1D;
            param.seaDecimal = 1D;
            param.landDate = java.time.LocalDate.now();
            param.landDateTime = java.time.LocalDateTime.now();
            param.piariPrimBool = Boolean.TRUE;
            param.piariWrapBool = Boolean.TRUE;
            param.bonvoStatus = "bonvoStatus";
            param.dstoreStringList = org.eclipse.collections.impl.factory.Lists.immutable.of("dstoreStringList");
            param.dstoreIntegerList = org.eclipse.collections.impl.factory.Lists.immutable.of(1);
            param.dstoreImmutableList = org.eclipse.collections.impl.factory.Lists.immutable.of("dstoreImmutableList");
            param.seaBean = "seaBean";
            param.seaBeanList = org.eclipse.collections.impl.factory.Lists.immutable.of("seaBeanList");
            param.landBean = "landBean";
            param.dstoreBean = "dstoreBean";
            param.ambaBean = "ambaBean";
        };

        // ## Act ##
        createBhv(null).requestValidator(paramLambda);
    }

    public void test_requestValidatorGenericform() {
        // ## Arrange ##
        Consumer<RemoteWxValidatorGenericformParam> paramLambda = param -> {
            param.seaId = 1;
            param.landNow = Boolean.TRUE;
            param.data = "data";
        };

        // ## Act ##
        createBhv(null).requestValidatorGenericform(paramLambda);
    }

    public void test_requestValidatorGroupingjson() {
        // ## Arrange ##
        Boolean grouping = Boolean.TRUE;

        // ## Act ##
        RemoteWxValidatorGroupingjsonReturn returnBean = createBhv("{}").requestValidatorGroupingjson(grouping);

        // ## Assert ##
        logger.debug("grouping={}", returnBean.grouping);
        logger.debug("seaId={}", returnBean.seaId);
        logger.debug("landName={}", returnBean.landName);
    }

    public void test_requestValidatorListjson() {
        // ## Arrange ##
        Consumer<RemoteWxValidatorListjsonParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
            param.seaString = "seaString";
            param.seaInteger = 1;
            param.seaLong = 1L;
            param.seaFloat = 1F;
            param.seaDouble = 1D;
            param.seaDecimal = 1D;
            param.landDate = java.time.LocalDate.now();
            param.landDateTime = java.time.LocalDateTime.now();
            param.piariPrimBool = Boolean.TRUE;
            param.piariWrapBool = Boolean.TRUE;
            param.bonvoStatus = "bonvoStatus";
            param.dstoreStringList = org.eclipse.collections.impl.factory.Lists.immutable.of("dstoreStringList");
            param.dstoreIntegerList = org.eclipse.collections.impl.factory.Lists.immutable.of(1);
            param.dstoreImmutableList = org.eclipse.collections.impl.factory.Lists.immutable.of("dstoreImmutableList");
            param.seaBean = new RemoteWxValidatorListjsonParam.SeaPart();
            param.seaBean.over = 1;
            param.seaBean.mystic = Boolean.TRUE;
            RemoteWxValidatorListjsonParam.SeaPart.RestaurantPart restaurantPart =
                    new RemoteWxValidatorListjsonParam.SeaPart.RestaurantPart();
            restaurantPart.restaurantName = "restaurantName";
            restaurantPart.genreList = org.eclipse.collections.impl.factory.Lists.immutable.of("genreList");
            RemoteWxValidatorListjsonParam.SeaPart.RestaurantPart.MenuPart menuPart =
                    new RemoteWxValidatorListjsonParam.SeaPart.RestaurantPart.MenuPart();
            menuPart.menuName = "menuName";
            restaurantPart.menuList = org.eclipse.collections.impl.factory.Lists.immutable.of(menuPart);
            param.seaBean.restaurantList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantImmutableInstanceList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantImmutableTypeList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantIterableArrayList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantIterableImmutableList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBeanList = org.eclipse.collections.impl.factory.Lists.immutable.of(param.seaBean);
            param.landBean = new RemoteWxValidatorListjsonParam.LandPart();
            param.landBean.oneman = 1;
            param.landBean.minio = 1;
            param.landBean.haunted = DfCollectionUtil.newHashMap();
            param.landBean.bonvoBean = new RemoteWxValidatorListjsonParam.LandPart.BonvoPart();
            param.landBean.bonvoBean.yage = 1;
            param.dstoreBean = new RemoteWxValidatorListjsonParam.DstorePart();
            param.dstoreBean.goods = DfCollectionUtil.newHashMap();
            param.ambaBean = new RemoteWxValidatorListjsonParam.AmbaPart();
            param.ambaBean.ssador = 1;
            param.ambaBean.roomList = org.eclipse.collections.impl.factory.Lists.immutable.of(DfCollectionUtil.newHashMap());
        };

        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemoteWxValidatorListjsonReturn> list =
                createBhv("[]").requestValidatorListjson(paramLambda);

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("seaId={}", returnBean.seaId);
            logger.debug("landName={}", returnBean.landName);
            logger.debug("nestedBean={}", returnBean.nestedBean);
            if (returnBean.nestedBean != null) {
                logger.debug("nestedBean.piariId={}", returnBean.nestedBean.piariId);
                logger.debug("nestedBean.bonvo={}", returnBean.nestedBean.bonvo);
            }
            logger.debug("recursiveBean={}", returnBean.recursiveBean);
            if (returnBean.recursiveBean != null) {
                logger.debug("recursiveBean.seaId={}", returnBean.recursiveBean.seaId);
                logger.debug("recursiveBean.landName={}", returnBean.recursiveBean.landName);
                logger.debug("recursiveBean.nestedBean={}", returnBean.recursiveBean.nestedBean);
                if (returnBean.recursiveBean.nestedBean != null) {
                    logger.debug("recursiveBean.nestedBean.piariId={}", returnBean.recursiveBean.nestedBean.piariId);
                    logger.debug("recursiveBean.nestedBean.bonvo={}", returnBean.recursiveBean.nestedBean.bonvo);
                }
                logger.debug("recursiveBean.recursiveBean={}", returnBean.recursiveBean.recursiveBean);
                if (returnBean.recursiveBean.recursiveBean != null) {
                    logger.debug("recursiveBean.recursiveBean.seaId={}", returnBean.recursiveBean.recursiveBean.seaId);
                    logger.debug("recursiveBean.recursiveBean.landName={}", returnBean.recursiveBean.recursiveBean.landName);
                    logger.debug("recursiveBean.recursiveBean.nestedBean={}", returnBean.recursiveBean.recursiveBean.nestedBean);
                    logger.debug("recursiveBean.recursiveBean.recursiveBean={}", returnBean.recursiveBean.recursiveBean.recursiveBean);
                }
            }
        });
    }

    public void test_requestValidatorWholejson() {
        // ## Arrange ##
        Consumer<RemoteWxValidatorWholejsonParam> paramLambda = param -> {
            param.productName = "productName";
            param.productStatus = org.docksidestage.dbflute.allcommon.CDef.ProductStatus.codeOf("ONS");
            param.purchaseMemberName = "purchaseMemberName";
            param.seaString = "seaString";
            param.seaInteger = 1;
            param.seaLong = 1L;
            param.seaFloat = 1F;
            param.seaDouble = 1D;
            param.seaDecimal = 1D;
            param.landDate = java.time.LocalDate.now();
            param.landDateTime = java.time.LocalDateTime.now();
            param.piariPrimBool = Boolean.TRUE;
            param.piariWrapBool = Boolean.TRUE;
            param.bonvoStatus = "bonvoStatus";
            param.dstoreStringList = org.eclipse.collections.impl.factory.Lists.immutable.of("dstoreStringList");
            param.dstoreIntegerList = org.eclipse.collections.impl.factory.Lists.immutable.of(1);
            param.dstoreImmutableList = org.eclipse.collections.impl.factory.Lists.immutable.of("dstoreImmutableList");
            param.seaBean = new RemoteWxValidatorWholejsonParam.SeaPart();
            param.seaBean.over = 1;
            param.seaBean.mystic = Boolean.TRUE;
            RemoteWxValidatorWholejsonParam.SeaPart.RestaurantPart restaurantPart =
                    new RemoteWxValidatorWholejsonParam.SeaPart.RestaurantPart();
            restaurantPart.restaurantName = "restaurantName";
            restaurantPart.genreList = org.eclipse.collections.impl.factory.Lists.immutable.of("genreList");
            RemoteWxValidatorWholejsonParam.SeaPart.RestaurantPart.MenuPart menuPart =
                    new RemoteWxValidatorWholejsonParam.SeaPart.RestaurantPart.MenuPart();
            menuPart.menuName = "menuName";
            restaurantPart.menuList = org.eclipse.collections.impl.factory.Lists.immutable.of(menuPart);
            param.seaBean.restaurantList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantImmutableInstanceList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantImmutableTypeList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantIterableArrayList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBean.restaurantIterableImmutableList = org.eclipse.collections.impl.factory.Lists.immutable.of(restaurantPart);
            param.seaBeanList = org.eclipse.collections.impl.factory.Lists.immutable.of(param.seaBean);
            param.landBean = new RemoteWxValidatorWholejsonParam.LandPart();
            param.landBean.oneman = 1;
            param.landBean.minio = 1;
            param.landBean.haunted = DfCollectionUtil.newHashMap();
            param.landBean.bonvoBean = new RemoteWxValidatorWholejsonParam.LandPart.BonvoPart();
            param.landBean.bonvoBean.yage = 1;
            param.dstoreBean = new RemoteWxValidatorWholejsonParam.DstorePart();
            param.dstoreBean.goods = DfCollectionUtil.newHashMap();
            param.ambaBean = new RemoteWxValidatorWholejsonParam.AmbaPart();
            param.ambaBean.ssador = 1;
            param.ambaBean.roomList = org.eclipse.collections.impl.factory.Lists.immutable.of(DfCollectionUtil.newHashMap());
        };

        // ## Act ##
        RemoteWxValidatorWholejsonReturn returnBean = createBhv("{}").requestValidatorWholejson(paramLambda);

        // ## Assert ##
        logger.debug("seaId={}", returnBean.seaId);
        logger.debug("landName={}", returnBean.landName);
        logger.debug("data={}", returnBean.data);
    }

    public void test_requestValidatorCustom() {
        // ## Arrange ##
        Consumer<RemoteWxValidatorCustomParam> paramLambda = param -> {
            param.sea = "sea";
            param.land = "land";
        };

        // ## Act ##
        createBhv(null).requestValidatorCustom(paramLambda);
    }

    public void test_requestValidatorGroupsResponseDockside() {
        // ## Act ##
        RemoteWxValidatorGroupsResponseDocksideReturn returnBean = createBhv("{}").requestValidatorGroupsResponseDockside();

        // ## Assert ##
        logger.debug("docksideOnly={}", returnBean.docksideOnly);
        logger.debug("hangarOnly={}", returnBean.hangarOnly);
        logger.debug("bothNamed={}", returnBean.bothNamed);
        logger.debug("withDefault={}", returnBean.withDefault);
        logger.debug("noSpecified={}", returnBean.noSpecified);
        logger.debug("defaultOnly={}", returnBean.defaultOnly);
    }

    public void test_requestValidatorGroupsResponseHangar() {
        // ## Act ##
        RemoteWxValidatorGroupsResponseHangarReturn returnBean = createBhv("{}").requestValidatorGroupsResponseHangar();

        // ## Assert ##
        logger.debug("docksideOnly={}", returnBean.docksideOnly);
        logger.debug("hangarOnly={}", returnBean.hangarOnly);
        logger.debug("bothNamed={}", returnBean.bothNamed);
        logger.debug("withDefault={}", returnBean.withDefault);
        logger.debug("noSpecified={}", returnBean.noSpecified);
        logger.debug("defaultOnly={}", returnBean.defaultOnly);
    }

    public void test_requestValidatorGroupsResponseUsedefault() {
        // ## Act ##
        RemoteWxValidatorGroupsResponseUsedefaultReturn returnBean = createBhv("{}").requestValidatorGroupsResponseUsedefault();

        // ## Assert ##
        logger.debug("docksideOnly={}", returnBean.docksideOnly);
        logger.debug("hangarOnly={}", returnBean.hangarOnly);
        logger.debug("bothNamed={}", returnBean.bothNamed);
        logger.debug("withDefault={}", returnBean.withDefault);
        logger.debug("noSpecified={}", returnBean.noSpecified);
        logger.debug("defaultOnly={}", returnBean.defaultOnly);
    }

    private RemoteFortressWxBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemoteFortressWxBhv bhv = new RemoteFortressWxBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
