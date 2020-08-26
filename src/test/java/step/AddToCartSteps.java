package step;

import net.thucydides.core.annotations.Step;
import pages.AddToCart;

public class AddToCartSteps {

    AddToCart addToCart;

    @Step
    public void goToCartPage() {
        addToCart.goToCartPage();
    }

    @Step
    public void goToCheckout() {
        addToCart.goToCheckout();
    }
}
