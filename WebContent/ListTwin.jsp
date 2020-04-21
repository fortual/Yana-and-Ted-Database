<!-- This is the search result page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Twin Users</title>
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
		Statement statement2 = null;
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
	%>
<body>
	<h1>Twin Users</h1>
	<table>
	<%
		try {
		connection = DriverManager.getConnection(connectionUrl + database, userid, password);
		statement = connection.createStatement();
		statement2 = connection.createStatement();
		String sql = "SELECT a.email AS user1, b.email AS user2, a.comid " + 
				"FROM isfavorite a, isfavorite b " + 
				"WHERE b.email > a.email " + 
				"AND a.comid = b.comid " + 
				"ORDER BY a.comid;";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			sql = "select * from comedians where comid = '" + resultSet.getString("comid") + "'";
			resultSet2 = statement2.executeQuery(sql);
			resultSet2.next();
			%>
			
			<tr>
				<td><h2>Users <a href= "UserYoutubes.jsp?email=<%=resultSet.getString("user1")%>"><%=resultSet.getString("user1")%></a> and <a href= "UserYoutubes.jsp?email=<%=resultSet.getString("user2")%>"><%=resultSet.getString("user2")%></a> both like <a href= "comedian.jsp?comid=<%=resultSet2.getString("comid")%>"><%=resultSet2.getString("firstname")%> <%=resultSet2.getString("lastname")%></a></h2></td>
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