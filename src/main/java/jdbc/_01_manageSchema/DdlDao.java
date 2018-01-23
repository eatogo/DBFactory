package jdbc._01_manageSchema;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc._00_Init.DbConnector;

public class DdlDao {
	
	public boolean createCompleteTables() {
		try {
			DbConnector dbConnector = new DbConnector();
			Connection conn = dbConnector.connect();
			Statement stmt = conn.createStatement();
			SqlManager sqlManager = new SqlManager(stmt);
			System.out.println("開始建立會員系統tables");
			sqlManager.dropAllConstraints();
			sqlManager.dropAllTables();
			sqlManager.createAllTables();
			sqlManager.addAllConstraints();
			System.out.println("建立會員系統tables成功");
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立會員系統tables失敗");
			e.printStackTrace();
			return false;
		}
	}
	
}
