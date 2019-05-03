/**********************************************************************************
 * This java file works as a model for Registering a user in this MVC 
 * framework. the responsibility of this class is preparing the insert statement 
 * for the user and insert the user information in the DB, and it will return SUCCESS 
 * if the user is inserted in DB, or FAILED if inserting isn't successful.
 *********************************************************************************/

package ca.simpleweb.mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ca.simpleweb.mvc.objects.UserObject;
import ca.simpleweb.mvc.helpers.DBConnection;

public class Register {

	public String registerUser(UserObject userObject){
 
		//get user object information and store them into local variables
		String fisrtName = userObject.getFirstName();
		String lastName = userObject.getLastName();
		String address = userObject.getAddress();
		String email = userObject.getEmail();
		String password = userObject.getPassword();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// create a connection to the DB
			connection = DBConnection.connectDataBase();

			// Insert user info into the table 'USERS'
			String query = "insert into users(firstname,lastname,address,email,role,password) "
					+ "values (?,?,?,?,null,?)";

			//preparing the statement and assigning require parameters
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fisrtName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, password);

			int i = preparedStatement.executeUpdate();
			// check if inserting is successful 
			if (i != 0)
				return "SUCCESS";

		} catch (SQLException e) {
			e.printStackTrace();

		}
		// return FAILED if inserting isn't successful 
		return "FAILED";
	}




}
