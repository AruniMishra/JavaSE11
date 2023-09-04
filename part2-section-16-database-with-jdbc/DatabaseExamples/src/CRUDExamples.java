/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 15: Database Applications with JDBC
Topic:  CRUD operations
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CRUDExamples {

    public static void main(String[] args) throws SQLException {

        // Wrap connection in a try-with-resources,
        // so connection automatically gets closed
        try (Connection connection =
                     ConnectionExamples.getConnection(
                             ConnectionExamples.mySqlConnectionString)) {
            // Example of DDL -
            ConnectionExamples.createTable(connection);

            // Example of DML - create data
            addData(connection);

            addDataPreparedStatement(connection);

            addDataPreparedStatementMultiple(connection);

            // Example of DML - get (read) data
            getData(connection);

            // Example of DML - update data
            updateData(connection, "April", 21);

            // Example of DML - delete data
            deleteData(connection, 104);

            // Example of DML - get (read) data
            getData(connection);


            // Example of DML - get (read) data
            getPersonList(connection).forEach(System.out::println);

            // Example of DML - get (read) data
            getData(connection);

            ConnectionExamples.dropTable(connection);

        }
    }

    // insert a row of data into table
    public static void addData(Connection connection)
            throws SQLException {

        String insertSQL =
                "insert into PERSON (PERSON_ID, NAME, AGE) " +
                        "Values(101, 'JOE', 3)";

        try (Statement stmt = connection.createStatement()) {
            System.out.println("records inserted = " +
                    stmt.executeUpdate(insertSQL));
        }

    }

    public static void addDataPreparedStatement(Connection connection)
            throws SQLException {

        String insertSQL =
                "insert into PERSON (PERSON_ID, NAME, AGE) " +
                        "Values(?, ?, ?)";

        try (PreparedStatement stmt =
                     connection.prepareStatement(insertSQL)) {
            stmt.setInt(1, 102);
            stmt.setObject(2, "JOE2");
            stmt.setInt(3, 30);
            System.out.println("records inserted = " +
                    stmt.executeUpdate());
        }
    }

    // insert multiple rows of data into table
    public static void addDataPreparedStatementMultiple(Connection connection)
            throws SQLException {

        String[] names = {"Joe", "Carol", "April", "June", "Mark", "Don"};
        Random r = new Random();

        String insertSQL =
                "insert into PERSON (PERSON_ID, NAME, AGE) " +
                        "Values(?, ?, ?)";

        try (PreparedStatement stmt =
                     connection.prepareStatement(insertSQL)) {

            for (int i = 0; i < names.length; i++) {
                stmt.setInt(1, 103 + i);
                stmt.setObject(2, names[i]);
                stmt.setInt(3, r.nextInt(70));
                if (stmt.executeUpdate() == 1) {
                    System.out.println(names[i] + " was inserted");
                }
            }
        }
    }

    // get data from a table
    public static void getData(Connection connection) throws SQLException {

        /*
        The type of the resource must be specified in the try itself. i.e.
        it should be: try(Statement stmt = c.createStatement())

        The try-with-resource was enhanced in Java 9 and it now allows you to use a variable declared before
        the try statement in the try-with-resource block as long as it is final or effectively final.

        For example, the following is valid since Java 9:
        Statement stmt = c.createStatement();
        try(stmt){
          ...
        }


        However, try(stmt = c.createStatement();) is still invalid.
         */



        // Wild card * in select statement selects all column's data
        // for a record
        String retrieveSQL =
                "select * from PERSON ";

        try (Statement stmt = connection.createStatement();) {

            // ResultSet will be closed automatically when statement is
            // closed
            ResultSet rs = stmt.executeQuery(retrieveSQL);

            int columnCount = 0;

            if (rs != null) {
                // Use meta data to get information about the result set
                // returns number of columns
                columnCount = rs.getMetaData().getColumnCount();
            }

            // Result set is an iterable set of data, here representing
            // records returned from the select statement
            while (rs.next()) {
                // Loop through each column.  ResultSet meta data index
                // starts with 1, not 0.
                for (int i = 1; i <= columnCount; i++) {
                    // Print out column name and value.
                    System.out.print(((i > 1) ? ", " : "") +
                            // Get column name from meta data.
                            rs.getMetaData().getColumnName(i)
                            // Get data from result set
                            + " = " + rs.getObject(i));

                    // rs.getString(0); // invalid, colum starts with 1
                }
                System.out.println();
            }
        }
    }

    // update data in a single record in table
    public static void updateData(Connection connection, String name, int age)
            throws SQLException {

        String updateSQL =
                "UPDATE PERSON SET AGE = ? WHERE NAME = ?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(updateSQL)) {
            stmt.setInt(1, age);
            stmt.setObject(2, name);
            if (stmt.executeUpdate() == 1) {
                System.out.println(name + " was updated");
            }

        }
    }

    // delete a record from table
    public static void deleteData(Connection connection, int person_id)
            throws SQLException {

        String deleteSQL =
                "DELETE FROM PERSON WHERE PERSON_ID = ?";

        try (PreparedStatement stmt =
                     connection.prepareStatement(deleteSQL)) {

            stmt.setInt(1, person_id);
            if (stmt.executeUpdate() == 1) {
                System.out.println(person_id + " was deleted");
            }
        }
    }

    // get data from a table and populate a list of Person
    public static List<Person> getPersonList(Connection connection) throws SQLException {

        // Get all information in a record
        String retrieveSQL =
                "select * from PERSON ";

        List<Person> data = new ArrayList<>();
        // try (Statement stmt = connection.createStatement()) {

        /*
        There are 3 ResultSet types: TYPE_FORWARD_ONLY, TYPE_SCROLL_INSENSITIVE and TYPE_SCROLL_SENSITIVE.

        Note:
        `con.createStatement();` would return the Statement object of type TYPE_FORWARD_ONLY
        and have a concurrency level of CONCUR_READ_ONLY. Hence, by default ResultSet is not updatable.
         */
        try (Statement stmt = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                // ResultSet.CONCUR_READ_ONLY)) { // Result Set not updatable.
                ResultSet.CONCUR_UPDATABLE)) { // does permit rs.updateRow();

            // ResultSet will be closed automatically when statement is
            // closed
            ResultSet rs = stmt.executeQuery(retrieveSQL);


            /*

            // Result set is an iterable set of data, here representing
            // records returned from the select statement
            while (rs.next()) {
                data.add(new Person(rs.getInt("PERSON_ID"),
                        rs.getString("NAME"),
                        rs.getInt("AGE")));
            }

            // Iterate backwards through the result set...
            rs.afterLast();
            while (rs.previous()) {
                data.add(new Person(rs.getInt("PERSON_ID"),
                        rs.getString("NAME"),
                        rs.getInt("AGE")));
            }
            */

            // Iterate backwards through the result set...
            rs.afterLast();
            while (rs.previous()) {
                if (rs.getInt("PERSON_ID") == 103) {

                    // rs.updateInt("AGE", 99);
                    // rs.updateRow();
                    // System.out.println(rs.getInt("AGE"));
                    // System.out.println("updated");
                }
                data.add(new Person(rs.getInt("PERSON_ID"),
                        rs.getString("NAME"),
                        rs.getInt("AGE")));
            }
        } catch (SQLException se) {
            System.out.println(se);
        }

        return data;
    }

}


// Person class represents data in a PERSON table
class Person {
    private int id;
    private String name;
    private int age;

    // constructor
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


