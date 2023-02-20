<%@page import="com.ty.servlets_jsp_student.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Student> list=(List)request.getAttribute("list"); %>

<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>FatherName</th>
<th>Email</th>
<th>Password</th>
<th>Fees</th>
<th>Phone</th>
<th>Delete</th>
<th>Update</th>
</tr>

<% for(Student student:list){ %>

	<tr>
	<td><%= student.getId()%></td>
	<td><%=student.getName() %></td>
	<td><%=student.getFatherName() %></td>
	<td><%= student.getEmail()%></td>
	<td><%=student.getPassword() %></td>
	<td><%= student.getFees()%></td>
	<td><%= student.getPhone()%></td>
	<td><a href="delete?id=<%= student.getId() %>"><button>delete</button></a></td>
	<td><a href="update?id=<%= student.getId() %>"><button>update</button></a></td>
	</tr>
	
<% } %>
</table>

</body>
</html>