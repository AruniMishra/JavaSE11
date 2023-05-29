/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 15: Database Applications with JDBC
Topic:  Database URLs and DriverManager
*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionExamples {
    /*
    1. docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=pass123 -dp 3306:3306 --rm mysql
    2. sudo mysql -h 127.0.0.1 -P 3306 -u root -p
    3. CREATE DATABASE testDB;
    4. Intellij: project settings>Libraries>add Maven>mysql:mysql-connector-java:8.0.30
     */
    // A MySql database named testone, needs to exist.
    static String mySqlConnectionString =
            "jdbc:mysql://localhost:3306/testDB";

    // derby database will get created in current working directory
    static String derbyFileConnectionString =
            "jdbc:derby:db/derby/DatabaseDemo;create=true";

    // in memory derby database
    static String derbyMemoryConnectionString =
            "jdbc:derby:memory:DatabaseDemo;create=true";

    // SQLite connection, DatabaseDemo.db will get created
    static String sqliteConnectionString =
            "jdbc:sqlite:db\\sqlite\\DatabaseDemo.db";

    public static void main(String[] args) throws SQLException {

        // Wrap connection in a try-with-resources, so connection
        // automatically closed
        try (Connection connection = getConnection(mySqlConnectionString)) {
            // Example of DDL - add a table
            // createTable(connection);

            // Example of DDL - cleanup
            dropTable(connection);
        }
        System.out.println("Success!");

    }

    // Test multiple types of connections
    public static Connection getConnection(String connectionString)
            throws SQLException {

        Connection c;

        // Prior to JDBC 4.0 (Java 6), code required to for classloader to
        // to load driver class, using Class.forName. Code does nothing here,
        // but exam may test you on it, note, exception may occur if no derby.
        try {

            // Class.forName("org.apache.derby.iapi.jdbc.InternalDriver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (connectionString.indexOf("mysql") > -1) {

            // Adding additional properties - you would not
            // really put database username/password in code
            String username = "root";
            String password = "pass123";

            // Create a properties object and set properties.
            Properties properties = new Properties();

            // Note that "user" and "password" are the standard keys.
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            c = DriverManager.getConnection(connectionString, properties);

            // Alternate method, would not actually invoke both versions
            // Here as an example.
            c = DriverManager.getConnection(connectionString,
                    username, password);
        } else {
            if (connectionString.indexOf("sqlite") > -1) {
                // Derby creates directories, sqlite does not.
                Path p = Paths.get(connectionString.split(":")[2]);
                try {
                    Files.createDirectories(p.getParent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            c = DriverManager.getConnection(connectionString);
        }

        return c;
    }

    // Create a table in the current database schema
    public static void createTable(Connection connection)
            throws SQLException {

        String createSQL =
                "create table " +
                        "PERSON " +
                        "(PERSON_ID INTEGER NOT NULL, " +
                        "NAME varchar(255) NOT NULL," +
                        "AGE INTEGER NOT NULL, " +
                        "PRIMARY KEY (PERSON_ID))";

        try (Statement stmt = connection.createStatement()) {

            System.out.println(stmt.execute(createSQL));

        }

    }

    // Drop a table in the current database schema
    public static void dropTable(Connection connection)
            throws SQLException {

        String dropSQL =
                "drop table PERSON ";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(dropSQL);
        }
    }
}
