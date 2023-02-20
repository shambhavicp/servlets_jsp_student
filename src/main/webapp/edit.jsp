<%@page import="com.ty.servlets_jsp_student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Student student=(Student)request.getAttribute("student"); %>


<form action="edit" method="post">
Id:<input type="number" name="id" placeholder="Enter your id" value="<%= student.getId() %>" readonly="readonly">
Name:<input type="text" name="name" placeholder="Enter your name" value="<%= student.getName() %>">
FatherName:<input type="text" name="fathername" placeholder="Enter your father name" value="<%= student.getFatherName() %>">
Email:<input type="email" name="email" placeholder="Enter your email" value="<%= student.getEmail() %>">
Password:<input type="password" name="password" placeholder="Enter your password" value="<%= student.getPassword() %>">
Fees:<input type="number" name="fees" placeholder="Enter the fees" value="<%= student.getFees() %>" readonly="readonly">
Phone:<input type="tel" name="phone" placeholder="Enter your Phone" value="<%= student.getPhone() %>">

<input type="submit" value="Submit">

</form>


</body>
</html>