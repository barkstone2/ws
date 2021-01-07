<%@page import="board.model.dto.BoardDTO"%>
<%@page import="board.model.dao.BoardDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="db.DbImplOracle"%>
<%@page import="db.Db"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		Db db = new DbImplOracle();
		Connection conn = db.dbConn();
		PreparedStatement pstmt = null;
		
		/*String num_ = request.getParameter("num");
		int num;
		if(num_ == null || num_.length() <=0){
			num=0;
		}else{
			num=Integer.parseInt(num_);
		}
		
		out.println("num : "+num+"<br>");
		
		if(num>1000){
			out.println("종료");
			return;
		}
		BoardDAO dao = new BoardDAO();
		num = num +1;
		int ref = num;
		int re_step = 1;
		int re_level = 1;
		int hit = 0;
		
		BoardDTO dto = new BoardDTO();
		dto.setNum(num);
		dto.setWriter(String.valueOf(num));
		dto.setSubject(String.valueOf(num));
		dto.setContent(String.valueOf(num));
		dto.setEmail(String.valueOf(num)+"@gmail.com");
		dto.setPasswd(String.valueOf(num));
		String sql = "insert into board "
				+"(no, num, writer, subject, content, email, passwd, ref, re_step, re_level, hit, regi_date) "
				+"values(seq_board.nextval,?,?,?,?,?,?,?,?,?,0,default)";	
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getPasswd());
			pstmt.setInt(7, ref);
			pstmt.setInt(8, re_step);
			pstmt.setInt(9, re_level);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		db.dbConnClose(); */
	
	
		
		
		
		
		String sql = "insert into board "
				+"(no, num, writer, subject, content, email, passwd, ref, re_step, re_level, hit, regi_date) "
				+"values(?,?,?,?,?,?,?,?,?,?,0,default)";	
		try{
			pstmt = conn.prepareStatement(sql);
			for(int i=1; i<=1000; i++){
				pstmt.setInt(1, i);
				pstmt.setInt(2, i);
				pstmt.setString(3, String.valueOf(i));
				pstmt.setString(4, String.valueOf(i));
				pstmt.setString(5, String.valueOf(i));
				pstmt.setString(6, String.valueOf(i));
				pstmt.setString(7, String.valueOf(i));
				pstmt.setInt(8, i);
				pstmt.setInt(9, i);
				pstmt.setInt(10, i);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		db.dbConnClose();
	
	%>
	
	
</body>
<%-- <script>
setTimeout(function(){
		location.href='dummy.jsp?num=<%=num%>';
}, 100); // 1000 - 1초
</script> --%>
</html>