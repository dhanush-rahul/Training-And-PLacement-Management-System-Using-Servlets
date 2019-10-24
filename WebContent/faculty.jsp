<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
body{
background-image: url("data:image/jpeg;base64,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");
background-position: top;
background-size:400px;
background-repeat: no-repeat;
}
form{
   
      position:bottom;
      width:250px;
      text-align: center;
  } 
    ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

/* Change the link color on hover */
li a:hover {
  background-color: lightblue;
  color: black;
}
  
</style>

<head>
<meta charset="UTF-8">
<title>Faculty Login</title>
</head>
<body>
<form>
<ul>
<li><a href="FacultyServlet?operation=viewStudents">View Students</a></li>
<li><a href="FacultyServlet?operation=viewPlaced">View Placed Students</a></li>
<li><a href="FacultyServlet?operation=ActivitiesHOD">Post Academic Activities</a></li>
<li><a href="FacultyServlet?operation=Logout">Logout</a></li>
</ul>
</form>
</body>
</html>