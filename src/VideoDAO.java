import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class VideoDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	@SuppressWarnings("resource")
	public static VideoBean post(VideoBean bean) {
		// preparing some objects for connection
		Statement stmt = null;
		String url = bean.getUrl();
		String searchQuery = "select * from youtubevideos where url='" + url + "'";

		// "System.out.println" prints in the console; Normally used to trace the
		// process
		System.out.println("Searching for existing video...");

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// if video does not exist, then post may occur
			if (!more) {

				String title = bean.getTitle();
				String descrip = bean.getDescrip();
				int comid = bean.getComid();
				String postuser = bean.getPostUser();
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

				String insertQuery = "INSERT INTO `ytcomedy`.`youtubevideos` VALUES ('" + url + "', '" + title + "', '"
						+ descrip + "', '" + comid + "', '" + postuser + "', '" + date + "');";
				stmt = currentCon.createStatement();
				stmt.executeUpdate(insertQuery);

				// Post has been successfully inserted
				bean.setValid(true);
				System.out.println("Posting complete.");

				stmt.close();
				currentCon.close();
				rs.close();
			}

			// if video exists set the isValid variable to false
			else if (more) {
				System.out.println("ERROR: A video of that URL already exists.");
				bean.setValid(false);
			}
		}

		catch (Exception ex) {
			System.out.println("Post failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
					System.out.println(e);
				}

				currentCon = null;
			}
		}

		return bean;

	}
}