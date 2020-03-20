<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>LogIn</title>
</head>
<body>
<h1>Enter your login information</h1>
    <form action="userResult.jsp" method="post">
        Username: <input type="text" name="username"> <br>
        Password: <input type="password" name="password" /> <input type="submit"
            value="Submit" />
    </form>