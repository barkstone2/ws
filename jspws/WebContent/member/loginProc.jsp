<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%
	String id_ = request.getParameter("id");
	String pw_ = request.getParameter("pw");
	String ip_ = request.getParameter("ip");
	System.out.println(ip_);
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getSelect(id_);
	
	if(!dto.getIp().equals("14.56.196.18")){
		out.print("<script>alert('로그인이 허용된 IP가 아닙니다.');location.href='login.jsp';</script>");
		return;
	}
	
	if(dto.getPw()==null){
		out.print("<script>alert('잘못된 아이디입니다.');location.href='login.jsp';</script>");
		return;
	}
	
	if(dto.getLoginfailcounter()>=5){
		out.print("<script>alert('로그인 5회 실패로 로그인이 차단된 아이디입니다. \\n관리자에게 문의하세요.');location.href='login.jsp';</script>");
		return;
	}
	
	if(dto.getPw().equals(pw_)){
		session.setAttribute("cookId", id_);
		session.setAttribute("cookGrade", dto.getGrade());
		dao.setLoginFailCounter(id_, 0);
		out.print("<script>alert('로그인 성공');location.href='list.jsp';</script>");
	}else{
		dao.setLoginFailCounter(id_, dto.getLoginfailcounter()+1);
		out.print("<script>alert('비밀번호가 일치하지 않습니다.');location.href='login.jsp';</script>");
	}
	
%>

    