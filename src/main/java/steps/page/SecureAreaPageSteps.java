package steps.page;

import components.FlashMessageComponent;
import io.qameta.allure.Step;
import pages.SecureAreaPage;
import steps.component.FlashMessageSteps;

public class SecureAreaPageSteps extends BasePageSteps<SecureAreaPage> {
    private FlashMessageSteps flashMessageSteps;

    public SecureAreaPageSteps initPage() {
        super.initPage(SecureAreaPage.class);
        flashMessageSteps = new FlashMessageSteps();
        return this;
    }

    @Step("Get title text")
    public String getTitleText() {
        return getPage().getTitleText();
    }

    @Step("Log out")
    public FormAuthPageSteps logout() {
        getPage().logout();
        return new FormAuthPageSteps().initPage();
    }

    @Step("Get successful authorization message text")
    public String getSuccessMessage() {
        return flashMessageSteps.initComponent().getMessage().trim();
    }

    @Step("Close successful authorization message text")
    public SecureAreaPageSteps closeSuccessMessage() {
        flashMessageSteps.initComponent().close();
        return this;
    }

    @Step("Check that message status is success")
    public Boolean isFlashMessageSuccess() {
        return flashMessageSteps.initComponent().getStatus().equals(FlashMessageComponent.SUCCESS);
    }
}
