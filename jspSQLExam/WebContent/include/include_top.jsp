<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/include_check.jsp" %>
<table border="0" align="center" width="800">
	<tr>
		<th height="30">HOME</th>
		<th>회원관리</th>
		<th>게시판</th>
		<%=menu%>
		<th>접속IP:<%=ip%></th>
	</tr>
</table>