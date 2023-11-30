package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CountryZipCodeAPISteps {
    String API_URL = "";
    String countryCode = "";
    String zipCode = "";
    String placeName = "";
    @When("I enter {string} as country code")
    public void iEnterACountryCode(String arg0) throws Throwable {
        countryCode = arg0;
    }

    @Given("I need to know the name of a place by country and zip code")
    public void iNeedToKnowTheNameOfAPlaceByCountryAndZipCode() throws Throwable {
        
    }

    @And("I enter {string} as zip code")
    public void iEnterAZipCode(String arg0) throws Throwable {
        zipCode = arg0;
    }

    @Then("The API should provide me the exact place as {string}")
    public void theAPIShouldProvideMeTheExactNameOfThePlace(String arg0) throws Throwable {
        placeName = arg0;
        ExtractableResponse response = given().
                pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String place = jsonPathEvaluator.get("places[0].'place name'");
        String country = jsonPathEvaluator.get("country");
        /*
        System.out.println("Country is " + country + "\n" +
                "Zip Code is " + zipCode + "\n" +
                "Place Name is " + place);
         */
        System.out.println("Actual result is " + place);
        Assert.assertEquals(place,placeName);
    }
}
