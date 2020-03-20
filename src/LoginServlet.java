import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;
    String dbURL ="jdbc:mysql://localhost:3306/userDB";
    String username = "john";
    String password = "pass1234";
    
    
    public void init() {
        userDAO = new userDAO(); 
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
    	String login = request.getServletPath();
    	System.out.print(login);
    	System.out.print("Login Attempt");
    	attemptLogin(request, response);

    }
        
   
	 private void attemptLogin(HttpServletRequest request, HttpServletResponse response)
	 	throws ServletException, IOException
	 {
        	System.out.println("User obtained");
        	String user = null;
        	user = request.getParameter(username);
      
			if(user == null)
        	{
        		String LoginFailed = "Unable to login";
	        	request.setAttribute("loginFailed", LoginFailed);
	        }
        	else if(user.equals(request.getParameter("password")))
	        {
	        	String wPassword = "Wrong Password";
	        	request.setAttribute("loginFailed", wPassword);
	        }
	        else if(user.equals("root"))
	        {
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("RootLogin.jsp");
	        	dispatcher.forward(request,response);
	        }
	        else
	        {
	         	RequestDispatcher dispatcher = request.getRequestDispatcher("LoginPage.jsp");
	        	dispatcher.forward(request,response);
	        }
   }
        
}
