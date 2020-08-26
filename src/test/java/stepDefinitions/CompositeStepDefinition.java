package stepDefinitions;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.CompositeSteps;

public class CompositeStepDefinition {

    @Steps
    CompositeSteps compositeSteps;

    @When("^I empty shopping cart$")
    public void iEmptyCart() throws Throwable {
        compositeSteps.emptyCart();
    }
}
