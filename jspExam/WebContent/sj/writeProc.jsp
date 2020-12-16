<%@page import="sj.SjDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="sj.SjDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	SjDAO dao = new SjDAO();
	String[] ans = {"1","2","3","4","3"};
	int jumsu = 0;
	if(String.valueOf(dto.getMun_1()).equals(ans[0])){
		dto.setMun_ox_1("O");
		jumsu +=20;
	}else{
		dto.setMun_ox_1("X");
	}
	
	if(String.valueOf(dto.getMun_2()).equals(ans[1])){
		dto.setMun_ox_2("O");
		jumsu +=20;
	}else{
		dto.setMun_ox_2("X");
	}
	
	if(String.valueOf(dto.getMun_3()).equals(ans[2])){
		dto.setMun_ox_3("O");
		jumsu +=20;
	}else{
		dto.setMun_ox_3("X");
	}
	
	if(String.valueOf(dto.getMun_4()).equals(ans[3])){
		dto.setMun_ox_4("O");
		jumsu +=20;
	}else{
		dto.setMun_ox_4("X");
	}
	
	if(String.valueOf(dto.getMun_5()).equals(ans[4])){
		dto.setMun_ox_5("O");
		jumsu +=20;
	}else{
		dto.setMun_ox_5("X");
	}
	
	dto.setJumsu(jumsu);
	int result = dao.setInsert(dto);
	if(result>0){
		out.print("<script>alert('제출성공');location.href='write.jsp';</script>");
	}else{
		out.print("<script>alert('제출실패');location.href='write.jsp';</script>");
	}
	
	
%>

