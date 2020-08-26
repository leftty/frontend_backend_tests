package pages;

public class AddToCart extends GenericPage {

    private static final String VIEW_CART = "div.add2cart-popup a.cart";
    private static final String CHECKOUT = "div.add2cart-popup a.checkout";


    public void goToCartPage() {
        findElementByCss(VIEW_CART).click();
    }

    public void goToCheckout() {
        findElementByCss(CHECKOUT).click();
    }
}