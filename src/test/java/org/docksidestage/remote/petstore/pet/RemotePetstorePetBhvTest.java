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
package org.docksidestage.remote.petstore.pet;

import java.util.function.Consumer;

import javax.annotation.Resource;

import org.dbflute.remoteapi.mock.MockHttpClient;
import org.docksidestage.remote.petstore.pet.findbystatus.RemotePetFindbystatusParam;
import org.docksidestage.remote.petstore.pet.findbystatus.RemotePetFindbystatusReturn;
import org.docksidestage.remote.petstore.pet.findbytags.RemotePetFindbytagsParam;
import org.docksidestage.remote.petstore.pet.findbytags.RemotePetFindbytagsReturn;
import org.docksidestage.remote.petstore.pet.index.RemotePetGetReturn;
import org.docksidestage.remote.petstore.pet.index.RemotePetPetidPostParam;
import org.docksidestage.remote.petstore.pet.index.RemotePetPostParam;
import org.docksidestage.remote.petstore.pet.index.RemotePetPutParam;
import org.docksidestage.remote.petstore.pet.uploadimage.RemotePetUploadimageParam;
import org.docksidestage.remote.petstore.pet.uploadimage.RemotePetUploadimageReturn;
import org.docksidestage.unit.UnitRemoteapigenTestCase;
import org.lastaflute.web.servlet.request.RequestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The behavior test for remote API of pet.
 * @author FreeGen
 */
public class RemotePetstorePetBhvTest extends UnitRemoteapigenTestCase {

    private static final Logger logger = LoggerFactory.getLogger(RemotePetstorePetBhvTest.class);

    @Resource
    private RequestManager requestManager;

    public void test_requestPost() {
        // ## Arrange ##
        Consumer<RemotePetPostParam> paramLambda = param -> {
            param.id = 1L;
            param.category = new RemotePetPostParam.CategoryPart();
            param.category.id = 1L;
            param.category.name = "name";
            param.name = "name";
            param.photoUrls = org.dbflute.util.DfCollectionUtil.newArrayList("photoUrls");
            param.tags = org.dbflute.util.DfCollectionUtil.newArrayList(new RemotePetPostParam.TagPart());
            param.tags.get(0).id = 1L;
            param.tags.get(0).name = "name";
            param.status = "status";
        };

        // ## Act ##
        createBhv(null).requestPost(paramLambda);
    }

    public void test_requestPut() {
        // ## Arrange ##
        Consumer<RemotePetPutParam> paramLambda = param -> {
            param.id = 1L;
            param.category = new RemotePetPutParam.CategoryPart();
            param.category.id = 1L;
            param.category.name = "name";
            param.name = "name";
            param.photoUrls = org.dbflute.util.DfCollectionUtil.newArrayList("photoUrls");
            param.tags = org.dbflute.util.DfCollectionUtil.newArrayList(new RemotePetPutParam.TagPart());
            param.tags.get(0).id = 1L;
            param.tags.get(0).name = "name";
            param.status = "status";
        };

        // ## Act ##
        createBhv(null).requestPut(paramLambda);
    }

