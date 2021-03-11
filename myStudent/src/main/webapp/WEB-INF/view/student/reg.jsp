<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>
<form action="reg" method="post">
	학번 <input type="text" name="id"> <br>
	이름 <input type="text" name="name"> <br>
	전공 <input type="text" name="major"> <br>
	학년 <input type="text" name="grade"> <br>
	성별 <input type="text" name="gender"> <br>
	연락처 <input type="text" name="phone"> <br>
	이메일 <input type="text" name="email"> <br>
	주소 <input type="text" name="address"> <br>
	<button type="submit">등록</button>
	<button type="button" onclick="location.href='list';">목록으로</button>
</form>