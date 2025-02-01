package web.pages;

import web.configuration.DriverFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class BasePage {

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void addAlertBoxClosedCookie() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;

        getDriver().manage().addCookie(new Cookie(
                "OptanonAlertBoxClosed",
                formatter.format(zonedDateTime),
                ".inpost.pl",
                "/",
                new Date(System.currentTimeMillis() + 365L * 24 * 60 * 60 * 1000)
        ));
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

}
