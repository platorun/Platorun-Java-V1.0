package pageObjects;
import junit.framework.Assert;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQLDatabaseAppPage extends PageBase {

    public MySQLDatabaseAppPage(Connection connection) { super(connection); }

    Statement statement = null;
    ResultSet resultSet =null;
    List<String> allCities;
    String worldCountry;

    public void retrieveCitiesByCountry(String country) throws SQLException {
        worldCountry = country;
        allCities = new ArrayList<>();
        allCities = executeSQLStatement("SELECT Name FROM world.city WHERE CountryCode = " +
                "(SELECT Code FROM world.country WHERE Name = '" + country + "')");
    }

    public void showAlltheCities() {
        System.out.println("There are " + allCities.size() + " Cities in " + worldCountry);
        Assert.assertEquals(allCities.size(),allCities.size());
    }
}
