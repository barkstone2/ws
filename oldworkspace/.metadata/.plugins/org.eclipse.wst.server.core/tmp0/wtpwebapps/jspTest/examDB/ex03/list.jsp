<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "jspTest";
	String dbPw = "1234";	

	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공");
		
		String sql = "select * from com11st";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			int no = rs.getInt("no");
			String qChoice = rs.getString("qChoice");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			String subj = rs.getString("subj");
			String content = rs.getString("content");
			out.print(no + " / " + qChoice + " / " + name+ " / " + phone + " / " + email+ " / " + subj + " / " +content+"<br>");
		}
		
		
		
	}catch(Exception e){
		
	}




%>
    
    
    