package Obilet.pages;

import Obilet.utils.Drivers;
import Obilet.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public SearchPage() {
        PageFactory.initElements(Drivers.get(), this);
    }

    public By flightCode = By.className("code");
    public By outBoundEcoFlyContainer = By.cssSelector("#outbound-journeys .EF .fly-title-container");
    public By returnEcoFlyContainer = By.cssSelector("#return-journeys .EF .fly-title-container");

    @FindBy(css = "#outbound-journeys button.details")
    public WebElement outBoundDetails;
    @FindBy(css = "#return-journeys button.details")
    public WebElement returnFlightDetails;
    @FindBy(css = "#outbound-journeys .flights")
    public WebElement outboundFlights;
    @FindBy(css = "#return-journeys .flights")
    public WebElement returnFlights;
    @FindBy(css = ".details-modal .close")
    public WebElement detailCloseBtn;

    public static String departureFlightCode;
    public static String returnFlightCode;

    public void clickDepartureFlight() {
        Helpers.waitFor(2);
        outBoundDetails.click();
        departureFlightCode = Helpers.waitElementClickable(flightCode).getText();
        detailCloseBtn.click();
        outboundFlights.click();
        checkOutbondEcoFly();
    }

    public void clickReturnFlight() {
        Helpers.waitFor(2);
        returnFlightDetails.click();
        returnFlightCode = Helpers.waitElementClickable(flightCode).getText();
        detailCloseBtn.click();
        returnFlights.click();
        returnFlightEcoFly();
    }

    public void checkOutbondEcoFly() {
        try {
            Helpers.waitElementClickable(outBoundEcoFlyContainer).click();
        } catch (Exception e) {
            System.out.println("Eco Fly seçeneği bulunamadı");
        }
    }

    public void returnFlightEcoFly() {
        try {
            Helpers.waitElementClickable(returnEcoFlyContainer).click();
        } catch (Exception e) {
            System.out.println("Eco Fly seçeneği bulunamadı");
        }
    }
}
