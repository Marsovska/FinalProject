package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/CreatingLogCredential.feature",
        glue = "steps",
        dryRun =false,
        plugin = {"pretty","html:target/project.html"},
        tags = "@positive_test"
)




public class TestRunner {
}
