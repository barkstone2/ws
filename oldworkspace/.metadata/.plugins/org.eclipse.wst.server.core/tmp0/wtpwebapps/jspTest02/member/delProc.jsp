<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(id);
	
	if(pw.equals(dto.getPw())){
		int result = dao.setDelete(id);
		if(result >0){%>
			<script>
				alert('삭제 완료');
				location.href="list.jsp";
			</script>
			
		<%}else{%>
			<script>
				alert('삭제 실패');
				location.href="memDelete.jsp?id=<%=id%>";
			</script>	
		<%}
	
	}else {%>
		<script>
			alert('비밀번호가 일치하지 않습니다.');
			location.href="memDelete.jsp?id=<%=id%>";
		</script>	
	<%}%>
	
	
