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
import java.util.Date;
import java.util.Random;

import jdbc.model.global.DbConnector;
import jdbc.model.pojo.FOODS;
import jdbc.model.pojo.USERS;
import jdbc.utils.RandomFoodFactory;
import jdbc.utils.RandomTimeFactory;
import jdbc.utils.RandomUserFactory;

public class DataDao {
	String dbUsername, dbPassword;
	Connection conn = null;
	private Random random;
	private final Integer TOTAL_USERS = 100;
	private final Integer TOTAL_STORES = 1054;
	private final Integer TOTAL_OWNERS = 30;
	private final Integer TOTAL_MANAGERS = 60;
	private final Integer MAX_FAVORITE = 10;
	private final Integer ORDER_NUMBERS = 10;
	private final Integer FOOD_QUANTITY = 5;
	private final String BEGIN_DATE = "2010-01-01"; // 格式為：yyyy-MM-dd
	private final String END_DATE = "2018-03-24"; // 格式為：yyyy-MM-dd
	private Integer totalFoods;
	
	public DataDao(String dbUsername, String dbPassword) {
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		random = new Random();
		totalFoods = 0;
	}
	
	/**
	 * 建立所有資料
	 * @return true if success, false if fail
	 */
	public boolean insertAllData() {
		if (insertStaticData() && insertFakeData()) return true;
		else return false;
	}

