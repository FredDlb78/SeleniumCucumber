package org.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Chemin vers tes fichiers .feature
        glue = "org.stepdefinitions",              // Le package des définitions des étapes
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"}, // Rapport HTML
        monochrome = true
)
public class TestRunner {
}