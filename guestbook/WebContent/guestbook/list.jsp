<%@page import="com.gb.model.dto.GuestBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gb.model.dao.GuestBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String searchType = request.getParameter("searchType");
	String searchData = request.getParameter("searchData");
	if(searchType == null || searchData == null){
		searchType = null;
		searchData = null;
	}
	out.print("searchType : "+searchType+"<br>");
	out.print("searchData : "+searchData+"<br>");

	GuestBookDAO dao = new GuestBookDAO();
	ArrayList<GuestBookDTO> dtos = dao.getListAll(searchType, searchData);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<style>
#tarea{
height:98%;
width: 98%;
pointer-events: none;
border: none;
resize: none;
}
</style>
</head>
<body>
	<h2>방명록</h2>
	<select name="searchType">
		<option value="name">이름</option>
		<option value="content">내용</option>
		<option value="all">이름+내용</option>
	</select>
	<input type="text" name="searchValue">
	<input type="button" value="검색">
	<br><br>
	<input type="button" value="글쓰기" onclick="move();">
	<br>
<%
if(dtos.size()==0){
	out.print("등록된 방명록이 없습니다.");
}else{
	out.print(dtos.size()+"개의 글이 있습니다.");
	for(int i=0; i<dtos.size(); i++){
		GuestBookDTO dto = dtos.get(i);
	%>
		<table border="1" width="500">
			<tr>
				<td>글번호</td>
				<td><%=dto.getNo()%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=dto.getName()%></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=dto.getWrite_date()%></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=dto.getEmail()%></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea id="tarea"><%=dto.getContent()%></textarea>
				</td>
			</tr>
		</table>
	<%}
}%>

	
</body>
<script>
function move(){
	location.href='write.jsp';
}
</script>
</html>