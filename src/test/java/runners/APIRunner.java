package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/APIUserCreation.feature",
        glue = "APISteps",
        dryRun = false,
        tags = "",
        plugin = {"pretty", "html:target/cucumber.html", "rerun:target/failed.txt",
                "json:target/cucumber-reports/cucumber.json"}

)


public class APIRunner {

}
