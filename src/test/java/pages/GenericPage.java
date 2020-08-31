package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

import static java.time.Duration.ofMillis;

public class GenericPage extends PageObject {


    public void checkTextInElementWithCssSelector(String cssSelector, String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), text));

    }

    public void checkTextInElementWithXpath(String xpath, String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
    }

    public void checkTextIsPresentInPage(String text) {
        FluentWait wait = globalFluentWait(25, 200);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("body"), text));
    }

    public void checkTextIsNotPresentInPage(String text) {
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.not(ExpectedConditions.
                textToBePresentInElementLocated(By.cssSelector("body"), text)));
    }

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }

    public void clearSession() {
        ThucydidesWebDriverSupport.getDriver().manage().deleteAllCookies();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.sessionStorage.clear()");
        ThucydidesWebDriverSupport.clearSession();
    }

    protected WebElement findElementById(String id) {
        System.out.println("Searching for element: " + id);
        return getDriver().findElement(By.id(id));
    }

    protected WebElement findElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    protected WebElement findElementByXpath(String xpath) {
        System.out.println("Finding element: " + xpath);
        return getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected WebElement findElementByText(String text) {
        System.out.println("Finding element with text: " + text);
        FluentWait wait = globalFluentWait(10, 200);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + text + "')]")));
        return getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    protected WebElement findElementByCss(String css) {
        System.out.println("Finding element: " + css);
        return getDriver().findElement(By.cssSelector(css));
    }

    protected void scrollToAndClickByCss(String css) {
        System.out.println("Finding element: " + css);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementByCss(css));
        actions.perform();
        getDriver().findElement(By.cssSelector(css)).click();
    }

    protected void scrollToAndClickByXpath(String xpath) {
        System.out.println("Finding element: " + xpath);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(findElementByXpath(xpath));
        actions.perform();
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void selectCheckbox(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")));
        if (!(getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).isSelected())) {
            getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).click();
        }
    }

    public void deselectCheckbox(String text) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")));
        if (getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).isSelected()) {
            getDriver().findElement(By.xpath("//label[contains(text(),'" + text + "')]/preceding-sibling::input")).click();
        }
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void elementWithIdShouldBePresent(String id) {
        waitForRenderedElementsToBePresent(By.id(id));
    }

    public void checkTextIsPresentInHyperlink(String text) {
        Assert.assertNotNull("Hyperlink with text '" + text + "' was not found!", getDriver().findElement(By.xpath(
                "//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]")));
    }

    public void checkTextIsPresentInButton(String text) {
        Assert.assertNotNull("Button with text '" + text + "' was not found!", getDriver().findElement(By.xpath(
                "//button[contains(text(),'" + text + "')]")));
    }

    public void clickButton(String text) {
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(text(),'" + text + "')] | //button/span[contains(text(),'" + text + "')]")));
        findElementByXpath("//button[contains(text(),'" + text + "')] | //button/span[contains(text(),'" + text + "')]").click();
    }

    public void clickLink(String text) {
        String locator = "//a[contains(text(),'" + text + "')] | //a/span[contains(text(),'" + text + "')]";
        FluentWait wait = globalFluentWait(5, 200);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        findElementByXpath(locator).click();
    }


    void selectOptionFromDropdown(WebElement element, String searchCriteria) {
        new Select(element).selectByValue(searchCriteria);
    }

    public void goBackToPreviousPage() {
        getDriver().navigate().back();
    }

    void inputText(WebElement field, String text) {
        if (text.contentEquals("")) {
            int limit = field.getAttribute("value").length();
            for (int i = 0; i < limit; i++) {
                field.sendKeys(Keys.BACK_SPACE);
            }
        } else {
            field.clear();
            field.sendKeys(text);
        }
    }

    FluentWait globalFluentWait(int timeOutSeconds, int pollingEveryMilliseconds) {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(ofMillis(pollingEveryMilliseconds))
                .ignoring(NoSuchElementException.class);

        return wait;
    }

    public void checkTextIsPresentInElementWithCssSelector(String cssSelector, String text) {
        WebElement element = findElementByCss(cssSelector);
        Assert.assertTrue("Element with css selector '" + cssSelector + "' has text '" + element.getText().contains(text)
                + "' which does not contain expected text '" + text + "'", element.getText().contains(text));
    }

    public String generateEmailAddress() {
        return RandomStringUtils.randomAlphabetic(1) + RandomStringUtils.randomAlphanumeric(9, 15) + "@" +
                RandomStringUtils.randomAlphabetic(1) + RandomStringUtils.randomAlphanumeric(5, 9) + ".com";
    }
}
