package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericPageSteps;
import step.HomePageSteps;

public class HomePageStepDefinition {

    @Steps
    HomePageSteps homePageSteps;

    @Given("^I go to website homepage$")
    public void iGoToWebsiteHomepage() throws Throwable {
        homePageSteps.goToWebsiteHomepage();
    }

    @When("^I go to sign in form")
    public void iGoToSignInForm() throws Throwable {
        homePageSteps.clickSignInButton();
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void iSearchForProduct(String product) throws Throwable {
        homePageSteps.searchForProduct(product);
    }
}
