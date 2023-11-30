package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features="src/test/resources/features/Facebook.feature",
        glue = {"steps"},
        plugin = {"pretty",
                "html:Reports/platorun_cucumber_test_report.html",
                "json:Reports/platorun_cucumber_test_report.json",
                "junit:Reports/platorun_cucumber_test_report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = ("@AppiumAndroidTesting"))
public class FacebookRunner extends TestBase {
}
