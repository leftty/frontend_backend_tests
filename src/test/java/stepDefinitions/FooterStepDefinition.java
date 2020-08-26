package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import step.FooterSteps;

public class FooterStepDefinition {

    @Steps
    FooterSteps footerSteps;

    @Then("^the footer should contain \"([^\"]*)\"$")
    public void headerShouldContain(String text) throws Throwable {
        footerSteps.checkTextInFooter(text);
    }
}
