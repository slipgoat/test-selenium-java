import core.Configuration;
import core.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.page.MainPageSteps;

public class BaseTest {
    public MainPageSteps openMainPage() {
        WebDriverManager.getWebDriver().get(Configuration.getCommon().host());
        return new MainPageSteps().initPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.createWebDriver(Configuration.getCommon().browser());
        WebDriverManager.getWebDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverManager.getWebDriver().quit();
    }
}
