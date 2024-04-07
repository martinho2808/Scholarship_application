<%@page language="java" contentType="text/html"%>
<%
  String base = (String)application.getAttribute("base");
  String imageURL = (String)application.getAttribute("imageURL");
%>
<html>
<head>
<title>Scholarship Application</title>
</head>
<body>

<div class="header">
  <div class="logo">
    <p>Scholarship Application</p>
  </div>
  <div class="cart">
    <a class="link2" href="loginpage.jsp">Login</a>
    <a class="link2" href="register.jsp">Register</a>
  </div>
</div>

<div>
  <a href="index.jsp">Home Page</a> |
  <a href="scholarshipnews.jsp">Scholarship News</a> |
  <a href="contactus.jsp">Contact Us</a>
</div>

</body>
</html>