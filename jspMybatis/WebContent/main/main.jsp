<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영합니다</title>
<style>
body, html{
	width: 100%;
	min-height: 100%;
	margin: 0;
	padding: 0;
}
header{
	width: 100%;
	height: 20%;
	--background-color: yellow;
	display: flex;
	align-items: center;
	border-bottom: 1px solid black;
	min-height: 190px;
}
	.logo{
		margin-left: 20px;
		border: 1px solid black;
		--background-color: white;
		width: 150px;
		height: 150px;
		min-width: 150px;
		min-height: 150px;
	}
	#menu{
		width:100%;
		height:60%;
		display:flex;
		justify-content: center;
		align-items: center;
		min-width: 1070px;
	}
	.menu {
		display: flex;
		justify-content: center;
		width: 100%;
		align-items: center;
	}
		.menu > div{
			padding: 20px;
		}
		#mainMenu{
			width: 70%;
			min-width:765px;
			--background-color: green;
		}
		#userMenu{
			width:310px;
			max-width: 310px;
			--background-color: blue;
		}
main{
	max-width: 100%;
	height: 60%;
	--background-color: gray;
	display: flex;
	justify-content: center;
	align-items: center;
	border-bottom: 1px solid black;
	min-height:550px;
	padding: 20px;
}
footer{
	width: 100%;
	height: 20%;
	min-height:190px;
	--background-color: red;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<header>
		<jsp:include page="../include/inc_menu.jsp"></jsp:include>
	</header>
	<main>
		<jsp:include page="${menu_gubun}"></jsp:include>
		<%-- <c:choose>
			<c:when test="${menu_gubun == 'index'}">
				<jsp:include page="../main/main_sub.jsp"></jsp:include>
			</c:when>
			<c:when test="${menu_gubun == 'index2'}">
				<jsp:include page="./b.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="./c.jsp"></jsp:include>
			</c:otherwise>
		</c:choose> --%>
		
		<%-- <c:if test="${menu_gubun == 'index'}">
		<jsp:include page="./a.jsp"></jsp:include>
		</c:if>
		<c:if test="${menu_gubun != 'index'}">
		<jsp:include page="./b.jsp"></jsp:include>
		</c:if> --%>
	</main>
	
	<footer></footer>		
		
	
	
</body>
</html>