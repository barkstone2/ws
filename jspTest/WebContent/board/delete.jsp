<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>   
<div>
	<h2>게시글 삭제</h2>
</div>
<form method="post" action="${path}/board_servlet/deleteProc.do">
	비밀번호 <input type="password" name="pwd">
	<input type="hidden" name="no" value="${dto.no}">
	<input type="submit" value="삭제하기" id="btnSave">
	<input type="button" value="취소" onclick="move('view','${pageNumber}','${dto.no}');">	
</form>
<script>
function move(v_location, v_pageNumber, v_no){
	var prefix = '${path}/board_servlet/';
	var suffix = '.do?no='+v_no+'&pageNumber='+v_pageNumber;
	var url = prefix + v_location + suffix;
	location.href = prefix+v_location+suffix;
}
</script>