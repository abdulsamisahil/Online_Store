package Code;

import java.sql.*;

public class SQLTest
{
    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String user = "onlinestore";
        String password = "Inshallah123";

        String dbURL = "jdbc:sqlserver://localhost";

        Connection conn = DriverManager.getConnection(dbURL, user, password);
        if (conn != null)
        {
            System.out.println("Connected!");
            return conn;
        }
        return null;
    }
    void testSelectQuery() throws SQLException, ClassNotFoundException {
        Connection conn = connect();
        Statement stm = conn.createStatement();
        String query = "Select * from School.dbo.department";
        ResultSet resultSet = stm.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }
    }

    public static void main(String[] args) {
        SQLTest sql = new SQLTest();
        try {
            sql.testSelectQuery();
        }catch (Exception e ){

        }
    }
}
