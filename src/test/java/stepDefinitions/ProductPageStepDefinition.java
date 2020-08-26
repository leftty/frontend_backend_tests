package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.ProductPageSteps;

public class ProductPageStepDefinition {

    @Steps
    ProductPageSteps productPageSteps;

    @When("^I add product to cart$")
    public void iAddProductToCart() throws Throwable {
        productPageSteps.addProductToCart();
    }

    @When("^I add product to cart in quantity (\\d+)$")
    public void iAddProductToCartInQuantity(int qty) throws Throwable {
        productPageSteps.addProductToCartInQuantity(qty);
    }

    @When("^I add product to cart in quantity bigger than available stock$")
    public void iAddProductToCartInQuantityBiggerThanAvailableStock() throws Throwable {
        productPageSteps.addProductToCartInQuantityBiggerThanAvailableStock();
    }

}
