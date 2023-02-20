package Obilet.pages;

import Obilet.utils.Drivers;
import Obilet.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePage {

    public HomePage() {
        PageFactory.initElements(Drivers.get(), this);
    }

    @FindBy(className = "login")
    public WebElement loginBtn;

    public By mobileBanner = By.id("mobile-applications");
    public By mainLogo = By.cssSelector(".logo[aria-label='obilet.com']");
    public By menuRightText = By.cssSelector(".menu.right");

    public void check() {
        Assert.assertTrue(Helpers.waitElementClickable(mobileBanner).isDisplayed(),
                "Mobile banner didn't appear on Home Page");
        Assert.assertTrue(Helpers.waitElementClickable(mainLogo).isDisplayed(),
                "Main logo didn't appear on Home Page");
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void verifyRegisterSuccess() {
        Helpers.waitFor(5);
        Assert.assertTrue(Helpers.waitElementClickable(menuRightText).getText().contains("Hesabım"));
    }
}
