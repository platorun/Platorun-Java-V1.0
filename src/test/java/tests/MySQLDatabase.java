package tests;

import java.sql.*;
import java.util.List;

public class MySQLDatabase {

    Connection sqlConnection = null;
    Statement statement = null;
    ResultSet resultSet =null;
    List<String> resultList;

    public void connectAndExecute() {
        try {
            sqlConnection = DriverManager.getConnection("jdbc:mysql://{SERVER_NAME}:{PORT_NUMBER}/{SCHEMA}?user={USER}&password={PWD}");
            statement = sqlConnection.createStatement();
            if (statement.execute("SELECT * FROM {TABLE_FROM_MY_SCHEMA}")) {
                resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    resultList.add(resultSet.getString(1));
                }
                /* Add further resultList manipulation here */
            }
        } catch (SQLException ex) {
            System.out.println("MySQLException: " + ex.getMessage());
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) { }
                resultSet = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) { }
                statement = null;
            }
            if (sqlConnection != null) {
                try {
                    sqlConnection.close();
                } catch (SQLException sqlEx) { }
                sqlConnection = null;
            }
        }
    }
}
