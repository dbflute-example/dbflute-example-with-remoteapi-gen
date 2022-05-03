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
package org.docksidestage.remote.tricky.fieldcase.ngchar;

import com.google.gson.annotations.SerializedName;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as return for remote API of GET /fieldcase/ngchar/.
 * @author FreeGen
 */
public class RemoteFieldcaseNgcharGetReturn {

    /** The property of hangarid. (NullAllowed) */
    @SerializedName("hangar*id")
    public Integer hangarid;

    /** The property of onemanname. (NullAllowed) */
    @SerializedName("oneman-name")
    public String onemanname;

    /** The property of onePiari. (NullAllowed) */
    @SerializedName("1Piari")
    public String onePiari;

    /** The property of unchanged. (NullAllowed) */
    public String unchanged;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
