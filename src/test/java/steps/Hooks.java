package steps;
/*
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
*/

//import com.aventstack.extentreports.service.ExtentTestManager;
//import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.TestBase;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    @After
    public static void tearDown(Scenario scenario) throws InterruptedException, IOException, SQLException, Throwable {

        //validate if scenario has failed
        if(scenario.isFailed()) {

/*
            //File-based method
            File file = ((TakesScreenshot) TestBase.webDriver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSS");
            String datetime = ft.format(dNow);
            String imagePath = System.getProperty("user.dir") + "\\Screenshots\\" + datetime + ".jpg";
            FileUtils.copyFile(file, new File(imagePath));
*/
            //Byte array method
            byte[] screenShot = null;
            if (TestBase.appiumDriver != null) {
                screenShot = ((TakesScreenshot) TestBase.appiumDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenShot, "image/png:base64", scenario.getName());
            }
            if (TestBase.webDriver != null) {
                screenShot = ((TakesScreenshot) TestBase.webDriver).getScreenshotAs(OutputType.BYTES);
                //scenario.attach(screenShot, "image/jpg:base64", scenario.getName());
                scenario.attach(screenShot, "image/png", scenario.getName());

                /* Using the avent stack extent report plugin */
                //String strScreenshot = ((TakesScreenshot) TestBase.webDriver).getScreenshotAs(OutputType.BASE64);
                //ExtentTestManager.getTest().addScreenCaptureFromBase64String(strScreenshot);

                /* Using the grasshopper cucumber 7 extent report plugin */
                /*
                File file = ((TakesScreenshot) TestBase.webDriver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(file);
                Date dNow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSS");
                String datetime = ft.format(dNow);
                String imagePath = System.getProperty("user.dir") + "\\Screenshots\\" + datetime + ".jpg";
                FileUtils.copyFile(file, new File(imagePath));
                */
                //scenario.attach(file, "image/jpg", scenario.getName());
            }
/*
            ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\platorun_extent_test_report.html");
            ExtentReports extentReports = new ExtentReports();
            extentReports.attachReporter(extentHtmlReporter);
            ExtentTest extentTest = extentReports.createTest("Web UI Demo");
            extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(file.getAbsolutePath()).build());
            extentTest.fail("<a href='"+ file.getAbsolutePath() + "'> <img src='"+ file.getAbsolutePath() + "' height='100' width='100'/> </a>");
            extentTest.addScreenCaptureFromPath(file.getAbsolutePath());
            Reporter.log("<a href='"+ file.getAbsolutePath() + "'> <img src='"+ file.getAbsolutePath() + "' height='100' width='100'/> </a>");
            extentReports.flush();
*/
        }
        TestBase.tearDown();
    }
}
