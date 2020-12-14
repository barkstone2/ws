<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(id);
%>
	<form name="modiForm" method="post" action="modifyProc.jsp">
		<input type="hidden" name="id" value=<%=dto.getId() %>>
		아이디 : <%=dto.getId() %><br>
		비밀번호 : <input type="text" name="pw"><br>
		이름 : <%=dto.getName() %><br>
		성별 : <%=dto.getGender() %><br>
		생년월일 : <%=dto.getBirth() %><br>
		전화번호 : <input type="text" name="phone" value=<%=dto.getPhone() %>><br>
		이메일 : <input type="text" name="email" value=<%=dto.getEmail() %>><br>
		주소 : <input type="text" name="addr" value=<%=dto.getAddr() %>><br>
		가입일 : <%=dto.getJDate() %><br>
		<a href="#" onclick="modify();">[수정하기]</a>
	</form>
</body>
<script>
	function modify(){
		if(confirm('수정하시겠습니까?')){
			if(modiForm.pw.value==<%=dto.getPw()%>){
				modiForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
				modiForm.pw.focus();
			}
		}
	}
</script>
</html>