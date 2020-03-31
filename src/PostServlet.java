import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/PostServlet") // This is the URL of the servlet.
public class PostServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {

			VideoBean video = new VideoBean();
			video.setUrl(request.getParameter("url").toLowerCase());
			video.setTitle(request.getParameter("title"));
			video.setDescrip(request.getParameter("descrip"));
			video.setComid(Integer.parseInt(request.getParameter("comid")));
			UserBean postuser = (UserBean) request.getSession().getAttribute("currentSessionUser");
			video.setUser(postuser.getEmail());

			video = VideoDAO.post(video);

			if (video.isValid()) {
				response.sendRedirect("PostResult.jsp");
			}

			else
				response.sendRedirect("invalidLogin.jsp"); // error page

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}