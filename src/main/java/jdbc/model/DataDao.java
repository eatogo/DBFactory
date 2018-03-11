package jdbc.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.model.global.DbConnector;
import jdbc.model.pojo.FOODS;
import jdbc.model.pojo.STORE_AUTHORIZATIONS;
import jdbc.model.pojo.USERS;
import jdbc.utils.RandomFoodFactory;
import jdbc.utils.RandomStoreAuthFactory;
import jdbc.utils.RandomUserFactory;

public class DataDao {
	String dbUsername, dbPassword;
	Connection conn = null;
	
	public DataDao(String dbUsername, String dbPassword) {
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	
	private String USE_EATOGODB_SQL = "USE `eatogodb`;";
	private String SELECT_IDENTITY_BY_TYPE_SQL = "SELECT * FROM `IDENTITIES` WHERE identity_type = 'consumer';";
	
	public boolean isStaticDataExist() {
		boolean dataExists = false;
		try (Connection conn = new DbConnector().connect(dbUsername, dbPassword);
				Statement stmt = conn.createStatement();) {
			stmt.executeQuery(USE_EATOGODB_SQL);
			System.out.println("查詢固定資料是否存在");
			ResultSet rs = stmt.executeQuery(SELECT_IDENTITY_BY_TYPE_SQL);
			if (rs.next()) {
				dataExists = true;
				System.out.println("固定資料已存在");
			}
		} catch (SQLException e) {
			System.out.println("SQL問題，查詢固定資料失敗");
			e.printStackTrace();
		}
		return dataExists;
	}

	public boolean insertAllData() {
		if (insertStaticData()) return insertFakeData();
		else return false;
	}

	public boolean insertStaticData() {
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("關閉Connection錯誤");
					e.printStackTrace();
				}
		}
	}

	public boolean insertFakeData() {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			Long start = System.currentTimeMillis();
			System.out.println("開始建立動態(假)資料");
			System.out.println("開始建立假使用者資料");
			executeSqlFromGeneratedUserData();
			System.out.println("建立假使用者資料成功");
			System.out.println("開始建立假店家資料");
			executeSqlFromFile("storesData.sql");
			System.out.println("建立假店家資料成功");
			System.out.println("開始建立假店家管理員資料");
			executeSqlFromGeneratedAuthData();
			System.out.println("建立假店家管理員資料成功");
			System.out.println("開始建立假餐點資料");
			executeSqlFromGeneratedFoodData();
			System.out.println("建立假餐點資料成功");
			Long end = System.currentTimeMillis();
			System.out.println("建立動態(假)資料成功，總共耗時" + (end - start) / 1000.0 + "秒");
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL問題，建立動態(假)資料錯誤");
			e.printStackTrace();
			return false;
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("關閉Connection錯誤");
					e.printStackTrace();
				}
		}
	}

	private final String INSERT_GENERATED_USERS_SQL = "INSERT INTO `USERS`"
			+ " (user_password, user_cellphone, user_name, user_email, user_create_time, user_status)"
			+ " VALUES"
			+ " (?, ?, ?, ?, ?, ?);";

	private void executeSqlFromGeneratedUserData() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(USE_EATOGODB_SQL);
			stmt.close();
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_USERS_SQL);
			RandomUserFactory userFactory = new RandomUserFactory();
			USERS user;
			for (int index = 1; index <= 800; index++) {
				user = userFactory.generateRandomUser();
				ps.setString(1, user.getUser_password());
				ps.setString(2, user.getUser_cellphone());
				ps.setString(3, user.getUser_name());
				ps.setString(4, user.getUser_email());
				ps.setObject(5, user.getUser_create_time());
				ps.setString(6, user.getUser_status());
				ps.executeUpdate();
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立(假)使用者資料錯誤");
			e.printStackTrace();
		}
	}
	
	private final String INSERT_GENERATED_AUTH_SQL = "INSERT INTO `STORE_AUTHORIZATIONS`"
			+ " (store_auth_id, store_auth_user, store_auth)"
			+ " VALUES"
			+ " (?, ?, ?);";
	
	private void executeSqlFromGeneratedAuthData() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(USE_EATOGODB_SQL);
			stmt.close();
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_AUTH_SQL);
			RandomStoreAuthFactory authFactory = new RandomStoreAuthFactory();
			STORE_AUTHORIZATIONS auth;
			for (int index = 1; index <= 1054 ; index++) {
				auth = authFactory.generateRandomAuth(index);
				ps.setInt(1, auth.getStore_auth_id());
				ps.setInt(2, auth.getStore_auth_user());
				ps.setString(3, auth.getStore_auth());
				ps.executeUpdate();
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立(假)使用者資料錯誤");
			e.printStackTrace();
		}
	}

	private void executeSqlFromFile(String fileName) throws SQLException {
		Statement stmt = conn.createStatement();
		String url = this.getClass().getResource("/").getPath();
		File sqlFile = new File(url, fileName);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), "UTF8"));
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
			+ " (food_name, food_price, food_type, food_store, food_status, food_review_count)" + " VALUES"
			+ " (?, ?, ?, ?, ?, ?);";

	private void executeSqlFromGeneratedFoodData() {
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_FOODS_SQL);
			RandomFoodFactory foodFactory = new RandomFoodFactory();
			FOODS food;
			for (int store_id = 1; store_id <= 1054; store_id++) {
				for (int dishCount = 1; dishCount <= 8; dishCount++) {
					food = foodFactory.generateRandomFood(store_id);
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
