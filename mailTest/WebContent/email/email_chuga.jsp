<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding:5px;
}
.label{
	width:150px;
	text-align: center;
}
.longInput{
	width:710px;
}
.shortInput{
	width: 190px;
}
.middleInput{
	width: 330px;
}
.radioInp{
	display:flex;
	width:500px;
	justify-content: space-around;
}
.btn{
	display:flex;
	width:900px;
	justify-content: space-around;
	padding: 10px;
}
#formTitle{
	text-align: center;
}
.shotLine{
	display:flex;
	margin-right: 30px;
}
</style>
<form style="width:900px; border: 1px solid black;" action="${path}/email_servlet/chugaProc.do" method="post" name="chugaForm">
	고객명단<br>
	<c:forEach var="j" items="${list}">
		<input type="checkbox" name="toEmail" value="${j.email}">
		${j.no}. ${j.name} | ${j.email} | <fmt:formatDate pattern="yyyy-MM-dd" var="bd" value="${j.birthDay}"/>${bd}<br>
	</c:forEach>
	<div id="formTitle">
		<h2>이메일 보내기</h2>
	</div>
	<div class="row">
		<div class="label">
			제목
		</div>
		<div>
			<input type="text" name="subject" id="subject" class="longInput">
		</div>
	</div>
	<div class="row" style="display:flex; justify-content: center;">	
		<div>
			<textarea name="content" id="content" style="width:850px; height:500px; resize: none;"></textarea>
		</div>
	</div>
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="submit" value="메일 보내기">
				</div>
				<div>
					<input type="button" onclick="sendToBirth();" value="생일자 메일 보내기">
				</div>
			</div>
		</div>
	</div>
</form>
<script>
function sendToBirth(){
	document.chugaForm.action = "${path}/email_servlet/sendBirth.do";
	document.chugaForm.submit();
}
</script>
