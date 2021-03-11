<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>	
	<div class="flex f-center under-line width950">
		<div class="border-right width75 t-center">
			순번
		</div>
		<div class="border-right width150 t-center">
			과목이름
		</div>
		<div class="border-right width150 t-center">
			시험분류
		</div>
	</div>
	<c:forEach var="dto" items="${list}" varStatus="i">
	<div class="flex f-center under-line width950">
		<div class="border-right width75 t-center">
			${i.count}
		</div>
		<div class="border-right width150 t-center">
			${dto.name}
		</div>
		<div class="border-right width150 t-center">
			${dto.type}
		</div>
	</div>
	</c:forEach>

	<div class="width950 flex f-end">
		<button type="button" class="margin10" onclick="location.href='reg';">시험등록</button>
	</div>
	