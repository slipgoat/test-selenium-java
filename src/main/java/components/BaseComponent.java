package components;

import core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.List;

public class BaseComponent extends HtmlElement {
    protected final WebDriver webDriver;

    public BaseComponent() {
        webDriver = WebDriverManager.getWebDriver();
    }

    public BaseComponent reinitComponent() {
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
        new WebDriverWait(webDriver, timeoutSeconds).until(expectedCondition);
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
