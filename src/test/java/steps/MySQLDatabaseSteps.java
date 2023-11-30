package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MySQLDatabaseAppPage;
import tests.TestBase;

import java.sql.SQLException;

public class MySQLDatabaseSteps {
    MySQLDatabaseAppPage mySQLDatabaseAppPage;
    @When("I enter {string} as parameter")
    public void iEnterACountryAsParameter(String arg0) throws Throwable {
        mySQLDatabaseAppPage.retrieveCitiesByCountry(arg0);
    }

    @Given("I need to see all cities in a particular country")
    public void iNeedToSeeAllCitiesInAParticularCountry() throws Throwable {
        TestBase.mySQLSetup();
        mySQLDatabaseAppPage = new MySQLDatabaseAppPage(TestBase.sqlConnection);
    }

    @Then("It should return all cities in that country")
    public void itShouldReturnAllCitiesInThatCountry() throws SQLException, InterruptedException, Throwable {
        TestBase.tearDown();
        mySQLDatabaseAppPage.showAlltheCities();
    }
}
