<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>

<%
	
	String id = request.getParameter("id");
	String curPw = request.getParameter("curPw");
	String nextPw_ = request.getParameter("nextPw");
	String nextPw = nextPw_.trim();
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	int birth = Integer.parseInt(request.getParameter("birth"));

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbId = "jspTest";
	String dbPw = "1234";
	
	int result = 0;
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		System.out.println("오라클 접속 성공");
		
		String sql = "UPDATE joinTBL01 SET pw = ?, name = ?, phone = ?, email = ?, birth = ? where id = ?";
		pstmt = conn.prepareStatement(sql);
		if(nextPw.equals("")){
			pstmt.setString(1, curPw);
		}else{
			pstmt.setString(1, nextPw);
		}
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, email);
		pstmt.setInt(5, birth);
		pstmt.setString(6, id);
		result = pstmt.executeUpdate();
		System.out.println("쿼리 성공");
		
		if(result>0){
			out.print("<script>");
			out.print("alert('수정이 완료됐습니다.');");
			out.print("location.href='memberList.jsp';");
			out.print("</script>");
		}else{
			out.print("<script>");
			out.print("alert('수정중 오류가 발생했습니다.');");
			out.print("location.href='memberView.jsp?id='"+id+"';");
			out.print("</script>");
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
