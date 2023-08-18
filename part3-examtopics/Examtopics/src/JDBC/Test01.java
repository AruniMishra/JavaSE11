package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {
}


class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try (var con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB",
                "root", "pass123");)
        {
            connection = con;
            var stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("INSERT INTO PERSON VALUES(101, 'John', '23')");
            stmt.close();
        }
        connection.close();
    }
}