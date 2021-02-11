<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>   
<form>
	비밀번호 <input type="password" name="bPasswd" id="bPasswd">
	<input type="hidden" name="bNo" id="bNo" value="${bNo}">
	<input type="button" value="삭제하기" id="btnSave">
	<input type="button" value="취소" onclick="move('view','${pageNumber}','${search_option}','${search_data}','${dto.bNo}','${dto.bPasswd}');" id="btnList">	
</form>
<script>
$(document).ready(function(){
	$("#btnSave").click(function(){
		if(confirm('삭제하시겠습니까?')){
			goPage('deleteProc');
		}
	});
});

function move(value1, value2, value3, value4, value5, value6){
	if(value1=='list'){
		goPage(value1, value2, value3, value4, value5);
	}else if(value1=='view'){
		goPage(value1, value2, value3, value4, value5, value6);
	}else if(value1=='chuga'){
		goPage(value1, value2, value3, value4, value5);
	}else if(value1=='answer'){
		goPage(value1, value2, value3, value4, value5);
	}else if(value1=='modify'){
		var pwd = $('#bPasswdChk').val();
		goPage(value1, value2, value3, value4, value5, pwd);
	}else if(value1=='delete'){
		goPage(value1, value2, value3, value4, value5);
	}
}
var msg = '${viewMsg}';
if(msg != ""){
	alert(msg);
	move('list','${pageNumber}','${search_option}','${search_data}');
}

</script>