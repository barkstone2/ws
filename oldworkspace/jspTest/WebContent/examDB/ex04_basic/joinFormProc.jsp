<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>


<%
	int check = 0;
	String temp;
	
	String id = request.getParameter("id");
	temp = id.trim();
	if(!id.equals(temp)){
		check = 1;
		out.print("<script>alert('아이디를 입력하세요.'); history.back();</script>");
	}
	
	String pw = request.getParameter("pw");
	temp = pw.trim();
	if(!pw.equals(temp)){
		check = 1;
		out.print("<script>alert('비밀번호를 입력하세요.'); history.back();</script>");
	}
	
	String pwc = request.getParameter("pwc");
	temp = pwc.trim();
	if(!pwc.equals(temp)){
		check = 1;
		out.print("<script>alert('비밀번호확인을 입력하세요.'); history.back();</script>");
	}
	
	String name = request.getParameter("name");
	temp = name.trim();
	if(!name.equals(temp)){
		check = 1;
		out.print("<script>alert('이름을 입력하세요.'); history.back();</script>");
	}
	
	String phone = request.getParameter("phone");
	temp = phone.trim();
	if(!phone.equals(temp)){
		check = 1;
		out.print("<script>alert('전화번호를 입력하세요.'); history.back();</script>");
	}
	
	String email = request.getParameter("email");
	temp = email.trim();
	if(!email.equals(temp)){
		check = 1;
		out.print("<script>alert('이메일을 입력하세요.'); history.back();</script>");
	}
	
	String birth_ = request.getParameter("birth");
	temp = birth_.trim();
	if(!birth_.equals(temp)){
		check = 1;
		out.print("<script>alert('생년월일을 입력하세요.'); history.back();</script>");
	}
	
 	if(check==0){ 
		
		int birth = Integer.parseInt(birth_);
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
			
			String sql = "insert into joinTBL01 values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setInt(6, birth);
			result = pstmt.executeUpdate();
			System.out.println("쿼리 성공");
			
			if(result > 0){ %>
				<script>
					alert('정상적으로 처리됐습니다.');
					location.href='memberList.jsp';
				</script>
				
			<%} else {%>
				<script>
					alert('데이터베이스 처리 중 오류가 발생했습니다.');
					location.href='joinForm.jsp';
				</script>
				
			<%}
			
		}catch(Exception e){%>
				<script>
					alert('예외가 발생했습니다.');
					location.href='joinForm.jsp';
				</script>
			
	<%	} finally{
			try{
				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
 	} else{
		System.out.println("처리중 오류 발생");
		check = 0;
	} 
	%>
	
	
	
	
	
	
<%-- <%	
	
	int idLen1 = id.length();
	
	String id2 = id.replace(" ", "");
	int idLen2 = id2.length();
	
	if(idLen1 - idLen2 == 0){
	%>
		111
	
	<%}else{%>
		<script>
			alert('공백만 입력했습니다.\n다시 입력해주세요.');
			history.back(); // history.go(-1); 전 페이지, 1:다음페이지 2:다음다음 페이지
		</script>
	
	<%
	}
	if(id == null){
		System.out.println("널");
	}else if(id.equals("")) {
		System.out.println("공백");
	}else{
		System.out.println("몰라");
	}
	
%>	 --%>
