<%@page import="com.summer.app.departments.DepartmentDAO"%>
<%@page import="com.summer.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    DepartmentDTO dto = new DepartmentDTO();
    DepartmentDAO dao = new DepartmentDAO();
    String n  = request.getParameter("department_id");
    int num = Integer.parseInt(n);
    dto.setDepartment_id(num);
    dto = dao.getDetail(dto);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=dto.getDepartment_id() %></h1>
</body>
</html>