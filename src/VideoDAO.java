import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class VideoDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	@SuppressWarnings("resource")
	public static String post(VideoBean bean, String tags) {

		String message = "Something went wrong; you video has not been posted.";

		// preparing some objects for connection

		String url = bean.getUrl();
		String title = bean.getTitle();
		String descrip = bean.getDescrip();
		int comid = bean.getComid();
		String postuser = bean.getPostUser();
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

		Statement stmt = null;
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

				// Check for previous uploads
				java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
				searchQuery = "select * from youtubevideos where postuser='" + postuser + "' AND postdate='" + sqlDate
						+ "'";
				stmt = currentCon.createStatement();
				rs = stmt.executeQuery(searchQuery);

				int size = 0;
				if (rs != null) {
					rs.last(); // moves cursor to the last row
					size = rs.getRow(); // get row id
				}

				// If user posted fewer than 5 videos today
				if (size < 5) {

					// Inserting video into database
					String insertQuery = "INSERT INTO `ytcomedy`.`youtubevideos` VALUES ('" + url + "', '" + title
							+ "', '" + descrip + "', '" + comid + "', '" + postuser + "', '" + date + "');";
					stmt = currentCon.createStatement();
					stmt.executeUpdate(insertQuery);

					// Inserting tags into database
					String[] tag = tags.split(",");
					for (int i = 0; i < tag.length; i++) {
						
						insertQuery = "INSERT INTO `ytcomedy`.`youtubetags` VALUES ('" + url + "', '" + tag[i].trim() + "');";
						stmt = currentCon.createStatement();
						stmt.executeUpdate(insertQuery);
					}
					
					// Post has been successfully inserted
					bean.setValid(true);
					System.out.println("Posting complete.");
					message = "Video was sucessfully posted!.";
					
					// Closing connections
					stmt.close();
					currentCon.close();
					rs.close();
					
				} else {
					System.out.println("ERROR: User " + postuser + " attempted to post more than 5 videos today.");
					message = "You have already posted 5 videos today. Please wait until tomorrow to post more.";
					bean.setValid(false);
				}
			}

			// if video exists set the isValid variable to false
			else {
				System.out.println("ERROR: User " + postuser + " attempted to post a video already in database.");
				message = "That video was already uploaded. Try uploading a different video instead.";
				bean.setValid(false);
			}
		}

		catch (Exception ex) {
			System.out.println("Post failed: An Exception has occurred! " + ex);
			bean.setValid(false);
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

		return message;
	}

}