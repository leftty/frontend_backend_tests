package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.RegisterPageSteps;

public class RegisterPageStepDefinition {

    @Steps
    RegisterPageSteps registerPageSteps;

    @When("^I fill in email with proper email address$")
    public void iFillInEmailWithProperEmailAddress() {
        registerPageSteps.fillInEmailWithProperEmailAddress();
    }

    @When("^I fill in email with improper email address$")
    public void iFillInEmailWithImproperEmailAddress() {
        registerPageSteps.fillInEmailWithImproperEmailAddress();
    }

    @When("^I fill in password same as confirm password$")
    public void iFillInPasswordSameAsConfirmPassword() {
        registerPageSteps.fillInPasswordSameAsConfirmPassword();
    }

    @When("^I fill in password different than confirm password$")
    public void iFillInPasswordDifferentConfirmPassword() {
        registerPageSteps.fillInPasswordDifferentConfirmPassword();
    }

    @Then("^I should see error message \"([^\"]*)\" under the email field$")
    public void iShouldSeeUnderTheEmailField(String message) throws Throwable {
        registerPageSteps.checkEmailFieldErrorMessage(message);
    }

    @Then("^I should see error message \"([^\"]*)\" under the password field$")
    public void iShouldSeeUnderThePasswordField(String message) throws Throwable {
        registerPageSteps.checkPasswordFieldErrorMessage(message);
    }

    @Then("^I should see error message \"([^\"]*)\" under the password confirmation field$")
    public void iShouldSeeUnderTheConfirmPasswordField(String message) throws Throwable {
        registerPageSteps.checkPasswordConfirmationFieldErrorMessage(message);
    }
}
