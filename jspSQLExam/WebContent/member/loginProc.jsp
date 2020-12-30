<%@page import="member.model.MemberDTO"%>
<%@page import="member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	int cookNo = 0;
	String id_ = request.getParameter("id");
	String pw_ = request.getParameter("passwd");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(id_);
	
	if(dto.getPasswd()==null){
		out.print("<script>alert('등록되지 않은 아이디입니다.');location.href='login.jsp';</script>");
		return;
	}
	
	
	
	
	if(pw_.equals(dto.getPasswd())){
		session.setAttribute("cookNo", dto.getNo());
		out.print("<script>alert('로그인 성공');location.href='list.jsp';</script>");
	}else{
		out.print("<script>alert('비밀번호가 일치하지 않습니다.');location.href='login.jsp';</script>");
	}
	
	
%>
