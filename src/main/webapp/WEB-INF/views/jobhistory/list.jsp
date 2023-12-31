<%@page import="com.summer.app.JobHistory.JobhistoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.summer.app.JobHistory.JobhistoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	JobhistoryDAO jobhistoryDAO = new JobhistoryDAO();
	List<JobhistoryDTO> ar = jobhistoryDAO.getList();
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h3>Jobhistory</h3>
	
		<table>
			<thead>
					<tr>
						<th></th>
					</tr>
			</thead>
		
		
		
		
		</table>



</body>
</html>