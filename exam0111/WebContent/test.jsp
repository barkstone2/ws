<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="exam0111.EmployeesDTO"%>
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
		
		class Imsi{
			private Connection conn = null;
			private PreparedStatement pstmt = null;
			private ResultSet rs = null;
			
			public Imsi(){
			}
			
			public void getConn() {
				try {
					String driver = "oracle.jdbc.driver.OracleDriver";
					String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
					String dbId = "hr";
					String dbPw = "1234";
					Class.forName(driver);
					conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
					System.out.println("오라클 접속 성공");
				}catch (Exception e) {
					System.out.println("오라클 접속 실패");
					e.printStackTrace();
				}
			}
			public void quitConn() {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
			public EmployeesDTO getStevenKingInfo() {
				EmployeesDTO dto = new EmployeesDTO();
				getConn();
				try {
					String sql = "select * from employees where first_name='Steven' and last_name='King'";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						dto.setEmployeeId(rs.getInt("employee_id"));
						dto.setFirstName(rs.getString("first_name"));
						dto.setLastName(rs.getString("last_name"));
						dto.setEmail(rs.getString("email"));
						dto.setPhoneNumber(rs.getString("phone_number"));
						dto.setHireDate(rs.getString("hire_date"));
						dto.setJobId(rs.getString("job_id"));
						dto.setSalary(rs.getInt("salary"));
						dto.setCommisiionPct(rs.getInt("COMMISSION_PCT"));
						dto.setManagerId(rs.getInt("MANAGER_ID"));
						dto.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
					}
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					quitConn();
				}
				return dto;
			}
		}
	
	Imsi imsi = new Imsi();
	EmployeesDTO dto = imsi.getStevenKingInfo();
	
	
	
	out.print(dto);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	%>
</body>
</html>