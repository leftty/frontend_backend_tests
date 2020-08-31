package step;

import net.thucydides.core.annotations.Step;
import pages.CartPage;
import pages.GenericPage;
import pages.Header;
import pages.HomePage;

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
