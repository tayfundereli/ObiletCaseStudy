package Obilet.step_def;

import Obilet.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;

public class RegisterSteps {
    RegisterPage registerPage = new RegisterPage();

    @And("Uyelik Pop-Up'inin acildigi gorulur")
    public void uyelikPopUpIninAcildigiGorulur() {
        registerPage.isLoginPopupPresent();
    }

    @And("Uye ol sayfasina gidilir")
    public void uyeOlSayfasinaGidilir() {
        registerPage.clickLoginToRegisterBtn();
    }

    @And("Mail ve Password alani girilir")
    public void mailVePasswordAlaniGirilir(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            registerPage.fillLoginInfo(columns.get("email"), columns.get("password"));
        }
    }

    @And("Uye ol butonuna tiklanir")
    public void uyeOlButonunaTiklanir() {
        registerPage.clickRegisterBtn();
    }
}
