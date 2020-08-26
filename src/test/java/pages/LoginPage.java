package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class LoginPage extends GenericPage {

    private static final String EMAIL_INPUT = "#login-email";
    private static final String PASSWORD_INPUT = "#login-password";
    private static final String SIGN_IN_BUTTON = "table.login-form button[type='submit']";
    private static final String EMAIL_FIELD_ERROR = "#login-email+p.error";
    private static final String PASSWORD_FIELD_ERROR = "#login-password+p.error";
    private static final String CLOSE_SIGN_IN_FORM = "button.ui-dialog-titlebar-close";
    private static final String REGISTER_LINK = "a.create-account-link";


    public void inputEmail(String emailAddress) {
        findElementByCss(EMAIL_INPUT).clear();
        findElementByCss(EMAIL_INPUT).sendKeys(emailAddress);
    }

    public void inputPassword(String password) {
        findElementByCss(PASSWORD_INPUT).clear();
        findElementByCss(PASSWORD_INPUT).sendKeys(password);
    }

    public void signIn() {
        FluentWait wait = globalFluentWait(10, 250);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SIGN_IN_BUTTON)));
        findElementByCss(SIGN_IN_BUTTON).click();
    }

    public void checkEmailFieldErrorMessage(String message) {
        Assert.assertEquals("Error message '" + getDriver().findElement(By.cssSelector(EMAIL_FIELD_ERROR)).getText() +
                        "' is different than expected message '" + message + "'",
                message, getDriver().findElement(By.cssSelector(EMAIL_FIELD_ERROR)).getText());
    }

    public void checkPasswordFieldErrorMessage(String message) {
        Assert.assertEquals("Error message '" + getDriver().findElement(By.cssSelector(PASSWORD_FIELD_ERROR)).getText() +
                        "' is different than expected message '" + message + "'",
                message, getDriver().findElement(By.cssSelector(PASSWORD_FIELD_ERROR)).getText());
    }

    public void closeSignInForm() {
        findElementByCss(CLOSE_SIGN_IN_FORM).click();
    }

    public void checkSignInFormCleared() {
        Assert.assertEquals("Email error message is present but it should not be", 0,
                getDriver().findElements(By.cssSelector(PASSWORD_FIELD_ERROR)).size());
        Assert.assertEquals("Email error message is present but it should not be", 0,
                getDriver().findElements(By.cssSelector(EMAIL_FIELD_ERROR)).size());
        Assert.assertEquals("Email field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(EMAIL_INPUT)).getAttribute("value"));
        Assert.assertNull("Password field input should be empty but it is not",
                getDriver().findElement(By.cssSelector(PASSWORD_INPUT)).getAttribute("data-com.agilebits.onepassword.initial-value"));
    }

    public void goToRegisterForm() {
        findElementByCss(REGISTER_LINK).click();
    }
}
