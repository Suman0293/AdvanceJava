<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr>

	<center>
	
		<form >
			<h1>User Regitration</h1>
			
			<table>
				<tbody>
					<tr>
						<th>Id Number*</th>
						<td><input type="text" name="idNumber" value=""></td>
							
					</tr>

					<tr>
						<th>First Name*</th>
						<td><input type="text" name="fristName" value=""> </td>
					</tr>

					<tr>
						<th>Last Name*</th>
						<td><input type="text" name="lastName" value=""> </td>
					</tr>

					<tr>
						<th>LoginId*</th>
						<td><input type="text" name="loginId" value=""> </td>
					</tr>

					<tr>
						<th>Password*</th>
						<td><input type="text" name="password" value=""></td>
					</tr>

					<tr>
						<th>Date Of Britd*</th>
						<td><input type="date" name="dob" Id="Dateofbrith"></td>
					</tr>

					<tr>
						<th>Address*</th>
						<td><input type="text" name="address" value=""></td>
					</tr>

					<tr>
						<td align="Right" colspan="2"><input type="submit"
							name="operation" value="SignUp"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</center>
	<hr>

</body>
</html>