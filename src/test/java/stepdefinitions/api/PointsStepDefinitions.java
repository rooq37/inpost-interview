package stepdefinitions.api;

import api.PointsEndpoint;
import api.model.responses.Points;
import com.google.gson.Gson;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PointsStepDefinitions {

    private final PointsEndpoint pointsEndpoint = new PointsEndpoint();

    private String city;
    private Response response;
    private Points points;

    private Scenario currentScenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        currentScenario = scenario;
    }

    @Given("I have a city {string}")
    public void iHaveACity(String city) {
        this.city = city;
    }

    @When("I search for Parcel Lockers in that city")
    public void iSearchForParcelLockersInThatCity() {
        response = pointsEndpoint.getParcelLockersByCity(city);
    }

    @Then("the response should not be empty")
    public void theResponseShouldNotBeEmpty() {
        points = response.getBody().as(Points.class);
        Assertions.assertFalse(points.getItems().isEmpty());
    }

    @Then("the response should have a status code {int}")
    public void theResponseShouldHaveAStatusCode(Integer statusCode) {
        Assertions.assertEquals(statusCode, response.getStatusCode());
    }

    @When("I search for all Parcel Lockers across all pages in that city")
    public void iSearchForAllParcelLockersAcrossAllPagesInThatCity() {
        for (int i = 2; i <= points.getTotalPages(); i++) {
            Response nextPage = pointsEndpoint.getParcelLockersByCity(city, i);
            Assertions.assertEquals(200, nextPage.getStatusCode());
            Points nextPagePoints = nextPage.getBody().as(Points.class);
            points.getItems().addAll(nextPagePoints.getItems());
        }
    }

    @When("I save the results to a JSON file")
    public void iSaveTheResultsToAJsonFile() {
        String jsonString = new Gson().toJson(points.getItems());
        new File("api-tests-output").mkdir();
        String fileName = "api-tests-output" + File.separator + "parcellockers." + city + ".json";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(jsonString);
            currentScenario.attach(jsonString, "application/json", fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the number of results should be equal to the size of the result list")
    public void theNumberOfResultsShouldBeEqualToTheSizeOfTheResultList() {
        Assertions.assertEquals(points.getCount(), points.getItems().size());
    }

}
