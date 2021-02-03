package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface Db {
	public Connection getConn();
	public void quitConn(ResultSet rs, PreparedStatement pstmt, Connection conn);
}
