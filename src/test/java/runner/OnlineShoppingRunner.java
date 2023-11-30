package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features = "src/test/resources/features/OnlineShopping.feature",
        glue = {"steps"},
        plugin = {"pretty",
                "html:Reports/CucumberReport/platorun_cucumber_test_report.html",
                "json:Reports/CucumberReport/platorun_cucumber_test_report.json",
                "junit:Reports/CucumberReport/platorun_cucumber_test_report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = ("@SeleniumWebTesting"))
public class OnlineShoppingRunner extends TestBase {
}
