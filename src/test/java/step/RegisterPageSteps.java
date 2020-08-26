package step;

import net.thucydides.core.annotations.Step;
import pages.RegisterPage;

public class RegisterPageSteps {

    RegisterPage registerPage;

    @Step
    public void fillInEmailWithProperEmailAddress() {
        registerPage.fillInEmailWithProperEmailAddress();
    }

    @Step
    public void fillInPasswordSameAsConfirmPassword() {
        registerPage.fillInPasswordSameAsConfirmPassword();
    }

    @Step
    public void fillInPasswordDifferentConfirmPassword() {
        registerPage.fillInPasswordDifferentConfirmPassword();
    }

    @Step
    public void checkEmailFieldErrorMessage(String message) {
        registerPage.checkEmailFieldErrorMessage(message);
    }

    @Step
    public void checkPasswordFieldErrorMessage(String message) {
        registerPage.checkPasswordFieldErrorMessage(message);
    }

    @Step
    public void checkPasswordConfirmationFieldErrorMessage(String message) {
        registerPage.checkPasswordConfirmationFieldErrorMessage(message);
    }

    @Step
    public void fillInEmailWithImproperEmailAddress() {
        registerPage.fillInEmailWithImproperEmailAddress();
    }
}
