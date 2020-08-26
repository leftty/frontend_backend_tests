package step;

import net.thucydides.core.annotations.Step;
import pages.Header;

public class HeaderSteps extends GenericPageSteps {

    Header header;

    @Step
    public void checkTextInHeader(String text) {
        header.checkTextInHeader(text);
    }

    @Step
    public void checkNumberOfProductsInMinicart(int noOfProducts) {
        header.checkNumberOfProductsInMinicart(noOfProducts);
    }

    @Step
    public void setLocation(String country) {
        header.setLocation(country);
    }

    @Step
    public void setCurrency(String currency) {
        header.setCurrency(currency);
    }
}
