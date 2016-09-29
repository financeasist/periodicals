package com.periodicals.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection connection;

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/periodicals_db?autoReconnect=true&useSSL=false";
	private static String login = "root";
	private static String password = "root";

	public ConnectionUtil() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, login, password);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return connection;
	}

}
