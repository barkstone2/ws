<%@page import="etc.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
 
<div style="border: 1px solid black; width:800px; padding: 10px;">
<%
	if(session.getAttribute("cookId")==null){
	%>
	<div style="width:100%; text-align: right;">
		[로그인]
	</div>
		<hr>
	<%}else{%>
	<div style="width:100%; text-align: right;">
		${cookId}님 안녕하세요. &nbsp;&nbsp;<a href="logout.jsp">[로그아웃]</a>
	</div>
		<hr>	
	<%}
	
	if(session.getAttribute("cookDto")!=null){
		MemberDTO dto = (MemberDTO)session.getAttribute("cookDto");
		String grade = dto.getGrade();
	
		if(grade.equals("1")){
			out.print("회원관리 | 상품관리 | 배송관리 | 문의관리 | 주문페이지");
		}else if(grade.equals("2")){
			out.print("상품관리 | 문의관리 | 주문페이지");
		}else if(grade.equals("3")){
			out.print("배송관리 | 문의관리 | 주문페이지");
		}else{
			out.println("문의관리 | 주문페이지");
		}
	}else{
		out.println("문의관리 | 주문페이지");
	}
	
%>
</div>
	<hr>
<script>
	function login(){
		alert('로그인 후 이용하세요.');
		location.href='login.jsp';
	}
</script>