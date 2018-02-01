package jdbc._02_manageData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import hibernate._00_init.schemas.food.FOODS;
import jdbc._00_Init.DbConnector;
import jdbc._02_manageData.generateData.RandomFoodGenerator;

public class DataDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	String url = null;
	File sqlFile = null;
	BufferedReader br = null;
	RandomFoodGenerator foodGenerator = null;
	FOODS food = null;

	public boolean insertStaticData(String dbUsername, String dbPassword) {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
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
			conn = new DbConnector().connect(dbUsername, dbPassword);
			System.out.println("開始建立動態(假)資料");
			executeSqlFromFile("storesData.sql");
//			executeSqlFromFile("foodsData.sql");
			executeSqlFromGeneratedData();
			System.out.println("建立動態(假)資料成功");
			return true;
		} catch (SQLException e) {
			System.out.println("SQL問題，建立動態(假)資料錯誤");
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

	private final String INSERT_GENERATED_FOODS_SQL = "INSERT INTO `FOODS`"
			+ " (food_name, food_price, food_type, food_store, food_status, food_review_count)"
			+ " VALUES"
			+ " (?, ?, ?, ?, ?, ?);";
	private void executeSqlFromGeneratedData() {
		try {
			ps = conn.prepareStatement(INSERT_GENERATED_FOODS_SQL);
			for (int store_id = 1; store_id <= 1054; store_id++) {
				for (int dishCount = 1; dishCount <= 8; dishCount++) {
					foodGenerator = new RandomFoodGenerator();
					food = foodGenerator.generateRandomFood(store_id);
					ps.setString(1, food.getFood_name());
					ps.setInt(2, food.getFood_price());
					ps.setString(3, food.getFood_type());
					ps.setInt(4, store_id);
					ps.setString(5, food.getFood_status());
					ps.setLong(6, food.getFood_review_count());
					ps.executeUpdate();
				}
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}
}
