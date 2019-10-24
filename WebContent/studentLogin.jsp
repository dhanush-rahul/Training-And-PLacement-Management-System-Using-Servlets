<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.center {
	text-align: center;
	margin: auto;
	width: 60%;
	border: 3px solid #73AD21;
	padding: 40px 0;
}
input[type=submit],button {
	background-color: purple;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: inherit;
}

input[type=submit]:hover,button:hover {
	background-color: black;
}
</style>
<head>
<meta charset="UTF-8">
<title>Student Portal</title>
</head>
<body>
<form class="center" action="LoginServlet?operation=StudentLogin" method=post>
<table align="center">
				<tr>
					<td>Enter Username:</td>
				</tr>
				<tr>
					<td><input type="text" name="username" value=""  required></td>
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
				Don't have an account?<a href="StudentRegister.jsp">Create an account</a>
			</p>
</form>

<button onclick="goBack()" value="Back">Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>