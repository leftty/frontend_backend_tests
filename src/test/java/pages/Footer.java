package pages;

import exceptions.AutomationException;
import org.junit.Assert;

public class Footer extends GenericPage {

    private static final String FOOTER = "#footer-area";

    public void checkTextInFooter(String text) {
        Assert.assertTrue("Footer text '" + findElementByCss(FOOTER).getText() + "' does not contain " + text,
                findElementByCss(FOOTER).getText().contains(text));
    }
}
