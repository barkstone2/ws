<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookId = null;
	if(session.getAttribute("cookId") != null){
		cookId = (String) session.getAttribute("cookId");
	}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원목록 - <%=cookId %></h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>출생년도</td>
			<td>비고</td>
		</tr>
<%
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbId = "jspTest";
	String dbPw = "1234";
	
	int result = 0;
	ArrayList<String> list = new ArrayList<>();
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		
		String sql = "select * from joinTBL01";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		String temp = "";
		
		while(rs.next()){
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String birth = rs.getString("birth").substring(0, 4)+"년";
			temp = id+"/"+pw+"/"+name+"/"+phone+"/"+email+"/"+birth;
			list.add(temp);
			
			out.println("<tr>");
			out.println("<td><a href='memberView.jsp?id="+id+"'>"+id+"</a></td>");
			out.println("<td>"+pw+"</td>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+phone+"</td>");
			out.println("<td>"+email+"</td>");
			out.println("<td>"+birth+"</td>");
			out.println("<td>&nbsp;</td>");
			out.println("</tr>");
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null){
				rs.close();
			}
			if(pstmt !=null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>    	
	</table>
	<a href='joinForm.jsp'>[처음으로]</a>
	<a href='logout.jsp'>[로그아웃]</a>
</body>

</html>

