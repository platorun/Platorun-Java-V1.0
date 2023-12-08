package pageObjects;

import junit.framework.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLServerDatabaseAppPage extends PageBase {

    public SQLServerDatabaseAppPage(Connection connection) { super(connection); }

    Statement statement = null;
    ResultSet resultSet =null;
    List<String> allCities;
    String worldCountry;

    public void retrieveCitiesByCountry(String country) throws SQLException {
        worldCountry = country;
        allCities = new ArrayList<>();

        /* Use this code for direct SQL statement
        allCities = executeSQLStatement("SELECT Name FROM city WHERE CountryCode = " +
                "(SELECT Code FROM country WHERE Name = '" + country + "')");
        */

        //This code uses Stored Procedure Call
        allCities = executeStoredProcedure("SP_Platorun_1", country);
    }

    public void showAlltheCities() {
        System.out.println("There are " + allCities.size() + " Cities in " + worldCountry);
        Assert.assertEquals(allCities.size(),allCities.size());
    }
}
