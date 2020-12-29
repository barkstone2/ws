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
	if(session.getAttribute("cookId")==null){
		out.print("<script>alert('로그인이 필요한 작업입니다.');location.href='login.jsp';</script>");
		return;
	}
	if(session.getAttribute("cookId").equals(id) || session.getAttribute("cookGrade").equals("1")){
	}else{
		out.print("<script>alert('권한이 없습니다.');location.href='list.jsp';</script>");
		return;
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제</title>
</head>
<body>
	<h2>회원정보 삭제</h2>
	<form name="deleteForm" method="post" action="deleteProc.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="hidden" name="id" value="<%=dto.getId() %>"><%=dto.getId() %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw"></td>
			</tr>
		</table>
		<input type="button" value="삭제하기" onclick="memDel();">
	</form>
</body>
<script>
	function memDel(){
		if(confirm('정말 삭제하시겠습니까?')){
			if(deleteForm.pw.value==<%=dto.getPw()%>){
				deleteForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
			}
		}
	}

</script>
</html>