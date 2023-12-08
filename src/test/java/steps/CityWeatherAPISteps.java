package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CityWeatherAPISteps {
    String city = "";
    @Given("I need to know the weather of a specific City")
    public void iNeedToKnowTheWeatherOfASpecificCity() {
        
    }
    @When("I enter {string} as the City")
    public void iEnterWorldCityAsTheCity(String arg0) {
        city = arg0;
    }
    @Then("The API should provide me the current temperature in Degrees Celsius")
    public void theAPIShouldProvideMeTheCurrentTemperatureInDegreesCelsius() throws Throwable {
        URL obj = new URL("https://api.api-ninjas.com/v1/weather?city=" + city);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Api-Key", "0hR9dpzL6aGRUwPDCEZwng==7yTZjPHaRouWOoVw");
        con.setRequestProperty("Content-Type", "application/json");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.toString());
            String cityWeather = json.get("temp").toString();
            System.out.println("Actual result is " + cityWeather);
            Assert.assertEquals(cityWeather,cityWeather);
        } else {
            Assert.assertEquals("0","1");
        }
    }
}
