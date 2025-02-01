package stepdefinitions.api;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestHooks {

    private static final Logger LOGGER = LogManager.getLogger(TestHooks.class);

    @BeforeAll
    public static void setupBeforeSuite() {
        LOGGER.info("===========================================");
        LOGGER.info("Starting the Cucumber API Test Suite...");
        LOGGER.info("ENVIRONMENT: " + System.getProperty("env", "dev"));
        LOGGER.info("===========================================");
    }

    @Before
    public void setUp(Scenario scenario) {
        LOGGER.info("Starting scenario " + scenario.getName() + "...");
    }

    @After
    public void tearDown(Scenario scenario) {
        LOGGER.info("Scenario " + scenario.getName() + " finished...");
    }

}
