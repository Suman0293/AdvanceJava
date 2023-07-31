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
		String msg = (String) request.getAttribute("msg");
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<%@ include file="Header.jsp"%>
	<center>
		<form action="UserCtl" method="post">
			
			<h1>User Update</h1>
			<table>
			
			

				<tr>
					<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
				</tr>
				
				
				
				<tr>
					<th>FirstName*</th>
					<td><input type="text" name="firstName" value="<%=bean.getFirstName() %>"></td>


				</tr>
				<tr>
					<th>LastName*</th>
					<td><input type="text" name="lastName" value="<%=bean.getLastName() %>"></td>


				</tr>
				<tr>
					<th>LoginId*</th>
					<td><input type="text" name="loginId" value="<%=bean.getLogin_id() %>"></td>


				</tr>
				<tr>
					<th>Password*</th>
					<td><input type="text" name="password" value="<%=bean.getPassword() %>"></td>

				</tr>

				<tr>
					<th>Dob*</th>
					<td><input type="text" name="dob" value="<%=bean.getDob() %>"></td>

				</tr>


				<tr>
					<th>Address*</th>
					<td><input type="text" name="address" value="<%=bean.getAddress() %>"></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation" value="Update">
					<input type="submit" name="operation" value="Add">
					</td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>