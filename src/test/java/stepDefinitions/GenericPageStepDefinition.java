package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericPageSteps;

public class GenericPageStepDefinition {

    @Steps
    GenericPageSteps genericPageSteps;

    @When("^I wait until page is loaded$")
    public void iWaitUntilPageIsLoaded() throws Throwable {
        genericPageSteps.waitForPageToLoad();
    }

    @Then("^I should see \"(.*)\"$")
    public void iShouldSeeText(String text) throws Throwable {
        genericPageSteps.checkTextIsPresentInPage(text);
    }

    @Then("^I should not see \"([^\"]*)\"$")
    public void iShouldNotSeeText(String text) throws Throwable {
        genericPageSteps.checkTextIsNotPresentInPage(text);
    }

    @Then("^I wait (\\d+) seconds$")
    public void iWaitSeconds(int seconds) throws Throwable {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^element with id \"([^\"]*)\" should be present$")
    public void elementWithIdShouldBePresent(String id) throws Throwable {
        genericPageSteps.elementWithIdShouldBePresent(id);
    }

    @After
    @When("^I clear the browser session$")
    public void clearSession() {
        genericPageSteps.clearSession();
    }

    @When("^refresh the page$")
    public void refreshThePage() throws Throwable {
        genericPageSteps.refreshPage();
    }

    @Then("^wait until I see \"([^\"]*)\"$")
    public void waitUntilISee(String text) throws Throwable {
        genericPageSteps.checkTextIsPresentInPage(text);
    }

    @Then("^I should see \"([^\"]*)\" hyperlink$")
    public void iShouldSeeHyperlink(String text) throws Throwable {
        genericPageSteps.checkTextIsPresentInHyperlink(text);
    }

    @Then("^I should see \"([^\"]*)\" button$")
    public void iShouldSeeButton(String text) throws Throwable {
        genericPageSteps.checkTextIsPresentInButton(text);
    }

    @When("^I click \"([^\"]*)\" link$")
    public void iClickLink(String text) throws Throwable {
        genericPageSteps.clickLink(text);
    }

    @When("^I click \"([^\"]*)\" button$")
    public void iClickButton(String text) throws Throwable {
        genericPageSteps.clickButton(text);
    }

    @When("^I go back to previous page$")
    public void iGoBackToPreviousPage() throws Throwable {
        genericPageSteps.goBackToPreviousPage();
    }
}
