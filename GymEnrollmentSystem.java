/*
PostgreSQL JDBC Driver Documentation - https://jdbc.postgresql.org/documentation/

Team 475 - Gym Enrollment System
1) Adam Chhor
2) Ian McNeal
3) Sandesh Rai
4) Sovannara Tav
 */
import java.sql.*; // Imports all packages tied to the PostgreSQL JDBC Driver
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GymEnrollmentSystem
{
    public static void main(String[] args)
    {
        // Retrieves the PostgreSQL database properties
        Properties properties = new Properties();
        String fileName = "DatabaseProperties.properties";
        try
        {
            FileInputStream inputFile = new FileInputStream(fileName);
            properties.load(inputFile);
            inputFile.close();
        }
        catch (IOException e)
        {
            System.err.println("Input file error: " + e.getMessage());
            return;
        }
        String url = properties.getProperty("database.url");
        String user = properties.getProperty("database.user");
        String password = properties.getProperty("database.password");

        // Establishes the connection between JDBC and PostgreSQL database
        try
        {
            Connection databaseConnection =
                    DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established");

            /*
             *
             * SQL query execution example
             *
             */
            PreparedStatement testQuery =
                    databaseConnection.prepareStatement("SELECT * FROM Employee");
            ResultSet testQueryResults = testQuery.executeQuery();
            ResultSetMetaData metaData = testQueryResults.getMetaData();

            // PostgreSQL column indexes start at 1 rather than 0
            for(int i = 1; i <= metaData.getColumnCount(); i++)
            {
                System.out.printf("%-20s", metaData.getColumnName(i));
            }
            System.out.println();

            while (testQueryResults.next())
            {
                for(int i = 1; i <= metaData.getColumnCount(); i++)
                {
                    System.out.printf("%-20s", testQueryResults.getString(i));
                }
                System.out.println();
            }

            testQueryResults.close();
            testQuery.close();
            /*
             *
             *
             *
             */

            databaseConnection.close();
            System.out.println("Database connection closed");
        }
        catch (SQLException e)
        {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}