package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import properties.PropertiesUtils;

public class HomePage extends BasePage {

    private static final String PAGE_URL = PropertiesUtils.getProperty("webUrl");

    private static final By PARCEL_NUMBER_INPUT = By.name("number");
    private static final By PARCEL_NUMBER_SUBMIT_BUTTON = By.xpath("//button[@type='submit']");

    public void openHomePage() {
        getDriver().get(PAGE_URL);
    }

    public WebElement getParcelNumberInput() {
        return getDriver().findElement(PARCEL_NUMBER_INPUT);
    }

    public WebElement getParcelNumberSubmitButton() {
        return getDriver().findElement(PARCEL_NUMBER_SUBMIT_BUTTON);
    }

}
