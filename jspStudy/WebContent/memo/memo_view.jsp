<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	margin-bottom: 5px;
	border-bottom: 1px solid black;
	align-items: center;
	height:30px;
}
.row > :nth-child(2){
	margin-left: 15px;
}
.label{
	width:120px;
	text-align: center;
	border-right: 1px solid black;
}
#btn{
	display:flex;
	justify-content: center;
	margin-top: 20px;
}
#radioInput{
	width:180px;
	display:flex;
	justify-content: space-around;
}
#formTitle{
	text-align: center;
}
#btn > div {
	padding: 10px;
}
</style>    


<div style="width:400px;">
	<div id="formTitle">
		<h2>메모 상세보기</h2>
	</div>
	<div class="row">
		<div class="label">
			순번
		</div>
		<div>
			${dto.no}
		</div>
	</div>
	<div class="row">
		<div class="label">
			작성자
		</div>
		<div>
			${dto.id}
		</div>
	</div>
	<div class="row">
		<div class="label">
			내용
		</div>
		<div>
			${dto.content}
		</div>
	</div>
	<div class="row">
		<div class="label">
			작성일
		</div>
		<div>
			${dto.regi_date}
		</div>
	</div>
	<div>
		<input type="button" value="목록으로" onclick="move('list','${pageNumber}','');">
	</div>
</div>
<script>
function move(value1, value2, value3){
	if(value1=='list'){
		location.href='${path}/memo_servlet/memo.do?pageNumber='+value2;
	}
}
</script>