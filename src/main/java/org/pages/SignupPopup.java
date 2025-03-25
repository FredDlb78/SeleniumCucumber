package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.AccountFactory;

import static org.junit.Assert.assertTrue;

public class SignupPopup extends AbstractPage {

    private WebDriver driver;

    @FindBy(id = "sign-username")
    private WebElement usernameInput;
    @FindBy(id = "sign-password")
    private WebElement passwordInput;
    @FindBy(css = "button[onclick='register()']")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@id='signInModal']//div[@class='modal-content']//span[contains(text(), '×')]")
    private WebElement crossButton;
    @FindBy(xpath = "//div[@id='signInModal']//button[contains(text(), 'Close')]")
    private WebElement closeButton;
    @FindBy(id = "signInModalLabel")
    private WebElement signUpPopupTitle;

    public SignupPopup(WebDriver driver) {
        super(driver);
        this.driver = driver;
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

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void iSignUpWithANewRandomAccount() {
        AccountFactory.newAccount();

        String username = AccountFactory.getUsername();
        String password = AccountFactory.getPassword();

        setUsername(username);
        setPassword(password);
        clickSignUpButton();
        System.out.println("Signing up with: " + username + " / " + password);
    }

    public void iSignUpWithInvalidCredentials(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
        System.out.println("Signing up with: " + username + " / " + password);
    }

    public void signupTitleIsVisible() {
        waitForElementToBeVisible(signUpPopupTitle);
        assertTrue("Signup popup title should be visible", signUpPopupTitle.isDisplayed());
        System.out.println("Signup popup is opened");
    }

    public void iAmSignedUpSuccessfully() {
        acceptAndVerifyAlertText("Sign up successful.", "Sign up failed");
        System.out.println("I am signed up successfully");
    }

    public void iAmNotSignedUpSuccessfully(String errorMessage) {
        acceptAndVerifyAlertText(errorMessage, "Sign up failed");
        System.out.println("I am not signed up successfully");
    }

    public void iSignedUpWithAnExistingAccount(String errorMessage) {
        acceptAndVerifyAlertText(errorMessage, "Sign up failed");
        System.out.println("I signed up with an existing account");
    }

    public void iSignedUpWithAnEmptyUsernameOrPassword(String errorMessage) {
        acceptAndVerifyAlertText(errorMessage, "Sign up failed");
        System.out.println("I signed up with an empty username or password");
    }
}