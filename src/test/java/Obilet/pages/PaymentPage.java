package Obilet.pages;

import Obilet.utils.Drivers;
import Obilet.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PaymentPage {

    public PaymentPage() {
        PageFactory.initElements(Drivers.get(), this);
    }

    public By partnerInfo = By.className("partner-info");

    @FindBy(id = "payment")
    public WebElement paymentModal;

    List<String> flightArrays = new ArrayList<String>();

    public void verifyPaymentPage() {
        Assert.assertTrue(paymentModal.isDisplayed(), "Payment Page didn't loaded successfully");
    }

    public void verifyFlightsInfo() {
        for (int i = 0; i < Helpers.flightCount(partnerInfo); i++) {
            Helpers.waitFor(1);
            flightArrays.add(Drivers.get().findElements(partnerInfo).get(i).getText());
        }
        Assert.assertTrue(flightArrays.get(0).contains(SearchPage.departureFlightCode.split(": ")[1]));
        Assert.assertTrue(flightArrays.get(1).contains(SearchPage.returnFlightCode.split(": ")[1]));
    }
}
