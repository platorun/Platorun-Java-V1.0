package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FacebookAppPage;
import pageObjects.UniversalAppPage;
import tests.TestBase;

import java.net.MalformedURLException;
import java.sql.SQLException;

import static tests.TestBase.androidSetUp;
import static tests.TestBase.tearDown;

public class UniversalAppSteps {
    UniversalAppPage universalAppPage;
    @Given("I want to do exploratory testing on the Universal App")
    public void iWantToDoExploratoryTestingOnTheUniversalApp() throws MalformedURLException, Throwable {
        androidSetUp("com.sherdle.universal",".MainActivity","8200","4724","emulator-5554");
        universalAppPage = new UniversalAppPage(TestBase.appiumDriver);
        universalAppPage.openUniversalApp();
    }

    @When("I navigate to the menus and elements")
    public void iNavigateToTheMenusAndElements() throws Throwable {
    }

    @Then("The application should bring me to the page with ease")
    public void theApplicationShouldBringMeToThePageWithEase() throws InterruptedException, SQLException, Throwable {
        tearDown();
    }
}
