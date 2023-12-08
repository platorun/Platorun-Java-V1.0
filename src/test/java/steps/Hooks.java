package steps;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.TestBase;

import java.io.IOException;
import java.sql.SQLException;

public class Hooks {
    @After
    public static void tearDown(Scenario scenario) throws InterruptedException, IOException, SQLException, Throwable {

        //Validate if scenario has failed. If so, take a screenshot of the page where the test execution has failed.
        if(scenario.isFailed()) {
            byte[] screenShot = null;
            if (TestBase.appiumDriver != null) {
                screenShot = ((TakesScreenshot) TestBase.appiumDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenShot, "image/png:base64", scenario.getName());
            }
            if (TestBase.webDriver != null) {
                screenShot = ((TakesScreenshot) TestBase.webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenShot, "image/png", scenario.getName());
            }
        }
        TestBase.tearDown();
    }
}
