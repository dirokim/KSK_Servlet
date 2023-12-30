<%@page import="com.summer.app.Employees.EmployeeDTO"%>
<%@page import="com.summer.app.Employees.EmployeeDAO"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    EmployeeDAO emplyeeDAO = new EmployeeDAO();
    List<EmployeeDTO> ar = emplyeeDAO.getList();
    
    
    

    %>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Employees List </h1>
	
	<table>
		<thead>
			<tr>
				<th>EMPLOYEE_ID</th>
				<th>FIRST_NAME</th>
				<th>LAST_NAME</th>
				<th>EMAIIL</th>
				<th>PHONE_NUMBER</th>
				<th>HIRE_DATE</th>
				<th>JOB_ID</th>
				<th>SALARY</th>
				<th>COMMISSION_PCT</th>
				<th>MANAGER_ID</th>
				<th>DEPARTMENT_ID</th>
			</tr>
		</thead>
		<tbody>
			<% for (EmployeeDTO employeeDTO : ar) {%>
				<tr>
					<td><a></a></td>
				
				
				
				</tr>
			<%}%>
		</tbody>
	
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>