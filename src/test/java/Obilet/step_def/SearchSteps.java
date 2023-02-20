package Obilet.step_def;

import Obilet.pages.SearchPage;
import io.cucumber.java.en.And;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();

    @And("Ucuslardan herhangi bir gidis ucusu secilir")
    public void ucuslardanHerhangiBirGidisUcusuSecilir() {
        searchPage.clickDepartureFlight();
    }

    @And("Ucuslardan herhangi bir donus ucusu secilir")
    public void ucuslardanHerhangiBirDonusUcusuSecilir() {
        searchPage.clickReturnFlight();
    }
}
