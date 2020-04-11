<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	    $( "#datepicker" ).datepicker({
	    	dateFormat: "yy-mm-dd",
	    	changeYear: true
	    });
	  });
  </script>
</head>
<body>
<h1>Add Comedian</h1>
<form action="AddComedianServlet">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" maxlength="50" required/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" maxlength="50" required/></td>
				</tr>
				<tr>
					<td>Birthday</td>
					<td><input type="text" id="datepicker" name="birthday" required></td>
				</tr><tr>
					<td>Birthplace</td>
					<td><input type="text" name="birthplace" maxlength="50" required/></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
</html>