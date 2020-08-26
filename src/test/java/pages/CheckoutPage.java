package pages;

import exceptions.AutomationException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends GenericPage {

    private static final String COUNTRY = "#shippingaddress-country-code";
    private static final String EMAIL = "#email";
    private static final String FIRST_NAME = "#shippingaddress-firstname";
    private static final String LAST_NAME = "#shippingaddress-lastname";
    private static final String ADDRESS = "#shippingaddress-street";
    private static final String CITY = "#shippingaddress-city";
    private static final String STATE = "#shippingaddress-custom-state";
    private static final String ZIP_CODE = "#shippingaddress-zipcode";
    private static final String PHONE = "#shippingaddress-phone";
    private static final String VAT_NUMBER = "#shippingaddress-vat-number";
    private static final String SHIPPING = "button.checkout_fastlane_section-next";
    private static final String FREE_SHIPPING = "label[title='Free shipping on orders over $50']>input";
    private static final String LOCAL_PICKUP = "label[title='Local pickup']>input";
    private static final String LOCAL_SHIPPING = "label[title='Local pickup']>input";
    private static final String COURIER = "label[title='Local pickup']>input";
    private static final String PAYMENT = "button.checkout_fastlane_section-next";
    private static final String PLACE_ORDER = "button.place-order";
    private static final String TOTAL_COST = "div.order-total";
    private static final String PAYPAL = "#pmethod15";
    private static final String CREDIT_CARD = "#pmethod30";
    private static final String PHONE_ORDERING = "#pmethod2";
    private static final String CASH_ON_DELIVERY = "#pmethod6";

    public void countryEmailPrefilled() {
        Select select = new Select(getDriver().findElement(By. xpath("//select")));
        WebElement option = select.getFirstSelectedOption();
        Assert.assertEquals("Selected country is not the expected one", "Romania",
                option.getAttribute("innerText"));
        if (RegisterPage.email.contentEquals("")) {
            Assert.assertEquals("Email field input value is not the expected one", "test1986@test1986.com",
                    getDriver().findElement(By.cssSelector(EMAIL)).getAttribute("value"));
        }
        else {
            Assert.assertEquals("Email field input value is not the expected one", RegisterPage.email,
                    getDriver().findElement(By.cssSelector(EMAIL)).getAttribute("value"));
        }
        Assert.assertEquals("First name field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(FIRST_NAME)).getAttribute("value"));
        Assert.assertEquals("Last name field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(LAST_NAME)).getAttribute("value"));
        Assert.assertEquals("Address field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(ADDRESS)).getAttribute("value"));
        Assert.assertEquals("City field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(CITY)).getAttribute("value"));
        Assert.assertEquals("State field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(STATE)).getAttribute("value"));
        Assert.assertEquals("Zip code field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(ZIP_CODE)).getAttribute("value"));
        Assert.assertEquals("Telephone field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(PHONE)).getAttribute("value"));
        Assert.assertEquals("Vat number field input should be empty but it is not", "",
                getDriver().findElement(By.cssSelector(VAT_NUMBER)).getAttribute("value"));
    }

    public void fillInFirstName(String firstName) {
        findElementByCss(FIRST_NAME).clear();
        findElementByCss(FIRST_NAME).sendKeys(firstName);
    }

    public void fillInLastName(String lastName) {
        findElementByCss(LAST_NAME).clear();
        findElementByCss(LAST_NAME).sendKeys(lastName);
    }

    public void fillInAddress(String address) {
        findElementByCss(ADDRESS).clear();
        findElementByCss(ADDRESS).sendKeys(address);
    }

    public void fillInCity(String city) {
        findElementByCss(CITY).clear();
        findElementByCss(CITY).sendKeys(city);
    }

    public void fillInZipCode(String zipCode) {
        findElementByCss(ZIP_CODE).clear();
        findElementByCss(ZIP_CODE).sendKeys(zipCode);
    }

    public void goToShippingStep() {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SHIPPING)));
        findElementByCss(SHIPPING).click();
    }

    public void goToPaymentStep() {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PAYMENT)));
        findElementByCss(PAYMENT).click();
    }

    public void fillInShippingInfoIfNoPreviousAddressesExistGoToShippingStep() {
        if (getDriver().findElements(By.cssSelector("#shippingaddress-firstname")).size() > 0) {
            checkTextIsPresentInPage("Proceed to shipping");
            countryEmailPrefilled();
            fillInFirstName("Dragos");
            fillInLastName("Panzaru");
            fillInAddress("10 Downing Street");
            fillInCity("Bucharest");
            fillInZipCode("077160");
            goToShippingStep();
        }
    }

    public void selectCashOnDelivery() {
        findElementByCss(CASH_ON_DELIVERY).click();
    }

    public void placeOrder() {
        findElementByCss(PLACE_ORDER).click();
    }

    public void fillInPhoneNo(String phoneNo) {
        findElementByCss(PHONE).clear();
        findElementByCss(PHONE).sendKeys(phoneNo);
    }

    public void fillInVatNo(String vatNo) {
        findElementByCss(VAT_NUMBER).clear();
        findElementByCss(VAT_NUMBER).sendKeys(vatNo);
    }

    public void selectShipping(String shippingType) {
        String deliveryType = shippingType.toLowerCase();
        switch (deliveryType) {
            case "local pickup":
                findElementByCss(LOCAL_PICKUP).click();
                break;
            case "free shipping":
                findElementByCss(FREE_SHIPPING).click();
                break;
            case "local shipping":
                findElementByCss(LOCAL_SHIPPING).click();
                break;
            case "courier":
                findElementByCss(COURIER).click();
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid delivery type " + deliveryType);
        }
    }

    public void checkTotalCost(String totalCost) {
        Assert.assertTrue("Total cost '" + findElementByCss(TOTAL_COST).getText().trim() +
                "' is different than expected one '" + totalCost + "'", findElementByCss(TOTAL_COST).getText().trim().contentEquals(totalCost));
    }

    public void selectPaymentMethod(String paymentMethod) {
        String deliveryType = paymentMethod.toLowerCase();
        switch (deliveryType) {
            case "paypal":
                findElementByCss(PAYPAL).click();
                break;
            case "credit card":
            case "debit card":
                findElementByCss(CREDIT_CARD).click();
                break;
            case "phone ordering":
                findElementByCss(PHONE_ORDERING).click();
                break;
            case "cash on delivery":
                findElementByCss(CASH_ON_DELIVERY).click();
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid payment method " + deliveryType);
        }
    }
}
