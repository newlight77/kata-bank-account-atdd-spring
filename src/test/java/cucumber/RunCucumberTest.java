package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
            "pretty",
            "json:target/cucumber/cucumber.json",
            "json:build/cucumber/cucumber.json",
            "de.monochromata.cucumber.report.PrettyReports:build/cucumber",
            "de.monochromata.cucumber.report.PrettyReports:target/cucumber"
    },
    features = {
            "features"
    },
    glue = {
        "cucumber/stepdefs",
        "cucumber/config"
    }
)
public class RunCucumberTest {
}