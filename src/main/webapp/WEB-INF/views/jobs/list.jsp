<%@page import="java.util.List"%>
<%@page import="com.summer.app.Jobs.JobDAO"%>
<%@page import="com.summer.app.Jobs.JobDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    JobDAO jobDAO = new JobDAO();
   	List<JobDTO> ar = jobDAO.getList();
   	
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Job List</h3>
	
	
	
		<table>
			<thead>
				<tr>
					<th>Job_id</th>
					<th>Job_title</th>
					<th>Min_salary</th>
					<th>Max_salary</th>
				</tr>
			</thead>
			<tbody>
				<%for(JobDTO joibDTO: ar){ %>
				<tr>
					<td>jobDTO.getJob_id()</td>
					<td>jobDTO.getJob_title()</td>
					<td>jobDTO.getMin_salary()</td>
					<td>jobDTO.getMax_salary()</td>
				</tr>
				<%} %>
			</tbody>
		</table>
</body>
</html>