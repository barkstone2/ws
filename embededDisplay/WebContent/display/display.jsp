<%@page import="db.HumanDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.DbMethod"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	DbMethod db = new DbMethod();
	ArrayList<HumanDTO> dtos = db.getListAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td align="center">AptID</td>
			<td align="center">Security</td>
			<td align="center">Light</td>
			<td align="center">AirConditioner</td>
			<td align="center">Television</td>
			<td align="center">Cucu</td>
		</tr>
	
<%
	for(int i=0; i<dtos.size(); i++){
		HumanDTO dto = dtos.get(i);%>
		<tr>
			<td align="center"><%=dto.getAptId() %></td>
			<td align="center"><%=dto.getSecurity() %></td>
			<td align="center"><%=dto.getLight() %></td>
			<td align="center"><%=dto.getAirConditioner() %></td>
			<td align="center"><%=dto.getTelevision() %></td>
			<td align="center"><%=dto.getCucu() %></td>
		</tr>
		
	<%}%>
		
	
	</table>
	
	
</body>
</html>