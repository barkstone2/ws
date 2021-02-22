<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>   
<form>
	비밀번호 <input type="password" name="bPasswd" id="bPasswd">
	<input type="hidden" name="bNo" id="bNo" value="${bNo}">
	<input type="button" value="삭제하기" id="btnSave">
	<input type="button" value="취소" onclick="move('view','${pageNumber}','${dto.bNo}');" id="btnList">	
</form>
<script>
$(document).ready(function(){
	$("#btnSave").click(function(){
		if(confirm('삭제하시겠습니까?')){
			goPage('deleteProc');
		}
	});
});

function move(v_location, v_pageNumber, v_bNo){
	var bPasswd = '${dto.bPasswd}';
	
	goPage(v_location, v_pageNumber, v_bNo, bPasswd);
}

var msg = '${viewMsg}';
if(msg != ""){
	alert(msg);
	move('list','${pageNumber}');
}

</script>