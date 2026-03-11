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
package org.docksidestage.remote.fortress.wx.security.request.jsonbody.error;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as param for remote API of POST /wx/security/request/jsonbody/error.
 * @author FreeGen
 */
public class RemoteWxSecurityRequestJsonbodyErrorParam {

    /** The property of secureSea. (e.g. mystic) (NullAllowed) */
    public String secureSea;

    /** The property of secureLand. (e.g. 83) (NullAllowed) */
    public Integer secureLand;

    /** The property of openPiari. (e.g. 2019-04-07) (NullAllowed) */
    public java.time.LocalDate openPiari;

    /** The property of secureMiraco. (e.g. [harborSide, riverSide]) (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> secureMiraco;

    /** The property of secureAmba. (NullAllowed) */
    @javax.validation.Valid
    public MapPart secureAmba;

    /**
     * The part class of MapPart.
     * @author FreeGen
     */
    public static class MapPart {

        /** The property of dstore. (e.g. ambahotel) (NullAllowed) */
        public String dstore;

        /** The property of secureBonvo. (e.g. shop) (NullAllowed) */
        public String secureBonvo;

        /** The property of dohotel. (NullAllowed) */
        @javax.validation.Valid
        public NestedMapPart dohotel;

        /**
         * The part class of NestedMapPart.
         * @author FreeGen
         */
        public static class NestedMapPart {

            /** The property of secureLando. (e.g. oneman) (NullAllowed) */
            public String secureLando;

            /** The property of landodo. (e.g. oneoneman) (NullAllowed) */
            public String landodo;
        }

        /** The property of secureDodohotel. (NullAllowed) */
        @javax.validation.Valid
        public NestedMapPart secureDodohotel;

        /** The property of secureDododohotelList. (NullAllowed) */
        public org.eclipse.collections.api.list.ImmutableList<String> secureDododohotelList;
    }

    /** The property of ssador. (NullAllowed) */
    @javax.validation.Valid
    public MapPart ssador;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
