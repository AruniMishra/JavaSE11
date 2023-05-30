/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 15: Database Applications with JDBC
Topic:  CallableStatement
*/

import java.sql.*;

public class CallableExample {
    public static void main(String[] args) throws SQLException, InterruptedException {

        // Wrap connection in a try-with-resources, so connection
        // automatically closed when completes or gets exception
        try (Connection connection = ConnectionExamples.getConnection(ConnectionExamples.mySqlConnectionString);) {
            // This method will create derby table PERSONS and populate with data.
            setUpData(connection);

            // Retrieve and Print List of Person
            System.out.println("\n-- list before procedure");
            CRUDExamples.getPersonList(connection).forEach(System.out::println);

            // Execute DDL to create the stored procedure in DERBY
            createProcForDerby(connection);

            executeStoredProcedure(connection, "CHANGED NAME TO BOB", 101);

            // Execute the stored procedure with different values
            executeStoredProcedure(connection, "CHANGED NAME TO BOB", 101);
            executeStoredProcedure(connection, "CHANGED NAME TO CAROL", 102);

            // Retrieve and Print List of Person
            System.out.println("\n-- list after procedure");
            CRUDExamples.getPersonList(connection).forEach(System.out::println);


            System.out.println("\n\n-- javaUpdatePassThrough");
            // Execute java method which simply executes an update query
            javaUpdatePassThrough("BOB", 103);

            // Retrieve and Print List of Person
            CRUDExamples.getPersonList(connection).forEach(System.out::println);

        }
    }

    // Pass thru to other methods, to create a Table, PERSONS in the
    // Derby database, and add Data to it.
    public static void setUpData(Connection connection) throws SQLException {

        try {
            ConnectionExamples.dropTable(connection);
        } catch (SQLException se) {
            System.out.println(se);
        }

        // Example of DDL -
        ConnectionExamples.createTable(connection);

        // Example of DML - create data
        CRUDExamples.addDataPreparedStatementMultiple(connection);
    }

    // This is the java method which the Derby stored procedure will execute.
    public static void javaUpdatePassThrough(String name, int personId) throws SQLException {

        // Java code to do the actual update
        String query = "update PERSON set name = ? where person_id = ?";

        try (Connection connection =
                     ConnectionExamples.getConnection(ConnectionExamples.mySqlConnectionString);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, personId);
            int result = pstmt.executeUpdate();
            if (result == 1) System.out.println("Row was updated");

        }
    }


    // Executes the Derby stored procedure, keeps connection open
    public static void executeStoredProcedure(Connection connection, String name, int personId) throws SQLException {

        try (
                // CallableStatement similar to PreparedStatement except
                CallableStatement cs = connection.prepareCall("{ call retrieveData()}")) {
            cs.execute();
        }
    }


    // Method creates a stored procedure in Derby based on java code
    public static void createProcForDerby(Connection connection) throws SQLException {

        // Derby let's you create a stored procedure based on java code,
        // in this case, the method CallableExample.testProc is defined in
        // current class.
        // String createProcedure = "create procedure" + " UPDATE_PERSON(" + "IN name VARCHAR(255)," + "IN pid INTEGER) " + "PARAMETER STYLE JAVA READS SQL" + " DATA LANGUAGE JAVA EXTERNAL NAME " + "'CallableExample.javaUpdatePassThrough'";

        String query = "CREATE PROCEDURE `retrieveData`() " + "BEGIN " + " SELECT * FROM PERSON; " + "END";

        try (Statement stmt = connection.createStatement()) {
            try {
                // First drop Procedure
                stmt.execute("drop procedure retrieveData");
            } catch (Exception e) {
                // Ignore error, might occur if procedure does not exist
            }
            // Create the stored procedure in Derby
            int i = stmt.executeUpdate(query);
            System.out.println("\ncreateProcedure: " + i);

        }
    }
}
