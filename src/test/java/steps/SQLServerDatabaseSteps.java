package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SQLServerDatabaseAppPage;
import tests.TestBase;

import java.sql.SQLException;

public class SQLServerDatabaseSteps {
    SQLServerDatabaseAppPage sqlServerDatabaseAppPage;
    @Given("I need to see all SQLServer cities in a particular country")
    public void iNeedToSeeAllSQLServerCitiesInAParticularCountry() {
        TestBase.SQLServerSetup();
        sqlServerDatabaseAppPage = new SQLServerDatabaseAppPage(TestBase.sqlConnection);
    }

    @When("I enter {string} as SQLServer parameter")
    public void iEnterACountryAsSQLServerParameter(String arg0) throws SQLException {
        sqlServerDatabaseAppPage.retrieveCitiesByCountry(arg0);
    }

    @Then("It should return SQLServer cities in that country")
    public void itShouldReturnSQLServerCitiesInThatCountry() throws SQLException, InterruptedException {
        TestBase.tearDown();
        sqlServerDatabaseAppPage.showAlltheCities();
    }
}
