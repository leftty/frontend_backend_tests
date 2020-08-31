package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Header extends GenericPage {

    private static final String HEADER = "#header";
    private static final String MINICART_ITEMS = "div.minicart-items-number";
    private static final String MINICART = "div.lc-minicart";
    private static final String FULL_CART = "div.full-cart";
    private static final String VIEW_CART = "div.full-cart a.cart";
    private static final String LOCATION = "#country_code_1";
    private static final String CURRENCY = "#currency_code_1";


    public void checkTextInHeader(String text) {
        Assert.assertTrue("Header text is '" + findElementByCss(HEADER).getText() + "' and does not contain '" + text + "'",
                findElementByCss(HEADER).getText().contains(text));
    }

    public void checkNumberOfProductsInMinicart(int noOfProducts) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(MINICART_ITEMS), Integer.toString(noOfProducts)));
    }

    public void goToCartPage() {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(MINICART)));
        getDriver().findElement(By.cssSelector(MINICART)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(FULL_CART)));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(VIEW_CART)));
        getDriver().findElement(By.cssSelector(VIEW_CART)).click();
    }

    public boolean isCartEmpty() {
        return getDriver().findElement(By.cssSelector(MINICART_ITEMS)).getText().contentEquals("0");
    }

    public void setCurrency(String currency) {
        Select currencies = new Select(findElementByCss(CURRENCY));
        if (!(currencies.getFirstSelectedOption().getText().contentEquals(currency))) {
            currencies.selectByVisibleText(currency);
        }
    }

    public void setLocation(String country) {
        Select locations = new Select(findElementByCss(LOCATION));
        if (!(locations.getFirstSelectedOption().getText().contentEquals(country))) {
            locations.selectByVisibleText(country);
        }
    }
}
