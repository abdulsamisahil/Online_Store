package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnection
{
    private Connection connection;

    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String user = "onlinestore";
        String password = "project50";

        String dbURL = "jdbc:sqlserver://localhost";

        connection = DriverManager.getConnection(dbURL, user, password);
        if (connection != null)
        {
            System.out.println("Connected!");
            return connection;

        } else {
            System.out.println("Connection failed! ");
        }
        return null;
    }
}
