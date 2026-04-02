/*
 * Copyright 2017-2026 the original author or authors.
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
package org.docksidestage.remote.tricky.fieldcase.numbercamel;

import org.lastaflute.core.util.Lato;

import com.google.gson.annotations.SerializedName;

/**
 * The bean class as param for remote API of GET /fieldcase/numbercamel/.
 * @author FreeGen
 */
public class RemoteFieldcaseNumbercamelGetParam {

    /** The property of seaIdOne. (NullAllowed) */
    @SerializedName("sea_id_1")
    public Integer seaIdOne;

    /** The property of landTwoName. (NullAllowed) */
    @SerializedName("land_2_name")
    public String landTwoName;

    /** The property of threePiari. (NullAllowed) */
    @SerializedName("3_piari")
    public String threePiari;

    /** The property of bonvofour4dstore. (NullAllowed) */
    @SerializedName("bonvo4_4dstore")
    public String bonvofour4dstore;

    /** The property of ambafive. (NullAllowed) */
    @SerializedName("amba5")
    public String ambafive;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
