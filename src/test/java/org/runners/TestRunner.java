package org.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Chemin vers les fichiers .feature
        glue = "src/test/java/org/stepdefinitions", // Assure-toi que glue pointe vers le bon package pour les step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Optionnel : Génération des rapports
)
public class TestRunner {
}
