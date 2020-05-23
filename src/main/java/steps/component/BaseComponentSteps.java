package steps.component;

import components.BaseComponent;
import core.WebDriverManager;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BaseComponentSteps<C extends BaseComponent> {
    private final ThreadLocal<C> component = new ThreadLocal<>();

    public C getComponent() {
        return component.get();
    }

    public C initComponent(Class<C> componentClass) {
        if (getComponent() == null) {
            component.set(HtmlElementLoader.create(componentClass, WebDriverManager.getWebDriver()));
        }
        return getComponent();
    }
}
