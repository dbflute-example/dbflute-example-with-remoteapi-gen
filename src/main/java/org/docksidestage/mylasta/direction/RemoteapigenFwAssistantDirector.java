/*
 * Copyright 2015-2016 the original author or authors.
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
package org.docksidestage.mylasta.direction;

import javax.annotation.Resource;

import org.docksidestage.mylasta.direction.sponsor.RemoteapigenActionAdjustmentProvider;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenApiFailureHook;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenCookieResourceProvider;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenCurtainBeforeHook;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenJsonResourceProvider;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenSecurityResourceProvider;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenTimeResourceProvider;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenUserLocaleProcessProvider;
import org.docksidestage.mylasta.direction.sponsor.RemoteapigenUserTimeZoneProcessProvider;
import org.lastaflute.core.direction.CachedFwAssistantDirector;
import org.lastaflute.core.direction.FwAssistDirection;
import org.lastaflute.core.direction.FwCoreDirection;
import org.lastaflute.core.security.InvertibleCryptographer;
import org.lastaflute.core.security.OneWayCryptographer;
import org.lastaflute.db.direction.FwDbDirection;
import org.lastaflute.web.api.ApiFailureHook;
import org.lastaflute.web.direction.FwWebDirection;

/**
 * @author jflute
 */
public class RemoteapigenFwAssistantDirector extends CachedFwAssistantDirector {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    private RemoteapigenConfig config;

    // ===================================================================================
    //                                                                              Assist
    //                                                                              ======
    @Override
    protected void prepareAssistDirection(FwAssistDirection direction) {
        direction.directConfig(nameList -> nameList.add("remoteapigen_config.properties"), "remoteapigen_env.properties");
    }

    // ===================================================================================
    //                                                                               Core
    //                                                                              ======
    @Override
    protected void prepareCoreDirection(FwCoreDirection direction) {
        // this configuration is on remoteapigen_env.properties because this is true only when development
        direction.directDevelopmentHere(config.isDevelopmentHere());

        // titles of the application for logging are from configurations
        direction.directLoggingTitle(config.getDomainTitle(), config.getEnvironmentTitle());

        // this configuration is on sea_env.properties because it has no influence to production
        // even if you set true manually and forget to set false back
        direction.directFrameworkDebug(config.isFrameworkDebug()); // basically false

        // you can add your own process when your application is booting
        direction.directCurtainBefore(createCurtainBeforeHook());

        direction.directSecurity(createSecurityResourceProvider());
        direction.directTime(createTimeResourceProvider());
        direction.directJson(createJsonResourceProvider());
    }

    protected RemoteapigenCurtainBeforeHook createCurtainBeforeHook() {
        return new RemoteapigenCurtainBeforeHook();
    }

    protected RemoteapigenSecurityResourceProvider createSecurityResourceProvider() { // #change_it_first
        final InvertibleCryptographer inver = InvertibleCryptographer.createAesCipher("remoteapigen:dockside:");
        final OneWayCryptographer oneWay = OneWayCryptographer.createSha256Cryptographer();
        return new RemoteapigenSecurityResourceProvider(inver, oneWay);
    }

    protected RemoteapigenTimeResourceProvider createTimeResourceProvider() {
        return new RemoteapigenTimeResourceProvider(config);
    }

    protected RemoteapigenJsonResourceProvider createJsonResourceProvider() {
        return new RemoteapigenJsonResourceProvider();
    }

    // ===================================================================================
    //                                                                                 DB
    //                                                                                ====
    @Override
    protected void prepareDbDirection(FwDbDirection direction) {
    }

    // ===================================================================================
    //                                                                                Web
    //                                                                               =====
    @Override
    protected void prepareWebDirection(FwWebDirection direction) {
        direction.directRequest(createUserLocaleProcessProvider(), createUserTimeZoneProcessProvider());
        direction.directCookie(createCookieResourceProvider());
        direction.directAdjustment(createActionAdjustmentProvider());
        direction.directApiCall(createApiFailureHook());
    }

    protected RemoteapigenUserLocaleProcessProvider createUserLocaleProcessProvider() {
        return new RemoteapigenUserLocaleProcessProvider();
    }

    protected RemoteapigenUserTimeZoneProcessProvider createUserTimeZoneProcessProvider() {
        return new RemoteapigenUserTimeZoneProcessProvider();
    }

    protected RemoteapigenCookieResourceProvider createCookieResourceProvider() { // #change_it_first
        final InvertibleCryptographer cr = InvertibleCryptographer.createAesCipher("dockside:remoteapigen:");
        return new RemoteapigenCookieResourceProvider(config, cr);
    }

    protected RemoteapigenActionAdjustmentProvider createActionAdjustmentProvider() {
        return new RemoteapigenActionAdjustmentProvider();
    }

    protected RemoteapigenApiFailureHook createApiFailureHook() {
        return new RemoteapigenApiFailureHook();
    }

    // TODO p1us2er0 Removed after lastaflute bug fix. (2020/02/24)
    protected FwWebDirection createWebDirection() {
        return new FwWebDirection() {
            public ApiFailureHook assistApiFailureHook() {
                assertAssistObjectNotNull(apiFailureHook, "Not found the hook for API failure.");
                return apiFailureHook;
            }
        };
    }
}
