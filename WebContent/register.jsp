<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>

* {
  box-sizing: border-box;
}

input[type=text], select, textarea,input[type=password] {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
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

.container {
  border-radius: 5px;
  background-color:lightblue;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;Insert title here
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
<head>
<meta charset="UTF-8">
<title>Faculty Registration</title>
</head>
<body>
<div class="container">
	<form class="center" action="AdminServlet?operation=FacultyRegister"
		method=post>
		<div class="row">
		<div class="col-25">
		<label>Username:</label></div> <div class="col-75"><input type="text" name="username" required></div></div>
		<div class="row">
		<div class="col-25">
		<label> Password:</label></div><div class="col-75"><input type="password" name="password" required></div></div>
			<div class="row">
			<div class="col-25">
			<label>Stream:</label></div><div class="col-75"><select name="stream" required>
			<option value="">Choose</option>
			<option value="CSE">CSE</option>
			<option value="ECE">ECE</option>
			<option value="MECH">MECH</option>
			<option value="CIVIL">CIVIL</option>
			<option value="IT">IT</option>
		</select> </div></div>
		<div class="row">
		<div class="col-25">
		<label>Role(Faculty/HOD):</label></div><div class="col-75"><input type="text" name="role"
			required></div></div>
			<div class="row"> <input type="submit"
			value="Submit"></div>
	</form>
</div>
	<button onclick="goBack()" value="Back">Back</button>
	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>