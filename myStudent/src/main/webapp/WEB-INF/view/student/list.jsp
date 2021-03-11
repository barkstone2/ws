<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>
	<div class="flex f-center under-line width950">
		<div class="border-right width75 t-center">
			순번
		</div>
		<div class="border-right width150 t-center">
			학번
		</div>
		<div class="border-right width100 t-center">
			이름
		</div>
		<div class="border-right width150 t-center">
			전공
		</div>
		<div class="border-right width100 t-center">
			학년
		</div>
		<div class="border-right width75 t-center">
			성별
		</div>
		<div class="border-right width150 t-center">
			연락처
		</div>
		<div class="width150 t-center">
			이메일
		</div>
	</div>
	<c:forEach var="studentDTO" items="${list}" varStatus="i">
		<div class="flex f-center under-line width950">
			<div class="border-right width75 t-center">
				${i.count}
			</div>
			<div class="border-right width150 t-center">
				${studentDTO.id}
			</div>
			<div class="border-right width100 t-center">
				${studentDTO.name}
			</div>
			<div class="border-right width150 t-center">
				${studentDTO.major}
			</div>
			<div class="border-right width100 t-center">
				${studentDTO.grade}
			</div>
			<div class="border-right width75 t-center">
				${studentDTO.gender}
			</div>
			<div class="border-right width150 t-center">
				${studentDTO.phone}
			</div>
			<div class="width150 t-center">
				${studentDTO.email}
			</div>
		</div>
	</c:forEach>
	<div class="width950 flex f-end">
		<button type="button" class="margin10" onclick="location.href='reg';">학생등록</button>
	</div>