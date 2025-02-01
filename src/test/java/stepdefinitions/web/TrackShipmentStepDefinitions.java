package stepdefinitions.web;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import web.pages.TrackShipmentPage;

public class TrackShipmentStepDefinitions {

    private final TrackShipmentPage trackShipmentPage = new TrackShipmentPage();

    @Then("parcel's last status is equal to {string}")
    public void parcelSLastStatusIsEqualTo(String expectedStatus) {
        Assertions.assertEquals(expectedStatus, trackShipmentPage.getShipmentLastStatusLabel().getText());
    }

}
