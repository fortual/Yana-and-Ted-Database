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
		
		
		request.setAttribute("PostVideoMessage", null);
		
		
		try {

			VideoBean video = new VideoBean();
			String postuser = (String) request.getSession().getAttribute("currentSessionUser");
			
			video.setUrl(request.getParameter("url").toLowerCase());
			video.setTitle(request.getParameter("title"));
			video.setDescrip(request.getParameter("descrip"));
			video.setComid(Integer.parseInt(request.getParameter("comid")));
			video.setUser(postuser);
			String tags = request.getParameter("tags").toLowerCase();
			
			// Setting output message regarding success of post
			request.setAttribute("PostVideoMessage", VideoDAO.post(video, tags));

			

		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("PostVideoMessage", e);
		}
		
		// Returning user to Post page with message
		request.getRequestDispatcher("mainPage.jsp").forward(request, response);
	}
}