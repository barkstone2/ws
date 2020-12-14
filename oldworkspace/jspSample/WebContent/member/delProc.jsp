<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String id = request.getParameter("id");
	String no_ = request.getParameter("no");
	int no = Integer.parseInt(no_);
	MemberDAO dao = new MemberDAO();
	int result = dao.setDelete(id, no);
	if(result>0){%>
		<script>
			alert('삭제 성공');
			location.href='list.jsp';
		</script>
	<%}else{%>
		<script>
			alert('삭제 실패');
			location.href='delete.jsp?id=<%=id%>&no=<%=no%>';
		</script>
	<%}
%>