package org.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.HomePage;
import org.pages.SignupPopup;
import org.utils.WebDriverManager;

public class SignupSteps {

    private WebDriver driver;
    private HomePage homePage;
    private SignupPopup signupPopup;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
        homePage = new HomePage(driver);
        signupPopup = new SignupPopup(driver);
    }

    @Given("I am on the Demoblaze home page")
    public void iAmOnDemoblazeHomePage() {
        homePage.iGoToDemoblazeHomePage();
    }

    @When("I click on the signup menu")
    public void iClickOnTheSignupMenu() {
        homePage.iClickOnSignupMenu();
    }

    @Then("The signup popup is opened")
    public void signupPopupIsOpened() {
        signupPopup.signupTitleIsVisible();
    }

    @When("I sign up with a new random account")
    public void iSignUpWithANewRandomAccount() {
        signupPopup.iSignUpWithANewRandomAccount();
    }

    @When("I sign up with {string} and {string}")
    public void iSignUpWith(String username, String password) {
        signupPopup.iSignUpWithInvalidCredentials(username, password);
    }

    @Then("The user is signed up successfully")
    public void iAmSignedUpSuccessfully() {
        signupPopup.iAmSignedUpSuccessfully();
    }

    @Then("The user is not signed up successfully with {string} and {string} is displayed")
    public void theUserIsNotSignedUpSuccessfully(String invalidCredentials, String errorMessage) {
        switch (invalidCredentials) {
            case "an existing user":
                signupPopup.iSignedUpWithAnExistingAccount(errorMessage.trim());
                break;
            case "an empty username":
                signupPopup.iSignedUpWithAnEmptyUsernameOrPassword(errorMessage.trim());
                break;
            case "an empty password":
                signupPopup.iSignedUpWithAnEmptyUsernameOrPassword(errorMessage.trim());
                break;
            default:
                signupPopup.iAmNotSignedUpSuccessfully(errorMessage);
                break;
        }
    }

    @After
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
}