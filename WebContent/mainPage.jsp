<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>ComedyTube Main Page</title>
</head>
<body>
	<h1>Welcome to Comedy Tube</h1>
	<table style="width: 100%">
			<td><jsp:include page="PostForm.jsp" /></td>
			<td><jsp:include page="AddComedian.jsp" /></td>
	</table>
	<table style="width: 100%; height: 800px">
		<td><jsp:include page="ListCool.jsp" /></td>
		<td><jsp:include page="ListNew.jsp" /></td>
	</table>
	<table style="width: 100%; height: 800px">
		<td><jsp:include page="ListHot.jsp" /></td>
		<td><jsp:include page="ListTop.jsp" /></td>
	</table>
	<br>
	<table style="width: 600px; height: 800px">
		<td><jsp:include page="ListTop.jsp" /></td>
	</table>

	<br>

	<h2>Common Favorite Comedian</h2>
	<td><select name="category">
			<option value="-1">-Select Category-</option>
			<option value="user 1">User 1</option>
			<option value="user 2">User 2</option>
	</select></td>
	<td><select name="category">
			<option value="-1">-Select Category-</option>
			<option value="user 3">User 3</option>
			<option value="user 4">User 4</option>
	</select></td>
	<form action="listPages6.jsp" method="post">
		<input type="submit" value="continue" />
	</form>

	<h2>
		<a href="listPages7.jsp">Most Productive Users</a>
	</h2>

	<h2>
		<a href="listPages8.jsp">Positive Reviewers</a>
	</h2>

	<h2>
		<a href="listPages9.jsp">Poor Youtubes</a>
	</h2>

	<h2>Twin Users</h2>
	<td><select name="category">
			<option value="-1">-Select Category-</option>
			<option value="user 1">User 1</option>
			<option value="user 2">User 2</option>
	</select></td>
	<td><select name="category">
			<option value="-1">-Select Category-</option>
			<option value="user 3">User 3</option>
			<option value="user 4">User 4</option>
	</select></td>
	<form action="listPages10.jsp" method="post">
		<input type="submit" value="continue" />
	</form>
</body>
</html>