	/**
	 * 建立靜態資料
	 * @return true if success, false if fail
	 */
	public boolean insertStaticData() {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			System.out.println("開始建立固定資料");
			executeSqlFromFile("createStaticData.sql");
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
	
	/**
	 * 執行sql檔案
	 * @param fileName
	 * @throws SQLException
	 */
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

	/**
	 * 建立動態假資料
	 * @return ture if success, false if fail
	 */
	public boolean insertFakeData() {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			Long start = System.currentTimeMillis();
			System.out.println("開始建立動態(假)資料");
			
			System.out.println("開始建立假使用者資料");
			executeSqlFromGeneratedUserData();
			System.out.println("建立假使用者資料成功");
			
			System.out.println("開始建立假店家資料");
			executeSqlFromFile("createStoresData.sql");
			System.out.println("建立假店家資料成功");
			
			System.out.println("開始建立假店家管理員資料");
			executeSqlFromGeneratedAuthData();
			System.out.println("建立假店家管理員資料成功");
			
			System.out.println("開始建立假餐點資料");
			executeSqlFromGeneratedFoodData();
			System.out.println("建立假餐點資料成功");
			
			System.out.println("開始建立假收藏資料");
			executeSqlFromGeneratedFavoriteData();
			System.out.println("建立假收藏資料成功");
			
			System.out.println("開始建立假訂單資料");
			executeSqlFromGeneratedOrderData();
			System.out.println("建立假訂單資料成功");
			
			System.out.println("開始建立假訂單詳細資料");
			executeSqlFromGeneratedOrderDetailData();
			System.out.println("建立假訂單詳細資料成功");
			
			System.out.println("開始建立評價資料");
			executeSqlFromGeneratedReviewData();
			System.out.println("建立評價資料成功");
			
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

	private String USE_EATOGODB_SQL = "USE `eatogodb`;";
	private final String INSERT_GENERATED_USERS_SQL = "INSERT INTO `USERS`"
			+ " (user_password, user_cellphone, user_name, user_email, user_create_time, user_status)"
			+ " VALUES"
			+ " (?, ?, ?, ?, ?, ?);";

	/**
	 * 建立使用者資料，資料筆數依照TOTAL_USERS
	 */
	private void executeSqlFromGeneratedUserData() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(USE_EATOGODB_SQL);
			stmt.close();
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_USERS_SQL);
			RandomUserFactory userFactory = new RandomUserFactory();
			USERS user;
			for (int index = 1; index <= TOTAL_USERS; index++) {
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
	
	/**
	 * 將總筆數TOTAL_STORES家店家的店主權限平均分給前TOTAL_OWNERS個使用者
	 * 而(TOTAL_MANAGERS - TOTAL_OWNERS)個使用者則隨機成為各店家管理員
	 */
	private void executeSqlFromGeneratedAuthData() {
		Integer storesPerOwner = TOTAL_STORES / TOTAL_OWNERS;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(USE_EATOGODB_SQL);
			stmt.close();
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_AUTH_SQL);
			int ownerId = 1;
			for (int storeId = 1; storeId <= TOTAL_STORES; storeId++) {
				ps.setInt(1, storeId);
				ps.setInt(2, ownerId);
				ps.setString(3, "owner");
				ps.executeUpdate();
				if (storeId % storesPerOwner == 0) {
					ownerId++;
				}
				ps.setInt(1, storeId);
				ps.setInt(2, ((int) (Math.random() * TOTAL_MANAGERS) + TOTAL_OWNERS + 1));
				ps.setString(3, "manager");
				ps.executeUpdate();
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立(假)使用者資料錯誤");
			e.printStackTrace();
		}
	}

	private final String INSERT_GENERATED_FOODS_SQL = "INSERT INTO `FOODS`"
			+ " (food_name, food_price, food_type, food_store, food_status, food_review_count)" 
			+ " VALUES"
			+ " (?, ?, ?, ?, ?, ?);";

	/**
	 * 每間店家平均產生八道菜色，餐點類型隨機
	 */
	private void executeSqlFromGeneratedFoodData() {
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_FOODS_SQL);
			RandomFoodFactory foodFactory = new RandomFoodFactory();
			FOODS food;
			for (int store_id = 1; store_id <= TOTAL_STORES; store_id++) {
				for (int dishCount = 1; dishCount <= 8; dishCount++) {
					food = foodFactory.generateRandomFood(store_id);
					ps.setString(1, food.getFood_name());
					ps.setInt(2, food.getFood_price());
					ps.setString(3, food.getFood_type());
					ps.setInt(4, store_id);
					ps.setString(5, food.getFood_status());
					ps.setLong(6, food.getFood_review_count());
					ps.executeUpdate();
					totalFoods++;
				}
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}
	
	private final String INSERT_GENERATED_FAVORITES_SQL = "INSERT INTO `FAVORITES`"
			+ " (favorite_food, favorite_user)"
			+ " VALUES"
			+ " (?, ?);";
	
	/**
	 * 亂數為每個使用者產生收藏清單，數量隨機，每人最多產生MAX_FAVORITE筆記錄
	 */
	private void executeSqlFromGeneratedFavoriteData() {
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_FAVORITES_SQL);
			for (int user = 1; user <= TOTAL_USERS; user++) {
				int numberOfFavorite = random.nextInt(MAX_FAVORITE) + 1;
				for (int round = 1; round <= numberOfFavorite; round++) {
					int randomFoodId = random.nextInt(totalFoods) + 1;
					ps.setInt(1, randomFoodId);
					ps.setInt(2, user);
					ps.executeUpdate();
				}
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}
	
	private final String INSERT_GENERATED_ORDERS_SQL = "INSERT INTO `ORDERS`"
			+ " (order_user, order_time, order_store, order_status)"
			+ " VALUES"
			+ " (?, ?, ?, ?);";
	
	/**
	 * 共(TOTAL_USERS - TOTAL_OWNERS - TOTAL_MANAGERS)位單純使用者會各有50筆訂單記錄
	 * 每人分別有ORDER_NUMBERS筆店家未確認訂單(ordered)
	 * ORDER_NUMBERS筆店家未出貨訂單(unfinished)
	 * ORDER_NUMBERS筆客戶已評價但店家未確認訂單(unconfirmed_store)
	 * ORDER_NUMBERS筆店家已確認但客戶未評價訂單(unconfirmed_user)
	 * 以及ORDER_NUMBERS筆完成訂單(finished)
	 */
	private void executeSqlFromGeneratedOrderData() {
		Integer startOfUserId = TOTAL_OWNERS + TOTAL_MANAGERS;
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_ORDERS_SQL);
			for (int userId = startOfUserId; userId <= TOTAL_USERS; userId++) {
				for (int orderNumber = 1; orderNumber <= ORDER_NUMBERS; orderNumber++) {
					ps.setInt(1, userId);
					Date date = RandomTimeFactory.randomDate(BEGIN_DATE, END_DATE);
					ps.setObject(2, date);
					ps.setInt(3, random.nextInt(TOTAL_STORES) + 1);
					ps.setString(4, "ordered");
					ps.executeUpdate();
				}
				for (int orderNumber = 1; orderNumber <= ORDER_NUMBERS; orderNumber++) {
					ps.setInt(1, userId);
					Date date = RandomTimeFactory.randomDate(BEGIN_DATE, END_DATE);
					ps.setObject(2, date);
					ps.setInt(3, random.nextInt(TOTAL_STORES) + 1);
					ps.setString(4, "unfinished");
					ps.executeUpdate();
				}
				for (int orderNumber = 1; orderNumber <= ORDER_NUMBERS; orderNumber++) {
					ps.setInt(1, userId);
					Date date = RandomTimeFactory.randomDate(BEGIN_DATE, END_DATE);
					ps.setObject(2, date);
					ps.setInt(3, random.nextInt(TOTAL_STORES) + 1);
					ps.setString(4, "unconfirmed_store");
					ps.executeUpdate();
				}
				for (int orderNumber = 1; orderNumber <= ORDER_NUMBERS; orderNumber++) {
					ps.setInt(1, userId);
					Date date = RandomTimeFactory.randomDate(BEGIN_DATE, END_DATE);
					ps.setObject(2, date);
					ps.setInt(3, random.nextInt(TOTAL_STORES) + 1);
					ps.setString(4, "unconfirmed_user");
					ps.executeUpdate();
				}
				for (int orderNumber = 1; orderNumber <= ORDER_NUMBERS; orderNumber++) {
					ps.setInt(1, userId);
					Date date = RandomTimeFactory.randomDate(BEGIN_DATE, END_DATE);
					ps.setObject(2, date);
					ps.setInt(3, random.nextInt(TOTAL_STORES) + 1);
					ps.setString(4, "finished");
					ps.executeUpdate();
				}
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}
	
	private String SELECT_ORDER_BY_ORDER_STATUS_SQL = "SELECT * FROM `ORDERS` WHERE order_status = ?;";
	private String INSERT_GENERATED_ORDER_DETAILS_SQL = "INSERT INTO `ORDER_DETAILS`"
			+ " (order_id, order_food, order_quantity)"
			+ " VALUES"
			+ " (?, ?, ?);";
	
	/**
	 * 依據亂數產生訂單及訂單狀態產生訂單詳細資訊
	 */
	private void executeSqlFromGeneratedOrderDetailData() {
		generateOrders("ordered");
		generateOrders("unfinished");
		generateOrders("unconfirmed_store");
		generateOrders("unconfirmed_user");
		generateOrders("finished");
	}
	
	private void generateOrders(String orderStatus) {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ORDER_BY_ORDER_STATUS_SQL);
			ps.setString(1, orderStatus);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ps = conn.prepareStatement(INSERT_GENERATED_ORDER_DETAILS_SQL);
				ps.setInt(1, result.getInt(1));
				ps.setInt(2, random.nextInt(totalFoods) + 1);
				ps.setInt(3, random.nextInt(FOOD_QUANTITY) + 1);
				ps.executeUpdate();
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}
	
	private String INSERT_GENERATED_REVIEWS_SQL = "INSERT INTO `REVIEWS`"
			+ " (review_user, review_order, review_food, review_time)"
			+ " VALUES"
			+ " (?, ?, ?, ?);";
	
	private void executeSqlFromGeneratedReviewData() {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ORDER_BY_ORDER_STATUS_SQL);
			ps.setString(1, "finished");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				ps = conn.prepareStatement(INSERT_GENERATED_REVIEWS_SQL);
				ps.setInt(1, result.getInt("order_user"));
				ps.setInt(2, result.getInt("order_id"));
				ps.setInt(3, random.nextInt(FOOD_QUANTITY) + 1);
				ps.setObject(4, new Date(System.currentTimeMillis() + random.nextInt(100000) - 50000));
				ps.executeUpdate();
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}
	
	private String SELECT_IDENTITY_BY_TYPE_SQL = "SELECT * FROM `IDENTITIES` WHERE identity_type = 'consumer';";
	
	/**
	 * 查詢是否有任何靜態資料存在
	 * @return true if exists, false if none
	 */
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

}