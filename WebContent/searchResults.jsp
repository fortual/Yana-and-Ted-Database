<!--Example search jsp -->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "ytcomedy";
String userid = "john";
String password = "pass1234";
try {
	Class.forName(driver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
	<h1>Search Results</h1>
	<table width=50%>
		<%
			try {
			connection = DriverManager.getConnection(connectionUrl + database, userid, password);
			statement = connection.createStatement();
			String sql = ("SELECT * FROM Comedians WHERE firstname = '" + request.getParameter("search") + "' OR lastname = '" + request.getParameter("search") + "'");
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
		%>
		<tr>
			<td><a href= "comedian.jsp?comid=<%=resultSet.getString("comid")%>"><%=resultSet.getString("firstname")%> <%=resultSet.getString("lastname")%></a></td>
		</tr>
		<%
			}

		connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</table>
	<table width=50%>
		<%
			try {
			connection = DriverManager.getConnection(connectionUrl + database, userid, password);
			statement = connection.createStatement();
			String sql = ("SELECT * FROM youtubetags WHERE tag = '" + request.getParameter("search") + "'");
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
		%>
		<tr>
			<td><a href= "VideoPage.jsp?url=<%=resultSet.getString("url")%>"><%=resultSet.getString("tag")%></a></td>
		</tr>
		<%
			}

		connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</table>

</body>
</html>