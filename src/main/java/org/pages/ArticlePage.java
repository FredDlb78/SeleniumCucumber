package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage extends AbstractPage {
    private WebDriver driver;

    public ArticlePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Samsung galaxy s6')]")
    private WebElement samsungGalaxyS6;

    public void iClickOnTheSamsungGalaxyS6() {
        samsungGalaxyS6.click();
        System.out.println("I click on the Samsung Galaxy S6");
    }

    public void articleIsAddedSuccessfully() {
        acceptAndVerifyAlertText("Product added", "Product is not added");
        System.out.println("The article is added successfully");
    }
}
