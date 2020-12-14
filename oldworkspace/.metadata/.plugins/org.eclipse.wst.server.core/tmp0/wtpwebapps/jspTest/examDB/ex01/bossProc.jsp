<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String boss_1 = request.getParameter("boss_1");
	String boss_2 = request.getParameter("boss_2");
	String boss_3 = request.getParameter("boss_3");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int result = 0;
	
	try {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
		String dbId = "jspTest";
		String dbPasswd = "1234";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPasswd);
		System.out.println("오라클 접속 성공");
		
		String sql = "insert into boss values(seq_boss.nextval, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boss_1);
		pstmt.setString(2, boss_2);
		pstmt.setString(3, boss_3);
		result = pstmt.executeUpdate();
		
		
		
		if(result >0){
			out.println("<script>");
			out.println("alert('정상 처리 되었습니다.');");
			out.println("location.href='list.jsp';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('처리중 오류가 발생했습니다.');");
			out.println("location.href='boss.jsp';");
			out.println("</script>");
			
		}
		
		
		System.out.println(result);
		
	}catch(Exception e){
		System.out.println("오라클 접속 실패");
		e.printStackTrace();
	}
	
	
%>

    