package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.CartPageSteps;

public class CartPageStepDefinition {

    @Steps
    CartPageSteps cartPageSteps;

    @Then("^I should see \"([^\"]*)\" as shipping fee$")
    public void iShouldSeeAsShippingFee(String shippingFee) throws Throwable {
        cartPageSteps.checkShippingFee(shippingFee);
    }

    @Then("^I should see \"([^\"]*)\" as total fee$")
    public void iShouldSeeAsTotalFee(String totalFee) throws Throwable {
        cartPageSteps.checkTotalFee(totalFee);
    }

    @When("^I remove product \"([^\"]*)\" from shopping cart$")
    public void iRemoveProductFromCart(String productName) throws Throwable {
        cartPageSteps.removeProductFromCart(productName);
    }

    @When("^I change quantity for product \"([^\"]*)\" to (\\d+)$")
    public void iChangeQuantityForProductTo(String productName, int qty) throws Throwable {
        cartPageSteps.changeQtyForProduct(productName, qty);
    }

    @When("^I go to checkout page$")
    public void iGoToCheckoutPage() {
        cartPageSteps.goToCheckoutPage();
    }
}
