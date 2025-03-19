package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "signin2")
    private WebElement signupMenu;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void iClickOnSignupMenu() {
        signupMenu.click();
    }
}
