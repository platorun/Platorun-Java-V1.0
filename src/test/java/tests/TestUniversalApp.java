package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestUniversalApp {
    public AndroidDriver driver;
    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("appPackage", "com.sherdle.universal");
        caps.setCapability("appActivity", ".MainActivity");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("deviceName", "Android Emulator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    private void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();
    }

    @Test
    public void testUniversalApp(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElementById("com.sherdle.universal:id/introduction_activity_button_next").click();
        driver.findElementById("com.sherdle.universal:id/introduction_activity_button_next").click();
        driver.findElementById("com.sherdle.universal:id/introduction_activity_button_next").click();
        driver.findElementById("com.sherdle.universal:id/privacy_accept_button").click();
        AndroidElement views =
                (AndroidElement) driver.findElement(By.id("com.sherdle.universal:id/list"));

        //Tap
        //actions = new AndroidTouchAction(driver);
        //actions.tap(ElementOption.element(views)).perform();

        //ScrollDown
        boolean found = false;
        while (!found){
            try {
                AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[contains(@text,'State of the Word 2022')]");
                found = element.isDisplayed();
            }
            catch(Exception e) {
            }

            if (!found)
                scrollDown();
        }
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'State of the Word 2022')]").click();

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        if (driver != null){
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
