<!-- This is the video upload page. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ComedyTube Post Form</title>
</head>
<body>
<h2>Video Posting</h2>
${PostVideoMessage}<br>


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


		try {
		connection = DriverManager.getConnection(connectionUrl + database, userid, password);
		statement = connection.createStatement();
		String sql = "select * from comedians";
		resultSet = statement.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>


<form action="PostServlet">
			<table style="width: 50%">
				<tr>
					<td>YouTube Embed URL:</td>
					<td><input type="text" name="url" required/></td>
				</tr>
				<tr>
					<td>Title:</td>
					<td><input type="text" name="title" required/></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="descrip" required/></td>
				</tr>
				<tr>
					<td>Comedian:</td>
					<td><select name="comid">
		<%
			while (resultSet.next()) {
		%>

		<option value="<%=resultSet.getString("comid")%>"><%=resultSet.getString("firstname")%> <%=resultSet.getString("lastname")%></option>

		<%
			}
		%>
	</select>
	</td>
				</tr>
				<tr>
					<td>Tags (separated by comma):</td>
					<td><input type="text" name="tags" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>