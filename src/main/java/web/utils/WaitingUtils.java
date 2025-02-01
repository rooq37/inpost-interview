package web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingUtils {

    private static final Duration DEFAULT_DURATION = Duration.ofSeconds(20);

    public static WebElement waitUntilVisible(WebDriver driver, By selector) {
        WebDriverWait wait = new WebDriverWait(driver,DEFAULT_DURATION);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

}
