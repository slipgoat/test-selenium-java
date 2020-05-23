package steps.component;

import components.FlashMessageComponent;
import core.Utils;
import io.qameta.allure.Step;

public class FlashMessageSteps extends BaseComponentSteps<FlashMessageComponent> {
    public FlashMessageSteps initComponent() {
        super.initComponent(FlashMessageComponent.class);
        return this;
    }

    @Step("Get flash message text")
    public String getMessage() {
        return getComponent().getText().trim();
    }

    @Step("Get status")
    public String getStatus() {
        String status = getComponent().getStatus();
        if (status == null) {
            throw new IllegalStateException("Undefined flash message status");
        }

        return status;
    }

    @Step("Check presence of flash message")
    public Boolean isVisible() {
        return Utils.isVisible(getComponent());
    }

    @Step("Close")
    public void close() {
        getComponent().close();
    }
}
