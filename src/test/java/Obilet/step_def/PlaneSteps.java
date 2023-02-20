package Obilet.step_def;

import Obilet.pages.PlanePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class PlaneSteps {
    PlanePage planePage = new PlanePage();

    @When("Ucak tabine tiklanir")
    public void ucakTabineTiklanir() {
        planePage.clickPlaneTab();
    }

    @And("{string} bileti arama sayfasinin acildigi gorulur")
    public void biletiAramaSayfasininAcildigiGorulur(String text) {
        planePage.verifyPlaneTab(text);
    }

    @And("Bir gidis ili ve  donus ili secilir")
    public void birGidisIliVeDonusIliSecilir(DataTable dt) {
        List<Map<String, String>> rows = dt.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            planePage.fillOutTheFlightCities(columns.get("origin"), columns.get("destination"));
        }
    }

    @And("Bir gidis tarihi ve donus tarihi secilir")
    public void birGidisTarihiVeDonusTarihiSecilir() {
        planePage.fillOutTheFlightDates();
    }
}
