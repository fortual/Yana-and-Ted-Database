<!-- This is the video upload page. -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Video Upload</title>
</head>
<body>
<h1>Video Upload</h1>
<form action="uploadResult.jsp" method="post">
			<table style="with: 50%">
				<tr>
					<td>Enter Video Embed Code (Must be YouTube)</td>
					<td><input type="text" name="url" /></td>
				</tr>
				<tr>
					<td>Enter Video Title</td>
					<td><input type="text" name="videoTitle" /></td>
				</tr>
				<tr>
					<td>Enter Video Description</td>
					<td><input type="text" name="videoDescription" /></td>
				</tr>
				<tr>
					<td>Enter Video Tags</td>
					<td><input type="text" name="tags" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>