package stepDefinitions;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.AddToCartSteps;

public class AddToCartStepDefinition {

    @Steps
    AddToCartSteps addToCartSteps;

    @When("^I go to view cart$")
    public void iGoToViewCart()  throws Throwable {
        addToCartSteps.goToCartPage();
    }

    @When("^I go to checkout$")
    public void iGoToCheckout()  throws Throwable {
        addToCartSteps.goToCheckout();
    }

}
