<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>
	
	<c:if test="${list.size()<=0}">
		조회 결과가 없습니다.
	</c:if>
	<c:if test="${list.size()>0}">
		<div>
			이름 : ${list.get(0).studentName}<br>
			학번 : ${list.get(0).studentId}
		</div>
		<div class="flex f-center under-line width950">
			<div class="border-right width75 t-center">
				순번
			</div>
			<div class="border-right width150 t-center">
				시험코드
			</div>
			<div class="border-right width100 t-center">
				과목명
			</div>
			<div class="border-right width150 t-center">
				시험분류
			</div>
			<div class="border-right width100 t-center">
				점수
			</div>
		</div>
		<c:forEach var="dto" items="${list}" varStatus="i">
		<div class="flex f-center under-line width950">
			<div class="border-right width75 t-center">
				${i.count}
			</div>
			<div class="border-right width150 t-center">
				${dto.examNo}
			</div>
			<div class="border-right width100 t-center">
				${dto.examName}
			</div>
			<div class="border-right width150 t-center">
				${dto.examType}
			</div>
			<div class="border-right width100 t-center">
				${dto.score}
			</div>
		</div>
		</c:forEach>
		
	</c:if>
	
	<div class="width950 flex f-end">
		<button type="button" class="margin10" onclick="location.href='search';">조회하기</button>
		<button type="button" class="margin10" onclick="location.href='reg';">점수등록</button>
	</div>
	