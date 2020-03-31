<!-- This is an example page of a video -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<html>
<head>
<title>Example Video</title>
</head>
<body>

<h1>Funniest Joke you've ever Heard About Being Late</h1>
<iframe width="900" height="506" src="https://www.youtube.com/embed/kLUFit8815c" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<h2>Description</h2>
<h3>A hilarious video about being late</h3>
<h2>Tags</h2>
<h3>funny, late, joke</h3>

<h2>Add to favorites</h2>
<form action="favComedian.jsp" method="post"> <input type="submit"
            value="Submit" /> </form>
<h2>Delete from favorites</h2>
<form action="favComedian.jsp" method="post"> <input type="submit"
            value="Submit" /> </form>

<h2>Comments</h2>
<h3>Enter a Comment</h3>

<table style="with: 50%">
				<tr> 
					<td>Ranking</td>>
				<td>
					<select id="rank" name="rank">
 					<option value="poor">poor</option>
  					<option value="fair">fair</option>
  					<option value="good">good</option>
  					<option value="excellent">excellent</option>
					</select>
				</td>
				</tr>
				<tr>
					<td>Comment</td>
					<td><input type="text" name="comment" /></td>
				</tr>
</table>
<form action="exampleVideo.jsp" method="post"> <input type="submit"
            value="Submit" /> </form>

</body>
</html>