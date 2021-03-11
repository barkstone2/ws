<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>
		
	<form action="list" method="get">
		* 조회할 학생 이름을 선택하세요.<br>
		<select name="studentName">
			<c:forEach var="dto" items="${list}" varStatus="i">
				<option value="${dto.name}">${i.count}:${dto.name}(${dto.id})</option>
			</c:forEach>
		</select>
		<button type="submit">조회</button>
		<button type="button" onclick="location.href='reg';">성적등록</button>
	</form>