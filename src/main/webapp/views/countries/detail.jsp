<%@page import="com.summer.app.Countries.CountryDTO"%>
<%@page import="com.summer.app.Countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    CountryDAO countryDAO = new CountryDAO();
    CountryDTO countryDTO = new CountryDTO();
    String sum = request.getParameter("country_id");
	int num = Integer.parseInt(sum);
    countryDTO.setCountry_id(num);	 
    countryDTO = countryDAO.getDetail(countryDTO);
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%=countryDTO.getCountry_name() %></h1>
	
	<button>추가</button>



</body>
</html>