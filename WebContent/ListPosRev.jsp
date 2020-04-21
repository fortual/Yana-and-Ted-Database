<!-- This is the search result page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Who Reviews Well</title>
</head>
	<%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
	<%
		String driver = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String database = "ytcomedy";
		String userid = "john";
		String password = "pass1234";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
	%>
<body>
	<h1>Who Reviews Well</h1>
	<table>
	<%
		try {
		connection = DriverManager.getConnection(connectionUrl + database, userid, password);
		statement = connection.createStatement();
		String sql = "select * from users where exists (select * from reviews where users.email = reviews.author AND (reviews.rating = 'e' OR reviews.rating = 'g'))  limit 10";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			%>
			
			<tr>
				<td><h2><a href= "UserYoutubes.jsp?email=<%=resultSet.getString("email")%>"><%=resultSet.getString("firstname")%> <%=resultSet.getString("lastname")%></a></h2></td>
			</tr>
			<%
		}
	connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	</table>
</body>
</html>