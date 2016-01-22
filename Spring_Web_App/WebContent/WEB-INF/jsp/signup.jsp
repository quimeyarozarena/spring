<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up here ! </title>
</head>
<body>

<div>

<label>${message}</label>

	<form action="${pageContext.request.contextPath}/signup" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label>Enter username: </label></td>
				<td><input type="text" name="username"/></td>
			</tr>
			
			<tr>
				<td><label>Enter password: </label></td>
				<td><input type="password" name="password"/></td>
			</tr>
			
			<tr>
				<td><label>Re-enter password: </label></td>
				<td><input type="password" name="repassword"/></td>
			</tr>
			
			<tr>
				<td><label>Choose Gender: </label></td>
				<td><input type="radio" name="gender" value="male"/>
				<input type="radio" name="gender" value="female"/></td>
			</tr>
			
			<tr>
				<td><label>Select vehicle: </label></td>
				<td><input type="checkbox" name="vehicle" value="Car"/>
				<input type="checkbox" name="vehicle" value="Bike"/></td>
			</tr>
			
			<tr>
			
			<td><label>Select country: </label></td>
			
				<td>
					<select name="country">
						<option value="India">INDIA</option>
						<option value="usa">USA</option>
						<option value="uk">UK</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td><label>Select image: </label></td>
				<td><input type="file" name = "image"/></td>
			</tr>
		</table>
	
	<input type="submit" value="Save" />
	</form>
</div>

</body>
</html>