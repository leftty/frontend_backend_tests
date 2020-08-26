package step;

import net.thucydides.core.annotations.Step;
import pages.CartPage;
import pages.Header;

public class CompositeSteps {

    Header header;
    CartPage cartPage;

    @Step
    public void emptyCart() {
        if (!(header.isCartEmpty())) {
            header.goToCartPage();
            cartPage.emptyCart();
        }
    }
}
