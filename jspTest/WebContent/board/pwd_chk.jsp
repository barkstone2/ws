<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<div>
	<h2>게시글 수정</h2>
</div>
<form method="post" action="${path}/board_servlet/modify.do">
	비밀번호 <input type="password" name="pwd">
	<input type="hidden" name="no" value="${no}">
	<input type="submit" value="제출" id="btnSave">
	<input type="button" value="취소" onclick="move('view','${pageNumber}','${no}');">	
</form>
<script>
function move(v_location, v_pageNumber, v_no){
	var prefix = '${path}/board_servlet/';
	var suffix = '.do?no='+v_no+'&pageNumber='+v_pageNumber;
	var url = prefix + v_location + suffix;
	location.href = prefix+v_location+suffix;
}
</script>