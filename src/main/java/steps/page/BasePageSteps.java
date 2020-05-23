package steps.page;

import core.WebDriverManager;
import pages.BasePage;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BasePageSteps<P extends BasePage> {
    private final ThreadLocal<P> page = new ThreadLocal<>();

    public P getPage() {
        return page.get();
    }

    public P initPage(Class<P> pageClass) {
        if (getPage() == null) {
            page.set(HtmlElementLoader.create(pageClass, WebDriverManager.getWebDriver()));
        }
        return getPage();
    }
}
