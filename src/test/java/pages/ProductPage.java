package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage extends GenericPage {

    private static final String VIEW_CART = "button.add2cart";
    private static final String QUANTITY = "input[name='amount']";
    private static final String STOCK = "span.product-items-available";
    private static final String ERROR = "div[role='tooltip']";

    public void addProductToCart() {
        getDriver().findElement(By.cssSelector(VIEW_CART)).click();
    }

    public void setQuantity(int qty) {
        getDriver().findElement(By.cssSelector(QUANTITY)).clear();
        getDriver().findElement(By.cssSelector(QUANTITY)).sendKeys(Integer.toString(qty));
    }

    public void addProductToCartInQuantityBiggerThanAvailableStock() {
        String stock = findElementByCss(STOCK).getText().substring(1, findElementByCss(STOCK).getText().indexOf(" "));
        findElementByCss(QUANTITY).clear();
        findElementByCss(QUANTITY).sendKeys(Integer.toString(Integer.parseInt(stock) + 1));
        Assert.assertTrue("The error message '" + findElementByCss(ERROR).getText() + "' is not the expected one",
                findElementByCss(ERROR).getText().contains("Maximum value is " + stock));
    }

}
