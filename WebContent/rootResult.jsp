<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session= "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>LogInCheck</title>
</head>

<body>
    <h1>You have been logged in.</h1>
    <ul>
        <li><p>
                <b>Username:</b>
                <%String user=request.getParameter("username");%>
                <%=user %>
            </p></li>
        <li><p>
                <b>Password:</b>
                <%String pass=request.getParameter("password");%>
                <%=pass %>
            </p></li>
    </ul>
    
    <SCRIPT type="text/JavaScript">
    
    if(request.getParameter("initialized") != null) {
    	document.write("Database initialized!");
     
     }
     </SCRIPT>

	
    <FORM NAME="form1" action="init.jsp" METHOD="POST">
        <INPUT TYPE="HIDDEN" NAME="buttonName">
        <INPUT TYPE="submit" VALUE="Initialize Database">
    </FORM>

    <SCRIPT LANGUAGE="java">
       session.setAttribute("username", user);
       session.setAttribute("password", pass);
    </SCRIPT>
