<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String id = request.getParameter("id");
	
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
		
		String sql = "delete joinTBL01 where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		result = pstmt.executeUpdate();
		
		if(result >0){%>
			<script>
				alert('회원정보가 삭제되었습니다.');
				location.href='memberList.jsp';
			</script>
			
		<%}else{%>
			<script>
				alert('회원정보 삭제에 실패했습니다.');
				location.href='memberView.jsp?id=<%=id%>';
			</script>
		<%}
		
	}catch(Exception e){
		
	}finally{
		try{
			if(rs != null){rs.close();}
			if(pstmt != null){pstmt.close();}
			if(conn != null){conn.close();}
		}catch(Exception e){
			
		}
	}


%>
    
    