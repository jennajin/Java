/**********************************************************************************
 * Description: This java file works as a model for checking a user in this MVC 
 *********************************************************************************/

package ca.simpleweb.mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ca.simpleweb.mvc.helpers.DBConnection;
import ca.simpleweb.mvc.objects.UserObject;

public class UserChecker {

	public UserObject checkUser(String inputemail, String inputpassword) {
		// Create user object
		UserObject userObj = new UserObject();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// Select user info from the table 'USERS'
		String query = "SELECT * FROM users WHERE email = ?";

		try {
			// create a connection to the DB
			connection = DBConnection.connectDataBase();

			//preparing the statement and assigning require parameters
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, inputemail);
			ResultSet result = preparedStatement.executeQuery();

			// check if user email exists
			while (result.next()) {
				String password = result.getString("password");

				if(password.equals(inputpassword)) {
					userObj.setFirstName(result.getString("firstname"));
					userObj.setLastName(result.getString("lastname"));
					userObj.setAddress(result.getString("address"));
					userObj.setEmail(result.getString("email"));
					userObj.setRole(result.getString("role"));
					userObj.setCreated(result.getString("role"));
					userObj.setPassword(result.getString("password"));
					return userObj;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		// return null if email or password is invalid 
		return null;
	}

}
