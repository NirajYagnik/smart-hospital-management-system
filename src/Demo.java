/*
Demo Module to test connections with the database
*/
import java.sql.*;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;



/**
 *
 * @author www.luv2code.com
 */
public class Demo {

    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "";
        String pass = "";

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            //String sqlSelectQuery = 
              //             "SELECT * FROM books WHERE title = 'BOOK Title'";
 
            // Step 2.B: Creating JDBC Statement 
            //PreparedStatement preparedStatement = null;
            //preparedStatement = myConn.prepareStatement(sqlSelectQuery);
 
            // set values for PreparedStatement for respective ?
            //preparedStatement.setInt(1, 7); // PLAYER_ID
 
            // Step 2.C: Executing SQL & retrieve data into ResultSet
            //ResultSet resultSet = null;
            //resultSet = preparedStatement.executeQuery();
 
 
            // processing returned data and printing into console
            //while(resultSet.next()) {
              //  System.out.println(resultSet.getString(1) + "\t" + 
                //        resultSet.getInt(2) + "\t");
            //}
 
            myRs = myStmt.executeQuery("select * from Doctor");
            //myStmt.executeUpdate("INSERT INTO books " + "VALUES ('Simpson',1500)");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("DocName") + ", " + myRs.getString("Department"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }    

}
