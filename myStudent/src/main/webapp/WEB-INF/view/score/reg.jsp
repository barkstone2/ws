<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>


<form action="reg" method="post">
	학생
	<select name="studentId">
		<c:forEach var="student" items="${studentList}" varStatus="i">
			<option value="${student.id}">${i.count}:${student.name}(${student.id})</option>
		</c:forEach>
	</select><br>
	시험번호 
	<select name="examNo">
		<c:forEach var="exam" items="${examList}" varStatus="i">
			<option value="${exam.no}">${i.count}:${exam.name}(${exam.type})</option>
		</c:forEach>
	</select><br>
	점수 <input type="text" name="score"><br>
	<button type="submit">등록</button>
	<button type="button" class="margin10" onclick="location.href='search';">조회하기</button>
</form>



	