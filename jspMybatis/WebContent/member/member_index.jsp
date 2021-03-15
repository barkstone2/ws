<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/inc_header.jsp" %>

<div id="result"></div>  

<c:if test="${menu_gubun=='/member/member_index.jsp'}">
	<script>
	$(document).ready(function(){
		getPath('${path}');
		if('${menuMove}'!=null&&'${menuMove}'!=''){
			goPage('${menuMove}');
		}else{
			goPage('list');
		}
	});
	</script>
</c:if>

<script type="text/javascript" src="${path}/member/_member.js"></script>
