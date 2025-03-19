package org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    private WebDriver driver;

    public WebDriver initializeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/Users/freddelabre/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void iGoToDemoblazeHomePage() {
        if (driver != null) {
            driver.get("https://www.demoblaze.com/index.html");
        } else {
            System.out.println("WebDriver n'est pas initialisé.");
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
