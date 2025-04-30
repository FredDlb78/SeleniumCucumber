package org.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.ArticlePage;
import org.pages.CartPage;
import org.pages.HomePage;
import org.pages.LoginPopup;
import org.utils.WebDriverManager;

public class OrderSteps {

    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;
    private ArticlePage articlePage;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        articlePage = new ArticlePage(driver);

    }

    @When("I click on the Samsung galaxy s6")
    public void iClickOnTheSamsungGalaxyS6() {
        articlePage.iClickOnTheSamsungGalaxyS6();
    }

    @When("I click on the button {string}")
    public void iClickOnAddToCartButton() {
        throw new io.cucumber.java.PendingException();
    }

    @When("I confirm the popup")
    public void i_confirm_the_popup() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I click on the Cart menu")
    public void i_click_on_the_cart_menu() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I fill and confirm the form")
    public void i_fill_and_confirm_the_form() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("A popup is displayed to confirm the order")
    public void a_popup_is_displayed_to_confirm_the_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
