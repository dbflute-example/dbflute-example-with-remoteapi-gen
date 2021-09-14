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
package org.docksidestage.remote.petstore.store.order;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as param for remote API of POST /store/order.
 * @author FreeGen
 */
public class RemoteStoreOrderParam {

    /** The property of id. (NullAllowed) */
    public Long id;

    /** The property of petId. (NullAllowed) */
    public Long petId;

    /** The property of quantity. (NullAllowed) */
    public Integer quantity;

    /** The property of shipDate. (NullAllowed) */
    public java.time.LocalDateTime shipDate;

    /** The property of status. (enumValue=[placed, approved, delivered]) (Order Status) (NullAllowed) */
    public String status;

    /** The property of complete. (NullAllowed) */
    public Boolean complete;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
