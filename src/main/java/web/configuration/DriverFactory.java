package web.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String remoteDriverUrl = System.getProperty("remoteDriverUrl", "");
            driver = remoteDriverUrl.isEmpty() ? getChromeDriver() : getRemoteChromeDriver(remoteDriverUrl);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static ChromeDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver getRemoteChromeDriver(String url) {
        ChromeOptions options = new ChromeOptions();
        try {
            return new RemoteWebDriver(URI.create(url).toURL(), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
