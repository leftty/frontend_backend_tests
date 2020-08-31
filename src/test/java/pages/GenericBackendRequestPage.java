package pages;

import exceptions.AutomationException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import util.TypeLoader;
import util.backend.GenericBackendClient;
import util.backend.GenericData;
import util.backend.JsonPathAlteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GenericBackendRequestPage extends PageObject {

    private static GenericBackendClient genericBackendClient = new GenericBackendClient();
    private static String id;
    private static Response response;

    public void addItem() {
        // read post request body from file
        String title = RandomStringUtils.randomAlphanumeric(10);
        String postRequestBody = GenericData.readJsonValueFromFile("map.json","$");
        RestAssured.registerParser("text/plain", Parser.JSON);

        response = given().contentType(ContentType.JSON)
                .queryParam("token", TypeLoader.getApiKey())
                .queryParam("title", title)
                .queryParam("type", "Web Map")
                .queryParam("f", "json")
                .body(postRequestBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/users/leftty86/addItem");
        id  = GenericData.extractStringValueFromJsonString(response.getBody().asString(), "$.id");
    }

    public void statusCodeShouldBe(int statusCode) {
        response.then().log().all()
                .statusCode(statusCode);
    }

    public void fieldInPathShouldExist(String parentElementPath, String key) {
        RestAssured.registerParser("text/plain", Parser.JSON);
        response.then().body(parentElementPath, hasKey(key));
    }

    public void fieldInPathShouldNotExist(String parentElementPath, String key) {
        RestAssured.registerParser("text/plain", Parser.JSON);
        response.then().body(parentElementPath, not(hasKey(key)));
    }

    public void valueForFieldInPathShouldBe(String path, String expectedValue) {
        RestAssured.registerParser("text/plain", Parser.JSON);
        if (expectedValue.contentEquals("null")) {
            response.then().body(path, nullValue());
        }
        else if (expectedValue.contentEquals("true") || expectedValue.contentEquals("false")) {
            response.then().body(path, equalTo(Boolean.parseBoolean(expectedValue)));
        }
        else if (NumberUtils.isCreatable(expectedValue)) {
            response.then().body(path, equalTo(Integer.parseInt(expectedValue)));
        }
        else {
            response.then().body(path, equalTo(expectedValue));
        }
    }

    public void getItem() {
        RestAssured.registerParser("text/plain", Parser.JSON);

        response = given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .queryParam("token", TypeLoader.getApiKey())
                .queryParam("type", "Web Map")
                .queryParam("f", "json")
                .log().method().log().uri().log().body()
                .get(TypeLoader.getBasePathUrl() + "/items/{id}");
    }

    public void checkMapId() {
        RestAssured.registerParser("text/plain", Parser.JSON);
        response.then().body("id",equalTo(id));
    }

    public void deleteItem() {
        RestAssured.registerParser("text/plain", Parser.JSON);

        response = given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .queryParam("token", TypeLoader.getApiKey())
                .queryParam("f", "json")
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/users/leftty86/items/{id}/delete");
    }

    public void markMapForDeletion() {
        RestAssured.registerParser("text/plain", Parser.JSON);

        response = given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .queryParam("token", TypeLoader.getApiKey())
                .queryParam("f", "json")
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/users/leftty86/items/{id}/canDelete");
        System.out.println("test");
    }


    public void addItemInvalidApiKey() {
        // read post request body from file
        String title = RandomStringUtils.randomAlphanumeric(10);
        String apiKey = RandomStringUtils.randomAlphanumeric(236);
        String postRequestBody = GenericData.readJsonValueFromFile("map.json","$");
        RestAssured.registerParser("text/plain", Parser.JSON);

        response = given().contentType(ContentType.JSON)
                .queryParam("token", apiKey)
                .queryParam("title", title)
                .queryParam("type", "Web Map")
                .queryParam("f", "json")
                .body(postRequestBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/users/leftty86/addItem");
    }

    public void addItemOverHttp() {
        // read post request body from file
        String title = RandomStringUtils.randomAlphanumeric(10);
        String postRequestBody = GenericData.readJsonValueFromFile("map.json","$");
        RestAssured.registerParser("text/plain", Parser.JSON);

        response = given().contentType(ContentType.JSON)
                .queryParam("token", TypeLoader.getApiKey())
                .queryParam("title", title)
                .queryParam("type", "Web Map")
                .queryParam("f", "json")
                .body(postRequestBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl().substring(0,4) + TypeLoader.getBasePathUrl().substring(5) + "/users/leftty86/addItem");
    }

    public void addItemInvalidMapType() {
        // read post request body from file
        String title = RandomStringUtils.randomAlphanumeric(10);
        String postRequestBody = GenericData.readJsonValueFromFile("map.json","$");
        RestAssured.registerParser("text/plain", Parser.JSON);

        response = given().contentType(ContentType.JSON)
                .queryParam("token", TypeLoader.getApiKey())
                .queryParam("title", title)
                .queryParam("type", "Online Map")
                .queryParam("f", "json")
                .body(postRequestBody)
                .log().method().log().uri().log().body()
                .post(TypeLoader.getBasePathUrl() + "/users/leftty86/addItem");
    }
}
