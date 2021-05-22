<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	hello world
	<form action="/checkin">
		<input type="text" name="name"><br> <input type="submit"
			value="LOG IN">
	</form>
	<form action="/getLogByDate">
		<input type="text" name="getLogByDate"><br> <input
			type="submit" value="Get Log By Date">
	</form>
	<form action="/getAllLogs">
		<input type="submit" value="Get All Logs">
	</form>

</body>
</html>