package Obilet.step_def;

import Obilet.pages.PaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class PaymentSteps {

    PaymentPage paymentPage = new PaymentPage();

    @Then("Odeme sayfasinin basarili sekilde acildigi kontrol edilir")
    public void odemeSayfasininBasariliSekildeAcildigiKontrolEdilir() {
        paymentPage.verifyPaymentPage();
    }

    @And("Odeme sayfasindaki gidis ve donus ucusunun secilen gidis ve donus ucusu oldugu kontrol edilir")
    public void odemeSayfasindakiGidisVeDonusUcusununSecilenGidisVeDonusUcusuOlduguKontrolEdilir() {
        paymentPage.verifyFlightsInfo();
    }
}
