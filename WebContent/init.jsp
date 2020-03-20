<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session= "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Initializing database...</title>

      <style>
         table, th, td {
            border: 1px solid black;
         }
      </style>
   </head>

   <body>
      <h1>Current Users</h1>
      <table>
         <tr>
            <th>Username</th>
            <th>Password</th>
         </tr>
         <tr>
            <td>jane@gmail.com</td>
            <td>23kjd</td>
         </tr>
         <tr>
            <td>bob@gmail.com</td>
            <td>1972w30</td>
         </tr>
          <tr>
            <td>pascal@gmail.com</td>
            <td>passwordword</td>
         </tr>
          <tr>
            <td>anna@yahoo.com</td>
            <td>fyghuskd</td>
         </tr>
          <tr>
            <td>lilly@hotmail.com</td>
            <td>ahahdbs</td>
         </tr>
          <tr>
            <td>mary@yahoo.com</td>
            <td>1970j</td>
         </tr>
          <tr>
            <td>matty@gmail.com</td>
            <td>38492</td>
         </tr>
          <tr>
            <td>cora@hotmail.com</td>
            <td>dfghjhgf</td>
         </tr>
          <tr>
            <td>harry@gmail.com</td>
            <td>197jh0</td>
         </tr>
          <tr>
            <td>canada@hotmail.com</td>
            <td>passsss12</td>
         </tr>
      </table>
   </body>
</html>















<SCRIPT LANGUAGE="javascript">
       session.setAttribute("initialized", "Yes");
	window.location.replace = "rootResult.jsp";
 </SCRIPT>