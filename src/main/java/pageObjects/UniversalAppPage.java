package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.text.DateFormatSymbols;

public class UniversalAppPage extends PageBase {

    public UniversalAppPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    String xPath;
    @AndroidFindBy(id = "com.sherdle.universal:id/introduction_activity_button_next")
    MobileElement step1;
    @AndroidFindBy(id = "com.sherdle.universal:id/introduction_activity_button_next")
    MobileElement step2;
    @AndroidFindBy(id = "com.sherdle.universal:id/introduction_activity_button_next")
    MobileElement step3;
    @AndroidFindBy(id = "com.sherdle.universal:id/privacy_accept_button")
    MobileElement step4;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Menu opened']")
    MobileElement step5;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[contains(@text,'Flickr')]")
    MobileElement step6;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'ALLOW')]")
    MobileElement step7;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement step8;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Settings')]")
    MobileElement step9;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'About')]")
    MobileElement step10;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'OK')]")
    MobileElement step11;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    MobileElement step12;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Menu opened']")
    MobileElement step13;
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[contains(@text,'Wordpress Blogs')]")
    MobileElement step14;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='View Mode']")
    MobileElement step15;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@index='1']")
    MobileElement step16;
    public void openUniversalApp() {
        clickMobile(step1);
        clickMobile(step2);
        clickMobile(step3);
        clickMobile(step4);
        clickMobile(step5);
        clickMobile(step6);
        clickMobile(step7);
        clickMobile(step8);
        clickMobile(step9);
        clickMobile(step10);
        clickMobile(step11);
        clickMobile(step12);
        clickMobile(step13);
        clickMobile(step14);
        clickMobile(step15);
        clickMobile(step16);
        ScrollPageUp("One Inbox to Rule Them All");
    }
    private void ScrollPageUp(String TargetElement) {
        AndroidElement views =
                (AndroidElement) appiumDriver.findElement(By.id("com.sherdle.universal:id/list"));

        //ScrollUp
        boolean found = false;
        while (!found){
            try {
                AndroidElement element = (AndroidElement) appiumDriver.findElementByXPath("//android.widget.TextView[contains(@text,'" + TargetElement + "')]");
                found = element.isDisplayed();
            }
            catch(Exception e) {
            }

            if (!found)
                scrollUp();
        }
        appiumDriver.findElementByXPath("//android.widget.TextView[contains(@text,'" + TargetElement + "')]").click();
    }
}
