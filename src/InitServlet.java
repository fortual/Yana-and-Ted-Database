import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/InitServlet") // This is the URL of the servlet.
public class InitServlet extends HttpServlet {

	static Connection currentCon = null;
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Statement stmt = null;
		String sql1 = "CREATE TABLE Users (email VARCHAR(50),pass VARCHAR(50),firstname VARCHAR(50),lastname VARCHAR(50),gender CHAR(1),age INTEGER,PRIMARY KEY(email));";
		String sql2 = "CREATE TABLE Comedians (comid INTEGER NOT NULL AUTO_INCREMENT,firstname VARCHAR(50),lastname VARCHAR(50),birthday DATE,birthplace VARCHAR(50),PRIMARY KEY(comid));";
		String sql3 = "CREATE TABLE YoutubeVideos (url VARCHAR(150),title VARCHAR(50),descrip VARCHAR(200),comid INTEGER NOT NULL,postuser VARCHAR(50) NOT NULL,postdate DATE,PRIMARY KEY(url),FOREIGN KEY(comid) REFERENCES Comedians(comid),FOREIGN KEY(postuser) REFERENCES Users(email));";
		String sql4 = "CREATE TABLE Reviews (reviewid INTEGER NOT NULL AUTO_INCREMENT,remark VARCHAR(100),rating CHAR(1),author VARCHAR(50) NOT NULL,youtubeid VARCHAR(150) NOT NULL,PRIMARY KEY(reviewid),FOREIGN KEY(author) REFERENCES Users(email),FOREIGN KEY(youtubeid) REFERENCES YoutubeVideos(url),CONSTRAINT ratingck CHECK (rating='P' OR rating='F' OR rating='G' OR rating='E'));";
		String sql5 = "CREATE TABLE YoutubeTags(url VARCHAR(150),tag VARCHAR(50),PRIMARY KEY(url, tag));";
		String sql6 = "CREATE TABLE IsFavorite(email VARCHAR(50),comid INTEGER,PRIMARY KEY(email, comid),FOREIGN KEY(email) REFERENCES Users(email),FOREIGN KEY(comid) REFERENCES Comedians(comid));";
		currentCon = ConnectionManager.getConnection();
		
		try {
			stmt = currentCon.createStatement();
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.executeUpdate(sql5);
			stmt.executeUpdate(sql6);
			stmt.close();
			currentCon.close();
			response.sendRedirect("Index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (currentCon != null)
				try {
					currentCon.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			response.sendRedirect("invalidLogin.jsp");
		}
	}
}