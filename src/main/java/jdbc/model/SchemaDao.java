package jdbc.model;

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

import jdbc.model.global.DbConnector;

public class SchemaDao {
	Connection conn = null;
	String dbUsername, dbPassword;
	String url = null;
	File sqlFile = null;
	BufferedReader br = null;
	
	public SchemaDao(String dbUsername, String dbPassword) {
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	
	public boolean createAllSchema() {
		if (createDatabase()) {
			return createAllTables();
		}
		return false;
	}
	
	private boolean createDatabase() {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			System.out.println("開始建立資料庫");
			executeSqlFromFile("createDB.sql");
			System.out.println("資料庫建立成功");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立資料庫失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean createAllTables() {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			System.out.println("開始建立Tables");
			executeSqlFromFile("createTables.sql");
			System.out.println("建立Tables成功");
			System.out.println("開始建立Constraints");
			executeSqlFromFile("addConstraints.sql");
			System.out.println("建立Constraints成功");
			System.out.println("開始建立Views");
			executeSqlFromFile("createView.sql");
			System.out.println("建立Views成功");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立Tables或Constraints或View失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	private void executeSqlFromFile(String fileName) {
		url = this.getClass().getResource("/").getPath();
		sqlFile = new File(url, fileName);
		try {
			Statement stmt = conn.createStatement();
			br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), "UTF8"));
			String sql;
			while ((sql = br.readLine()) != null) {
				stmt.executeUpdate(sql);
			}
			br.close();
			stmt.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println("檔案編碼錯誤" + fileName);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("找不到檔案：" + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("讀取檔案錯誤：" + fileName);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("執行 " + fileName + " 敘述時發生錯誤");
			e.printStackTrace();
		}
	}
	
}
