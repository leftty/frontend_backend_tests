package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import step.CheckoutPageSteps;

public class CheckoutPageStepDefinition {

    @Steps
    CheckoutPageSteps checkoutPageSteps;

    @Then("^only country and email fields should be prefilled$")
    public void onlyCountryAndEmailFieldsShouldBePrefilled() throws Throwable {
        checkoutPageSteps.countryEmailPrefilled();
    }

    @When("^I fill first name with \"([^\"]*)\"$")
    public void iFillFirstNameWith(String firstName) throws Throwable {
        checkoutPageSteps.fillInFirstName(firstName);
    }

    @And("^I fill last name with \"([^\"]*)\"$")
    public void iFillLastNameWith(String lastName) throws Throwable {
        checkoutPageSteps.fillInLastName(lastName);
    }

    @And("^I fill address with \"([^\"]*)\"$")
    public void iFillAddressWith(String address) throws Throwable {
        checkoutPageSteps.fillInAddress(address);
    }

    @And("^I fill in city with \"([^\"]*)\"$")
    public void iFillInCityWith(String city) throws Throwable {
        checkoutPageSteps.fillInCity(city);
    }

    @And("^I fill in address with \"([^\"]*)\"$")
    public void iFillInAddressWith(String city) throws Throwable {
        checkoutPageSteps.fillInAddress(city);
    }

    @And("^I fill in zip code with \"([^\"]*)\"$")
    public void iFillInZipCodeWith(String zipCode) throws Throwable {
        checkoutPageSteps.fillInZipCode(zipCode);
    }

    @Then("^I go to shipping step$")
    public void iGoToShippingStep() throws Throwable {
        checkoutPageSteps.goToShippingStep();
    }

    @When("^I select ([^\"]*) delivery$")
    public void iSelectShipping(String shippingType) throws Throwable {
        checkoutPageSteps.selectShipping(shippingType);
    }

    @And("^I go to payment step$")
    public void iGoToPaymentStep() throws Throwable {
        checkoutPageSteps.goToPaymentStep();
    }

    @Then("^I fill in shipping info if no previous addresses exist and go to shipping step$")
    public void iFillInShippingInfoIfNoPreviousAddressesExistAndGoToShippingStep() throws Throwable {
        checkoutPageSteps.fillInShippingInfoIfNoPreviousAddressesExistGoToShippingStep();
    }

    @When("^I select cash on delivery as payment method$")
    public void iSelectCashOnDeliveryAsPaymentMethod() throws Throwable {
        checkoutPageSteps.selectCashOnDelivery();
    }

    @And("^I place order$")
    public void iPlaceOrder() throws Throwable {
        checkoutPageSteps.placeOrder();
    }

    @And("^I fill in telephone with \"([^\"]*)\"$")
    public void iFillInTelephoneWith(String phoneNo) throws Throwable {
        checkoutPageSteps.fillInPhoneNo(phoneNo);
    }

    @And("^I fill in vat number with \"([^\"]*)\"$")
    public void iFillInVatNumberWith(String vatNo) throws Throwable {
        checkoutPageSteps.fillInVatNo(vatNo);
    }

    @Then("^wait until I see \"([^\"]*)\" as total cost$")
    public void waitUntilISeeAsTotalCost(String totalCost) throws Throwable {
        checkoutPageSteps.checkTotalCost(totalCost);
    }

    @When("^I select ([^\"]*) payment method$")
    public void iSelectPaymentMethod(String paymentMethod) {
        checkoutPageSteps.selectPaymentMethod(paymentMethod);
    }
}
