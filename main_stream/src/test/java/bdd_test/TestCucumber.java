package bdd_test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"bdd_test"},
        plugin = { "pretty", "html:target/cucumber-reports/report.html" },
        publish = true)


public class TestCucumber extends SpringIntegrationTest {
}


