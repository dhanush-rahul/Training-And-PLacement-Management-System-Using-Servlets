<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portal Login</title>
</head>
<style>
.center {
	text-align: center;
	margin: auto;
	width: 60%;
	border: 3px solid #73AD21;
	padding: 40px 0;
}
</style>
<body>
	<div class="center">
		<p style="font-size: 20px">Sign in</p>
		<form action="LoginServlet?operation=FacultyLogin" method="post" align="center">
			<table align="center">
				<tr>
					<td>Enter Username:</td>
				</tr>
				<tr>
					<td><input type="text" name="username" value="" required></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
				</tr>
				<tr>
					<td><input type="password" name="password" value="" required></td>
				</tr>
			</table>
			<input type="submit" name="login" value="LOGIN"
				style="font-size: 10pt; color: white; background-color: green; border: 2px solid #336600; padding: 10px">
			<p>
				Don't have an account?<a href="register.jsp">Create an account</a>
			</p>
			<p><a href="studentLogin.jsp">Student Login</a></p>
		</form>
	</div>
</body>
</html>