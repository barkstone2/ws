package test_loop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import db.Db;
import db.DbImplOracle;

public class TransactionDAO {
	private Db db = new DbImplOracle();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public TransactionDAO() {
		conn = db.dbConn();
	}
	
	public void quitConn() {
		db.dbConnClose();
	}
	
	public void insert() {
		Savepoint savePoint = null;
		try {
			conn.setAutoCommit(false);
			long start_time = System.currentTimeMillis();
			String sql = "insert into transactionTBL values(?,?,default)";
			pstmt = conn.prepareStatement(sql);
			for(int i=1; i<=100000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "N"+i);
				pstmt.executeUpdate();
				if(i==1000) {
					savePoint = conn.setSavepoint("S1");
				}
			}
			conn.rollback(savePoint);
			conn.commit();
			//conn.setAutoCommit(true);
			long end_time = System.currentTimeMillis();
			System.out.println("시작시간 : "+start_time);
			System.out.println("종료시간 : "+end_time);
			System.out.println("소요시간 : "+((end_time-start_time)/1000)+"초 소요됨");
		}catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			quitConn();
		}
	}
	
	
	public void insertBatch() {
		try {
			conn.setAutoCommit(false);
			long start_time = System.currentTimeMillis();
			String sql = "insert into transactionTBL values(?,?,default)";
			pstmt = conn.prepareStatement(sql);
			for(int i=1; i<=100000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "N"+i);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			long end_time = System.currentTimeMillis();
			System.out.println("시작시간 : "+start_time);
			System.out.println("종료시간 : "+end_time);
			System.out.println("소요시간 : "+((end_time-start_time))+"초 소요됨");
		}catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			quitConn();
		}
	}
	
	
	
	
	
}
