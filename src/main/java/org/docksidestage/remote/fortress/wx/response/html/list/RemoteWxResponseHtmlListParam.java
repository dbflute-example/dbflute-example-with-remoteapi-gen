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
package org.docksidestage.remote.fortress.wx.response.html.list;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as param for remote API of GET /wx/response/html/list.
 * @author FreeGen
 */
public class RemoteWxResponseHtmlListParam {

    /** The property of memberName. (NullAllowed) */
    public String memberName;

    /** The property of memberStatus. (enumValue=[FML, WDL, PRV]) ( * `FML` - Formalized. * `WDL` - Withdrawal. * `PRV` - Provisional. :: fromCls(CDef$MemberStatus)) (NullAllowed) */
    public org.docksidestage.dbflute.allcommon.CDef.MemberStatus memberStatus;

    /** The property of purchaseProductName. (NullAllowed) */
    public String purchaseProductName;

    /** The property of unpaid. (NullAllowed) */
    public Boolean unpaid;

    /** The property of formalizedFrom. (NullAllowed) */
    public java.time.LocalDate formalizedFrom;

    /** The property of formalizedTo. (NullAllowed) */
    public java.time.LocalDate formalizedTo;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
