<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String id_ = "";
	String pw_ = "";

	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getLogin(id);
	int state = dto.getState();
	id_ = dto.getId();
	pw_ = dto.getPw();

	String cookId = null;
	if(state == 2){%>
		<script>
			alert('휴면회원 입니다.');
			location.href='list.jsp';
		</script>
	<%}else {
		if(id.equals(id_)){
			if(pw.equals(pw_)){
				session.setAttribute("cookId", id);
				
				%>
					<script>
						alert('로그인 성공');
						location.href='list.jsp';
					</script>	
					
				<%}else{%>
					<script>
						alert('비밀번호가 틀립니다.');
						location.href='login.jsp';
					</script>
				<%}
			}else{%>
				<script>
					alert('등록되지 않은 아이디입니다.');
					location.href='login.jsp';
				</script>	
			<%}
	}	



%>    
    
