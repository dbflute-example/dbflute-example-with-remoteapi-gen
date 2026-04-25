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
package org.docksidestage.remote.tricky.urlcharacter.pathcolon;

import org.lastaflute.core.util.Lato;

import com.google.gson.annotations.SerializedName;

/**
 * The bean class as return for remote API of GET /urlcharacter/:pathcolon/.
 * @author FreeGen
 */
public class RemoteUrlcharacterPathcolonReturn {

    /** The property of hangarId. (NullAllowed) */
    @SerializedName("hangar_id")
    public Integer hangarId;

    /** The property of onemanName. (NullAllowed) */
    public String onemanName;

    /** The property of piari. (NullAllowed) */
    public String piari;

    /** The property of bonvo. (NullAllowed) */
    @SerializedName("BONVO")
    public String bonvo;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
