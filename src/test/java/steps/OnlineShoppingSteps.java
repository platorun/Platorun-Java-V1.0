package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OnlineShoppingAppPage;
import tests.TestBase;

import java.sql.SQLException;

public class OnlineShoppingSteps extends TestBase {
    OnlineShoppingAppPage onlineShoppingAppPage;
    @And("I add {string} to my cart")
    public void iAddTheItemToMyCart(String arg0) throws Throwable {
        onlineShoppingAppPage.addItemsToCart(arg0);
    }

    @And("I checkout and fill in my {string}, {string}, {string} shipping details")
    public void iCheckoutAndFillInMyShippingDetails(String arg0, String arg1, String arg2) throws Throwable{
        onlineShoppingAppPage.checkOutAndFillShippingInformation(arg0, arg1, arg2);
    }
    @When("I continue and click Finish")
    public void iContinueAndClickFinish() throws InterruptedException, SQLException, Throwable {
        onlineShoppingAppPage.completeTransaction();
    }
    @And("I login with my {string} and {string} credentials")
    public void iLoginWithMyUsernameAndPasswordCredentials(String arg0, String arg1) throws Throwable {
        onlineShoppingAppPage.performLogin(arg0, arg1);
    }

    @Then("A confirmation message {string} should be displayed on the screen")
    public void aConfirmationMessageShouldBeDisplayedOnTheScreen(String arg0) throws SQLException, InterruptedException, Throwable {
        onlineShoppingAppPage.verifyConfirmationMessage(arg0);
        tearDown();
    }

    @Given("I want to purchase items online using Google Chrome")
    public void iWantToPurchaseItemsOnlineUsingGoogleChrome() {
        webSetup("CHROME");
        onlineShoppingAppPage = new OnlineShoppingAppPage(TestBase.webDriver);
    }
    @Given("I want to purchase items online using Microsoft Edge")
    public void iWantToPurchaseItemsOnlineUsingMicrosoftEdge() {
        webSetup("MSEDGE");
        onlineShoppingAppPage = new OnlineShoppingAppPage(TestBase.webDriver);
    }
    @Given("I want to purchase items online using Mozilla Firefox")
    public void iWantToPurchaseItemsOnlineUsingMozillaFirefox() {
        webSetup("FIREFOX");
        onlineShoppingAppPage = new OnlineShoppingAppPage(TestBase.webDriver);
    }
}
