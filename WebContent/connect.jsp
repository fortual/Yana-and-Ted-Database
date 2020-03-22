
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd" >

<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%> 


<%
/* Create string of connection url within specified format with machine name, 
port number and database name. Here machine name id localhost and database name is student. */
String connectionURL = "jdbc:mysql://localhost:3306/ytcomedy";
// declare a connection by using Connection interface 
Connection connection = null;
// declare object of Statement interface that uses for executing sql statements.
PreparedStatement pstatement = null;
// Load JBBC driver "com.mysql.jdbc.Driver"
Class.forName("com.mysql.jdbc.Driver").newInstance();
int updateQuery = 0;

try {
	/* Create a connection by using getConnection() method that takes 
	parameters of string type connection url, user name and password to connect 
	to database. */
	connection = DriverManager.getConnection(connectionURL, "root", "Bannana1");

} catch (Exception ex) {
	out.println("Unable to connect to batabase.");

} finally {
	// close all the connections.
	pstatement.close();
	connection.close();
}
%>