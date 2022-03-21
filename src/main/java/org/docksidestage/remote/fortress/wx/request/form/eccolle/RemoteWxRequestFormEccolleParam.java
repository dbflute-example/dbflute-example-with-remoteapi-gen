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
package org.docksidestage.remote.fortress.wx.request.form.eccolle;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as param for remote API of GET /wx/request/form/eccolle.
 * @author FreeGen
 */
public class RemoteWxRequestFormEccolleParam {

    /** The property of sea. (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> sea;

    /** The property of land. (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> land;

    /** The property of piari. (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> piari;

    /** The property of bonvo. (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> bonvo;

    /** The property of dstore. (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> dstore;

    /** The property of amba. (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> amba;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
