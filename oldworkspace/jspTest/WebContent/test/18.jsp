<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "hong";
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" width="800" align="center">
		<tr height="100">
			<td colspan="2">
				<%@include file="./18_top.jsp" %>
<!-- 				include 지시자 : 페이지를 불러온 후 컴파일(부모 페이지의 변수 인식 O) -->
			</td>
		</tr>
<%-- 		<tr height="100">
			<td colspan="2">
				<jsp:include page="18_top.jsp">
					<jsp:param value="<%=name %>" name="name"/>
				</jsp:include> <!-- jsp 액션태그 : 파일을 먼저 컴파일(부모 페이지 변수 인식 X) -->
			</td>
		</tr> --%>
		
		<tr height="300">
			<td width="200">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="100">
			<td colspan="2">
				<%@include file="./18_bottom.jsp" %>
			</td>
		</tr>
	</table>


</body>
</html>