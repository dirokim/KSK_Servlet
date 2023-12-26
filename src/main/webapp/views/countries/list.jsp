<%@page import="com.summer.app.Countries.CountryDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.summer.app.Countries.CountryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    CountryDAO countryDAO = new CountryDAO();
    List<CountryDTO> ar = countryDAO.getList();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Country List</h1>
	<table>
		<thead>
			<tr>
				<th>
				</th>
			</tr>
		</thead>
	
	</table>




</body>
</html>