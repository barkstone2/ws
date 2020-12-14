<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="student.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String sid = request.getParameter("sid");
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentDTO> list = dao.getListAll();
		
	%>
	<form name="addScoreForm" method="post" action="addScoreProc.jsp">
		학년 : <input type="radio" name="hakyun" value="1">1
		<input type="radio" name="hakyun" value="2">2
		<input type="radio" name="hakyun" value="3">3<br>
		시험구분 : <input type="radio" name="testType" value="중간고사">중간고사
		<input type="radio" name="testType" value="기말고사">기말고사<br>
		국어 : <input type="text" name="kor"><br>
		영어 : <input type="text" name="eng"><br>
		수학 : <input type="text" name="mat"><br>
		과학 : <input type="text" name="sci"><br>
		학생 아이디 : 
		<select name="sid">
			<%
				for(int i=0; i<list.size(); i++){
					StudentDTO dto = list.get(i);
				%>
					<option value="<%=dto.getSid()%>"><%=dto.getSid()%></option>
				<%}
			%>
		</select><br>
		<input type="submit">
	</form>
	
	
	
</body>
</html>