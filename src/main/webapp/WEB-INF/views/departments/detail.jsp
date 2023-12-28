<%@page import="com.summer.app.departments.DepartmentDAO"%>
<%@page import="com.summer.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    DepartmentDTO departmentDTO = new DepartmentDTO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    String n  = request.getParameter("department_id");
    int num = Integer.parseInt(n);
    departmentDTO.setDepartment_id(num);
    departmentDTO = departmentDAO.getDetail(departmentDTO);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=departmentDTO.getDepartment_name() %></h1>
	<input type="hidden" id="hidden" value="<%=departmentDTO.getDepartment_id()%>">
	<button id="btn">수정</button>
	
	
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let sum = document.getElementById("hidden");
		btn.addEventListener("click",function(){
			alert(sum.value);
		location.href="./update.jsp?department_id="+sum.value;			
		});
	</script>
</body>
</html>