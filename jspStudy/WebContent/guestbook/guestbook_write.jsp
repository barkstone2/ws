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
#btn > div {
	padding: 10px;
}
</style>
<form name="writeForm" method="post" action="${path}/guestbook_servlet/writeProc.do">
	<div class="row">
		<div class="label">이름</div>
		<div><input type="text" name="name"></div>
	</div>
	
	<div class="row">
		<div class="label">이메일</div>
		<div><input type="text" name="email"></div>
	</div>
	
	<div class="row">
		<div class="label">비밀번호</div>
		<div><input type="text" name="passwd"></div>
	</div>
	
	<div>
		<textarea name="content" style="resize: none; width:300px; height:200px;"></textarea>
	</div>
	<div id="btn">
		<div>
			<input type="button" value="확인" onclick="move('write','','');">
		</div>
		<div>
			<input type="button" value="취소" onclick="move('list','','');">
		</div>
	</div>
</form>

<script>
function move(value1, value2, value3){
	if(value1=='list'){
		location.href='${path}/guestbook_servlet/list.do?pageNumber='+value2;
	}else if(value1=='write'){
		writeForm.submit();
	}
}
</script>
