<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/inc_header.jsp" %>
<script>
var msg = '${msg}';
var url = '${reUrl}';
alert(msg);
document.location.href=url;
</script>