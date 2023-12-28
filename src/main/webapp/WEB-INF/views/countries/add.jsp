<%@page import="com.summer.app.Countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	CountryDAO countryDAO = new CountryDAO();
 
 
 %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./addProcess">
		<div>
			Country_id <input type="text" name="country_id">
		</div>
		<div>
			Country_nmae <input type="text" name="country_name">
		</div>
		<div>
			Region_id <input type="text" nmae="region_id">
		</div>
						
	</form>




</body>
</html>