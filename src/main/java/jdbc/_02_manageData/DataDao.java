package jdbc._02_manageData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc._00_Init.DbConnector;

public class DataDao {
	Connection conn = null;
	Statement stmt = null;
	String url = null;
	File sqlFile = null;
	BufferedReader br = null;

	public DataDao(String dbUsername, String dbPassword) {
		conn = new DbConnector().connect(dbUsername, dbPassword);
	}

	public boolean insertFixedData() {
		try {
			System.out.println("開始建立固定資料");
			executeSqlFromFile("fixedData.sql");
			System.out.println("建立固定資料成功");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL問題，建立固定資料失敗");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			System.out.println("IO問題，建立固定資料失敗");
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertFakedData() {
		try {
			useEatogoDB();
			System.out.println("開始建立動態(假)資料");

			System.out.println("建立動態(假)資料成功");
			return true;
		} catch (SQLException e) {
			System.out.println("建立動態(假)資料失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	private void executeSqlFromFile(String fileName) throws IOException, SQLException {
		stmt = conn.createStatement();
		url = this.getClass().getResource("/").getPath();
		sqlFile = new File(url, fileName);
		br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile)));
		String sql;
		while ((sql = br.readLine()) != null) {
			stmt.executeUpdate(sql);
		}
		br.close();
		stmt.close();
	}

	private final String USE_EATOGO_DATABASE_SQL = "USE eatogodb;";

	private void useEatogoDB() throws SQLException {
		stmt.executeUpdate(USE_EATOGO_DATABASE_SQL);
	}

}
