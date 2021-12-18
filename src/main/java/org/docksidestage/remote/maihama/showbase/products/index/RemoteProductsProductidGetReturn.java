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
package org.docksidestage.remote.maihama.showbase.products.index;

import javax.validation.constraints.NotNull;

import org.lastaflute.core.util.Lato;
import org.lastaflute.web.validation.Required;

/**
 * The bean class as return for remote API of GET /products/{productId}/.
 * @author FreeGen
 */
public class RemoteProductsProductidGetReturn {

    /** The property of productId. */
    @Required
    public Integer productId;

    /** The property of productName. */
    @Required
    public String productName;

    /** The property of productStatus. (enumValue=[ONS, PST, SST]) ( * `ONS` - OnSaleProduction. * `PST` - ProductionStop. * `SST` - SaleStop. :: fromCls(AppCDef$PublicProductStatus)) */
    @Required
    public org.docksidestage.dbflute.allcommon.CDef.ProductStatus productStatus;

    /** The property of pastProductStatuses. (enumValue=[ONS, PST, SST]) */
    @NotNull
    public org.eclipse.collections.api.list.ImmutableList<org.docksidestage.dbflute.allcommon.CDef.ProductStatus> pastProductStatuses;

    /** The property of purchasedMemberIds. */
    @NotNull
    public org.eclipse.collections.api.list.ImmutableList<Integer> purchasedMemberIds;

    /** The property of productCategory. */
    @Required
    public String productCategory;

    /** The property of regularPrice. */
    @Required
    public Integer regularPrice;

    /** The property of latestPurchaseDate. (null if no purchase) (NullAllowed) */
    public java.time.LocalDate latestPurchaseDate;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
