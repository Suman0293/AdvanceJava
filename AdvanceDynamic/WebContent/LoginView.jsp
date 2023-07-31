<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="LoginCtl" method="post">
		<%@ include file="Header.jsp"%>

		<%
			String msg = (String) request.getAttribute("msg");
			String uri = (String) request.getAttribute("uri");
		%>
		<center>

			<h1>User Login</h1>


			<table>
				<tbody>

					<tr>
						<%
							if (msg != null) {
						%>
						<font color="red">
							<h5><%=msg%></h5>
						</font>
						<%
							}
						%>
					</tr>

					<tr>
						<th>LoginId*</th>

						<td><input type="text" name="loginId" value=""></td>
					</tr>

					<tr>
						<th>Password*</th>
						<td><input type="passward" name="password" value=""></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" name="operation" value="SignIn">
							<input type="submit" name="operation" value="SignUp"></td>
					</tr>

				</tbody>
			</table>
			<input type="hidden" name="uri" value="<%=uri%>">
		</center>
	</form>
	<%@include file="Footer.jsp"%>
</body>
</html>