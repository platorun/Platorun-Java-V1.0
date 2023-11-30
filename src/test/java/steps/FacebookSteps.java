package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CalculatorAppPage;
import pageObjects.FacebookAppPage;
import tests.TestBase;

import java.net.MalformedURLException;
import java.sql.SQLException;

import static tests.TestBase.androidSetUp;
import static tests.TestBase.tearDown;

public class FacebookSteps {
    FacebookAppPage facebookAppPage;
    @Given("I want to create a new Facebook account")
    public void iWantToCreateANewFacebookAccount() throws MalformedURLException, Throwable {
        androidSetUp("com.facebook.katana",".LoginActivity","8200","4723","emulator-5554");
        facebookAppPage = new FacebookAppPage(TestBase.appiumDriver);
        facebookAppPage.openFacebook();
    }

    @And("I enter {string} as First Name")
    public void iEnterAFirstName(String arg0) throws Throwable {
        facebookAppPage.firstName = arg0;
        facebookAppPage.enterFirstName();
    }

    @And("I enter {string} as Last Name")
    public void iEnterALastName(String arg0) throws Throwable {
        facebookAppPage.lastName = arg0;
        facebookAppPage.enterLastName();
    }

    @And("I enter {string} as Birthday")
    public void iEnterABirthday(String arg0) throws Throwable {
        facebookAppPage.birthDate = arg0;
        facebookAppPage.enterBirthDate();
    }

    @And("I enter {string} as Gender")
    public void iEnterAGender(String arg0) throws Throwable {

        facebookAppPage.gender = arg0;
        facebookAppPage.selectGender();
    }

    @And("I enter {string} as Mobile Number")
    public void iEnterAMobileNumber(String arg0) throws Throwable {

        facebookAppPage.mobileNumber = arg0;
        facebookAppPage.enterMobileNumber();
    }

    @And("I enter {string} as Password")
    public void iEnterAPassword(String arg0) throws Throwable {

        facebookAppPage.password = arg0;
        facebookAppPage.enterPassword();
    }
    @When("I submit all information required")
    public void iSubmitAllInformationRequired() throws Throwable {
    }

    @Then("The application should create a Facebook account for me")
    public void theApplicationShouldCreateAFacebookAccountForMe() throws InterruptedException, SQLException, Throwable {
        tearDown();
    }
}
