package tests;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AppiumDriver appiumDriver;
    public static WebDriver webDriver;
    public static Connection sqlConnection = null;

    public static void webSetup(String browserApp) {
        switch (browserApp) {
            case "MSEDGE":
                System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
                webDriver = new EdgeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }

    public static void mySQLSetup() {
        try {
            sqlConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world?user=root&password=$PQATesting2022");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void SQLServerSetup() {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String sqlConn = "jdbc:sqlserver://PQA-0551LT;encrypt=true;trustServerCertificate=true;databaseName=World;user=sa;password=$PQATesting2022";
            sqlConnection = DriverManager.getConnection(sqlConn);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void androidSetUp(String appPackage,
                                    String appActivity,
                                    String systemPort,
                                    String appiumPort,
                                    String deviceSerial)
            throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("udid", deviceSerial);
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("systemPort", systemPort);
        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:" + appiumPort + "/wd/hub"), caps);
    }

    public static void tearDown() throws InterruptedException, SQLException {
        if (appiumDriver != null){
            Thread.sleep(1000);
            appiumDriver.quit();
            appiumDriver = null;
        }
        if (webDriver != null){
            Thread.sleep(1000);
            webDriver.quit();
            webDriver = null;
        }
        if (sqlConnection != null) {
            Thread.sleep(1000);
            sqlConnection.close();
            sqlConnection = null;
        }
    }
}
