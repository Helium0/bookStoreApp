package mysql;

import java.sql.*;

public class MySQLConnector {

    private final String url = "jdbc:mysql://localhost:3307/bookstoreapp-db-1";
    private final String user = "root";
    private final String password = "";


    private Connection dataBaseConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    private Statement statementSetup() throws SQLException {
        return dataBaseConnection().createStatement();
    }

    public ResultSet resultSet(String executeCommand) throws SQLException {
        return statementSetup().executeQuery(executeCommand);
    }

}
