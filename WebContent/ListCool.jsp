<!-- This is the search result page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Who's Cool</title>
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
	<h1>Who's Cool</h1>
	<table>
	<%
		try {
		connection = DriverManager.getConnection(connectionUrl + database, userid, password);
		statement = connection.createStatement();
		String sql = "select comid, firstname, lastname from comedians where exists (select comid from youtubevideos where comedians.comid = youtubevideos.comid AND exists (select youtubeid from reviews where youtubevideos.url = reviews.youtubeid AND reviews.rating = 'e'))  limit 10";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			%>
			
			<tr>
				<td><h2><a href= "comedian.jsp?comid=<%=resultSet.getString("comid")%>"><%=resultSet.getString("firstname")%> <%=resultSet.getString("lastname")%></a></h2></td>
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