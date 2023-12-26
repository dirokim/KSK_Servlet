<%@page import="com.summer.app.departments.DepartmentDTO"%>
<%@page import="com.summer.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
  	DepartmentDAO departmentDAO = new DepartmentDAO();
  	DepartmentDTO departmentDTO = new DepartmentDTO();
	String num = request.getParameter("department_id");
    departmentDTO.setDepartment_id(Integer.parseInt(num));
    departmentDTO = departmentDAO.getDetail(departmentDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="" class="" action="./update.jsp">
	<div>
	부서번호 <input type="text" value="<%=departmentDTO.getDepartment_id() %>" name="department_id" >
	</div>
	<div>
	부서명 <input type="text" value="<%=departmentDTO.getDepartment_name()%>" name="department_name">
	</div>
	<div>
	매니저아이디 <input type="text" value="<%=departmentDTO.getManager_id() %>" name="manager_id">
	</div>
	<div>
	지역 아이디 <input type="text" value="<%=departmentDTO.getLocation_id() %>" name="location_id">	
	</div>
	<button>수정</button>
	</form>
	

</body>
</html>