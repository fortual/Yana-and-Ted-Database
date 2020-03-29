import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VideoDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

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
				Date postdate = bean.getDate();
				
				String insertQuery = "INSERT INTO `ytcomedy`.`youtubevideos`" + "VALUES ('" + url + "', '" + title + "', '"
						+ descrip + "', '" + comid + "', '" + postuser + "', '" + postdate + "');";
				stmt = currentCon.createStatement();
				stmt.executeUpdate(insertQuery);
				
				// Post has been successfully inserted
				bean.setValid(true);
				System.out.println("Posting complete.");
				
				stmt.close();
				currentCon.close();
				rs.close();
			}

			// if user exists set the isValid variable to true
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