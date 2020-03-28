<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>New User</h1>
<form action="RegistrationServlet">
			<table style="with: 50%">
				<tr>
					<td>Username (Email)</td>
					<td><input type="text" name="email" maxlength="50" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" maxlength="50" required/></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" maxlength="50" required/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" maxlength="50" required/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" maxlength="1" required/></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" maxlength="2" required/></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
</html>