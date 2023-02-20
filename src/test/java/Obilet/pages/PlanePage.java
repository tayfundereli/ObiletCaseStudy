package Obilet.pages;

import Obilet.utils.Drivers;
import Obilet.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlanePage {
    public PlanePage() {
        PageFactory.initElements(Drivers.get(), this);
    }

    @FindBy(css = "[data-event-action='Flight']")
    public WebElement flightTab;
    @FindBy(id = "origin")
    public WebElement originDropdown;
    @FindBy(id = "origin-input")
    public WebElement originInput;
    @FindBy(id = "destination")
    public WebElement destinationDropdown;
    @FindBy(id = "destination-input")
    public WebElement destinationInput;
    @FindBy(id = "departure-input")
    public WebElement departureInput;
    @FindBy(id = "one-way")
    public WebElement returnInput;
    @FindBy(id = "search-button")
    public WebElement searchBtn;

    public By planePageHeader = By.cssSelector("h1 span");

    String dateTimePicker = "button[data-date='%s']";

    public void fillOutTheFlightCities(String origin, String destination) {
        Helpers.waitFor(2);
        originDropdown.click();
        Helpers.sendText(origin + Keys.ENTER, 0.5, originInput);
        destinationDropdown.click();
        Helpers.sendText(destination + Keys.ENTER, 0.5, destinationInput);
    }

    public void clickPlaneTab() {
        flightTab.click();
    }

    public void verifyPlaneTab(String text) {
        Assert.assertTrue(Helpers.waitElementClickable(planePageHeader).getText().contains(text),
                "Plane page didn't loaded successfully");
    }

    public void fillOutTheFlightDates() {
        departureInput.click();
        By today = By.cssSelector(String.format(dateTimePicker, java.time.LocalDate.now().plusDays(1)));
        Helpers.waitElementClickable(today).click();
        returnInput.click();
        By tomorrow = By.cssSelector(String.format(dateTimePicker, java.time.LocalDate.now().plusDays(2)));
        Helpers.waitElementClickable(tomorrow).click();
        Helpers.waitFor(2);
        searchBtn.click();
    }
}
