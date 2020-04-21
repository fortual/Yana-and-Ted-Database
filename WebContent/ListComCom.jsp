<!-- This is the search result page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Common Comedians</title>
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
Statement statement2 = null;
ResultSet resultSet2 = null;
%>
<body>
	<h1>Common Comedians</h1>
	<form action="mainPage.jsp" method="post">
	<%
		try {
		connection = DriverManager.getConnection(connectionUrl + database, userid, password);
		statement = connection.createStatement();
		String sql = "select * from users";
		resultSet = statement.executeQuery(sql);
	%><select name="name1">
		<%
			while (resultSet.next()) {
		%>

		<option value="<%=resultSet.getString("email")%>"><%=resultSet.getString("email")%></option>

		<%
			}
		%>
	</select>
	<br>
	<select name="name2">
		<%
			resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
		%>

		<option value="<%=resultSet.getString("email")%>"><%=resultSet.getString("email")%></option>

		<%
			}
		%>
	</select>
	<%
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	 <br><input type="submit" value="Submit" />
	  
			<%
			if(request.getParameter("name1") != null && request.getParameter("name2") != null) {
				String user1 = request.getParameter("name1");
				String user2 = request.getParameter("name2");
				try {
					connection = DriverManager.getConnection(connectionUrl + database, userid, password);
					statement = connection.createStatement();
					statement2 = connection.createStatement();
					
					String sql = "SELECT a.comid FROM isfavorite a, isfavorite b WHERE a.email = '" + user1 + "' AND b.email = '" + user2 + "' AND a.comid = b.comid ORDER BY a.comid;";
					resultSet = statement.executeQuery(sql);
					resultSet.next();
					
					sql = "SELECT * FROM comedians WHERE comid = '" + resultSet.getString("a.comid") + "'";
					resultSet2 = statement2.executeQuery(sql);
					resultSet2.next();
					%>

					<br><%=user1%> and <%=user2%> both like <%=resultSet2.getString("firstname")%> <%=resultSet2.getString("lastname")%>

					<%
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			%>
		
    </form>
   
</body>
</html>