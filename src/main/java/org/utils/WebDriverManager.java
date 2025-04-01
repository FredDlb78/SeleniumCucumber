package org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WebDriverException;

public class WebDriverManager {

    private static WebDriver driver;

    // Retourne une instance du WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                FirefoxOptions options = new FirefoxOptions();
                // Exécute Firefox en mode headless (sans interface graphique)
                options.setHeadless(true); // True pour le mode headless
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize(); // Maximiser la fenêtre, même en headless si nécessaire
            } catch (WebDriverException e) {
                System.out.println("Erreur lors de l'initialisation du WebDriver: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return driver;
    }

    // Ouvre la page d'accueil de Demoblaze
    public void iAmOnDemoblazeHomePage() {
        if (driver != null) {
            driver.get("https://www.demoblaze.com/index.html");
        } else {
            System.out.println("WebDriver n'est pas initialisé.");
        }
        System.out.println("Je vais sur la page d'accueil de Demoblaze.");
    }

    // Ferme le WebDriver
    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.quit(); // Ferme le navigateur et libère les ressources
            } catch (Exception e) {
                System.out.println("Erreur lors de la fermeture du WebDriver: " + e.getMessage());
            } finally {
                driver = null; // Réinitialise le WebDriver pour permettre une nouvelle initialisation
            }
        }
    }

    // Hook pour s'assurer que WebDriver est fermé (si nécessaire, utilisé dans un framework comme JUnit)
    @Override
    protected void finalize() throws Throwable {
        closeDriver(); // S'assure que le driver est fermé lorsque l'objet est détruit
        super.finalize();
    }
}