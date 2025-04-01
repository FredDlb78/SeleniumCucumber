package org.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Chemin des fichiers .feature
        glue = "org.stepdefinitions", // Package contenant les Step Definitions
        plugin = {
                "pretty", // Pour un affichage plus lisible dans la console
                "html:target/cucumber-reports/cucumber.html", // Génère un rapport HTML
                "json:target/cucumber-reports/cucumber.json", // Génère un rapport JSON pour l'intégration avec d'autres outils
                "io.qameta.allure.cucumber7jvm.AllureReporter" // Intégration avec Allure pour la génération de rapports visuels
        },
        monochrome = true // Rend la sortie console plus lisible
)
public class TestRunner {
}