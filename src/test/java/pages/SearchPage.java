package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class SearchPage extends GenericPage {

    private static final String SEARCH_INPUT = "#searchIdentifier";
    private static final String SEARCH_BUTTON = "a.govuk-button";
    private static final String LOG_OUT_LINK = "#navigation>li:last-of-type>a";
    private static final String SEARCH_OPTIONS_DROPDOWN = "#test-search-criteria";
    private static final String LOG_OUT_LINK_IN_HAMBURGER_MENU = "#menuLinks>a:last-of-type";
    private static final String SPECIFIC_ERROR = "#name-error>p";
    private static final String SEARCH_RESULT = "ul.products-grid>li";
    private static final String PRICE_FILTER_START_INTERVAL = "div#page-wrapper div.cloud-filters-filter-price form>input:nth-of-type(1)";
    private static final String PRICE_FILTER_END_INTERVAL = "div#page-wrapper div.cloud-filters-filter-price form>input:nth-of-type(2)";
    private static final String ADD_TO_CART_BUTTON = "button.add-to-cart";
//    private static final String ADD_TO_CART_BUTTON = "button.add-to-cart";

    public void shouldSeeResults(int noOfResults) {
        waitForPageToLoad();
        List<WebElement> results = getDriver().findElements(By.cssSelector(SEARCH_RESULT));
        Assert.assertEquals("The actual number of search results " + results.size() + " is different than the " +
                "expected number of search results " + noOfResults, results.size(), noOfResults);
    }

    public void filterByCategory(String category) {
        WebElement categoryFilter = getDriver().findElement(By.xpath("//div[@id='page-wrapper']//div[contains(@class, " +
                "'cloud-filters-filter-category')]//span[text() = '" + category + "']/preceding-sibling::input"));
        categoryFilter.click();
        FluentWait waitToAppear = globalFluentWait(2, 200);
        FluentWait waitToDisappear = globalFluentWait(10, 200);
        try {
            waitToAppear.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wait-block-overlay")));
        } catch (TimeoutException e) {
            System.out.println("Overlay already disappeared!");
        }
        waitToDisappear.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.wait-block-overlay"), 0));
    }

    public void filterBySize(String size) {
        WebElement categoryFilter = getDriver().findElement(By.xpath("//div[@id='page-wrapper']//div[contains(@class, " +
                "'cloud-filters-filter-size')]//span[text() = '" + size + "']/preceding-sibling::input"));
        categoryFilter.click();
        FluentWait waitToAppear = globalFluentWait(2, 200);
        FluentWait waitToDisappear = globalFluentWait(10, 200);
        try {
            waitToAppear.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wait-block-overlay")));
        } catch (TimeoutException e) {
            System.out.println("Overlay already disappeared!");
        }
        waitToDisappear.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.wait-block-overlay"), 0));
    }

    public void filterByPriceBetween(String fromValue, String toValue) {
        WebElement fromPrice = getDriver().findElement(By.cssSelector(PRICE_FILTER_START_INTERVAL));
        WebElement toPrice = getDriver().findElement(By.cssSelector(PRICE_FILTER_END_INTERVAL));
        fromPrice.clear();
        fromPrice.sendKeys(fromValue);
        toPrice.clear();
        toPrice.sendKeys(toValue);
        FluentWait waitToAppear = globalFluentWait(2, 200);
        FluentWait waitToDisappear = globalFluentWait(10, 200);
        try {
            waitToAppear.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wait-block-overlay")));
        } catch (TimeoutException e) {
            System.out.println("Overlay already disappeared!");
        }
        waitToDisappear.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.wait-block-overlay"), 0));
    }

    public void filterByPriceEqualOrBiggerThan(String fromValue) {
        WebElement fromPrice = getDriver().findElement(By.cssSelector(PRICE_FILTER_START_INTERVAL));
        fromPrice.clear();
        fromPrice.sendKeys(fromValue);
        FluentWait waitToAppear = globalFluentWait(2, 200);
        FluentWait waitToDisappear = globalFluentWait(10, 200);
        try {
            waitToAppear.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wait-block-overlay")));
        } catch (TimeoutException e) {
            System.out.println("Overlay already disappeared!");
        }
        waitToDisappear.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.wait-block-overlay"), 0));
    }

    public void filterByPriceEqualOrSmallerThan(String toValue) {
        WebElement toPrice = getDriver().findElement(By.cssSelector(PRICE_FILTER_END_INTERVAL));
        toPrice.clear();
        toPrice.sendKeys(toValue);
        FluentWait waitToAppear = globalFluentWait(2, 200);
        FluentWait waitToDisappear = globalFluentWait(10, 200);
        try {
            waitToAppear.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.wait-block-overlay")));
        } catch (TimeoutException e) {
            System.out.println("Overlay already disappeared!");
        }
        waitToDisappear.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.wait-block-overlay"), 0));
    }

    public void addProductToCart(String product) {
        WebElement productLink = getDriver().findElement(By.xpath("//a[contains(@class, 'url')][contains(text(),'" + product + "')]"));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(productLink).perform();
        WebElement addToCart = getDriver().findElement(By.cssSelector(ADD_TO_CART_BUTTON));
        builder.moveToElement(addToCart).click().perform();
    }

    public void goToProductPage(String productName) {
        WebElement productLink = getDriver().findElement(By.xpath("//a[contains(@class, 'url')][contains(text(),'" + productName + "')]"));
        productLink.click();
    }
}
