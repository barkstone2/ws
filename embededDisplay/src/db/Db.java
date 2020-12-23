package db;

import java.sql.Connection;

public interface Db {
	public Connection getConn();
	public void getConnClose();
}
