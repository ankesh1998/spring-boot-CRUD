<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%
			if (request.getAttribute("result") != null) {
				out.print(request.getAttribute("result"));
			}
		%>
		<form action="userRegistration" method="post">
			<table>
				<thead>
					<tr>
						<th colspan="2">User Details</th>
					</tr>
				</thead>
				<tr>
					<td>Name -</td>
					<td><input type="text" name="user_name" required="required"></td>
				</tr>
				<tr>
					<td>E-mail -</td>
					<td><input type="text" name="user_email"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$|null"
						title="Please enter a valid E-mail address"></td>
				</tr>

				<tr>
					<td>Contact -</td>
					<td><input type="text" name="user_contact" required="required"
						pattern="[6789][0-9]{9}"
						title="Please enter a valid contact number" maxlength="10"></td>
				</tr>
				<tr>

					<td colspan="2"><input type="submit" value="submit"></td>


				</tr>
			</table>
		</form>
		<div>
			<a href="allUser"><button>View all User</button></a>
		</div>
	</div>
</body>
</html>