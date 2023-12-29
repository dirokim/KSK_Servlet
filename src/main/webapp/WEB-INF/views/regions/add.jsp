<%@page import="com.summer.app.regions.RegionDTO"%>
<%@page import="com.summer.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 
	
	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>REgions Add</h1>
	
	<form id="" class="" action="./addProcess.jsp" >
		<div>
		    대륙ID<input name="region_id" type="text">
		</div>
		<div>
			대륙명 <input type="text" name="region_name">
		</div>
		<button>추가</button>
		
	</form>
	
</body>
</html>