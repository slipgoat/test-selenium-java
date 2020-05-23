package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static WebDriver createWebDriver(String browser) {
        DesiredCapabilities desiredCapabilities;
        URL remoteDriveUrl;

        switch (browser) {
            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                break;
            case "chrome":
            default:
                desiredCapabilities = DesiredCapabilities.chrome();
                break;
        }

        try {
            remoteDriveUrl = new URL(Configuration.getCommon().hubUrl());
        } catch (MalformedURLException e) {
            throw  new IllegalArgumentException("Incorrect remote driver url");
        }

        webDriver.set(new RemoteWebDriver(remoteDriveUrl, desiredCapabilities));

        return getWebDriver();
    }

}
