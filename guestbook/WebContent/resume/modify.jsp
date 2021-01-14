<%@page import="resume.ResumeDTO"%>
<%@page import="resume.ResumeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String no = request.getParameter("no");
	ResumeDAO dao = new ResumeDAO();
	ResumeDTO dto = dao.getSelect(no);
%>
<!DOCTYPE html>
<html>
<head>
<style>
#picbutton{
	padding: 1px 1px;
	background-color:#FF6600;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="border: 1px solid black; width: 600px;">
		<form name="modifyForm" method="post" encType="multipart/form-data" action="modifyProc.jsp">
		<input type="hidden" name="no" value="<%=no%>">
		- 인적사항
			<table border="1" width="600">
				<tr>
					<td rowspan="3" width="100">
					<img src="<%=request.getContextPath()%>/upload/img/<%=dto.getPic()%>" style="width: 100px; height:100px;">
					</td>
					<td width="100">성명</td>
					<td><%=dto.getName() %></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value="<%=dto.getEmail() %>"></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="phone" value="<%=dto.getPhone() %>"></td>
				</tr>
				<tr>
					<td align="center">
					<label for="input-pic" id="picbutton">사진 변경</label>
					<input type="file" name="pic" id="input-pic" style="display: none">
					</td>
					<td>주소</td>
					<td><input type="text" name="address" value="<%=dto.getAddress() %>"></td>
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
					<td><input type="text" name="gigan1"
					value="<%=dto.getGigan1()==null?"&nbsp;":dto.getGigan1() %>"></td>
					<td><input type="text" name="school1"
					value="<%=dto.getSchool1()==null?"&nbsp;":dto.getSchool1() %>"></td>
					<td><input type="text" name="jeongong1"
					value="<%=dto.getJeongong1()==null?"&nbsp;":dto.getJeongong1() %>"></td>
				</tr>
				<tr>					
					<td><input type="text" name="gigan2"
					value="<%=dto.getGigan2()==null?"&nbsp;":dto.getGigan2() %>"></td>
					<td><input type="text" name="school2"
					value="<%=dto.getSchool2()==null?"&nbsp;":dto.getSchool2() %>"></td>
					<td><input type="text" name="jeongong2"
					value="<%=dto.getJeongong2()==null?"&nbsp;":dto.getJeongong2() %>"></td>
				</tr>
				<tr>					
					<td><input type="text" name="gigan3"
					value="<%=dto.getGigan3()==null?"&nbsp;":dto.getGigan3() %>"></td>
					<td><input type="text" name="school3"
					value="<%=dto.getSchool3()==null?"&nbsp;":dto.getSchool3() %>"></td>
					<td><input type="text" name="jeongong3"
					value="<%=dto.getJeongong3()==null?"&nbsp;":dto.getJeongong3() %>"></td>
				</tr>
				<tr>					
					<td><input type="text" name="gigan4"
					value="<%=dto.getGigan4()==null?"&nbsp;":dto.getGigan4() %>"></td>
					<td><input type="text" name="school4"
					value="<%=dto.getSchool4()==null?"&nbsp;":dto.getSchool4() %>"></td>
					<td><input type="text" name="jeongong4"
					value="<%=dto.getJeongong4()==null?"&nbsp;":dto.getJeongong4() %>"></td>
				</tr>
			</table>
			- 어학능력
			<table border="1" width="600">
				<tr>
					<td rowspan="2">어학</td>
					<td width="100">TOEIC</td>
					<td width="125"><input type="text" name="TOEIC" value="<%=dto.getToeic() %>" style="width: 100px">점</td>
					<td width="100">일본어</td>
					<td width="125"><input type="text" name="japan" value="<%=dto.getJapan() %>" style="width: 100px">급</td>
				</tr>
				<tr>
					<td>TOEFL</td>
					<td><input type="text" name="TOEFL" value="<%=dto.getToefl() %>" style="width: 100px">점</td>
					<td>중국어</td>
					<td><input type="text" name="china" value="<%=dto.getChina() %>" style="width: 100px">급</td>
				</tr>
			</table>
			<input type="submit" value="수정하기">
			<input type="button" value="이전으로" onclick="location.href='view.jsp?no=<%=no %>'">
		</form>
	</div>
</body>
</html>