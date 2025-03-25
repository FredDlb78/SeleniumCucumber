package org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
/*            String chromeDriverPath = System.getProperty("webdriver.chrome.driver", "/Users/freddelabre/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);*/
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void iAmOnDemoblazeHomePage() {
        if (driver != null) {
            driver.get("https://www.demoblaze.com/index.html");
        } else {
            System.out.println("WebDriver n'est pas initialisé.");
        }
        System.out.println("I go to the Demoblaze home page");
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}