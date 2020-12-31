<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_top_common.jsp" %>
<%@include file="../include/include_top_import.jsp" %>
<%@include file="../include/include_top_session.jsp" %>
<%@include file="../include/include_top_session_check.jsp" %>
<%
	MemberDAO dao = new MemberDAO();

	String pw_ = request.getParameter("passwd");
	MemberDTO dto = dao.getView(cookNo);
	
	
	if(pw_.equals(dto.getPasswd())){
		int result = dao.setDelete(cookNo);
		
		if(result>0){
			session.invalidate();
			out.print("<script>alert('삭제성공');location.href='login.jsp';</script>");
		}else{
			out.print("<script>alert('삭제실패');location.href='delete.jsp';</script>");
		}
	}else{
		out.print("<script>alert('비밀번호가 일치하지 않습니다.');location.href='delete.jsp';</script>");
	}

	
%>