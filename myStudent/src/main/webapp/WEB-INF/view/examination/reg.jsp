<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>
<form action="reg" method="post">
	과목이름 <input type="text" name="name"> <br>
	시험분류 <input type="text" name="type"> <br>
	<button type="submit">등록</button>
	<button type="button" onclick="location.href='list';">목록으로</button>
</form>