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
		<thead border=1>
			<tr>
				<th>국가이름</th>
				<th>리젼 아이디</th>
				<th>국가이름</th>
			</tr>
		</thead>
		<tbody>
			<%=for(CountryDTO countryDTO:ar){ %>
			<tr>
				<td>
					<%=countryDTO.getCountry_id() %>
				</td>
				<td>
					<%=countryDTO.getRegion_id() %>
				</td>
				<td>
				 	<a href="./detail.jsp?country_id=<%=countryDTO.getCountry_id()%>"><%=countryDTO.getCountry_name() %></a>
				</td>
			</tr>
			
			<%}%>
		</tbody>
	
	</table>




</body>
</html>