<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>New User</h1>
<form action="PostVideoServlet">
			<table style="with: 50%">
				<tr>
					<td>URL</td>
					<td><input type="text" name="url" maxlength="150" required/></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" maxlength="50" required/></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="firstname" maxlength="200" required/></td>
				</tr>
				<tr>
					<td>Comedian ID</td>
					<td><input type="text" name="lastname" maxlength="50" required/></td>
				</tr>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
</html>