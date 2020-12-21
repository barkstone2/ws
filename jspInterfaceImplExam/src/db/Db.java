package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface Db {

	public Connection getConn();
	public PreparedStatement setInsert(Object dto, Connection conn);
	
}
