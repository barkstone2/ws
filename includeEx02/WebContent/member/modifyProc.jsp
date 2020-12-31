<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/include_top_common.jsp" %>
<%@include file="../include/include_top_import.jsp" %>
<%@include file="../include/include_top_session.jsp" %>
<%@include file="../include/include_top_session_check.jsp" %>
<jsp:useBean id="dto" class="member.model.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	MemberDAO dao = new MemberDAO();
	int result = dao.setUpdate(dto, cookNo);
	
	if(result>0){
		out.print("<script>alert('수정성공');location.href='view.jsp';</script>");
	}else{
		out.print("<script>alert('가입실패');location.href='modify.jsp';</script>");
	}
%>
