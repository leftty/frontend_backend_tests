package pages;

import exceptions.AutomationException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

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
    private static final String LOCAL_SHIPPING = "label[title='Local shipping']>input";
    private static final String COURIER = "label[title='Courier']>input";
    private static final String PAYMENT = "button.checkout_fastlane_section-next";
    private static final String PLACE_ORDER = "button.place-order";
    private static final String PLACE_ORDER_PAYPAL = "#pcp-hosted-fields-submit";
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
        waitForPageToLoad();
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
        FluentWait wait = globalFluentWait(10, 200);
        waitForPageToLoad();
        if (getDriver().findElements(By.cssSelector("div.pcp-hosted-fields-container[style='display: none;']")).size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PLACE_ORDER)));
            try {
                getDriver().findElement(By.cssSelector(PLACE_ORDER)).click();
            } catch (ElementClickInterceptedException e) {
                getDriver().findElement(By.cssSelector(PLACE_ORDER)).click();
            }
        }
        else {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PLACE_ORDER_PAYPAL)));
            try {
                getDriver().findElement(By.cssSelector(PLACE_ORDER_PAYPAL)).click();
            } catch (ElementClickInterceptedException e) {
                getDriver().findElement(By.cssSelector(PLACE_ORDER_PAYPAL)).click();
            }
        }
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
        waitForPageToLoad();
        FluentWait wait = globalFluentWait(20, 200);
        switch (deliveryType) {
            case "local pickup":
                wait.until(not(ExpectedConditions.stalenessOf(findElementByCss(LOCAL_PICKUP))));
                wait.until(ExpectedConditions.elementToBeClickable(findElementByCss(LOCAL_PICKUP)));
                findElementByCss(LOCAL_PICKUP).click();
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                break;
            case "free shipping":
                wait.until(not(ExpectedConditions.stalenessOf(findElementByCss(FREE_SHIPPING))));
                wait.until(ExpectedConditions.elementToBeClickable(findElementByCss(FREE_SHIPPING)));
                findElementByCss(FREE_SHIPPING).click();
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                break;
            case "local shipping":
                wait.until(not(ExpectedConditions.stalenessOf(findElementByCss(LOCAL_SHIPPING))));
                wait.until(ExpectedConditions.elementToBeClickable(findElementByCss(LOCAL_SHIPPING)));
                findElementByCss(LOCAL_SHIPPING).click();
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                break;
            case "courier":
                wait.until(not(ExpectedConditions.stalenessOf(findElementByCss(COURIER))));
                wait.until(ExpectedConditions.elementToBeClickable(findElementByCss(COURIER)));
                findElementByCss(COURIER).click();
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid delivery type " + deliveryType);
        }
        waitForPageToLoad();
    }

    public void checkTotalCost(String totalCost) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(TOTAL_COST), totalCost));
    }

    public void selectPaymentMethod(String paymentMethod) {
        String deliveryType = paymentMethod.toLowerCase();
        waitForPageToLoad();
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
        switch (deliveryType) {
            case "paypal":
                wait.until(not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(PAYPAL)))));
                wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(PAYPAL))));
                try {
                    getDriver().findElement(By.cssSelector(PAYPAL)).click();

                } catch (Exception e) {
                    getDriver().findElement(By.cssSelector(PAYPAL)).click();
                }
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.paypal-buttons")));
                getDriver().switchTo().frame("braintree-hosted-field-number");
                getDriver().findElement(By.cssSelector("#credit-card-number")).sendKeys("4263982640269299");
                getDriver().switchTo().defaultContent();
                getDriver().switchTo().frame("braintree-hosted-field-expirationDate");
                getDriver().findElement(By.cssSelector("#expiration")).sendKeys("04/2023");
                getDriver().switchTo().defaultContent();
                getDriver().switchTo().frame("braintree-hosted-field-cvv");
                getDriver().findElement(By.cssSelector("#cvv")).sendKeys("738");
                getDriver().switchTo().defaultContent();
                break;
            case "credit card":
            case "debit card":
                wait.until(not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(CREDIT_CARD)))));
                wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(CREDIT_CARD))));
                try {
                    getDriver().findElement(By.cssSelector(CREDIT_CARD)).click();
                } catch (Exception e) {
                    getDriver().findElement(By.cssSelector(CREDIT_CARD)).click();
                }
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                break;
            case "phone ordering":
                wait.until(not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(PHONE_ORDERING)))));
                wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(PHONE_ORDERING))));
                try {
                    getDriver().findElement(By.cssSelector(PHONE_ORDERING)).click();
                } catch (Exception e) {
                    getDriver().findElement(By.cssSelector(PHONE_ORDERING)).click();
                }
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                break;
            case "cash on delivery":
                wait.until(not(ExpectedConditions.stalenessOf(getDriver().findElement(By.cssSelector(CASH_ON_DELIVERY)))));
                wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.cssSelector(CASH_ON_DELIVERY))));
                try {
                    getDriver().findElement(By.cssSelector(CASH_ON_DELIVERY)).click();
                }  catch (Exception e) {
                    getDriver().findElement(By.cssSelector(CASH_ON_DELIVERY)).click();
                }
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.reloading-animated"), 0));
                break;
            default:  // should be unreachable!
                throw new AutomationException("Invalid payment method " + deliveryType);
        }
    }
}
