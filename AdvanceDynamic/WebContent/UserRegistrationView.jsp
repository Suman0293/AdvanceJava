
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	%>
<center>
	<form action="UserCtl" method="post">
	<%@ include file="Header.jsp"%>
		<h1>User Registration</h1>
		<table>

			<tr>
				<%
					if (msg != null) {
				%>
				<font color="green">
				<%=msg%>
				</font>
				<%
					}
				%>
			</tr>
			<tr>
				<th>FirstName</th>
				<td><input type="text" name="firstName"></td>


			</tr>
			<tr>
				<th>LastName</th>
				<td><input type="text" name="lastName"></td>


			</tr>
			<tr>
				<th>LoginId</th>
				<td><input type="text" name="loginId"></td>


			</tr>
			<tr>
				<th>Password</th>
				<td><input type="text" name="password"></td>

			</tr>

			<tr>
				<th>Dob</th>
				<td><input type="date" name="dob"></td>

			</tr>


			<tr>
				<th>Address</th>
				<td><input type="text" name="address"></td>

			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="operation" value="Add"></td>
			</tr>

		</table>
	</form>
</center>
</body>
</html>