package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import org.apache.http.HttpStatus;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CountryZipCodes extends TestBase {
    @DataProvider(name = "Country Zip Codes")
    public static Object[][] countryZipCodes() throws IOException, ParseException {
        Object[][] obj = JsonReader.getJSONScript
                (System.getProperty("user.dir") + "/data/CountryZipCodesData.json",
                        "Country Zip Codes", 3);
        return (String[][]) obj;
    }
    @Test(dataProvider = "Country Zip Codes")
    public void requestZipCodePlace(String countryCode, String zipCode, String placeName) {
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
        System.out.println("Country is " + country + "\n" +
                "Zip Code is " + zipCode + "\n" +
                "Place Name is " + place);
        Assert.assertEquals(place,placeName);
    }
}
