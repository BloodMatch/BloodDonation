package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	/*
	 *	DbConnection create single connection with
	 *	Mysql DataBase using JDBC driver
	 */
	
	final private static String driver = "com.mysql.cj.jdbc.Driver";
	final private static String dbDriver = "mysql";
	final private static String hostname = "localhost";
	final private static String port = "3306";
	final private static String database = "blooddonation";
	final private static String user = "root";
	final private static String passwd = "";
	private static Connection connection;
	
	static {
		try {
			// load JDBC Driver
			Class.forName(driver);
			connection = DriverManager.getConnection(
					String.format("jdbc:%s://%s:%s/%s", dbDriver, hostname, port, database)
					, user, passwd);
			System.out.println("isClosed = " + connection.isClosed());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private DbConnection() {
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
