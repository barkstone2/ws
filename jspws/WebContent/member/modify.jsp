<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_menu.jsp" %>    
<%request.setCharacterEncoding("utf-8"); %>
<%

	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(id);
	String job = dto.getJob();
	if(session.getAttribute("cookId")==null){
		out.print("<script>alert('로그인이 필요한 작업입니다.');location.href='login.jsp';</script>");
		return;
	}
	if(session.getAttribute("cookId").equals(id) || session.getAttribute("cookGrade").equals("1")){
	}else{
		out.print("<script>alert('권한이 없습니다.');location.href='login.jsp';</script>");
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
td {
	text-align: center;
}
</style>
<title>회원정보 수정</title>
</head>
<body>
	<h2>회원정보 수정</h2>
	<form name="modifyForm" method="post" action="modifyProc.jsp">
		<table border="1">
			<tr>
				<td>회원번호</td>
				<td><%=dto.getNo() %></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
				<input type="hidden" value="<%=dto.getId() %>" name="id"><%=dto.getId() %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=dto.getName() %></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="nickname" value="<%=dto.getNickname()%>"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="<%=dto.getPhone()%>"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="<%=dto.getEmail()%>"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" value="<%=dto.getAddr()%>"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%=dto.getGender() %></td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option value="회사원" <%if(job.equals("회사원")) out.print("selected"); %>>회사원</option>
						<option value="학생" <%if(job.equals("학생")) out.print("selected"); %>>학생</option>
						<option value="공무원" <%if(job.equals("공무원")) out.print("selected"); %>>공무원</option>
						<option value="군인" <%if(job.equals("군인")) out.print("selected"); %>>군인</option>
						<option value="주부" <%if(job.equals("주부")) out.print("selected"); %>>주부</option>
						<option value="무직" <%if(job.equals("무직")) out.print("selected"); %>>무직</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>회원등급</td>
				<td><%=dto.getGrade() %></td>
			</tr>
			<tr>
				<td>가입일</td>
				<td><%=dto.getRdate() %></td>
			</tr>	
		</table>
		<input type="button" value="수정하기" onclick="modify();">
	</form>
</body>
<script>
	function modify(){
		if(confirm('수정하시겠습니까?')){
			if(modifyForm.pw.value==<%=dto.getPw()%>){
				modifyForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
			}
		}
	}
</script>
</html>