package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericBackendRequestSteps;

import java.util.List;
import java.util.Map;

public class GenericBackendRequestStepDefinition {

    @Steps
    GenericBackendRequestSteps genericBackendRequestSteps;

    @When("^I make proper post request on the create map endpoint$")
    public void iMakeProperPostRequestOnTheCreateMapEndpoint() throws Throwable {
        genericBackendRequestSteps.addItem();
    }


    @Then("^response status code should be (\\d+)$")
    public void responseStatusCodeShouldBe(int statusCode) throws Throwable {
        genericBackendRequestSteps.statusCodeShouldBe(statusCode);
    }

    @And("^response body should have following fields$")
    public void responseBodyShouldHaveFollowingFields(DataTable dt) throws Throwable {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            genericBackendRequestSteps.fieldInPathShouldExist(stringMap.get("Path"), stringMap.get("Field"));
        }
    }

    @And("^following response body fields should have values$")
    public void followingResponseBodyFieldsShouldHaveValue(DataTable dt) throws Throwable {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map<String, String> stringMap : list) {
            genericBackendRequestSteps.valueForFieldInPathShouldBe(stringMap.get("Path"), stringMap.get("Value"));
        }
    }

    @When("^I make get request for the newly created map$")
    public void iMakeGetRequestForTheNewlyCreatedMap() throws Throwable {
        genericBackendRequestSteps.getItem();
    }

    @And("^I should see id of newly created map in response body$")
    public void iShouldSeeIdOfNewlyCreatedMapInResponseBody() throws Throwable {
        genericBackendRequestSteps.checkMapId();
    }

    @When("^I make delete request for the newly created map$")
    public void iMakeDeleteRequestForTheNewlyCreatedMap() throws Throwable {
        genericBackendRequestSteps.deleteItem();
    }

    @When("^I mark newly created map for deletion$")
    public void iMarkNewlyCreatedMapForDeletion() throws Throwable {
        genericBackendRequestSteps.markMapForDeletion();
    }

    @When("^I make post request on the create map endpoint with invalid key$")
    public void iMakePostRequestOnTheCreateMapEndpointWithInvalidKey() {
        genericBackendRequestSteps.addItemInvalidApiKey();
    }

    @When("^I make post request on the create map endpoint over http$")
    public void iMakePostRequestOnTheCreateMapEndpointOverHttp() {
        genericBackendRequestSteps.addItemOverHttp();
    }

    @When("^I make post request on the create map with invalid map type$")
    public void iMakePostRequestOnTheCreateMapWithInvalidMapType() {
        genericBackendRequestSteps.addItemInvalidMapType();
    }
}
