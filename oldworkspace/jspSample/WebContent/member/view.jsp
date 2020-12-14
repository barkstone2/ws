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
	
	String no_ = request.getParameter("no");
	String id = request.getParameter("id");
	int no = Integer.parseInt(no_);
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(no, id);
	
%>	
	회원번호 : <%=dto.getNo() %><br>
	아이디 : <%=dto.getId() %><br>
	이름 : <%=dto.getName() %><br>
	전화번호 : <%=dto.getPhone() %><br>
	이메일 : <%=dto.getEmail() %><br>
	생년월일 : <%=dto.getBirth() %><br>
	가입일 : <%=dto.getjDate() %><br>
	<a href="#" onclick="move('M', '<%=dto.getNo() %>', '<%=dto.getId() %>')">[수정하기]</a>
	<a href="#" onclick="move('D', '<%=dto.getNo() %>', '<%=dto.getId() %>')">[삭제하기]</a>
	<a href="logoutProc.jsp">[로그아웃]</a>
	<a href="list.jsp">[회원목록]</a>
	
</body>
<script>
	function move(value1, value2, value3){
		if('<%=cookId%>'==value3){
			if(value1 == 'M'){
				location.href="modify.jsp?no="+value2+"&id="+value3;
			}else{
				location.href="delete.jsp?no="+value2+"&id="+value3;
			}
		}else{
			alert('로그인이 필요합니다.');
		}
	}
</script>

</html>