package cucumber.cucumber_test;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.managers.FileReaderManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\cucumber\\feature\\CheckOut.feature",
        glue = {"cucumber.step_definition"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true

)
public class TestRunner {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    }
}
