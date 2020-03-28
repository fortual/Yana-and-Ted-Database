import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static UserBean login(UserBean bean) {

		// preparing some objects for connection
		Statement stmt = null;

		String email = bean.getEmail();
		String password = bean.getPassword();

		String searchQuery = "select * from users where email='" + email + "' AND pass='" + password + "'";

		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("Your username is " + email);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");

				System.out.println("Welcome " + firstName);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return bean;

	}

	public static UserBean registration(UserBean bean) {

		// preparing some objects for connection
		Statement stmt = null;

		String email = bean.getEmail();
		String password = bean.getPassword();
		String firstname = bean.getFirstName();
		String lastname = bean.getLastName();
		char gender = bean.getGender();
		int age = bean.getAge();

		String searchQuery = "select * from users where email='" + email + "'";

		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("Your username is " + email);
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();			
			
			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Registration complete.");
				bean.setValid(true);
				String insertQuery = "INSERT INTO `ytcomedy`.`users`" + "VALUES ('" + email + "', '" + password + "', '" + firstname + "', '" + lastname + "', '" + gender + "', '" + age + "');";
				stmt = currentCon.createStatement();
				stmt.executeUpdate(insertQuery);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				System.out.println("ERROR: A user of that name already exists.");
				bean.setValid(false);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return bean;

	}
}