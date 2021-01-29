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
<form style="width:650px; border: 1px solid black;" method="post" action="${path}/survey_servlet2/chugaProc.do" name="chugaForm">
	<div id="formTitle">
		<h2>설문등록</h2>
	</div>
	<div class="row">
		<div class="label">
			질문
		</div>
		<div>
			<input type="text" name="question" class="inp">
		</div>
	</div>
	<div class="row">
		<div class="label">
			답변1
		</div>
		<div>
			<input type="text" name="ans1" class="inp">
		</div>
	</div>
	<div class="row">	
		<div class="label">
			답변2
		</div>
		<div>
			<input type="text" name="ans2" class="inp">
		</div>
	</div>
	<div class="row">	
		<div class="label">
			답변3
		</div>
		<div>
			<input type="text" name="ans3" class="inp">
		</div>
	</div>
	<div class="row">	
		<div class="label">
			답변4
		</div>
		<div>
			<input type="text" name="ans4" class="inp">
		</div>
	</div>
	
	<div class="row">	
		<div class="label">
			시작일
		</div>
		<div>
		
			<select name="sYear">
				<c:forEach var="i" begin="${nowDate.nowYear-1}" end="${nowDate.nowYear+5}" step="1">
				<option value="${i}" <c:if test="${i==nowDate.nowYear}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>년
			<select name="sMonth">
				<c:forEach var="i" begin="1" end="12" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==nowDate.nowMonth}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>월
			<select name="sDay">
				<c:forEach var="i" begin="1" end="31" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==nowDate.nowDay}">selected="selected"</c:if>><c:out value="${i}"></c:out></option>
				</c:forEach>
			</select>일
		</div>
		<div class="label">
			종료일
		</div>
		<div>
			<select name="eYear">
				<c:forEach var="i" begin="${nowDate.nowYear-1}" end="${nowDate.nowYear+5}" step="1">
				<option value="${i}" <c:if test="${i==nowDate.nowYear}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>년
			<select name="eMonth">
				<c:forEach var="i" begin="1" end="12" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==nowDate.nowMonth+1}">selected="selected"</c:if>><c:out value="${i}"/></option>
				</c:forEach>
			</select>월
			<select name="eDay">
				<c:forEach var="i" begin="1" end="31" step="1">
				<fmt:formatNumber value="${i}" pattern="00" var="i"/>
				<option value="${i}" <c:if test="${i==nowDate.nowDay}">selected="selected"</c:if>><c:out value="${i}"></c:out></option>
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
				<input type="radio" name="status" value="1" checked="checked">&nbsp;&nbsp;진행중
			</div>
			<div>
				<input type="radio" name="status" value="0">&nbsp;&nbsp;종료
			</div>
		</div>
	</div>
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="button" value="설문등록" onclick="move('chugaProc','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnSave">
				</div>
				<div>
					<input type="button" value="목록으로" onclick="move('list','${pageNumber}','${list_gubun}','${search_option}','${search_data}','${search_date_s}','${search_date_e}','${dto.no}');" id="btnList">
				</div>
			</div>
		</div>
	</div>
</form>
<script>
function move(value1, value2, value3, value4, value5, value6, value7, value8){
	var basicUrl = "${path}/survey_servlet2/";
	var queryString = 
		"?pageNumber="+value2
		+"&list_gubun="+value3
		+"&search_option="+value4
		+"&search_data="+value5
		+"&search_date_s="+value6
		+"&search_date_e="+value7
		+"&no="+value8;
	
	if(value1=='list'){
		location.href= basicUrl+"list.do"+ queryString;
	}else if(value1=='view'){
		location.href=basicUrl+"view.do"+ queryString;
	}else if(value1=='result'){
		location.href=basicUrl+"result.do"+ queryString;
	}else if(value1=='modify'){
		location.href=basicUrl+"modify.do"+ queryString;
	}else if(value1=='chuga'){
		location.href=basicUrl+"chuga.do"+ queryString;
	}else if(value1=='solve'){
		location.href="${path}/survey_servlet2/solve.do";
	}else if(value1=='answer'){
		answerForm.submit();
	}else if(value1=='chugaProc'){
		chugaForm.submit();
	}else if(value1=='solveProc'){
		solveForm.submit();
	}
}
</script>