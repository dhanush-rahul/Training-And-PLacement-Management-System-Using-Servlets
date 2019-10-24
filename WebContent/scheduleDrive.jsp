<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>

  * {
  box-sizing: border-box;
}

input[type=text], select, textarea,input[type=password],input[type=number] {
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
<title>Schedule Drive</title>
</head>
<body>
<div class="container">
	<form action="TpoServlet?varname=scheduleDrive" method="post">
		<div class="row">
		<div class="col-25">
			<label>Company Name :</label></div>
			<div class="col-75">
				<input type="text" name="companyName" required></div></div>
				<div class="row">
				<div class="col-25">
			Stream :</div><div class="col-75"><select name="stream" required>
				<option value="">Choose</option>
				<option value="CSE">CSE</option>
				<option value="IT">IT</option>
				<option value="ECE">ECE</option>
				<option value="MECH">MECH</option>
				<option value="CIVIL">CIVIL</option>
				</select></div></div>
				<div class="row">
				<div class="col-25">
			Role :</div><div class="col-75"><input type="text" name="role" required></div></div>
			<div class="row">
			<div class="col-25">
			Eligibility(In %) :</div><div class="col-75"><input type="number" name="eligibility" required></div></div>
			<div class="row">
			<div class="col-25">
			Type Of Job :</div><div class="col-75"><select name="typeOfJob" required>
						<option value="">Choose</option>
						<option value="Internship">Internship</option>
						<option value="FullTime">Full-Time</option>
				</select></div></div>
				<div class="row">
				<div class="col-25">
				Schedule Date :</div><div class="col-75"><input type="date" name="scheduleDate" required></div></div>
				<div class="row">
				<div class="col-25">
				State :</div><div class="col-75"><input type="text" name="state" required></div></div>
			
			<div class="row">
			<div class="col-25">
				Contract Period(in months) :</div><div class="col-75">
				<input type="number" name="contract" required></div></div>
				<div class="row">
				<div class="col-25">
				Pay (CTC in LPA) :</div><div class="col-75">
				<input type="number" name="pay" step=".01" required></div></div>
				<input type="submit" value="Schedule">
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