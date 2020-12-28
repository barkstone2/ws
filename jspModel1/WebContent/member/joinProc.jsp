<%@page import="java.net.Inet4Address"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@include file="../include/include_check.jsp" %>
<jsp:useBean id="dto" class="etc.member.MemberDTO" scope="page"></jsp:useBean>    
<jsp:setProperty property="*" name="dto"/>
<%
	
	out.println("ip : "+ip);

	 if(!ip.equals("14.56.196.18")){
		//response.sendRedirect("join.jsp");
		out.println("<script>alert('허용된 아이피가 아닙니다.');location.href='join.jsp';</script>");
	}else{
		MemberDAO dao = new MemberDAO();
		int result = dao.setInsert(dto);
		if(result >0){
			out.print("<script>");
			out.print("alert('가입 성공');");
			out.print("location.href='login.jsp';");
			out.print("</script>");
		}else{
			out.print("<script>");
			out.print("alert('가입 실패');");
			out.print("location.href='join.jsp';");
			out.print("</script>");
		}
	}
 
%>

