<%@page import="jspInterfaceImplExam.model.resume.ResumeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jspInterfaceImplExam.model.resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	ResumeDAO dao = new ResumeDAO();
	ArrayList<ResumeDTO> dtos = dao.getListAll();

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<c:forEach items="${list}" var="dto">
	<div style="border: 1px solid black; width: 600px;">
		- 인적사항
		<table border="1" width="600">
			<tr>
				<td rowspan="4" width="200">
				<a href="view.do?no=${dto.no}"><img src="../image/${dto.pic}" style="width: 100px; height:100px;"></a>
				</td>
				<td width="100">성명</td>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${dto.email}</td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td>${dto.phone }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${dto.address}</td>
			</tr>
		</table>
		- 학력사항
		<table border="1" width="600">
			<tr>
				<td>기간</td>
				<td>학교명</td>
				<td>전공(학과)</td>
			</tr>
			<tr>
				<td>${dto.gigan1}&nbsp;</td>
				<td>${dto.school1}&nbsp;</td>
				<td>${dto.jeongong1}&nbsp;</td>
			</tr>
			<tr>
				<td>${dto.gigan2}&nbsp;</td>
				<td>${dto.school2}&nbsp;</td>
				<td>${dto.jeongong2}&nbsp;</td>
			</tr>
			<tr>
				<td>${dto.gigan3}&nbsp;</td>
				<td>${dto.school3}&nbsp;</td>
				<td>${dto.jeongong3}&nbsp;</td>
			</tr>
			<tr>
				<td>${dto.gigan4}&nbsp;</td>
				<td>${dto.school4}&nbsp;</td>
				<td>${dto.jeongong4}&nbsp;</td>
			</tr>
		</table>
		- 어학능력
		<table border="1" width="600">
			<tr>
				<td rowspan="2">어학</td>
				<td width="100">TOEIC</td>
				<td>${dto.toeic }점</td>
				<td width="100">일본어</td>
				<td>${dto.japan }급</td>
			</tr>
			<tr>
				<td>TOEFL</td>
				<td>${dto.toefl }점</td>
				<td>중국어</td>
				<td>${dto.china }급</td>
			</tr>
		</table>
	</div>
	<br><br>
</c:forEach>


<%-- <%
for(int i=0; i<dtos.size(); i++){
	ResumeDTO dto = dtos.get(i);%>
	<div style="border: 1px solid black; width: 600px;">
		- 인적사항
		<table border="1" width="600">
			<tr>
				<td rowspan="4" width="200"><a href="view.jsp?no=<%=dto.getNo()%>"><%=dto.getPic()%></a></td>
				<td width="100">성명</td>
				<td><%=dto.getName() %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%=dto.getEmail() %></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><%=dto.getPhone() %></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><%=dto.getAddress() %></td>
			</tr>
		</table>
		- 학력사항
		<table border="1" width="600">
			<tr>
				<td>기간</td>
				<td>학교명</td>
				<td>전공(학과)</td>
			</tr>
			<tr>
				<td><%=dto.getGigan1()==null?"&nbsp;":dto.getGigan1() %>&nbsp;</td>
				<td><%=dto.getSchool1()==null?"&nbsp;":dto.getSchool1() %>&nbsp;</td>
				<td><%=dto.getJeongong1()==null?"&nbsp;":dto.getJeongong1() %>&nbsp;</td>
			</tr>
			<tr>
				<td><%=dto.getGigan2()==null?"&nbsp;":dto.getGigan2() %>&nbsp;</td>
				<td><%=dto.getSchool2()==null?"&nbsp;":dto.getSchool2() %>&nbsp;</td>
				<td><%=dto.getJeongong2()==null?"&nbsp;":dto.getJeongong2() %>&nbsp;</td>
			</tr>
			<tr>
				<td><%=dto.getGigan3()==null?"&nbsp;":dto.getGigan3() %>&nbsp;</td>
				<td><%=dto.getSchool3()==null?"&nbsp;":dto.getSchool3() %>&nbsp;</td>
				<td><%=dto.getJeongong3()==null?"&nbsp;":dto.getJeongong3() %>&nbsp;</td>
			</tr>
			<tr>
				<td><%=dto.getGigan4()==null?"&nbsp;":dto.getGigan4() %>&nbsp;</td>
				<td><%=dto.getSchool4()==null?"&nbsp;":dto.getSchool4() %>&nbsp;</td>
				<td><%=dto.getJeongong4()==null?"&nbsp;":dto.getJeongong4() %>&nbsp;</td>
			</tr>
		</table>
		- 어학능력
		<table border="1" width="600">
			<tr>
				<td rowspan="2">어학</td>
				<td width="100">TOEIC</td>
				<td><%=dto.getToeic() %>점</td>
				<td width="100">일본어</td>
				<td><%=dto.getJapan() %>급</td>
			</tr>
			<tr>
				<td>TOEFL</td>
				<td><%=dto.getToefl() %>점</td>
				<td>중국어</td>
				<td><%=dto.getChina() %>급</td>
			</tr>
		</table>
	</div>
	<br><br>
<%}

%> --%>
	<a href="write.jsp">[이력서 작성]</a>
	


</body>
</html>