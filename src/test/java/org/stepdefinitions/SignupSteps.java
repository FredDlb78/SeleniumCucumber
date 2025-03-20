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
    private WebDriverManager webDriverManager;
    private HomePage homePage;
    private SignupPopup signupPopup;
    @Before
    public void setUp() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.initializeDriver();
        homePage = new HomePage(driver);
        signupPopup = new SignupPopup(driver);
    }

    @Given("I go to the Demoblaze home page")
    public void iGoToDemoblazeHomePage() {
        webDriverManager.iGoToDemoblazeHomePage();
    }

    @When("I click on the signup menu")
    public void iClickOnTheSignupMenu() {
        homePage.iClickOnSignupMenu();
    }

    @Then("The signup popup is opened")
    public void signupPopupIsOpened() {
        signupPopup.signupTitleIsVisible();
    }

    @Then("The user is signed up successfully")
    public void iAmSignedUpSuccessfully() {
        signupPopup.iAmSignedUpSuccessfully();
    }

    @After
    public void tearDown() {
        webDriverManager.closeDriver();
    }

    @When("^I sign up with (.*) and (.*)$")
    public void iSignUpWithUsernameAndPassword(String username, String password) {
        signupPopup.iSignUpWithUsernameAndPassword(username, password);
    }

}