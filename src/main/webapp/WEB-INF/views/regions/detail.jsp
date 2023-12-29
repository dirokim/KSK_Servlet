<%@page import="com.summer.app.regions.RegionDTO"%>
<%@page import="com.summer.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
  <%
    
    //RegionDTO regionDTO = (RegionDTO)request.getAttribute("detail");
	

 %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3>${requestScope.detail.region_id}</h3>
	<h3>${requestScope.detail.region_name }</h3>	
	<input type="hidden" value="" id="hidden">
	<button id="btn">수정</button>
 
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		btn.addEventListener("click",function(){
			
			let num = document.getElementById("hidden");
			alert(num.value);
			location.href="./update.jsp?region_id="+num.value;
		});
	</script>
	
</body>
</html>