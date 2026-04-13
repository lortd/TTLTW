package me.nhom65.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	private static String username;
	private static String password;
	private static String database;
	

	static {
		try {
			Class.forName(driverClass);
			username = ContextServer.get("DB_USERNAME");
			password = ContextServer.get("DB_PASSWORD");
			database = ContextServer.get("DB_DATABASE");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/"+database+"?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Ho_Chi_Minh";
		return DriverManager.getConnection(url, username, password);
	}
	
}
