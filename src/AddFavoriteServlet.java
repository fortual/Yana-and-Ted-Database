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
 * Servlet implementation class RegistrationServlet
 */

@WebServlet("/AddFavoriteServlet") // This is the URL of the servlet.
public class AddFavoriteServlet extends HttpServlet {
	static Connection currentCon = null;
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {
			// Copy get request to variables
			HttpSession session = request.getSession(true);
			UserBean bean = (UserBean)session.getAttribute("currentSessionUser");
			int comid = Integer.parseInt(request.getParameter("comid"));
			

			try {
				Statement stmt = null;
				
				String insertQuery = "INSERT INTO `ytcomedy`.`isfavorite`" + "VALUES ('" + bean.getEmail() + "', '" + comid + "');";
				stmt = currentCon.createStatement();
				stmt.executeUpdate(insertQuery);
				
				
				}
				catch (Exception ex) {
					System.out.println("Add Favorite Error: An Exception has occurred! " + ex);
					response.sendRedirect("mainPage.jsp"); // logged-in page
				}

			
			response.sendRedirect("mainPage.jsp"); // logged-in page

		}

		catch (Throwable theException) {
			System.out.println(theException);
			response.sendRedirect("mainPage.jsp"); // logged-in page
		}
	}

}