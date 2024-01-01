<%@page import="com.summer.app.Locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.summer.app.Locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	LocationDAO locationDAO = new LocationDAO();
    	List<LocationDTO> ar = locationDAO.getList();
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h3>Locations List</h3>
			
			
			
		<table>
			<thead>
				<tr>
					<th>Location_id</th>
					<th>Street_address</th>
					<th>Postal_code</th>
					<th>City</th>
					<th>State_province</th>
					<th>Country_id</th>
				</tr>
			</thead>
			<tbody>
				<%for(LocationDTO locationDTO : ar) {%>
				<tr>
					<td>locationDTO.getLocation_id()</td>
					<td>locationDTO.getStreet_address()</td>
					<td>locationDTO.getPostal_code()</td>
					<td>locationDTO.getCity()</td>
					<td>locationDTO.getState_province</td>
					<td>locationDTO.getCountry_id</td>
				</tr>
				<%} %>
			</tbody>
		</table>		
</body>
</html>