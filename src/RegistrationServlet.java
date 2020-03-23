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

try
{	    

     UserBean user = new UserBean();
     String email = request.getParameter("email");
     String gender = request.getParameter("gender");
     int age = Integer.parseInt(request.getParameter("age"));
     user.setEmail(email.toLowerCase());
     user.setPassword(request.getParameter("password"));
     user.setFirstName(request.getParameter("firstname"));
     user.setLastName(request.getParameter("lastname"));
     user.setGender(gender.charAt(0));
     user.setAge(age);

     user = UserDAO.registration(user);
	   		    
     if (user.isValid())
     {
	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("currentSessionUser",user); 
          response.sendRedirect("mainPage.jsp"); //logged-in page      		
     }
	        
     else 
          response.sendRedirect("invalidRegistration.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}