import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ComedianDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;


	public static ComedianBean addComedian(ComedianBean bean) {

		// preparing some objects for connection
		Statement stmt = null;
		
		String firstname = bean.getFirstName();
		String lastname = bean.getLastName();
		java.sql.Date birthday = bean.getBirthday();
		String birthplace = bean.getBirthplace();
		int comid = bean.getComid();

		String searchQuery = "select * from comedians where firstname='" + firstname + "' AND lastname='" + lastname + "'";

		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("comedian is '" + firstname + " " + lastname + "'");
		System.out.println("Query: " + searchQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();			
			
			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Inserting...");
				String insertQuery = "INSERT INTO `ytcomedy`.`comedians`(firstname, lastname, birthday, birthplace)" + "VALUES ('" + firstname + "', '" + lastname + "', '" + birthday + "', '" + birthplace + "');";
				stmt = currentCon.createStatement();
				stmt.executeUpdate(insertQuery);
				bean.setValid(true);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				System.out.println("ERROR: A comedian of that name already exists.");
				bean.setValid(false);
			}
		}

		catch (Exception ex) {
			System.out.println("Add comedian failed: An Exception has occurred! " + ex);
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