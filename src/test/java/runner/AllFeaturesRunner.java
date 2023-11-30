package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features= {"src/test/resources/features/GoogleMaps.feature",
                "src/test/resources/features/MySQLDatabase.feature",
                "src/test/resources/features/SQLServerDatabase.feature",
                "src/test/resources/features/CountryZipCodeAPI.feature",
                "src/test/resources/features/OnlineShopping.feature"},
        glue = {"steps"},
        plugin = {"pretty",
                "html:Reports/CucumberReport/platorun_cucumber_test_report.html",
                "json:Reports/CucumberReport/platorun_cucumber_test_report.json",
                "junit:Reports/CucumberReport/platorun_cucumber_test_report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })
public class AllFeaturesRunner extends TestBase {
}
