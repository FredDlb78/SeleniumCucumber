package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {
    private WebDriver driver;

    @FindBy(id = "signin2")
    private WebElement signupMenu;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void acceptAndVerifyAlertText(String expectedAlertText, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            if (!alertText.equals(expectedAlertText.trim())) {
                throw new IllegalStateException(errorMessage);
            }
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            throw new RuntimeException("No alert found or error occurred: " + e.getMessage(), e);
        }
    }

    public void assertEquals(String expectedResult, String actualResult, String errorMessage) {
        if (!expectedResult.equals(actualResult)) {
            throw new IllegalStateException(errorMessage + " (Expected: " + expectedResult + ", but was: " + actualResult + ")");
        }
    }
}