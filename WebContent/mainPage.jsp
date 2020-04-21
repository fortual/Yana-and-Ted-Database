<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>ComedyTube Main Page</title>
</head>
<body>
	<h1>Welcome to Comedy Tube!</h1><br>
	<a href= "search.jsp">Search for Videos and Comedians</a><br>
	<table style="width: 100%">
		<td><jsp:include page="PostForm.jsp" /></td>
		<td><jsp:include page="AddComedian.jsp" /></td>
	</table>
	<br>
	<table style="width: 100%; height: 400px">
		<td><jsp:include page="ListCool.jsp" /></td>
		<td><jsp:include page="ListNew.jsp" /></td>
	</table>
	<br>
	<table style="width: 100%; height: 400px">
		<td><jsp:include page="ListHot.jsp" /></td>
		<td><jsp:include page="ListTop.jsp" /></td>
	</table>
	<br>

	<table style="width: 100%; height: 400px">
		<td><jsp:include page="ListComCom.jsp" /></td>
		<td><jsp:include page="ListTwin.jsp" /></td>
	</table>
	
	<jsp:include page="ListFavorite.jsp" />
	<br>
	<jsp:include page="ListTags.jsp" />
	<br>
	<jsp:include page="ListProdUsers.jsp" />
	<br>
	<jsp:include page="ListPosRev.jsp" />
	<br>
	<jsp:include page="ListPoor.jsp" />



</body>
</html>