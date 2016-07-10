package db.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection(String type, String host, int port, String dbName, String user, String pw){
		Connection connection = null;
		DriverManager.setLoginTimeout(60);
		String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
				.append(port).append("/").append(dbName).append("?user=").append(user).append("&password=")
				.append(pw).toString();
		System.out.println("URL:" + url);
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}
		return connection;
	}
}
