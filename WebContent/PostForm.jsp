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
					<td>Comedian ID:</td>
					<td><input type="text" name="comid" required/></td>
				</tr>
				<tr>
					<td>Tags (separated by comma):</td>
					<td><input type="text" name="tags" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>