package jdbc._04_createAll;

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

import jdbc._00_Init.DbConnector;

public class SchemaDao {
	Connection conn = null;
	Statement stmt = null;
	String url = null;
	File sqlFile = null;
	BufferedReader br = null;
	
	public boolean createAllSchema(String dbUsername, String dbPassword) {
		if (createDatabase(dbUsername, dbPassword)) {
			return createAllTables(dbUsername, dbPassword);
		}
		return false;
	}
	
	private boolean createDatabase(String dbUsername, String dbPassword) {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			executeSqlFromFile("createDB.sql");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立資料庫失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean createAllTables(String dbUsername, String dbPassword) {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			executeSqlFromFile("createTables.sql");
			executeSqlFromFile("addConstraints.sql");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立tables失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	private void executeSqlFromFile(String fileName) {
		url = this.getClass().getResource("/").getPath();
		sqlFile = new File(url, fileName);
		try {
			stmt = conn.createStatement();
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
