/**********************************************************************************
 * This java file is for loading the mySQL driver, and creating the connection 
 * to the DB.  
 *********************************************************************************/

package ca.simpleweb.mvc.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection connection = null;
	private static String username = "admin"; // mySQL username
	private static String password = "admin"; // mySQL password
	private static String database = "comp3095"; // database name
	private static String url = "jdbc:mysql://localhost:3306/" + database; // database url

	public static Connection connectDataBase(){
		try {
			try {
				// loading the MySQL driver
				Class.forName("com.mysql.jdbc.Driver");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// connection to the Database
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return connection;
	}
}
