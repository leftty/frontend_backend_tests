package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends GenericPage {

    private static final String EMAIL = "#login";
    private static final String PASSWORD = "#password";
    private static final String CONFIRM_PASSWORD = "#password-conf";
    private static final String EMAIL_ERROR = "#login+p";
    private static final String PASSWORD_ERROR = "#password+p";
    private static final String CONFIRM_PASSWORD_ERROR = "#password-conf+p";

    static String email = "";

    public void fillInEmailWithProperEmailAddress() {
        email = generateEmailAddress();
        findElementByCss(EMAIL).sendKeys(email);
    }

    public void fillInPasswordSameAsConfirmPassword() {
        findElementByCss(PASSWORD).sendKeys("123456");
        findElementByCss(CONFIRM_PASSWORD).sendKeys("123456");
    }

    public void fillInPasswordDifferentConfirmPassword() {
        findElementByCss(PASSWORD).sendKeys("123456");
        findElementByCss(CONFIRM_PASSWORD).sendKeys("1234567");
    }

    public void checkEmailFieldErrorMessage(String message) {
        Assert.assertEquals("Error message '" + getDriver().findElement(By.cssSelector(EMAIL_ERROR)).getText() +
                        "' is different than expected message '" + message + "'",
                message, getDriver().findElement(By.cssSelector(EMAIL_ERROR)).getText());
    }

    public void checkPasswordFieldErrorMessage(String message) {
        Assert.assertEquals("Error message '" + getDriver().findElement(By.cssSelector(PASSWORD_ERROR)).getText() +
                        "' is different than expected message '" + message + "'",
                message, getDriver().findElement(By.cssSelector(PASSWORD_ERROR)).getText());
    }

    public void checkPasswordConfirmationFieldErrorMessage(String message) {
        Assert.assertEquals("Error message '" + getDriver().findElement(By.cssSelector(CONFIRM_PASSWORD_ERROR)).getText() +
                        "' is different than expected message '" + message + "'",
                message, getDriver().findElement(By.cssSelector(CONFIRM_PASSWORD_ERROR)).getText());
    }

    public void fillInEmailWithImproperEmailAddress() {
        findElementByCss(EMAIL).sendKeys("test@test");
    }
}
