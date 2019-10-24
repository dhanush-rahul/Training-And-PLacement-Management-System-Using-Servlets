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
  background-color: lightblue;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
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
<title>Student Registration</title>
</head>
<body>
<div class="container">
	<form action="AdminServlet?operation=StudentRegister" method=post>
	<div class="row">
	<div class="col-25">
		<label>Student Username:</label></div>
	<div class="col-75"><input type="text" name="username" required></div></div>
			<div class="row">
			<div class="col-25">
				<label>Student ID:</label></div>
				<div class="col-75"><input type="text" name="studentId" required></div></div>
			<div class="row">
			<div class="col-25">
				<label>Student Password:</label></div>
				<div class="col-75"><input type="password" name="password" required></div></div>
			<div class="row">
			<div class="col-25">
				<label>Stream:</label></div>
				<div class="col-75"><select name="stream" required>
						<option value="">Choose</option>
						<option value="CSE">CSE</option>
						<option value="ECE">ECE</option>
						<option value="MECH">MECH</option>
						<option value="CIVIL">CIVIL</option>
						<option value="IT">IT</option>
				</select></div></div>
			
			<div class="row">
			<div class="col-25">
				<label>Current Status:</label></div>
				<div class="col-75"><select name="status" required><option value="">Choose</option>
						<option value="Not-Placed">Not Placed</option>
						<option value="Placed">Placed</option></select>
			</div></div>

			<div class="row">
				<div class="col-25"><label>Enter Marks</label></div></div>
			<div class="row">
				<div class="col-25"><label>1-1</label></div>
				<div class="col-75"><input type="number" name="one-one" step=".01" required></div></div>
			<div class="row">
			
				<div class="col-25"><label>1-2</label></div>
				<div class="col-75"><input type="number" name="one-two" step=".01" required></div></div>
			<div class="row">
			
				<div class="col-25"><label>2-1</label></div>
				<div class="col-75"><input type="number" name="two-one" step=".01" required></div></div>
			<div class="row">
			
				<div class="col-25"><label>2-2</label></div>
				<div class="col-75"><input type="number" name="two-two" step=".01" required></div></div>
			<div class="row">
			
				<div class="col-25"><label>3-1</label></div>
				<div class="col-75"><input type="number" name="three-one" step=".01" required></div></div>
			<div class="row">
			
				<div class="col-25"><label>3-2</label></div>
				<div class="col-75"><input type="number" name="three-two" step=".01" required></div></div>
				
				<div style="padding-left: 650px"><input type="submit" value="Submit"></div>
			
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