package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.utils.WaitingUtils;

public class TrackShipmentPage extends BasePage {
    private static final By SHIPMENT_LAST_STATUS = By.xpath("//div[@class='single--status--block -active']//p[@class='paragraph--component -big -secondary']");

    public WebElement getShipmentLastStatusLabel() {
        return WaitingUtils.waitUntilVisible(getDriver(), SHIPMENT_LAST_STATUS);
    }

}
