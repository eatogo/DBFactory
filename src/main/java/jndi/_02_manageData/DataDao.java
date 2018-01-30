package jndi._02_manageData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jndi._00_init.DbConnector;

public class DataDao {
	Connection conn = null;
	Statement stmt = null;
	String url = null;
	File sqlFile = null;
	BufferedReader br = null;

	public boolean insertFixedData(String dbUsername, String dbPassword) {
		try {
			conn = DbConnector.connect().getConnection();
			System.out.println("開始建立固定資料");
			executeSqlFromFile("staticData.sql");
			System.out.println("建立固定資料成功");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL問題，建立固定資料失敗");
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("關閉stmt錯誤");
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("關閉conn錯誤");
					e.printStackTrace();
				}
		}
	}

	public boolean insertFakedData(String dbUsername, String dbPassword) {
		try {
			conn = DbConnector.connect().getConnection();
			useEatogoDB();
			System.out.println("開始建立動態(假)資料");
			
			executeSqlFromFile("fakeData.sql");

			System.out.println("建立動態(假)資料成功");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL問題，建立動態(假)資料失敗");
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("關閉stmt錯誤");
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("關閉conn錯誤");
					e.printStackTrace();
				}
		}
	}
	
	private void executeSqlFromFile(String fileName) throws SQLException {
		stmt = conn.createStatement();
		url = this.getClass().getResource("/").getPath();
		sqlFile = new File(url, fileName);
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), "UTF8"));
			String sql;
			while ((sql = br.readLine()) != null) {
				stmt.executeUpdate(sql);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println("檔案編碼錯誤" + fileName);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("找不到檔案：" + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("讀取檔案錯誤：" + fileName);
			e.printStackTrace();
		}
		stmt.close();
	}

	private final String USE_EATOGO_DATABASE_SQL = "USE eatogodb;";

	private void useEatogoDB() {
		try {
			stmt.executeUpdate(USE_EATOGO_DATABASE_SQL);
		} catch (SQLException e) {
			System.out.println("使用eatogodb錯誤");
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("關閉stmt錯誤");
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("關閉conn錯誤");
					e.printStackTrace();
				}
		}
	}

}
