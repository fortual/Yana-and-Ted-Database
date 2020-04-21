<!-- This is the search result page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Who's Top</title>
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
	<h1>Who's Top</h1>
	<table>
		<%
			try {
			connection = DriverManager.getConnection(connectionUrl + database, userid, password);
			statement = connection.createStatement();
			statement2 = connection.createStatement();
			String sql = "select comid, count(comid) from youtubevideos order by count(comid)  limit 10";
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			int count = resultSet.getInt("count(comid)");
			do {
				sql = "select * from comedians where comid = '" + resultSet.getString("comid") + "'";
				resultSet2 = statement2.executeQuery(sql);
				resultSet2.next();
		%>
		<tr>
			<td><h2>
					<a href="comedian.jsp?comid=<%=resultSet.getInt("comid")%>"><%=resultSet2.getString("firstname")%>
						<%=resultSet2.getString("lastname")%></a>
				</h2></td>
		</tr>
		<%
		if (count == resultSet.getInt("count(comid)")) {
			break;
		}
		} while (resultSet.next());
			
			
		connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</table>
</body>
</html>