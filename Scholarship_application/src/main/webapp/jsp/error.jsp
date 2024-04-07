<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>Error Occurred</h1>

<p>${errorMessage}</p>
<p>jdbcDriver: ${jdbcDriver}</p>
<p>dbURL: ${dbURL}</p>
<p>dbUserName: ${dbUserName}</p>
<p>dbPassword: ${dbPassword}</p>
<p>username: ${username}</p>
<p>password: ${password}</p>
</body>
</html>