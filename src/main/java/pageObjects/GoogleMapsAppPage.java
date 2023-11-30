package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GoogleMapsAppPage extends PageBase {

    public GoogleMapsAppPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    String xPath;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'SKIP')]")
    MobileElement popupSkip;
    @AndroidFindBy(id = "search_omnibox_text_box")
    MobileElement searchBox;
    @AndroidFindBy(id = "search_omnibox_edit_text")
    MobileElement editBox;


    public void openGoogleMaps() {
        clickMobile(popupSkip);
        clickMobile(searchBox);
    }

    public void enterDestination(String strLocation) {
        sendText(editBox, strLocation);
        //xPath = "//android.widget.TextView[matches(@text,'" + strLocation + "','i')]";
        xPath = "//android.widget.TextView[@text,'" + strLocation + "']";
        clickByXPath(xPath);
        xPath = "//android.widget.Button[@text,'Directions']";
        clickByXPath(xPath);
    }
    public void enterStartLocation(String startLocation) {
        if (startLocation.trim().toUpperCase().compareTo("YOUR LOCATION") == 0) {
            xPath = "//android.widget.TextView[@text,'Choose start location']";
            clickByXPath(xPath);
            xPath = "//android.widget.TextView[@text,'Your location']";
            clickByXPath(xPath);
        } else {
            xPath = "//android.widget.TextView[@text,'Choose start location']";
            clickByXPath(xPath);
            //xPath = "//android.widget.EditText[@text,'" + startLocation + "']";
            sendTextByXPath(xPath, startLocation);
        }

        xPath = "//android.widget.Button[contains(@text,'ALLOW')]";
        clickByXPath(xPath);
        xPath = "//android.widget.Button[contains(@text,'OK')]";
        clickByXPath(xPath);
        clickByID("permission_allow_foreground_only_button");
    }
    public void startNavigation(){
        clickByID("start_button");
        xPath = "//android.widget.Button[contains(@text,'GOT IT')]";
        clickByXPath(xPath);
        clickByID("dialog_positive_button");
        xPath = "//android.widget.TextView[contains(@text,'Continue')]";
        clickByXPath(xPath);
    }
}
