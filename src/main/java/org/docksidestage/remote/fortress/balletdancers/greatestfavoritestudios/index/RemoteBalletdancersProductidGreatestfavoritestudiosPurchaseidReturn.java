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
package org.docksidestage.remote.fortress.balletdancers.greatestfavoritestudios.index;

import org.lastaflute.core.util.Lato;
import org.lastaflute.web.validation.Required;

/**
 * The bean class as return for remote API of GET /ballet-dancers/{productId}/greatest-favorite-studios/{purchaseId}/.
 * @author FreeGen
 */
public class RemoteBalletdancersProductidGreatestfavoritestudiosPurchaseidReturn {

    /** The property of purchaseId. */
    @Required
    public Long purchaseId;

    /** The property of memberName. */
    @Required
    public String memberName;

    /** The property of productName. */
    @Required
    public String productName;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
