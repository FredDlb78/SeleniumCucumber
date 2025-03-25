package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{

    private WebDriver driver;

    @FindBy(id = "signin2")
    private WebElement signupMenu;

    @FindBy(id = "login2")
    private WebElement loginMenu;
    @FindBy(id = "nameofuser")
    private WebElement userMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void iGoToDemoblazeHomePage() {
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println("I go to the Demoblaze home page");
    }

    public void iClickOnSignupMenu() {
        signupMenu.click();
        System.out.println("I click on the signup menu");
    }

    public void iClickOnLoginMenu() {
        loginMenu.click();
        System.out.println("I click on the login menu");
    }

    public void iAmSuccessfullyLoggedIn(String username) {
        waitForElementToBeVisible(userMenu);
        assertEquals("Welcome " + username, userMenu.getText(), "The user is not logged in");
        System.out.println("I am successfully logged in");
    }
}