import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.page.FormAuthPageSteps;
import steps.page.SecureAreaPageSteps;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestFormAuthentication extends BaseTest {
    private final String correctUsername = "tomsmith";
    private final String correctPassword = "SuperSecretPassword!";

    @DataProvider(parallel = true)
    public Object[][] couldNotLoginDataProvider() {
        String invalidUsernameError = "Your username is invalid!";
        String invalidPasswordError = "Your password is invalid!";

        return new Object[][] {
                { "", "", "Your username is invalid!"},
                { "invalidUsername", "invalidPassword", invalidUsernameError},
                {correctUsername, "invalidPassword", invalidPasswordError},
                { "invalidUsername", correctPassword, invalidUsernameError},
                { "123456", correctPassword, invalidUsernameError},
                { "!@#$%^&*()", correctPassword, invalidUsernameError}
        };
    }

    @Test(description = "Testing failed authentication", dataProvider = "couldNotLoginDataProvider")
    public void couldNotLogin(String username, String password, String errorMessageText) {
        FormAuthPageSteps steps = openMainPage()
                .goToFormAuth();

        steps.setUsername(username)
                .setPassword(password)
                .submit();
        assertThat("Presence of flash message", steps.isFlashMessageVisible(), equalTo(true));
        assertThat("Message status is error", steps.isFlashMessageError(), equalTo(true));

        String errorMessage = steps.getFlashMessage();
        assertThat("Authentication error message text", errorMessage, containsString(errorMessageText));

        steps.closeFlashMessage();
        assertThat("Presence of flash message", steps.isFlashMessageVisible(), equalTo(false));
    }

    @Test(description = "Testing successful authentication")
    public void couldLogin() {
        FormAuthPageSteps steps = openMainPage()
                .goToFormAuth();

        SecureAreaPageSteps secureSteps = steps.setUsername(correctUsername)
                .setPassword(correctPassword)
                .submit();
        assertThat("Title is Secure Area", secureSteps.getTitleText(), equalTo("Secure Area"));
        assertThat("Presence of flash message", steps.isFlashMessageVisible(), equalTo(true));
        assertThat("Message status is success", secureSteps.isFlashMessageSuccess(), equalTo(true));

        String successMessage = secureSteps.getSuccessMessage();
        assertThat("Successful authentication message text", successMessage, containsString("You logged into a secure area!"));
    }

    @Test(description = "Testing successful log out")
    public void couldLogout() {
        FormAuthPageSteps steps = openMainPage()
                .goToFormAuth();

        steps.setUsername(correctUsername)
                .setPassword(correctPassword)
                .submit()
                .logout();

        assertThat("Title is Login Page", steps.getTitleText(), equalTo("Login Page"));
        assertThat("Presence of flash message", steps.isFlashMessageVisible(), equalTo(true));
        assertThat("Message status is success", steps.isFlashMessageSuccess(), equalTo(true));

        String successMessage = steps.getFlashMessage();
        assertThat("Successful log out message text", successMessage, containsString("You logged out of the secure area!"));
    }
}
