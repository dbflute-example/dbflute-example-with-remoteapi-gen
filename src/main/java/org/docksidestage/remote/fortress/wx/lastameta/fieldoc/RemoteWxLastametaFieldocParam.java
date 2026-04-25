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
package org.docksidestage.remote.fortress.wx.lastameta.fieldoc;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as param for remote API of POST /wx/lastameta/fieldoc/.
 * @author FreeGen
 */
public class RemoteWxLastametaFieldocParam {

    /** The property of seaStringBasic. (Sea String basic e.g. SeaOfDreams) (NullAllowed) */
    public String seaStringBasic;

    /** The property of seaStringQuoted. (Sea String quoted e.g. "Sea of Dreams") (NullAllowed) */
    public String seaStringQuoted;

    /** The property of seaStringNonSpace. (Sea String non space e.g. "Sea of Dreams") (NullAllowed) */
    public String seaStringNonSpace;

    /** The property of seaListBasic. (Sea List basic e.g. [dockside,hangar]) (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> seaListBasic;

    /** The property of seaImmutableListBasic. (Sea ImmutableList basic e.g. [dockside,hangar]) (NullAllowed) */
    public org.eclipse.collections.api.list.ImmutableList<String> seaImmutableListBasic;

    /** The property of seaMapBasic. (Sea Map basic e.g. {dockside:over,hangar:mystic}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapBasic;

    /** The property of seaMapQuoted. (Sea Map quoted e.g. {"dockside":"over","hangar":"mystic"}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapQuoted;

    /** The property of seaMapSpaceDelimiter. (Sea Map space delimiter e.g. {dockside : over , hangar : mystic}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapSpaceDelimiter;

    /** The property of seaMapSpaceValue. (Sea Map space value e.g. {dock side:over the waves,han gar:mys tic}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapSpaceValue;

    /** The property of seaMapNonGeneric. (Sea Map non generic e.g. {dockside:over,hangar:mystic}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapNonGeneric;

    /** The property of seaMapNonTyped. (Sea Map non typed e.g. {dockside:over,hangar:mystic}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapNonTyped;

    /** The property of seaMapInteger. (Sea Map Integer e.g. {dockside:1,hangar:2}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapInteger;

    /** The property of seaMapIntegerMismatched. (Sea Map Integer Mismatched e.g. {dockside:over,hangar:mystic}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapIntegerMismatched;

    /** The property of seaMapNestBean. (Sea Map nest bean e.g. {dockside:over,hangar:mystic}) (NullAllowed) */
    public java.util.Map<String, Object> seaMapNestBean;

    /** The property of seaClsBasic. (enumValue=[FML, WDL, PRV]) (Sea Classification basic e.g. FML: * `FML` - Formalized. * `WDL` - Withdrawal. * `PRV` - Provisional. :: fromCls(CDef$MemberStatus)) (NullAllowed) */
    public String seaClsBasic;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
