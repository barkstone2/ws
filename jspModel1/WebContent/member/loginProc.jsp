<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@include file="../include/include_check.jsp" %>
<jsp:useBean id="dto" class="etc.member.MemberDTO" scope="page"></jsp:useBean>    
<jsp:setProperty property="*" name="dto"/>
<%
	String cookId = null;
	MemberDAO dao = new MemberDAO();
	MemberDTO dto2 = dao.getSelect(dto.getId());
	if(dto2.getLoginFailCounter()>=5){
		out.print("<script>");
		out.print("alert('로그인 5회 실패. 관리자에게 문의하세요.');");
		out.print("location.href='login.jsp';");
		out.print("</script>");
	}else{
		if(dto2.getPasswd()==null){
			out.print("<script>");
			out.print("alert('가입되지 않은 아이디입니다.');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
		}else{
			if(dto2.getPasswd().equals(dto.getPasswd())){
				session.setAttribute("cookId", dto.getId());
				session.setAttribute("cookDto", dto2);
				dao.setFailCounter(dto2.getId(), 0);
				out.print("<script>");
				out.print("alert('로그인 성공');");
				out.print("location.href='list.jsp';");
				out.print("</script>");
			}else{
				dao.setFailCounter(dto2.getId(), dto2.getLoginFailCounter()+1);
				out.print("<script>");
				out.print("alert('비밀번호가 일치하지 않습니다.');");
				out.print("location.href='login.jsp';");
				out.print("</script>");
			}
		}
	}
%>
    