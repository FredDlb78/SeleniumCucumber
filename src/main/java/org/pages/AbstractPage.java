package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class AbstractPage {
    private WebDriver driver;

    @FindBy(id = "signin2")
    private WebElement signupMenu;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptAndVerifyAlertText(String expectedAlertText, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (!alertText.equals(expectedAlertText)) {
                throw new AssertionError(errorMessage);
            }
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assert.fail("No alert found or error occurred: " + e.getMessage());  // Utilisation de Assert.fail() de JUnit 4
        }
    }

    public void assertEquals(String expectedResult, String actualResult, String errorMessage) {
        try {
            if (!expectedResult.equals(actualResult)) {
                throw new AssertionError(errorMessage);
            }
        } catch (Exception e) {
            Assert.fail("Wrong result: " + e.getMessage());  // Utilisation de Assert.fail() de JUnit 4
        }
    }
}
