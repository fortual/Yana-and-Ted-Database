import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class RegistrationServlet extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String f=request.getParameter("first_name");  
String l=request.getParameter("last_name");  
String u=request.getParameter("username");  
String p=request.getParameter("password");  
String g=request.getParameter("gender");  
String a=request.getParameter("age");  

  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into registeruser values(?,?,?,?,?,?)");  
  
ps.setString(1,f);  
ps.setString(2,l);  
ps.setString(3,u);  
ps.setString(4,p);  
ps.setString(5,g);  
ps.setString(6,a);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");            
}
catch(Exception e2) {
System.out.println(e2);
}  
          
out.close();  
}  
  
}  