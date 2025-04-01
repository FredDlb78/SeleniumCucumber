package org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Détection de l'environnement (local ou CI)
            boolean isCI = System.getenv("GITHUB_ACTIONS") != null;

            if (isCI) {
                // Mode headless obligatoire sur GitHub Actions
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless"); // Exécution sans interface graphique
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(options);
            } else {
                // Mode normal en local
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
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