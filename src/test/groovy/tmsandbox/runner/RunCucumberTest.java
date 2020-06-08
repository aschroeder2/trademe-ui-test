package tmsandbox.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "html:build/reports/html",
                "junit:build/reports/cucumber-results.xml"
        },
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"tmsandbox", "stepdefs"}
)

public class RunCucumberTest {
}
