<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String searchType = request.getParameter("searchType");
String searchData = request.getParameter("searchData");

if(searchType == null || searchType.length() <=0 ||
searchData.length()<=0 || searchData == null){
	response.sendRedirect("list.jsp");
}else{
	response.sendRedirect("list.jsp?searchType="+searchType+"&searchData="+searchData);
}


%>
