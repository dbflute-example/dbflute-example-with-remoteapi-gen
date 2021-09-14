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
package org.docksidestage.remote.petstore.user.index;

import javax.xml.bind.annotation.XmlElement;

import org.lastaflute.core.util.Lato;

/**
 * The bean class as return for remote API of GET /user/{username}.
 * @author FreeGen
 */
public class RemoteUserGetReturn {

    /** The property of id. (NullAllowed) */
    @XmlElement(name = "id")
    public Long id;

    /** The property of username. (NullAllowed) */
    @XmlElement(name = "username")
    public String username;

    /** The property of firstName. (NullAllowed) */
    @XmlElement(name = "firstName")
    public String firstName;

    /** The property of lastName. (NullAllowed) */
    @XmlElement(name = "lastName")
    public String lastName;

    /** The property of email. (NullAllowed) */
    @XmlElement(name = "email")
    public String email;

    /** The property of password. (NullAllowed) */
    @XmlElement(name = "password")
    public String password;

    /** The property of phone. (NullAllowed) */
    @XmlElement(name = "phone")
    public String phone;

    /** The property of userStatus. (User Status) (NullAllowed) */
    @XmlElement(name = "userStatus")
    public Integer userStatus;

    @Override
    public String toString() {
        return Lato.string(this);
    }
}
