<%@page import="java.net.Inet4Address"%>
<%@page import="etc.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@include file="../include/include_check.jsp" %>
<%@include file="../include/include_menu.jsp" %>
<%@include file="../include/include_session_check.jsp" %>

<!DOCTYPE html>
<html>
<head>
<style>
td {
	text-align: center;
}
</style>

<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>

${cookId}<br>
로그인한 사람의 이름 : ${cookDto.name} <br>
로그인한 사람의 닉네임 : ${cookDto.nickname }<br>
로그인한 사람의 전화번호 : ${cookDto.phone }<br>
로그인한 사람의 주소 : ${cookDto.address }<br>
로그인한 사람의 등급 : ${cookDto.grade }<br>
	<h2>회원목록</h2>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>닉네임</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>성별</td>
			<td>직업</td>
			<td>회원등급</td>
			<td>가입일</td>
		</tr>
		
<%
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> dtos = dao.getListAll();
		for(int i=0; i<dtos.size(); i++){
			MemberDTO dto = dtos.get(i);
			String grade = dto.getGrade();
			if(grade.equals("4")){
				grade = "일반회원";
			}else if(grade.equals("3")){
				grade="배송관리자";
			}else if(grade.equals("2")){
				grade="상품관리자";
			}else{
				grade="전체관리자";
			}
			%>
		<tr>
			<td><%=dto.getNo() %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getNickname() %></td>
			<td><%=dto.getEmail() %></td>
			<td><%=dto.getPhone() %></td>
			<td><%=dto.getAddress() %></td>
			<td><%=dto.getGender() %></td>
			<td><%=dto.getJob() %></td>
			<td><%=grade+"("+dto.getGrade()+")"%></td>
			<td><%=dto.getRegi_date() %></td>
		</tr>
		<%}
%>
	</table>

</body>
</html>