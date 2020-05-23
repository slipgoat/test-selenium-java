package pages;

import components.FormAuthComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormAuthPage extends BasePage {
    private FormAuthComponent formAuth;

    @FindBy(css = "h2")
    private WebElement title;

    public FormAuthPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitleText() {
        waitPageLoad();
        return title.getText().trim();
    }

    public FormAuthComponent getFormAuth() {
        waitPageLoad();
        reinitElement(formAuth);
        return formAuth;
    }

    @Override
    protected void waitPageLoad() {
        waitUntil(baseTimeoutSec, ExpectedConditions.elementToBeClickable(title));
    }
}
