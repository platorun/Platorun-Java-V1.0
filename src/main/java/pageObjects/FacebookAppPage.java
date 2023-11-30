package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.text.DateFormatSymbols;

public class FacebookAppPage extends PageBase {

    public FacebookAppPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    public String firstName;
    public String lastName;
    /* yyyy-mm-dd */
    public String birthDate;
    public String gender;
    public String mobileNumber;
    public String password;
    String xPath;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'NONE OF THE ABOVE')]")
    MobileElement popupSkip;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Create new Facebook account']")
    MobileElement newAccount;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Next')]")
    MobileElement popupNext;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    MobileElement popupAllow;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'NONE OF THE ABOVE')]")
    MobileElement popupNone;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'First Name')]")
    MobileElement elementFirstName;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Last Name')]")
    MobileElement elementLastName;
    @AndroidFindBy(xpath = "//android.widget.NumberPicker[@index='2']//android.widget.EditText")
    MobileElement dtPickerYear;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@text,'Male')]")
    MobileElement chkBoxMale;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@text,'Female')]")
    MobileElement chkBoxFemale;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Mobile number')]")
    MobileElement elementMobileNumber;
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Password')]")
    MobileElement elementPassword;
    public void openFacebook() {
        clickMobile(popupSkip);
        clickMobile(newAccount);
        clickMobile(popupNext);
        clickMobile(popupAllow);
        clickMobile(popupAllow);
        clickMobile(popupNone);
    }
    public void enterFirstName() {
        sendText(elementFirstName, firstName);
    }
    public void enterLastName() {
        sendText(elementLastName, lastName);
        clickMobile(popupNext);
    }
    public void enterBirthDate() {
        sendTextDTPickerByXPath(
                "//android.widget.NumberPicker[@index='2']//android.widget.EditText",
                birthDate.substring(0,4));
        String strMonth = new DateFormatSymbols().getMonths()[Integer.parseInt(birthDate.substring(5,7))-1];
        sendTextDTPickerByXPath(
                "//android.widget.NumberPicker[@index='0']//android.widget.EditText",
                strMonth.substring(0,3));
        sendTextDTPickerByXPath(
                "//android.widget.NumberPicker[@index='1']//android.widget.EditText",
                birthDate.substring(8,10));
        clickMobile(popupNext);
    }
    public void selectGender() {
        switch (gender) {
            case "Male":
                clickMobile(chkBoxMale);
                break;
            case "Female":
                clickMobile(chkBoxFemale);
                break;
        }
        clickMobile(popupNext);
    }
    public void enterMobileNumber() {
        sendText(elementMobileNumber, mobileNumber);
        clickMobile(popupNext);
    }
    public void enterPassword() {
        sendText(elementPassword, password);
        clickMobile(popupNext);
    }
}
