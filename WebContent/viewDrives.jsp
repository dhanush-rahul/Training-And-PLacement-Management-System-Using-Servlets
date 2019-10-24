<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,bean.DrivesBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drives</title>
<style>
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
</head>
<body>

<table id="student">
<tr>
<th>Company Name</th>
<th>Stream </th>
<th>Eligibility</th>
<th>Role</th>
<th>Pay</th>
<th>Contract</th>
<th>Type Of Job</th>
<th>Schedule Date</th>
<th>State</th>
<th>Current Status</th>
<th>Apply</th>
</tr>
<%		ArrayList<DrivesBean> drivesList = (ArrayList<DrivesBean>) request.getAttribute("Drives");
 %>
 <tr>
 <% for(DrivesBean drives : drivesList) {%><tr>
 
 
			<td><%=drives.getCompanyName()%></td><td>
			<%=drives.getStream() %></td><td>
			<%=drives.getEligibility()%></td><td>
			<%=drives.getRole() %></td><td>
			<%=drives.getPay() %></td><td>
			<%=drives.getContract() %></td><td>
			<%=drives.getTypeOfJob()%></td><td>
			<%=drives.getScheduleDate() %></td><td>
			<%=drives.getState() %></td><td>
			<%=drives.getCurrentStatus() %></td>
 		
			
			<%
			
			}
 %>
 <td><a href="apply.jsp">Apply</a></td>
			</tr>	
 
</table>
<button onclick="goBack()" value="Back">Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>