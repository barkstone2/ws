package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbExample {
	
	public static Connection getConn() {
		Db db = new DbImplOracle();
		return db.getConn();
	}
	
	public static void quitConn(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		Db db = new DbImplOracle();
		db.quitConn(rs, pstmt, conn);
	}
	
}
