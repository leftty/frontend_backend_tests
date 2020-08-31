package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends GenericPage {

    private static final String SIGN_IN_SIGN_UP_BUTTON = "div.header_bar-sign_in>button";
    private static final String SEARCH_INPUT_FIELD = "div#search input[name='substring']";
    private static final String SEARCH_BUTTON = "div#search button";



    public void clickSignInButton() {
        getDriver().findElement(By.cssSelector(SIGN_IN_SIGN_UP_BUTTON)).click();
    }

    public void searchForProduct(String product) {
        getDriver().findElement(By.cssSelector(SEARCH_INPUT_FIELD)).clear();
        getDriver().findElement(By.cssSelector(SEARCH_INPUT_FIELD)).sendKeys(product);
        getDriver().findElement(By.cssSelector(SEARCH_BUTTON)).click();
        waitForPageToLoad();
    }

    public boolean isUserSignedIn() {
        return getDriver().findElements(By.cssSelector(SIGN_IN_SIGN_UP_BUTTON)).size() == 0;
    }
}
