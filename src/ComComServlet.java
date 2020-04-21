import java.sql.Connection;
import java.sql.ResultSet;
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

@WebServlet("/ComComServlet") // This is the URL of the servlet.
public class ComComServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs = null;
	static ResultSet rs2 = null;
	Statement stmt = null;
	Statement stmt2 = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		String message = null;
		request.setAttribute("ComCom", message);
		String user1 = request.getParameter("name1");
		String user2 = request.getParameter("name2");
		String searchQuery = "SELECT a.comid" + 
				"FROM isfavorite a, isfavorite b" + 
				"WHERE a.email = '" + user1 + "'" + 
				"AND b.email = '" + user2 + "'" + 
				"AND a.comid = b.comid" + 
				"ORDER BY a.comid;";
		
		try {

			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			while(rs.next())
			{
				searchQuery = "SELECT * FROM comedians WHERE comid = '" + rs.getString("comid") + "'";
				stmt2 = currentCon.createStatement();
				rs2 = stmt.executeQuery(searchQuery);
				rs2.next();
				message = message + rs2.getString("firstname") + " " + rs2.getString("firstname") + "\n";
			}
			
			// Setting output message regarding success of post
			request.setAttribute("ComCom", message);

			

		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("ComCom", e);
			request.getRequestDispatcher("mainPage.jsp").forward(request, response);
		}
		
		// Returning user to Post page with message
		request.getRequestDispatcher("mainPage.jsp").forward(request, response);
	}
}