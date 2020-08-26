package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.HeaderSteps;

public class HeaderStepDefinition {

    @Steps
    HeaderSteps headerSteps;

    @Then("^the header should contain \"([^\"]*)\"$")
    public void headerShouldContain(String text) throws Throwable {
        headerSteps.checkTextInHeader(text);
    }

    @Then("^I should see (\\d+) product|products in the shopping minicart$")
    public void iShouldSeeProductInTheShoppingMinicart(int noOfProducts) throws Throwable {
        headerSteps.checkNumberOfProductsInMinicart(noOfProducts);
    }

    @When("^I set location to \"([^\"]*)\"$")
    public void iSetLocationTo(String country) throws Throwable {
        headerSteps.setLocation(country);
    }

    @When("^I set currency to \"([^\"]*)\"$")
    public void iSetCurrencyTo(String currency) throws Throwable {
        headerSteps.setCurrency(currency);
    }
}
