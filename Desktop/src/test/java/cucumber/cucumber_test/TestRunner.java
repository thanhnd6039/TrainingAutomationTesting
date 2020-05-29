package cucumber.cucumber_test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\cucumber\\feature\\CheckOut.feature",
        glue = {"cucumber.step_definition"}
)
public class TestRunner {
}
