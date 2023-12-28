<%@page import="com.summer.app.departments.DepartmentDAO"%>
<%@page import="com.summer.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    DepartmentDTO departmentDTO = new DepartmentDTO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    String id = request.getParameter("department_id");
    String name= request.getParameter("department_name");
    String mana = request.getParameter("manager_id");
    String loca = request.getParameter("location_id");
    departmentDTO.setDepartment_id(Integer.parseInt(id));
    departmentDTO.setDepartment_name(name);
    departmentDTO.setManager_id(Integer.parseInt(mana));
    departmentDTO.setLocation_id(Integer.parseInt(loca));
    int result = departmentDAO.add(departmentDTO);
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>목록</h1>


	<script type="text/javascript">
		let result = '<%=result%>'
		if(result>0){
			alert('등록 성공');
		}else{
			alert('등록 실패');
		}
		window.location.href="./addProcess.jsp";
		
		
	</script>



</body>
</html>