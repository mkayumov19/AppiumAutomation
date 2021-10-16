package com.myCompany.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/myCompany/automation/step_definitions",
        dryRun = false,
        tags = "@search_results",
        plugin = {
                "json:target/cucumber.json"
        }
     )

public class CukesRunner {
}
