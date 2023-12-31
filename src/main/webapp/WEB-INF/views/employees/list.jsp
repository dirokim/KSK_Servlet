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
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getEmployee_id()</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getFirst_name()</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getLast_name()</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getEmail</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getPhone_number</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getHire_date</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getJob_id</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getSalary</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getCommission_pct</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getManager_id</a></td>
					<td><a href="./detail.jsp?employee_id=<%=EmployeeDTO.getDepartment_id()%>">EmployeeDTO.getDepartment_id</a></td>
				</tr>
			<%}%>
		</tbody>
	
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>