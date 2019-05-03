package ca.simpleweb.mvc.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationChecker {
	private Pattern namePattern;
	private Pattern emailPattern;
	private Pattern passwordPattern;
	private Matcher matcher;

	private static final String NAME_PATTERN = "[a-zA-Z]+";
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&��*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	private static final String PASSWORD_PATTERN = "(?=.*[A-Z])(?=.*[!@#$%^&+=]).{6,12}";

	/**
	 * Constructor
	 */
	public ValidationChecker() {
		namePattern = Pattern.compile(NAME_PATTERN);
		emailPattern = Pattern.compile(EMAIL_PATTERN);
		passwordPattern = Pattern.compile(PASSWORD_PATTERN);
	}

	// name validation
	public boolean isValidName(final String hex) {
		matcher = namePattern.matcher(hex);
		return matcher.matches();
	}


	// email validation
	public boolean isValidEmail(final String hex) {
		matcher = emailPattern.matcher(hex);
		return matcher.matches();
	}


	// password validation
	public boolean isValidPassword(final String hex) {
		matcher = passwordPattern.matcher(hex);
		return matcher.matches();
	}

	// require validation
	public boolean isNull(String value) {
		return value == null || value.trim().equals("");
	}

	// check whether email address exists
	public boolean UserExists(String inputemail){
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

			return result.next();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}
}
