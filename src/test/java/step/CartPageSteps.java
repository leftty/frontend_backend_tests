package step;

import net.thucydides.core.annotations.Step;
import pages.CartPage;

public class CartPageSteps {

    CartPage cartPage;

    @Step
    public void checkShippingFee(String shippingFee) {
        cartPage.checkShippingFee(shippingFee);
    }

    @Step
    public void checkTotalFee(String totalFee) {
        cartPage.checkTotalFee(totalFee);
    }

    @Step
    public void checkDiscount(String discount) {
        cartPage.checkDiscount(discount);
    }

    @Step
    public void removeProductFromCart(String productName) {
        cartPage.removeProductFromCart(productName);
    }

    @Step
    public void changeQtyForProduct(String productName, int qty) {
        cartPage.changeQtyForProduct(productName, qty);
    }

    @Step
    public void goToCheckoutPage() {
        cartPage.goToCheckoutPage();
    }
}
