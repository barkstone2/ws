<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<%
	String qChoice = request.getParameter("qChoice");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String subj = request.getParameter("subj");
	String content = request.getParameter("content");

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
		
		String sql = "insert into com11st values(seq_com11st.nextval, ?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qChoice);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, email);
		pstmt.setString(5, subj);
		pstmt.setString(6, content);
		result = pstmt.executeUpdate();
		System.out.println("쿼리 성공");
		
		if(result >0) {
			out.println("<script>");
			out.println("alert('정상적으로 처리됐습니다.');");
			out.println("location.href='list.jsp'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('처리 중 오류가 발생했습니다.');");
			out.println("location.href='11st.jsp'");
			out.println("</script>");
		}
		
	}catch(Exception e){
		out.println("<script>");
		out.println("alert('처리 중 오류가 발생했습니다.');");
		out.println("location.href='11st.jsp'");
		out.println("</script>");
	}
	

%>


    
    