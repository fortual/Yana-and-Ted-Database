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
<h1>Video Upload</h1>
${PostVideoMessage}<br>

<form action="PostServlet">
			<table style="with: 50%">
				<tr>
					<td>Enter Video Embed Code (Must be YouTube)</td>
					<td><input type="text" name="url" required/></td>
				</tr>
				<tr>
					<td>Enter Video Title</td>
					<td><input type="text" name="title" required/></td>
				</tr>
				<tr>
					<td>Enter Video Description</td>
					<td><input type="text" name="descrip" required/></td>
				</tr>
				<tr>
					<td>Enter Comedian ID</td>
					<td><input type="text" name="comid" required/></td>
				</tr>
				<tr>
					<td>Enter Tags separated by comma</td>
					<td><input type="text" name="tags" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>