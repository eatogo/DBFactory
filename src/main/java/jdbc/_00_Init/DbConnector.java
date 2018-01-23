package jdbc._00_Init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private String DBURL;
	private String USER;
	private String PASSWORD;
	private Connection conn;

	public Connection connect() {
		DBURL = DbConstants.URL;
		USER = DbConstants.USER;
		PASSWORD = DbConstants.PASSWORD;
		try {
			Class.forName(DbConstants.driverName);
			conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			System.out.println("資料庫連線失敗");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("找不到jdbc Driver");
			return null;
		}
	}
}
