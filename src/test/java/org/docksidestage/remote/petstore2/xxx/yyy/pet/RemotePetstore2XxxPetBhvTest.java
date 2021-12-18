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
package org.docksidestage.remote.petstore2.xxx.yyy.pet;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbystatus.RemotePetFindbystatusParam;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbystatus.RemotePetFindbystatusReturn;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbytags.RemotePetFindbytagsParam;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.findbytags.RemotePetFindbytagsReturn;
import org.docksidestage.remote.petstore2.xxx.yyy.pet.index.RemotePetReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of pet.
 * @author FreeGen
 */
public class RemotePetstore2XxxPetBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemotePetstore2XxxPetBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestFindbystatus() {
        // ## Arrange ##
        Consumer<RemotePetFindbystatusParam> paramLambda = param -> {
            param.status = org.eclipse.collections.impl.factory.Lists.immutable.of("status");
        };

        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemotePetFindbystatusReturn> list = createBhv("[]").requestFindbystatus(paramLambda);

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("id={}", returnBean.id);
            logger.debug("category.id={}", returnBean.category.id);
            logger.debug("category.name={}", returnBean.category.name);
            logger.debug("name={}", returnBean.name);
            logger.debug("photoUrls={}", returnBean.photoUrls);
            returnBean.tags.forEach(tag -> {
                logger.debug("tag.id={}", tag.id);
                logger.debug("tag.name={}", tag.name);
            });
            logger.debug("{}", returnBean.status);
        });
    }

    public void test_requestFindbytags() {
        // ## Arrange ##
        Consumer<RemotePetFindbytagsParam> paramLambda = param -> {
            param.tags = org.eclipse.collections.impl.factory.Lists.immutable.of("tags");
        };

        // ## Act ##
        org.eclipse.collections.api.list.ImmutableList<RemotePetFindbytagsReturn> list = createBhv("[]").requestFindbytags(paramLambda);

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("id={}", returnBean.id);
            logger.debug("category.id={}", returnBean.category.id);
            logger.debug("category.name={}", returnBean.category.name);
            logger.debug("name={}", returnBean.name);
            logger.debug("photoUrls={}", returnBean.photoUrls);
            if (returnBean.tags != null) {
                returnBean.tags.forEach(tag -> {
                    logger.debug("tag.id={}", tag.id);
                    logger.debug("tag.name={}", tag.name);
                });
            }
            logger.debug("{}", returnBean.status);
        });
    }

    public void test_request() {
        // ## Arrange ##
        Long petId = 1L;

        // ## Act ##
        RemotePetReturn returnBean = createBhv("{}").request(petId);

        // ## Assert ##
        logger.debug("id={}", returnBean.id);
        logger.debug("category={}", returnBean.category);
        if (returnBean.category != null) {
            logger.debug("category.id={}", returnBean.category.id);
            logger.debug("category.name={}", returnBean.category.name);
        }
        logger.debug("name={}", returnBean.name);
        logger.debug("photoUrls={}", returnBean.photoUrls);
        if (returnBean.tags != null) {
            returnBean.tags.forEach(tag -> {
                logger.debug("tag.id={}", tag.id);
                logger.debug("tag.name={}", tag.name);
            });
        }
        logger.debug("status={}", returnBean.status);
    }

    private RemotePetstore2XxxPetBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemotePetstore2XxxPetBhv bhv = new RemotePetstore2XxxPetBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
