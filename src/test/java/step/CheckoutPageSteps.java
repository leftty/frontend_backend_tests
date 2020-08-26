package step;

import net.thucydides.core.annotations.Step;
import pages.CheckoutPage;

public class CheckoutPageSteps {

    CheckoutPage checkoutPage;

    @Step
    public void countryEmailPrefilled() {
        checkoutPage.countryEmailPrefilled();
    }

    @Step
    public void fillInFirstName(String firstName) {
        checkoutPage.fillInFirstName(firstName);
    }

    @Step
    public void fillInLastName(String lastName) {
        checkoutPage.fillInLastName(lastName);
    }

    @Step
    public void fillInAddress(String address) {
        checkoutPage.fillInAddress(address);
    }

    @Step
    public void fillInCity(String city) {
        checkoutPage.fillInCity(city);
    }

    @Step
    public void fillInZipCode(String zipCode) {
        checkoutPage.fillInZipCode(zipCode);
    }

    @Step
    public void goToShippingStep() {
        checkoutPage.goToShippingStep();
    }

    @Step
    public void selectShipping(String shippingType) {
        checkoutPage.selectShipping(shippingType);
    }

    @Step
    public void goToPaymentStep() {
        checkoutPage.goToPaymentStep();
    }

    @Step
    public void fillInShippingInfoIfNoPreviousAddressesExistGoToShippingStep() {
        checkoutPage.fillInShippingInfoIfNoPreviousAddressesExistGoToShippingStep();
    }

    @Step
    public void selectCashOnDelivery() {
        checkoutPage.selectCashOnDelivery();
    }

    @Step
    public void placeOrder() {
        checkoutPage.placeOrder();
    }

    @Step
    public void fillInPhoneNo(String phoneNo) {
        checkoutPage.fillInPhoneNo(phoneNo);
    }

    @Step
    public void fillInVatNo(String vatNo) {
        checkoutPage.fillInVatNo(vatNo);
    }

    @Step
    public void checkTotalCost(String totalCost) {
        checkoutPage.checkTotalCost(totalCost);
    }

    @Step
    public void selectPaymentMethod(String paymentMethod) {
        checkoutPage.selectPaymentMethod(paymentMethod);
    }
}
