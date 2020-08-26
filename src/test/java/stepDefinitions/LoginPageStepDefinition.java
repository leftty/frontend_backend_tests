package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.LoginPageSteps;

public class LoginPageStepDefinition {

    @Steps
    LoginPageSteps loginPageSteps;

    @When("^I login with proper credentials$")
    public void iLoginWithProperCredentials() throws Throwable {
        loginPageSteps.iLoginWithProperCredentials();
    }

    @When("^I login with incorrect credentials$")
    public void iLoginWithIncorrectCredentials() throws Throwable {
        loginPageSteps.iLoginWithIncorrectCredentials();
    }

    @When("^I login with no credentials$")
    public void iLoginWithNoCredentials() throws Throwable {
        loginPageSteps.iLoginWithNoCredentials();
    }

    @When("^I login with only the email address$")
    public void iLoginWithOnlyEmailAddress() throws Throwable {
        loginPageSteps.iLoginWithEmailOnly();
    }

    @When("^I login with only the password$")
    public void iLoginWithOnlyPassword() throws Throwable {
        loginPageSteps.iLoginWithPasswordOnly();
    }

    @Then("^I should see \"([^\"]*)\" under the email field$")
    public void iShouldSeeUnderTheEmailField(String message) throws Throwable {
        loginPageSteps.checkEmailFieldErrorMessage(message);
    }

    @Then("^I should see \"([^\"]*)\" under the password field$")
    public void iShouldSeeUnderThePasswordField(String message) throws Throwable {
        loginPageSteps.checkPasswordFieldErrorMessage(message);
    }

    @When("^I close sign in form$")
    public void iCloseSignInForm() throws Throwable {
        loginPageSteps.closeSignInForm();
    }

    @Then("^sign in form should be cleared$")
    public void signInFormShouldBeCleared() throws Throwable {
        loginPageSteps.checkSignInFormCleared();
    }

    @When("^I go to register form$")
    public void iGoToRegisterForm() throws Throwable {
        loginPageSteps.goToRegisterForm();
    }
}
