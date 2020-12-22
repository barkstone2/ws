<%@page import="member.MemberDTO"%>
<%@page import="member.MemberExample"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	MemberExample dao = new MemberExample();
	MemberDTO dto = dao.getSelect(id);
%>
	<h2>회원 탈퇴</h2>
	<form name="deleteForm" method="post" action="deleteProc.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
		 		<td>전화번호</td>
				<td>직업</td>
			</tr>
			<tr>
				<td>
				<input type="hidden" name="id" value="<%=id%>">
				<%=dto.getId() %></td>
				<td><input type="text" name="pwd"></td>
	 			<td><%=dto.getName() %></td>
				<td><%=dto.getPhone() %></td>
				<td><%=dto.getJob() %></td>
			</tr>
		</table>
		<input type="button" value="삭제하기" onclick="delMem();">
	</form>
		
		
	
</body>
<script>
	function delMem(){
			if(confirm('탈퇴하시겠습니까?')){
				if(deleteForm.pwd.value==<%=dto.getPwd()%>){
					deleteForm.submit();
				}else{
					alert('비밀번호가 일치하지 않습니다.');
					deleteForm.pwd.focus();
				}
			}
		}
</script>
</html>