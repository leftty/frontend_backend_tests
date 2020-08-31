package util.backend;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import util.TypeLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GenericBackendClient {

    private Response callPostTechRecordsWithAlterations(String token, String requestBody, List<JsonPathAlteration> alterations) {
        //the only actions accepted are ADD_FIELD, ADD_VALUE, DELETE and REPLACE
        String alteredBody = GenericData.applyJsonAlterations(requestBody, alterations);

        Response response = given().headers(
                "Authorization",
                "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/vehicles");
        return response;
    }

}
