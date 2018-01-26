package jdbc._02_manageData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc._00_Init.DbConnector; 

public class DataDao {
	Connection conn = null;
	Statement stmt = null;
	
	public DataDao() {
		conn = new DbConnector().rootConnect();
	}

	public boolean insertFixedData() {
		try {
			System.out.println("開始建立固定資料");
			loadFixedFileFromSql();
			System.out.println("建立固定資料成功");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立固定資料失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	private void loadFixedFileFromSql() {
		String url = this.getClass().getResource("/").getPath();
		File sqlFile = new File(url, "fixedData.sql");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile)));
			String sql;
			while ((sql = br.readLine()) != null) {
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			}
			br.close();
			stmt.close();
			conn.close();
		} catch (FileNotFoundException e) {
			System.out.println("sql找不到");
			System.out.println(sqlFile.toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO開啟有問題");
			System.out.println(sqlFile.toString());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql執行有問題");
			e.printStackTrace();
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
	
	private final String USE_EATOGO_DATABASE_SQL = "USE eatogodb;";
	private void useEatogoDB() throws SQLException {
		stmt.executeUpdate(USE_EATOGO_DATABASE_SQL);
	}
	
}
