package db;

import java.sql.Connection;

public interface Db {
	Connection dbConn();
	void dbConnClose();
}
