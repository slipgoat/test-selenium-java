package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(css = "li a")
    private List<WebElement> links;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLink(String linkText) {
        getLinks().stream()
                .filter(it -> it.getText().trim().equals(linkText))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Could not find link with text \"" + linkText + "\""))
                .click();
    }

    private List<WebElement> getLinks() {
        reinitElements(links);
        return links;
    }

    @Override
    protected void waitPageLoad() {
        waitUntil(baseTimeoutSec, ExpectedConditions.elementToBeClickable(links.get(0)));
    }
}
