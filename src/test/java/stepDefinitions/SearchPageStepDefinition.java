package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.GenericBackendRequestSteps;
import step.GenericPageSteps;
import step.SearchPageSteps;

public class SearchPageStepDefinition {

    @Steps
    SearchPageSteps searchPageSteps;

    @Then("^I should see (\\d+) result|results$")
    public void iShouldSeeResults(int noOfResults) throws Throwable {
        searchPageSteps.shouldSeeResults(noOfResults);
    }

    @When("^I filter by category \"([^\"]*)\"$")
    public void iFilterByCategory(String category) throws Throwable {
        searchPageSteps.filterByCategory(category);
    }

    @When("^I filter by size \"([^\"]*)\"$")
    public void iFilterBySize(String size) throws Throwable {
        searchPageSteps.filterBySize(size);
    }

    @When("^I filter by price between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iFilterByPriceBetween(String fromValue, String toValue) throws Throwable {
        searchPageSteps.filterByPriceBetween(fromValue, toValue);
    }

    @When("^I add product \"([^\"]*)\" to cart from search page$")
    public void iAddProductToCartFromSearchPage(String product) throws Throwable {
        searchPageSteps.addProductToCartFromSearchPage(product);
    }

    @When("^I go \"([^\"]*)\" product page$")
    public void iGoProductPage(String productName) throws Throwable {
        searchPageSteps.goToProductPage(productName);
    }
}
