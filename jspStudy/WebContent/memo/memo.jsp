<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	align-items: center;
}
.label{
	width:120px;
	text-align: center;
}
#btn{
	display:flex;
	justify-content: center;
}
#radioInput{
	width:180px;
	display:flex;
	justify-content: space-around;
}
#formTitle{
	text-align: center;
}
.postcode{
	margin-bottom: 5px;
}
#postcode{
	width:120px;
}
#bAddr, #sAddr{
	width:350px;
}
#listLabel{
	display:flex;
	justify-content: center;
	align-items: center;
}
#mList{
	width:700px;
	height:200px;
}
.mlistcon{
	display:flex;
	justify-content: center;
	align-items: center;
}
#formTitle {
	text-align: center;
}
.mlistcon, #listLabel {
	border-bottom: 1px solid black;
	height:30px;
	text-align: center;
}
.column1{
	border-right: 1px solid black;
	width:60px;
}
.column2{
	border-right: 1px solid black;
	width:120px;
}
.column3{
	border-right: 1px solid black;
	width:300px;
}
.column4{
	border-right: 1px solid black;
	width:200px;
}
#memcount{
	margin-left: 10px;
	margin-bottom: 10px;
}
#btn{
	display:flex;
	justify-content: flex-end;
}
#btn > div {
	padding: 10px;
}
</style>
<div>
	<form name="regForm" method="post" action="${path}/memo_servlet/memoProc.do" style="width:700px;">
		<div id="formTitle">
			<h2>한줄메모장</h2>
		</div>
		<div class="row">
			<div class="label">
				작성자
			</div>
			<div>
				<input type="text" name="id">
			</div>
		</div>
		<div class="row">
			<div class="label">
				내용
			</div>
			<div>
				<input type="text" name="content" style="width:300px;">
				<input type="button" value="등록" onclick="reg();">
			</div>
		</div>
	</form>
	<div id="mList">
		<div id="memcount">
			* ${list.size()}개의 메모가 존재합니다.
		</div>
		<div id="listLabel">
			<div class="column1">
				순번
			</div>
			<div class="column2">
				작성자
			</div>
			<div class="column3">
				내용
			</div>
			<div class="column4">
				작성일
			</div>
		</div>
	<c:if test="${list.size()==0}">
		<div style="text-align:center;">
			등록된 메모가 없습니다.
		</div>
	</c:if>
	<c:forEach var="dto" items="${list}">
		<div class="mlistcon">
			<div class="column1">
				${dto.no}
			</div>
			<div class="column2">
				<a href="#" onclick="move('view','','${dto.no}');">${dto.id}</a>
			</div>
			<div class="column3">
				${dto.content}
			</div>
			<div class="column4">
				${dto.regi_date}
			</div>
		</div>
	</c:forEach>
	</div>
</div>



<script>
function reg(){
	if(confirm('등록하시겠습니까?')){
		regForm.submit();
	}
}
</script>
