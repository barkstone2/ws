<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String class1 = request.getParameter("class1");
	String class2 = request.getParameter("class2");
	String class3 = request.getParameter("class3");
	String class4 = request.getParameter("class4");
	String class5 = request.getParameter("class5");

%>

<%
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "jspTest";
	String dbPw = "1234";
	
	int result = 0;
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공");
		
		String sql = "insert into classChief values(seq_classChief.nextVal, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, class1);
		pstmt.setString(2, class2);
		pstmt.setString(3, class3);
		pstmt.setString(4, class4);
		pstmt.setString(5, class5);
		result = pstmt.executeUpdate();
		System.out.println("쿼리 성공");
		
		if(result >0) {
			out.println("<script>");
			out.println("alert('정상 처리 되었습니다.');");
			out.println("location.href='list.jsp';");
			out.println("</script>");
		} else {
		 	out.println("<script>");
			out.println("alert('처리중 오류가 발생했습니다.');");
			out.println("location.href='classChief.jsp';");
			out.println("</script>");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	 	out.println("<script>");
		out.println("alert('처리중 오류가 발생했습니다.');");
		out.println("location.href='classChief.jsp';");
		out.println("</script>");
	}

%>
    