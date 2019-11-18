package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/PurchaseSimulator.feature",
        glue = "stepDefinitions",
        tags ={"@Purchase-Simulator--UserStory01, @Add-First-Product-On-Cart, @Add-Second-Product-On-Cart, @Delete-Product"}
)

public class TestRunner {
}
