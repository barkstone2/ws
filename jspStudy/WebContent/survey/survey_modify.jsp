<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<jsp:useBean id="now" class="java.util.Date"/>
<style>
.row{
	display:flex;
	padding:5px;
}
.label{
	width:100px;
	text-align: center;
}
.inp{
	width:500px;
}
.radioInp{
	display:flex;
	width:500px;
	justify-content: space-around;
}
.btn{
	display:flex;
	width:650px;
	justify-content: space-around;
	padding: 10px;
}
#formTitle{
	text-align: center;
}
</style>
<form style="width:650px; border: 1px solid black;" method="post" action="" name="modifyForm">
	<div id="formTitle">
		<h2>설문수정</h2>
	</div>
	<div class="row">
		<div class="label">
			질문
		</div>
		<div>
			<input type="hidden" name="no" value="${dto.no}">
			<input type="text" name="question" class="inp" value="${dto.question}">
		</div>
	</div>
	<div class="row">
		<div class="label">
			답변1
		</div>
		<div>
			<input type="text" name="ans1" class="inp" value="${dto.ans1}">
		</div>
	</div>
	<div class="row">	
		<div class="label">
			답변2
		</div>
		<div>
			<input type="text" name="ans2" class="inp" value="${dto.ans2}">
		</div>
	</div>
	<div class="row">	
		<div class="label">
			답변3
		</div>
		<div>
			<input type="text" name="ans3" class="inp" value="${dto.ans3}">
		</div>
	</div>
	<div class="row">	
		<div class="label">
			답변4
		</div>
		<div>
			<input type="text" name="ans4" class="inp" value="${dto.ans4}">
		</div>
	</div>
	
	<div class="row">	
		<div class="label">
			시작일
		</div>
		<div>
			<select name="sYear">
				<c:forEach var="i" begin="${nowDate.nowYear-1}" end="${nowDate.nowYear+5}" step="1">
				<option value="${i}" <c:if test="${i==fn:substring(dto.start_date,0,4)}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>년
			<select name="sMonth">
				<c:forEach var="i" begin="1" end="12" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==fn:substring(dto.start_date,5,7)}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>월
			<select name="sDay">
				<c:forEach var="i" begin="1" end="31" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==fn:substring(dto.start_date,8,10)}">selected="selected"</c:if>><c:out value="${i}"></c:out></option>
				</c:forEach>
			</select>일
		</div>
		<div class="label">
			종료일
		</div>
		<div>
			<select name="eYear">
				<c:forEach var="i" begin="${nowDate.nowYear-1}" end="${nowDate.nowYear+5}" step="1">
				<option value="${i}" <c:if test="${i==fn:substring(dto.end_date,0,4)}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>년
			<select name="eMonth">
				<c:forEach var="i" begin="1" end="12" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==fn:substring(dto.end_date,5,7)}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>월
			<select name="eDay">
				<c:forEach var="i" begin="1" end="31" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==fn:substring(dto.end_date,8,10)}">selected="selected"</c:if>><c:out value="${i}"></c:out></option>
				</c:forEach>
			</select>일
		</div>
	</div>
	<div class="row">	
		<div class="label">
			진행여부
		</div>
		<div class="radioInp">
			<div>
				<input type="radio" name="status" value="1" <c:if test="${dto.status eq '1'.charAt(0)}">checked="checked"</c:if>>&nbsp;&nbsp;진행중
			</div>
			<div>
				<input type="radio" name="status" value="0" <c:if test="${dto.status eq '0'.charAt(0)}">checked="checked"</c:if>>&nbsp;&nbsp;종료
			</div>
		</div>
	</div>
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="button" value="설문수정" id="btnSave">
				</div>
				<div>
					<input type="button" value="돌아가기" id="btnBack">
				</div>
			</div>
		</div>
	</div>
</form>
<script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			goModifyProc();
		});
		$("#btnBack").click(function(){
			goView();
		});
	});
</script>