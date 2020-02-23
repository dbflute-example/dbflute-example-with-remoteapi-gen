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
package org.docksidestage.mylasta.direction.sponsor;

import java.util.TimeZone;

import org.docksidestage.mylasta.direction.RemoteapigenConfig;
import org.lastaflute.core.time.TypicalTimeResourceProvider;

/**
 * @author jflute
 */
public class RemoteapigenTimeResourceProvider extends TypicalTimeResourceProvider {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final RemoteapigenConfig config;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public RemoteapigenTimeResourceProvider(RemoteapigenConfig config) {
        this.config = config;
    }

    // ===================================================================================
    //                                                                      Basic Handling
    //                                                                      ==============
    @Override
    protected TimeZone getCentralTimeZone() {
        return RemoteapigenUserTimeZoneProcessProvider.centralTimeZone;
    }

    // ===================================================================================
    //                                                                     Time Adjustment
    //                                                                     ===============
    @Override
    protected String getTimeAdjustTimeMillis() {
        return config.getTimeAdjustTimeMillis();
    }

    @Override
    protected Long getTimeAdjustTimeMillisAsLong() {
        return config.getTimeAdjustTimeMillisAsLong();
    }
}