    public void test_requestFindbystatus() {
        // ## Arrange ##
        Consumer<RemotePetFindbystatusParam> paramLambda = param -> {
            param.status = org.dbflute.util.DfCollectionUtil.newArrayList("status");
        };

        // ## Act ##
        java.util.List<RemotePetFindbystatusReturn> list = createBhv("[]").requestFindbystatus(paramLambda);

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("id={}", returnBean.id);
            logger.debug("category={}", returnBean.category);
            if (returnBean.category != null) {
                logger.debug("category.id={}", returnBean.category.id);
                logger.debug("category.name={}", returnBean.category.name);
            }
            logger.debug("name={}", returnBean.name);
            logger.debug("photoUrls={}", returnBean.photoUrls);
            if (returnBean.photoUrls != null) {
                returnBean.photoUrls.forEach(photoUrl -> {
                    logger.debug("photoUrl={}", photoUrl);
                });
            }
            logger.debug("tags={}", returnBean.tags);
            if (returnBean.tags != null) {
                returnBean.tags.forEach(tag -> {
                    logger.debug("tag.id={}", tag.id);
                    logger.debug("tag.name={}", tag.name);
                });
            }
            logger.debug("status={}", returnBean.status);
        });
    }

    public void test_requestFindbytags() {
        // ## Arrange ##
        Consumer<RemotePetFindbytagsParam> paramLambda = param -> {
            param.tags = org.dbflute.util.DfCollectionUtil.newArrayList("tags");
        };

        // ## Act ##
        java.util.List<RemotePetFindbytagsReturn> list = createBhv("[]").requestFindbytags(paramLambda);

        // ## Assert ##
        list.forEach(returnBean -> {
            logger.debug("id={}", returnBean.id);
            logger.debug("category={}", returnBean.category);
            if (returnBean.category != null) {
                logger.debug("category.id={}", returnBean.category.id);
                logger.debug("category.name={}", returnBean.category.name);
            }
            logger.debug("name={}", returnBean.name);
            logger.debug("photoUrls={}", returnBean.photoUrls);
            if (returnBean.photoUrls != null) {
                returnBean.photoUrls.forEach(photoUrl -> {
                    logger.debug("photoUrl={}", photoUrl);
                });
            }
            logger.debug("tags={}", returnBean.tags);
            if (returnBean.tags != null) {
                returnBean.tags.forEach(tag -> {
                    logger.debug("tag.id={}", tag.id);
                    logger.debug("tag.name={}", tag.name);
                });
            }
            logger.debug("status={}", returnBean.status);
        });
    }

    public void test_requestGet() {
        // ## Arrange ##
        Long petId = 1L;

        // ## Act ##
        RemotePetGetReturn returnBean = createBhv("{}").requestGet(petId);

        // ## Assert ##
        logger.debug("id={}", returnBean.id);
        logger.debug("category={}", returnBean.category);
        if (returnBean.category != null) {
            logger.debug("category.id={}", returnBean.category.id);
            logger.debug("category.name={}", returnBean.category.name);
        }
        logger.debug("name={}", returnBean.name);
        logger.debug("photoUrls={}", returnBean.photoUrls);
        if (returnBean.photoUrls != null) {
            returnBean.photoUrls.forEach(photoUrl -> {
                logger.debug("photoUrl={}", photoUrl);
            });
        }
        logger.debug("tags={}", returnBean.tags);
        if (returnBean.tags != null) {
            returnBean.tags.forEach(tag -> {
                logger.debug("tag.id={}", tag.id);
                logger.debug("tag.name={}", tag.name);
            });
        }
        logger.debug("status={}", returnBean.status);
    }

    public void test_requestPostPetId() {
        // ## Arrange ##
        Long petId = 1L;
        Consumer<RemotePetPetidPostParam> paramLambda = param -> {
            param.name = "name";
            param.status = "status";
        };

        // ## Act ##
        createBhv(null).requestPost(petId, paramLambda);
    }

    public void test_requestDelete() {
        // ## Arrange ##
        Long petId = 1L;

        // ## Act ##
        createBhv(null).requestDelete(petId);
    }

    public void test_requestUploadimage() {
        // ## Arrange ##
        Long petId = 1L;
        Consumer<RemotePetUploadimageParam> paramLambda = param -> {
            param.additionalMetadata = "additionalMetadata";
            param.file = new org.lastaflute.web.ruts.multipart.MultipartFormFile() {
                @Override
                public byte[] getFileData() throws java.io.IOException {
                    return null;
                }

                @Override
                public java.io.InputStream getInputStream() throws java.io.IOException {
                    return null;
                }

                @Override
                public String getContentType() {
                    return null;
                }

                @Override
                public int getFileSize() {
                    return 0;
                }

                @Override
                public String getFileName() {
                    return null;
                }

                @Override
                public void destroy() {
                }
            };
        };

        // ## Act ##
        RemotePetUploadimageReturn returnBean = createBhv("{}").requestUploadimage(petId, paramLambda);

        // ## Assert ##
        logger.debug("code={}", returnBean.code);
        logger.debug("type={}", returnBean.type);
        logger.debug("message={}", returnBean.message);
    }

    private RemotePetstorePetBhv createBhv(String json) {
        MockHttpClient client = MockHttpClient.create(response -> {
            if (json == null) {
                response.asJsonNoContent(request -> true);
            } else {
                response.asJsonDirectly(json, request -> true);
            }
        });
        registerMock(client);
        RemotePetstorePetBhv bhv = new RemotePetstorePetBhv(requestManager);
        inject(bhv);
        return bhv;
    }
}
