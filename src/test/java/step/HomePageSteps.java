package step;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class HomePageSteps extends GenericPageSteps {

    HomePage homePage;

    public void goToWebsiteHomepage() {
        homePage.setDefaultBaseUrl(System.getProperty("baseUrl"));
        homePage.open();
    }

    @Step
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }

    @Step
    public void searchForProduct(String product) {
        homePage.searchForProduct(product);
    }
}
