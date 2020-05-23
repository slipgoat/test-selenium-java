package components;

import core.Configuration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.Utils;

@FindBy(css = ".flash")
public class FlashMessageComponent extends BaseComponent {
    public static final String ERROR = "error";
    public static final String SUCCESS = "success";

    @FindBy(css = ".close")
    private WebElement closeButton;

    public FlashMessageComponent() {
        super();
    }

    public String getStatus() {
        if (isErrorMessage()) {
            return ERROR;
        } else if (isSuccessMessage()) {
            return SUCCESS;
        }

        return null;
    }

    public void close() {
        closeButton.click();
        Utils.sleep(Configuration.getCommon().baseTimeoutMills());
    }

    private Boolean isErrorMessage() {
        return this.getAttribute("class").contains(ERROR);
    }

    private Boolean isSuccessMessage() {
        return this.getAttribute("class").contains(SUCCESS);
    }
}
