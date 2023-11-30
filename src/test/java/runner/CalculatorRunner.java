package runner;

import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import tests.TestBase;

import java.io.File;

@CucumberOptions(
        features="src/test/resources/features/Calculator.feature",
        glue = {"steps"},
        plugin = {"pretty",
                "html:Reports/platorun_cucumber_test_report.html",
                "json:Reports/platorun_cucumber_test_report.json",
                "junit:Reports/platorun_cucumber_test_report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = ("@AppiumAndroidTesting"))
public class CalculatorRunner extends TestBase {
}
