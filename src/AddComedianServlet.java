import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */

@WebServlet("/AddComedianServlet") // This is the URL of the servlet.
public class AddComedianServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {
			// Copy get request to variables
			ComedianBean bean = new ComedianBean();
			String nameF = request.getParameter("firstname");
			String nameL = request.getParameter("lastname");
			java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
			String birthplace = request.getParameter("birthplace");

			// Registration rules
			ServletException e = new ServletException();

			e = new ServletException("First Name is too long");
			if (nameF.length() > 50)
				throw (e);

			e = new ServletException("Last Name is too long");
			if (nameL.length() > 50)
				throw (e);

			bean.setFirstName(nameF);
			bean.setLastName(nameL);
			bean.setBirthday(birthday);
			bean.setBirthplace(birthplace);
			
			// Checks validity of user
			bean = ComedianDAO.addComedian(bean);

			if (bean.isValid()) {

				System.out.println("Comedian successfully added with ID = " + bean.getComid());
			}

			else
				System.out.println("Comedian NOT added"); // error page
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