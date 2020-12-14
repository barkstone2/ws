<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%
	String cookId = "";
	if(session.getAttribute("cookId") != null){
		cookId = (String) session.getAttribute("cookId");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(no, id);
%>
	<form name="delForm" method="post" action="delProc.jsp">
		<input type="hidden" name="no" value=<%=dto.getNo() %>>
		회원번호 : <%=dto.getNo() %><br>
		<input type="hidden" name="id" value=<%=dto.getId() %>>
		아이디 : <%=dto.getId() %><br>
		비밀번호 : <input type="text" name="pw"><br>
		이름 : <%=dto.getName() %><br>
		전화번호 : <%=dto.getPhone() %><br>
		이메일 : <%=dto.getEmail() %><br>
		생년월일 : <%=dto.getBirth() %><br>
		가입일 : <%=dto.getjDate() %><br>
		<a href="#" onclick="memDelete();">[삭제하기]</a>
	</form>
		<a href="logoutProc.jsp">[로그아웃]</a>
	
</body>
<script>
	function memDelete(){
		if(confirm('정말 삭제하시겠습니까?')){
			if(delForm.pw.value==<%=dto.getPw()%>){
				delForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
				delForm.pw.focus();
			}
		}
	}
</script>
</html>