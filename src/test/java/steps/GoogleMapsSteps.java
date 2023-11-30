package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GoogleMapsAppPage;
import tests.TestBase;

import java.net.MalformedURLException;
import java.sql.SQLException;

import static tests.TestBase.androidSetUp;

public class GoogleMapsSteps extends TestBase {
    GoogleMapsAppPage googleMapsAppPage;
    @Given("The user search {string} in Google Maps")
    public void theUserSearchADestinationInGoogleMaps(String arg0) throws MalformedURLException, Throwable {
        androidSetUp("com.google.android.apps.maps","com.google.android.maps.MapsActivity","8200","4723","emulator-5554");
        googleMapsAppPage = new GoogleMapsAppPage(TestBase.appiumDriver);
        googleMapsAppPage.openGoogleMaps();
        googleMapsAppPage.enterDestination(arg0);
    }

    @When("The user enters {string} in the map")
    public void theUserEntersStartLocationInTheMap(String arg0) throws Throwable {

        googleMapsAppPage.enterStartLocation(arg0);
    }

    @Then("Google Maps should start navigating from {string} to {string}")
    public void googleMapsShouldStartNavigatingFromStartLocationToDestination(String arg0, String arg1) throws InterruptedException, SQLException, Throwable {
        googleMapsAppPage.startNavigation();
        tearDown();
    }
}
