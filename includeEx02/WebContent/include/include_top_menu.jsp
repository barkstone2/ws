<%@page import="member.model.MemberDTO"%>
<%@page import="member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
//String ip = request.getParameter("ip");
String menu;
String cookNo_ = request.getParameter("cookNo");
int cookNo = Integer.parseInt(cookNo_);
if(cookNo==0){
	menu = "<a href='login.jsp'>로그인</a>";
}else{
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.getView(cookNo);
	menu = "<a href='logout.jsp'>로그아웃</a>&nbsp;("+dto.getName()+"님)"
	+"<a href='modify.jsp'>[수정하기]</a>"
	+"<a href='delete.jsp'>[삭제하기]</a>";
} 
%>
<table border="0" align="center" width="800">
	<tr>
		<th height="30">HOME</th>
		<th><a href="list.jsp">회원관리</a></th>
		<th>게시판</th>
		<th><%=menu %></th>
		<th>${param.ip }</th>
</table>