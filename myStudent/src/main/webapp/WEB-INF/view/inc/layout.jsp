<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="/WEB-INF/view/inc/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="/css/mainStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- Menu -->
	<tiles:insertAttribute name="menu" />
	<!-- main -->
	<div class="flex f-center full-height full-width">
		<main>
			<tiles:insertAttribute name="main" />
		</main>
	</div>
</body>
</html>