package Obilet.step_def;

import Obilet.pages.HomePage;
import Obilet.utils.ConfReader;
import Obilet.utils.Drivers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenericSteps {
    HomePage homePage = new HomePage();

    @Given("Ana sayfayi acilir")
    public void anaSayfayiAcilir() {
        Drivers.get().get(ConfReader.get("baseUrl"));
    }

    @And("Sayfanin dogru sekilde acildigi kontrol edilir")
    public void sayfaninDogruSekildeAcildigiKontrolEdilir() {
        homePage.check();
    }

    @When("Uye giris butonuna tiklanir")
    public void uyeGirisButonunaTiklanir() {
        homePage.clickLoginBtn();
    }

    @Then("Yeni kullanicinin basarili sekilde olusturuldugu kontrol edilir")
    public void yeniKullanicininBasariliSekildeOlusturulduguKontrolEdilir() {
        homePage.verifyRegisterSuccess();
    }
}
