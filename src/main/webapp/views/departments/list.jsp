<%@page import="java.util.List"%>
<%@page import="com.summer.app.departments.DepartmentDAO"%>
<%@page import="com.summer.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 
    DepartmentDAO departmentDAO = new DepartmentDAO();
    List<DepartmentDTO> ar = departmentDAO.getList();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border=1>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>상사아이디</th>
				<th>지역번호</th>
			</tr>
		</thead>
		<tbody>
		<% for(DepartmentDTO departmentDTO : ar){ %>
			<tr>
				<td><a href="./detail.jsp?department_id=<%=departmentDTO.getDepartment_id()%>"><%=departmentDTO.getDepartment_id()%></a></td>
				<td><a href="./detail.jsp?department_id=<%=departmentDTO.getDepartment_id()%>"><%=departmentDTO.getDepartment_name() %></a></td>
				<td><a href="./detail.jsp?department_id=<%=departmentDTO.getDepartment_id()%>"><%=departmentDTO.getLocation_id() %></a></td>
				<td><a href="./detail.jsp?department_id=<%=departmentDTO.getDepartment_id()%>"><%=departmentDTO.getManager_id() %></a></td>
			</tr>
		<%} %>
		</tbody>
	</table>


</body>
</html>