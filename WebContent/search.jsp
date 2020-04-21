<!--Example search html -->
<!DOCTYPE html>
<html lang="en">
<head>
<title>Search Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form class="form-inline" method="post" action="search.jsp">
			<input type="text" name="search" class="form-control"
				placeholder="Search">
			<button type="submit" name="save" class="btn btn-primary">Search</button>
		</form>
	</div>
	<jsp:include page="searchResults.jsp" />
</body>
</html>