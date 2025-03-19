package org.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.utils.WebDriverManager;
import org.pages.HomePage;

public class SignupSteps {

    private WebDriver driver;
    private WebDriverManager webDriverManager;
    HomePage homePage = new HomePage(driver);

    @Before
    public void setUp() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.initializeDriver();
    }

    @Given("I go to the Demoblaze home page")
    public void iGoToDemoblazeHomePage() {
        webDriverManager.iGoToDemoblazeHomePage();
    }

    @When("I click on the signup menu")
    public void iClickOnTheSignupMenu() {
        homePage.iClickOnSignupMenu();
    }
}
