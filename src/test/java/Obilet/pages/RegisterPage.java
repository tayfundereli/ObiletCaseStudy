package Obilet.pages;

import Obilet.utils.Drivers;
import Obilet.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Drivers.get(), this);
    }

    @FindBy(className = "ob-auth-modal")
    public WebElement loginPopup;
    @FindBy(className = "login-to-register")
    public WebElement loginToRegisterBtn;
    @FindBy(className = "register-button")
    public WebElement registerBtn;

    public By emailField = By.name("email");
    public By passwordField = By.name("password");

    public void isLoginPopupPresent() {
        Assert.assertTrue(loginPopup.isDisplayed(),
                "Login Pop-up didn't appear!");
    }

    public void clickLoginToRegisterBtn() {
        loginToRegisterBtn.click();
    }

    public void fillLoginInfo(String email, String password) {
        Helpers.waitElementClickable(emailField).sendKeys(email);
        Helpers.waitFor(2);
        Helpers.waitElementClickable(passwordField).sendKeys(password);
    }

    public void clickRegisterBtn() {
        registerBtn.click();
    }
}
