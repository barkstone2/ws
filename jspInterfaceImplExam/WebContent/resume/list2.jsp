<%@page import="jspInterfaceImplExam.model.resume.ResumeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <%
	ResumeDAO dao = new ResumeDAO();
	ArrayList<ResumeDTO> dtos = dao.getListAll();
	int dtoCount = dtos.size();
	int divCount = (int)Math.ceil(dtoCount/3.0);
	int counter = 0;


	for(int j=0; j<divCount; j++){
		int counter2 = 0;%>
	<div style="width: 306px; display: flex;">	
	<%for(int i=0+counter; i<dtoCount; i++){
		if(counter2==3){break;}
		ResumeDTO dto = dtos.get(i);%>
		<a href="view.do?no=<%=dto.getNo()%>" style="border: 1px solid black"><img src="../image/<%=dto.getPic() %>" style="width: 100px; height:100px;"></a>
		<%counter2++;
	}
	counter +=3;
	if(counter >= dtoCount && dtoCount<divCount*3){%>
		<div style="width: 102px; height:106px; 
		border: 1px solid black; display:flex; justify-content: center; align-items: center">없음</div>
	<%}
	%>
	</div>
	<%
	}
%> --%>
	
	
	<c:set var="count" value="0"/>
	<c:set var="lsize" value="${fn:length(list)}"/>
	<c:set var="divCount" value="${lsize/3}"/>
	<c:set var="divCount" value="${divCount+(1-(divCount%1)%1)}"/>
	<fmt:formatNumber value="${divCount}" type="number" var="divCount"/>
	<c:set var="counter" value="0"/>
	<c:forEach begin="1" end="${divCount}">
		<div style="width: 306px; display: flex">
			<c:forEach items="${list}" var="dto" begin="${count}" end="${count+2}">
				<c:set var="counter" value="${counter+1}"/>
				<a href="view.do?no=${dto.no}" style="border: 1px solid black"><img src="../image/${dto.pic}" style="width: 100px; height:100px;"></a>
			</c:forEach>
		<c:set var="count" value="${counter}"/>
		<c:if test="${counter ge lsize and lsize lt divCount*3}">
			<div style="width: 100px; height:104px; 
			border: 1px solid black; display:flex; justify-content: center; align-items: center">없음</div>
		</c:if>
		</div>
	</c:forEach>
	<a href="writeView.do">[이력서 작성]</a>
</body>
</html>