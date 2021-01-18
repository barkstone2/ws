<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body, html{
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}
header{
	width: 100%;
	height: 20%;
	background-color: yellow;
	display: flex;
	align-items: center;
}
	.logo{
		background-color: white;
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
			background-color: green;
		}
		#userMenu{
			width:30%;
			background-color: blue;
		}
main{
	width: 100%;
	height: 60%;
	background-color: gray;
}
footer{
	width: 100%;
	height: 20%;
	background-color: red;
}

</style>
</head>
<body>
	
	<header>
		<jsp:include page="../include/inc_menu.jsp"></jsp:include>
	</header>
	
	<main>
		
		<jsp:include page="${menu_gubun}"></jsp:include>
		<%-- <c:choose>
			<c:when test="${menu_gubun == 'index1'}">
				<jsp:include page="./a.jsp"></jsp:include>
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
		${menu_gubun}<br>
		
		
		${aaa}<br>
		${bbb}<br>
	</main>
	
	<footer>
		
	</footer>		
		
	
	
</body>
</html>