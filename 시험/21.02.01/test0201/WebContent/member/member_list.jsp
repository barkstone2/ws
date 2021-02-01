<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>

<h2>회원목록</h2>
<table border="1">
	<tr>
		<td>순번</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>성별</td>
		<td>태어난년도</td>
		<td>주소</td>
		<td>가입일</td>
	</tr>
	<c:forEach var="dto" items="${list}">
	<tr>
		<td>${dto.no}</td>
		<td><a href="#" onclick="view('${dto.no}');">${dto.id}</a></td>
		<td>${dto.pw}</td>
		<td>${dto.name}</td>
		<td>${dto.gender}</td>
		<td>${dto.bornYear}</td>
		<td>${dto.bAddr}/${dto.sAddr}/${dto.rAddr}</td>
		<td>${dto.regiDate}</td>
	</tr>
	</c:forEach>
</table>
<script>
function view(value1){
	location.href="${path}/member_servlet/view.do?no="+value1;
}
</script>