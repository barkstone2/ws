<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>제목은?</h1>
<p>
단락입니다.<br>
단락입니다.<br>
단락입니다.<br>
단락입니다.<br>
단락입니다.<br>
</p>
안녕하세요?<br><br><br>
오늘은 12월의 첫날입니다.

<hr>

<%
	String name = "홍길동";
	out.println(name + "<br>"); // 문자열 연산
	out.println(name);
	int age = 19;
%>

<h2><%out.println(name);%></h2>
<h2><%=name %> <%=age %></h2>


<!-- <%=name%> -->
<%--
주석
 --%>


<%--
<%! %>
- 선언문 : 멤버변수 또는 멤버메소드로 사용하고자 할 때, 즉, 전역변수. 거의 안 쓴다.
<% %>
-스크립트릿 : 지역변수
<%= %>
- 표현식(Expression), out.println(), EL:${}
 --%>




</body>
</html>