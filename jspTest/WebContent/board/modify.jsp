<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<style>
.row{
	display:flex;
	padding:5px;
}
.label{
	width:100px;
	text-align: center;
}
.longInput{
	width:770px;
}
.shortInput{
	width: 190px;
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
<form style="width:900px; border: 1px solid black;" method="post" action="${path}/board_servlet/modifyProc.do">
	<div id="formTitle">
		<h2>게시글 수정</h2>
		<input type="hidden" name="no" value="${dto.no}">
	</div>
	<div class="row">
		<div class="label">
			제목
		</div>
		<div>
			<input type="text" name="title" value="${dto.title}" class="longInput">
		</div>
	</div>
	<div class="row">
		<div class="shotLine">
			<div class="label">
				이름
			</div>
			<div>
				<input type="text" name="name" value="${dto.name}" class="shortInput">
			</div>
		</div>
		<div class="shotLine">
			<div class="label">
				비밀번호
			</div>
			<div>
				<input type="text" name="pwd" value="${dto.pwd}" class="shortInput">
			</div>
		</div>
	</div>
	<div class="row" style="display:flex; justify-content: center;">	
		<div>
			<textarea name="content" id="bContent" style="width:850px; height:500px; resize: none;">${dto.content}</textarea>
		</div>
	</div>
	<div class="row">	
		<div class="btn">
			<div style="width:300px; display:flex; justify-content: space-around;">
				<div>
					<input type="submit" value="게시글수정">
				</div>
				<div>
					<input type="button" value="목록으로" onclick="move('list','${pageNumber}');">
				</div>
				<div>
					<input type="button" value="돌아가기" onclick="move('view','${pageNumber}','${dto.no}');">
				</div>
			</div>
		</div>
	</div>
</form>
<script>
function move(v_location, v_pageNumber, v_no){
	var prefix = '${path}/board_servlet/';
	var suffix = '.do?no='+v_no+'&pageNumber='+v_pageNumber;
	var url = prefix + v_location + suffix;
	location.href = prefix+v_location+suffix;
}
</script>