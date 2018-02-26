package jdbc._00_Init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private String dbUrl = DbConstants.URL;
	private String driverName = DbConstants.DRIVER_NAME;
	private Connection conn;

	public Connection connect(String USER, String PASSWORD) {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			System.out.println("資料庫連線失敗");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("找不到JDBC Driver");
			return null;
		}
	}
	
}
