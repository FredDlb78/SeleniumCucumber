package org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.HomePage;
import org.pages.LoginPopup;
import org.utils.WebDriverManager;

public class LoginSteps {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPopup loginPopup;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
        homePage = new HomePage(driver);
        loginPopup = new LoginPopup(driver);
    }

    @When("I click on the login menu")
    public void iClickOnTheLoginMenu() {
        homePage.iClickOnLoginMenu();
    }

    @Then("The login popup is opened")
    public void loginPopupIsOpened() {
        loginPopup.loginTitleIsVisible();
    }

    @When("I log in with {string} and {string}")
    public void iLogInWith(String username, String password) {
        loginPopup.iLogInWith(username, password);
    }

    @Then("The user is logged successfully with {string}")
    public void iAmLoggedInSuccessfully(String username) {
        homePage.iAmSuccessfullyLoggedIn(username);
    }

    @After
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
}