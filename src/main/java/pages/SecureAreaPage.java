package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecureAreaPage extends BasePage {
    @FindBy(css = "h2")
    private WebElement title;

    @FindBy(css = "a.button")
    private WebElement logoutButton;

    public SecureAreaPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitleText() {
        waitPageLoad();
        return title.getText().trim();
    }

    public void logout() {
        waitPageLoad();
        logoutButton.click();
    }

    @Override
    protected void waitPageLoad() {
        waitUntil(baseTimeoutSec, ExpectedConditions.elementToBeClickable(title));
    }
}
