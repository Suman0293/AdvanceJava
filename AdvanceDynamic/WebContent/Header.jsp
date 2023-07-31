<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean bean1 = (UserBean) session.getAttribute("user");
	%>
	<%
		if (bean1 != null) {
	%>

	<h3>
		Hi....
		<%=bean1.getFirstName()%>

	</h3>
	<h3>
		<a href=" UserListCtl.do">UserList</a> |
		|<a href="LoginCtl?operation=logout">Logout</a>

	</h3>

	<%
		} else {
	%>


	<table width="100%" border="0">
		<tr>
			<td width="90%"></td>
			<td rowspan="2">
				<h1 align="Right">
					<img src="img/logo.png">
				</h1>
			</td>

		</tr>
		<tr>
			<td>
				<h3>Hi, admin (admin)</h3>

			</td>
		</tr>
	</table>
	<%
		}
	%>
	<hr>
</body>
</html>