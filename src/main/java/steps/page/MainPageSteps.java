package steps.page;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps extends BasePageSteps<MainPage> {
    public MainPageSteps initPage() {
        super.initPage(MainPage.class);
        return this;
    }

    @Step("Go to Form Authentication")
    public FormAuthPageSteps goToFormAuth() {
        getPage().clickLink("Form Authentication");
        return new FormAuthPageSteps().initPage();
    }
}
