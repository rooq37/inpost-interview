package stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import web.pages.HomePage;

public class HomeStepDefinitions {

    private final HomePage homePage = new HomePage();

    @Given("InPost page is open")
    public void inPostPageIsOpen() {
        homePage.openHomePage();
        homePage.addAlertBoxClosedCookie();
        homePage.refreshPage();
    }

    @When("I enter parcel number {string}")
    public void enterParcelNumber(String parcelNumber) {
        homePage.getParcelNumberInput().sendKeys(parcelNumber);
    }

    @And("I click Find button")
    public void clickFindButton() {
        homePage.getParcelNumberSubmitButton().click();
    }

}
