package pages;

import core.Configuration;
import core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

public abstract class BasePage {
    private final WebDriver webDriver;

    protected Long baseTimeoutSec = Configuration.getCommon().baseTimeoutSec();

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BasePage reinitPage() {
        HtmlElementLoader.populate(this, webDriver);
        return this;
    }

    public void reinitElement(WebElement element) {
        HtmlElementLoader.populate(element, webDriver);
    }

    public void reinitElements(List<WebElement> elements) {
        HtmlElementLoader.populate(elements, webDriver);
    }

    protected <T> void waitUntil(Long timeoutSeconds, ExpectedCondition<T> expectedCondition) {
        new WebDriverWait(WebDriverManager.getWebDriver(), timeoutSeconds).until(expectedCondition);
    }

    protected abstract void waitPageLoad();
}
