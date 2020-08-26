package step;

import net.thucydides.core.annotations.Step;
import pages.Footer;

public class FooterSteps {

    Footer footer;

    @Step
    public void checkTextInFooter(String text) {
        footer.checkTextInFooter(text);
    }
}
