package org.docksidestage.unit.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.dbflute.optional.OptionalThing;
import org.dbflute.remoteapi.mock.supporter.MockSupposedRequest;
import org.dbflute.util.DfStringUtil;
import org.lastaflute.web.servlet.request.RequestManager;

/**
 * Helper for {@link MockSupposedRequest} ({@link org.apache.http.HttpRequest}).<br>
 * This class is tentatively used to simplify testing of dbflute-example-with-remoteapi-gen.
 * @author p1us2er0
 */
public class MockSupposedRequestHelper {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected RequestManager requestManager;

    protected MockSupposedRequest request;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public MockSupposedRequestHelper(RequestManager requestManager, MockSupposedRequest request) {
        this.requestManager = requestManager;
        this.request = request;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public OptionalThing<Map<String, Object>> getQuery() {
        String query = DfStringUtil.substringFirstRear(request.getUrl(), "?");
        if (DfStringUtil.is_Null_or_Empty(query)) {
            return OptionalThing.empty();
        }
        return OptionalThing.of(Arrays.stream(query.split("&"))
                .map(keyValue -> keyValue.split("="))
                .collect(Collectors.toMap(keyValue -> keyValue[0], keyValue -> keyValue.length == 2 ? keyValue[1] : null)));
    }

    public OptionalThing<Map<String, Object>> getForm() {
        return request.getBody().map(body -> {
            return Arrays.stream(request.getBody().get().split("&"))
                    .map(keyValue -> keyValue.split("="))
                    .collect(Collectors.toMap(keyValue -> keyValue[0], keyValue -> keyValue.length == 2 ? keyValue[1] : null));
        });
    }

    public OptionalThing<Map<String, Object>> getJsonBody() {
        return request.getBody().map(body -> {
            @SuppressWarnings("unchecked")
            Map<String, Object> jsonBody = requestManager.getJsonManager().fromJson(body, HashMap.class);
            return jsonBody;
        });
    }
}
