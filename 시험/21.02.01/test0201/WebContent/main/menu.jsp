<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<input type="button" value="회원가입" onclick="move('reg');">
<input type="button" value="회원목록" onclick="move('list');">
<script>
function move(value1){
	if(value1=='reg'){
		location.href='${path}/member_servlet/reg.do';
	}else if(value1=='list'){
		location.href='${path}/member_servlet/list.do';
	}
}
</script>