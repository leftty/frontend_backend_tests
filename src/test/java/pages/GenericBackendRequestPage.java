package pages;

import net.serenitybdd.core.pages.PageObject;
import util.backend.GenericBackendClient;

import static io.restassured.RestAssured.given;

public class GenericBackendRequestPage extends PageObject {

    private static GenericBackendClient genericBackendClient = new GenericBackendClient();

}
