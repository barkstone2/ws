<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body {
margin: 0;
height: 100%;
overflow: hidden;
}
</style>
</head>
<body>
	<div style="width: 100%; height: inherit;">
		 <div style="height: 20%; background-color: aqua;"></div>
		 <div style="height: 60%; background-color: gray; display: flex">
		 	<div style="width: 20%; height:100%;"></div>
		 	<div style="width: 80%; height:100%; display: flex; align-items: center; justify-content: center;">
		 		<div style="width: 90%; height:80%; border: 1px solid black;">
		 			<div style="display:flex; border-bottom: 1px solid black;">
		 				<div style="width:10%; border-right: 1px solid black; text-align: center;">순번</div>
		 				<div style="width:40%; border-right: 1px solid black; text-align: center;">제목</div>
		 				<div style="width:20%; border-right: 1px solid black; text-align: center;">글쓴이</div>
		 				<div style="width:30%; text-align: center;">작성일</div>
		 			</div>
		 		</div>
		 	</div>
		 </div>
		 <div style="height: 20%;"></div>
	</div>
</body>
</html>