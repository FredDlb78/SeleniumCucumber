package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPopup extends AbstractPage {

    @FindBy(id = "loginusername")
    private WebElement usernameInput;
    @FindBy(id = "loginpassword")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    private WebElement loginButton;
    @FindBy(id = "logInModalLabel")
    private WebElement loginPopupTitle;

    public LoginPopup(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginTitleIsVisible() {
        waitForElementToBeVisible(loginPopupTitle);
        System.out.println("Login popup title is visible");
    }

    public void iLogInWith(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
        System.out.println("Logging in with: " + username + " / " + password);
    }
}