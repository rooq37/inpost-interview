package stepdefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import web.configuration.DriverFactory;

public class TestHooks {

    private static final Logger LOGGER = LogManager.getLogger(TestHooks.class);

    @BeforeAll
    public static void setupBeforeSuite() {
        LOGGER.info("===========================================");
        LOGGER.info("Starting the Cucumber WEB Test Suite...");
        LOGGER.info("ENVIRONMENT: " + System.getProperty("env", "dev"));
        LOGGER.info("DRIVER: " + System.getProperty("remoteDriverUrl", "LOCAL"));
        LOGGER.info("===========================================");
    }

    @Before
    public void setUp(Scenario scenario) {
        LOGGER.info("Starting scenario " + scenario.getName() + "...");
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", "screenshot.png");
        }
        DriverFactory.quitDriver();
        LOGGER.info("Scenario " + scenario.getName() + " finished...");
    }

}
