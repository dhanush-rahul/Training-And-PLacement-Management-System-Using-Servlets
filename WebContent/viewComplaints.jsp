<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.StudentComplaints,java.util.*"%>
<!DOCTYPE html>
<html>
<style>
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
#student {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#student td, #student th {
	border: 1px solid #ddd;
	padding: 8px;
}

#student tr:nth-child(even) {
	background-color: #f2f2f2;
}

#student tr:hover {
	background-color: #ddd;
}

#student th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
<head>
<meta charset="UTF-8">
<title>Complaints</title>
</head>
<%
ArrayList<StudentComplaints> complaints = (ArrayList<StudentComplaints>) request.getAttribute("complaints");
%>
<body>
<table id="student">
<tr><th>Student ID</th>
<th>Stream</th>
<th>Complaint</th>
</tr>
<%for(StudentComplaints complaint : complaints) {%>
<tr><td><%=complaint.getStudentId()%></td><td><%=complaint.getStream() %></td><td><%=complaint.getComplaint()%></td></tr>
<%} %>

</table>

<button onclick="goBack()" value="Back">Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>