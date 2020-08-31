package step;

import net.thucydides.core.annotations.Step;
import pages.GenericBackendRequestPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class GenericBackendRequestSteps {

    GenericBackendRequestPage genericBackendRequestPage;


    @Step
    public void addItem() {
        genericBackendRequestPage.addItem();
    }

    @Step
    public void statusCodeShouldBe(int statusCode) {
        genericBackendRequestPage.statusCodeShouldBe(statusCode);
    }

    @Step
    public void fieldInPathShouldExist(String parentElementPath, String key) {
        genericBackendRequestPage.fieldInPathShouldExist(parentElementPath, key);
    }

    @Step
    public void fieldInPathShouldNotExist(String parentElementPath, String key) {
        genericBackendRequestPage.fieldInPathShouldNotExist(parentElementPath, key);
    }

    @Step
    public void valueForFieldInPathShouldBe(String path, String expectedValue) {
        genericBackendRequestPage.valueForFieldInPathShouldBe(path, expectedValue);
    }

    @Step
    public void getItem() {
        genericBackendRequestPage.getItem();
    }

    @Step
    public void checkMapId() {
        genericBackendRequestPage.checkMapId();
    }

    @Step
    public void deleteItem() {
        genericBackendRequestPage.deleteItem();
    }

    @Step
    public void markMapForDeletion() {
        genericBackendRequestPage.markMapForDeletion();
    }

    @Step
    public void addItemInvalidApiKey() {
        genericBackendRequestPage.addItemInvalidApiKey();
    }

    @Step
    public void addItemOverHttp() {
        genericBackendRequestPage.addItemOverHttp();
    }

    @Step
    public void addItemInvalidMapType() {
        genericBackendRequestPage.addItemInvalidMapType();
    }
}
