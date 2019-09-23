<%@page import="com.springbootcrud.user.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
	<%
		if (request.getAttribute("result") != null) {
			String result = (String) request.getAttribute("result");
			out.print("<center><b style='color:green'>" + result + "</b></center>");
		}
	%>


	<div class="row">
		<div class='col-xs-8 col-sm-6 col-xs-offset-2 col-sm-offset-3'>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>User ID</th>
						<th>User Name</th>
						<th>User E-mail</th>
						<th>User Contact</th>

						<th colspan="2">Action</th>
					</tr>
				</thead>
				<%
					//out.print(request.getAttribute("result"));

					List<User> user = (List<User>) request.getAttribute("allUser");
					for (User u : user) {
				%>
				<tr>
					<td><%=u.getUser_id()%></td>
					<td><%=u.getUser_name()%></td>
					<td>
						<%
							if (u.getUser_email() == null) {
									u.setUser_email("Not Available");
								}
						%><%=u.getUser_email()%></td>

					<td><%=u.getUser_contact()%></td>
					<td>
						<button class="btn btn-primary btn-sm"
							onclick="location.href = 'edit_user?Id=<%=u.getUser_id()%>';">Edit</button>
						<button class="btn btn-primary btn-sm"
							onclick="location.href = 'delete_user?Id=<%=u.getUser_id()%>';">Delete</button>
					</td>

				</tr>

				<%
					}
				%>
			</table>
		</div>
	</div>
	<div align="center">
		<a href="/" class="btn btn-default">Go Back to Home</a>
	</div>
</body>
</html>