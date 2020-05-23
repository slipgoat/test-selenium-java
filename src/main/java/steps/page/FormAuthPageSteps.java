package steps.page;

import components.FlashMessageComponent;
import io.qameta.allure.Step;
import pages.FormAuthPage;
import steps.component.FlashMessageSteps;

public class FormAuthPageSteps extends BasePageSteps<FormAuthPage> {
    private FlashMessageSteps flashMessageSteps;

    public FormAuthPageSteps initPage() {
        super.initPage(FormAuthPage.class);
        flashMessageSteps = new FlashMessageSteps();
        return this;
    }

    @Step("Get title text")
    public String getTitleText() {
        return getPage().getTitleText();
    }

    @Step("Set user name - {username}")
    public FormAuthPageSteps setUsername(String username) {
        getPage().getFormAuth().setUsername(username);
        return this;
    }

    @Step("Set password - {password}")
    public FormAuthPageSteps setPassword(String password) {
        getPage().getFormAuth().setPassword(password);
        return this;
    }

    @Step("Click Login")
    public SecureAreaPageSteps submit() {
        getPage().getFormAuth().submit();
        return new SecureAreaPageSteps().initPage();
    }

    public String getFlashMessage() {
        return flashMessageSteps.initComponent()
                .getMessage()
                .trim();
    }

    public void closeFlashMessage() {
        flashMessageSteps.initComponent().close();
    }

    public Boolean isFlashMessageVisible() {
        return flashMessageSteps.initComponent().isVisible();
    }

    @Step("Check that message status is error")
    public Boolean isFlashMessageError() {
        return flashMessageSteps.initComponent()
                .getStatus()
                .equals(FlashMessageComponent.ERROR);
    }

    @Step("Check that message status is success")
    public Boolean isFlashMessageSuccess() {
        return flashMessageSteps.initComponent()
                .getStatus()
                .equals(FlashMessageComponent.SUCCESS);
    }
}
