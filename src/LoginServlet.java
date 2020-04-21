import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet") // This is the URL of the servlet.
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {

			UserBean user = new UserBean();
			user.setEmail(request.getParameter("email").toLowerCase());
			user.setPassword(request.getParameter("password"));
			
			// The logic doesn't work with "if" statements for some reason
			switch (user.getEmail()) {
			case "root": {
				switch (user.getPassword()) {
				case "pass1234":
					response.sendRedirect("RootControl.jsp");
					break;
				default:
					break;
				}
			}

			default: {
				user = UserDAO.login(user);

				if (user.isValid()) {

					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", user.getEmail());

					response.sendRedirect("mainPage.jsp");
				}

				else
					response.sendRedirect("invalidLogin.jsp"); // error page
				break;
			}
			}
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}