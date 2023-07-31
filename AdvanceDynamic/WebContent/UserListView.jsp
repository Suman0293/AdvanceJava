
<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
tr {
	border-style: 2px solid black;
	border-de
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="UserListCtl.do" method="post">
		<%@include file="Header.jsp"%>


		<%
			int pageNo = (Integer) request.getAttribute("pageNo");
			int index = ((pageNo - 1) * 5) + 1;
			List list = (List) request.getAttribute("list");
			Iterator it = list.iterator();
		%>

		<table>

			<tr>
				<td><input type="text" name="firstName"
					placeholder="Enter First Name"></td>
				<td><input type="date" name="dob"></td>
				<td></td>
				<td><input type="submit" name="operation" value="Search"></td>
			</tr>
			<tr></tr>
		</table>



		<table border="1px solid" style="width: 100%; border-collapse:collapse;">
			<tr>
				<th width="5%">Select</th>
				<th width="5%">S.No</th>
				<th width="13%">FirstName</th>
				<th width="13%">LastName</th>
				<th width="13%">LoginId</th>
				<th width="8%">Password</th>
				<th width="13%">Dob</th>
				<th width="8%">Address</th>
				<th width="5%">Edit</th>
			</tr>

			<%
				while (it.hasNext()) {

					UserBean bean = (UserBean) it.next();
			%>
			<tr>
				<td style="text-align: center;"><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td style="text-align: center;"><%=index++%></td>
				<td style="text-align: center;"><%=bean.getFirstName()%></td>
				<td style="text-align: center;"><%=bean.getLastName()%></td>
				<td style="text-align: center;"><%=bean.getLogin_id()%></td>
				<td style="text-align: center;"><%=bean.getPassword()%></td>
				<td style="text-align: center;"><%=bean.getDob()%></td>
				<td style="text-align: center;"><%=bean.getAddress()%></td>
				<td style="text-align: center;"><a href="UserCtl?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>


		</table>
		<table border="1px solid" style="width: 100%; border-collapse:collapse;" >
			<tr>
				<td width="25%"><input type="submit" name="operation" value="Previous"></td>
				<td width="25%"><input type="submit" name="operation" value="Add"></td>
				<td width="25%"><input type="submit" name="operation" value="Delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="Next"></td>
			</tr>
		</table>

		<input type="hidden" name="pageNo" value="<%=pageNo%>">

	</form>

</body>
</html>