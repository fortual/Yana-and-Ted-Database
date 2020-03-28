import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */

@WebServlet("/RegistrationServlet") // This is the URL of the servlet.
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {
			// Copy get request to variables
			UserBean user = new UserBean();
			String email = request.getParameter("email").toLowerCase();
			String password = request.getParameter("password");
			String nameF = request.getParameter("firstname");
			String nameL = request.getParameter("lastname");
			char gender = request.getParameter("gender").toLowerCase().charAt(0);
			int age = Integer.parseInt(request.getParameter("age"));

			// Registration rules
			UserException e = new UserException("needs 1 @ symbol");
			if (findChar('@', email) != 1)
				throw (e);
			e = new UserException("needs 1 . symbol");
			if (findChar('.', email) != 1)
				throw (e);
			e = new UserException("Email is too long");
			if (email.length() > 50)
				throw (e);

			e = new UserException("Password is too long");
			if (password.length() > 50)
				throw (e);

			e = new UserException("First Name is too long");
			if (nameF.length() > 50)
				throw (e);

			e = new UserException("Last Name is too long");
			if (nameL.length() > 50)
				throw (e);

			e = new UserException("Age is invalid");
			if (age < 13)
				throw (e);

			user.setEmail(email);
			user.setPassword(password);
			user.setFirstName(nameF);
			user.setLastName(nameL);
			user.setGender(gender);
			user.setAge(age);
			
			// Checks validity of user
			user = UserDAO.registration(user);

			if (user.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("mainPage.jsp"); // logged-in page
			}

			else
				response.sendRedirect("invalidRegistration.jsp"); // error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	public static int findChar(char symbol, String st) {
		int count = 0;
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == symbol)
				count++;
		}
		return count;
	}
}