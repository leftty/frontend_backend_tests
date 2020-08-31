package step;

import net.thucydides.core.annotations.Step;
import pages.Header;
import pages.SearchPage;

public class SearchPageSteps extends GenericPageSteps {

    SearchPage searchPage;
    Header header;

    @Step
    public void waitForPageToLoad() {
        searchPage.waitForPageToLoad();
    }

    @Step
    public void checkTextIsPresentInPage(String text) {
        searchPage.checkTextIsPresentInPage(text);
    }

    @Step
    public void checkTextIsNotPresentInPage(String text) {
        searchPage.checkTextIsNotPresentInPage(text);
    }

    @Step
    public void elementWithIdShouldBePresent(String id) {
        searchPage.elementWithIdShouldBePresent(id);
    }

    @Step
    public void refreshPage() {
        searchPage.refreshPage();
    }

    @Step
    public void shouldSeeResults(int noOfResults) {
        searchPage.shouldSeeResults(noOfResults);
    }

    @Step
    public void filterByCategory(String category) {
        searchPage.filterByCategory(category);
    }

    @Step
    public void filterBySize(String size) {
        searchPage.filterBySize(size);
    }

    @Step
    public void filterByPriceBetween(String fromValue, String toValue) {
        searchPage.filterByPriceBetween(fromValue, toValue);
    }

    @Step
    public void filterByPriceEqualOrBiggerThan(String fromValue) {
        searchPage.filterByPriceEqualOrBiggerThan(fromValue);
    }

    @Step
    public void filterByPriceEqualOrSmallerThan(String toValue) {
        searchPage.filterByPriceEqualOrSmallerThan(toValue);
    }

    @Step
    public void addProductToCartFromSearchPage(String product) {
        searchPage.addProductToCart(product);
    }

    @Step
    public void goToProductPage(String productName) {
        searchPage.goToProductPage(productName);
    }
}
