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
package org.docksidestage.remote.fortress.wx.routing.nearpath.byword16.optnum4num2str.named;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as return for remote API of GET /wx/routing/nearpath/byword16/optnum4num2str/{first}/named.
 * @author FreeGen
 */
public class RemoteWxRoutingNearpathByword16Optnum4num2strNamedReturn extends org.docksidestage.bizfw.remoteapi.AbstractListGetReturn {

    /** The property of method. (NullAllowed) */
    public String method;

    /** The property of first. (NullAllowed) */
    public java.util.Map<String, Object> first;

    /** The property of second. (NullAllowed) */
    public java.util.Map<String, Object> second;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
