<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String cookId = null;
	if(session.getAttribute("cookId") != null){
		cookId = (String) session.getAttribute("cookId");
	}
%>    
<%
	String id = request.getParameter("id");
	String pw = null;
	String name = null;
	String phone = null;
	String email = null;
	String birth = null;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbId = "jspTest";
	String dbPw = "1234";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공");
		
		String sql = "select * from joinTBL01 where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			pw = rs.getString("pw");
			name = rs.getString("name");
			phone = rs.getString("phone");
			email = rs.getString("email");
			birth = rs.getString("birth");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null){rs.close();}
			if(pstmt != null){pstmt.close();}
			if(conn != null){conn.close();}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정 - <%=cookId %></h1>
	
	<form name="modForm" method="post" action="memModiProc.jsp">
		<table>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" value="<%=id%>" name="id" readonly></td>
			</tr>
			<tr>
				<td>현재 비밀번호 : </td>
				<td><input type="password" name="curPw"></td>
			</tr>
			<tr>
				<td>변경할 비밀번호 : </td>
				<td><input type="password" name="nextPw"></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td><input type="text" name="phone" value="<%=phone%>"></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><input type="text" name="email" value="<%=email%>"></td>
			</tr>
			<tr>
				<td>출생년도 : </td>
				<td><input type="text" name="birth" value="<%=birth%>"></td>
			</tr>
		</table>
		<a href='#' onclick='memModi();'>[수정하기]</a>
	</form>
	<a href='joinForm.jsp'>[처음으로]</a>
	
</body>

<script>
	function memModi(){
		if(confirm('수정하시겠습니까?')){
			if(modForm.curPw.value==<%=pw%>){
				modForm.submit();
			}else{
				alert('현재 비밀번호가 일치하지 않습니다.');
				modForm.pwc.focus();
			}
		}
	}

</script>

</html>