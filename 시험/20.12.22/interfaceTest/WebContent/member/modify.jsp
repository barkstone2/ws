<%@page import="member.MemberDTO"%>
<%@page import="member.MemberExample"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	MemberExample dao = new MemberExample();
	MemberDTO dto = dao.getSelect(id);
	String job = dto.getJob();
%>
	<h2>회원 정보 수정</h2>
	<form name="modifyForm" method="post" action="modifyProc.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
		 		<td>전화번호</td>
				<td>직업</td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="<%=dto.getId() %>"><%=dto.getId() %></td>
	 			<td><input type="text" name="pwd"></td>
	 			<td><%=dto.getName() %></td>
				<td><input type="text" name="phone" value="<%=dto.getPhone() %>"></td>
				<td>
					<input type="radio" name="job" value="공무원">공무원&nbsp;
					<input type="radio" name="job" value="개발자">개발자&nbsp;
					<input type="radio" name="job" value="군인">군인&nbsp;
					<input type="radio" name="job" value="디자이너">디자이너&nbsp;
				</td>
			</tr>
		</table>
		<input type="button" value="수정하기" onclick="modify();">
	</form>
</body>
<script>
	var arrJob = document.getElementsByName("job");
	for(var i=0;arrJob.length;i++){
		if(arrJob[i].value=='<%=job%>'){
			arrJob[i].checked = true;
		}
	}
	function modify(){
		if(confirm('수정하시겠습니까?')){
			if(modifyForm.pwd.value==<%=dto.getPwd()%>){
				modifyForm.submit();
			}else{
				alert('비밀번호가 일치하지 않습니다.');
				modifyForm.pwd.focus();
			}
		}
	}
</script>
</html>