package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CartPage extends GenericPage {

    private static final String EMPTY_CART = "a.clear-bag";
    private static final String SHIPPING_FEE = "li.shipping-code-modifier";
    private static final String TOTAL_FEE = "li.total";
    private static final String DISCOUNT = "li.discount-code-modifier";
    private static final String CHECKOUT = "button.checkout";

    public void emptyCart() {
        FluentWait wait = globalFluentWait(15, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EMPTY_CART)));
        getDriver().findElement(By.cssSelector(EMPTY_CART)).click();
        getDriver().switchTo().alert().accept();
    }

    public void checkShippingFee(String shippingFee) {
        Assert.assertTrue("Shipping fee is '" + findElementByCss(SHIPPING_FEE).getText() + "' instead of '" + shippingFee + "'",
                findElementByCss(SHIPPING_FEE).getText().contains(shippingFee));
    }

    public void checkTotalFee(String totalFee) {
        Assert.assertTrue("Total fee is '" + findElementByCss(TOTAL_FEE).getText() + "' instead of '" + totalFee + "'",
                findElementByCss(TOTAL_FEE).getText().contains(totalFee));
    }

    public void removeProductFromCart(String productName) {
        WebElement removeProduct = findElementByXpath("//p[@class='item-title']/a[contains(text(),'" + productName + "')]" +
                "/../../following-sibling::td[@class='item-remove delete-from-list']//a");
        removeProduct.click();
    }

    public void changeQtyForProduct(String productName, int qty) {
        WebElement quantity = findElementByXpath("//p[@class='item-title']/a[contains(text(),'" + productName + "')]" +
                "/../../following-sibling::td[@class='item-qty']//input[@name='amount']");
        quantity.clear();
        quantity.sendKeys(Integer.toString(qty));
        new Actions(getDriver()).click(findElementByCss("#search input[placeholder='Search items...']")).perform();
    }

    public void goToCheckoutPage() {
        findElementByCss(CHECKOUT).click();
    }

    public void checkDiscount(String discount) {
        Assert.assertTrue("Discount is '" + findElementByCss(DISCOUNT).getText() + "' instead of '" + discount + "'",
                findElementByCss(DISCOUNT).getText().contains(discount));
    }
}
