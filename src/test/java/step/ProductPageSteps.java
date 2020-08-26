package step;

import net.thucydides.core.annotations.Step;
import pages.ProductPage;

public class ProductPageSteps {

    ProductPage productPage;

    @Step
    public void addProductToCart() {
        productPage.addProductToCart();
    }

    @Step
    public void addProductToCartInQuantity(int qty) {
        productPage.setQuantity(qty);
        productPage.addProductToCart();
    }

    @Step
    public void addProductToCartInQuantityBiggerThanAvailableStock() {
        productPage.addProductToCartInQuantityBiggerThanAvailableStock();
    }

}
