package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/CreatingLogCredential.feature",
        glue = "steps",
        dryRun = false,
        tags = "@positive_test",
        plugin = {"pretty"
                , "html:target/cucumber-html-reports/cucumber.html"
                , "json:target/cucumber-reports/cucumber.json"
                , "rerun:target/failed.txt"}

)


public class TestRunner {
}
