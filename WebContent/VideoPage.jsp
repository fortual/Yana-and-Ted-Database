<!-- This is an example page of a video -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Example Video</title>
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
Statement statementV = null;
ResultSet resultSetV = null;
Statement statementT = null;
ResultSet resultSetT = null;
Statement statementR = null;
ResultSet resultSetR = null;
try {
	connection = DriverManager.getConnection(connectionUrl + database, userid, password);
	statementV = connection.createStatement();
	String sql = ("SELECT * FROM youtubevideos WHERE url = '" + request.getParameter("url") + "'");
	resultSetV = statementV.executeQuery(sql);
	resultSetV.next();

	statementT = connection.createStatement();
	sql = ("SELECT * FROM youtubetags WHERE url = '" + request.getParameter("url") + "'");
	resultSetT = statementT.executeQuery(sql);

	statementR = connection.createStatement();
	sql = ("SELECT * FROM reviews WHERE youtubeid = '" + request.getParameter("url") + "'");
	resultSetR = statementR.executeQuery(sql);
} catch (Exception e) {
	e.printStackTrace();
}
%>
<body>

	<h1><%=resultSetV.getString("title")%></h1>
	<iframe width="900" height="506"
		src="<%=resultSetV.getString("url")%>" frameborder="0"
		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
	<h2>Description</h2>
	<h3><%=resultSetV.getString("descrip")%></h3>
	<h2>Tags</h2>
	<%
		while (resultSetT.next()) {
	%><h3><%=resultSetT.getString("tag")%>,
	</h3>
	<%
		}
	%>

	<h2>Add to favorites</h2>
	<form action="favComedian.jsp" method="post">
		<input type="submit" value="Submit" />
	</form>
	<h2>Delete from favorites</h2>
	<form action="favComedian.jsp" method="post">
		<input type="submit" value="Submit" />
	</form>

	<h2>Comments</h2>
	<h3>Enter a Comment</h3>

	<table style="with: 50%">
		<tr>
			<td>Ranking</td>>
			<td><select id="rank" name="rank">
					<option value="poor">poor</option>
					<option value="fair">fair</option>
					<option value="good">good</option>
					<option value="excellent">excellent</option>
			</select></td>
		</tr>
		<tr>
			<td>Comment</td>
			<td><input type="text" name="comment" /></td>
		</tr>
	</table>
	<form action="exampleVideo.jsp" method="post">
		<input type="submit" value="Submit" />
	</form>
	<%
		while (resultSetR.next()) {
	%>
	
	
	<table style="with: 50%">
	<%=resultSetR.getString("author")%>
		<tr>
			<td>Ranking</td>
			<td><%=resultSetR.getString("rating")%></td>
		</tr>
		<tr>
			<td><%=resultSetR.getString("remark")%></td>
		</tr>
	</table>
	
	
	<%
		}
	%>
</body>
</html>