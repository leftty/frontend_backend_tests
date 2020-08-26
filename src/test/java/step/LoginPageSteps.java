package step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.exec.environment.EnvironmentUtils;
import pages.LoginPage;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class LoginPageSteps extends GenericPageSteps {

    LoginPage loginPage;

    @Step
    public void iLoginWithProperCredentials() {
        String FILE_PATH = "conf/environment.properties";
        Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH)));
        } catch (IOException e) {
            System.out.println("Could not load properties from file");
        }
        String username = properties.getProperty("app.username");
        String password = properties.getProperty("app.password");
        loginPage.inputEmail(username);
        loginPage.inputPassword(password);
        loginPage.signIn();
    }

    @Step
    public void iLoginWithIncorrectCredentials() {
        loginPage.inputEmail("blalblabla@blablabla.com");
        loginPage.inputPassword("blabla");
        loginPage.signIn();
    }

    @Step
    public void iLoginWithNoCredentials() {
        loginPage.signIn();
    }

    @Step
    public void iLoginWithEmailOnly() {
        loginPage.inputEmail("blalblabla@blablabla.com");
        loginPage.signIn();
    }

    @Step
    public void iLoginWithPasswordOnly() {
        loginPage.inputPassword("blabla");
        loginPage.signIn();
    }

    @Step
    public void checkEmailFieldErrorMessage(String message) {
        loginPage.checkEmailFieldErrorMessage(message);
    }

    @Step
    public void checkPasswordFieldErrorMessage(String message) {
        loginPage.checkPasswordFieldErrorMessage(message);
    }

    @Step
    public void closeSignInForm() {
        loginPage.closeSignInForm();
    }

    @Step
    public void checkSignInFormCleared() {
        loginPage.checkSignInFormCleared();
    }

    @Step
    public void goToRegisterForm() {
        loginPage.goToRegisterForm();
    }
}
