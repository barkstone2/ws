package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {
	
	public Db() {
	}
	
	public static Connection getConn() {
		Connection conn = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbId = "srv_pg_impl";
			String dbPw = "1234";
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("오라클 접속 성공");
		}catch(Exception e) {
			System.out.println("오라클 접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
