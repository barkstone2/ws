<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookId = null;
	String cookGrade = null;
	if(session.getAttribute("cookId")!=null){
		cookId = (String)session.getAttribute("cookId");
		cookGrade = (String)session.getAttribute("cookGrade");
	}
%>
	
	<div style="width: 800px; border: 1px solid black; padding: 10px;">
		<div style="text-align: right;">
	<%
		if(cookId==null){%>
			<a href="login.jsp">[로그인]</a>			
		<%}else{%>
			<%=cookId%>님 환영합니다. &nbsp;&nbsp;<a href="logout.jsp">[로그아웃]</a>
		<%}
	%><a href="join.jsp">[회원가입]</a>
		</div>
		<hr>
		<div>
<%
	if(cookGrade==null){%>
			<a href="list.jsp">회원목록</a> | 배송조회
	<%
	}else{
		
		if(cookGrade.equals("1")){%>
			회원관리 | <a href="list.jsp">회원목록</a> | 배송조회
		<%}else if(cookGrade.equals("2")){%>
			상품관리 | <a href="list.jsp">회원목록</a> | 배송조회
		<%}else if(cookGrade.equals("3")){%>
			배송관리 | <a href="list.jsp">회원목록</a> | 배송조회
		<%}else{%>
			<a href="list.jsp">회원목록</a> | 배송조회
		<%}
	}%>
		</div>
	</div>
	



	
	