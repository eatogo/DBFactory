package jdbc.model;

import edu.ntut.eatogo.dbfactory.factory.RandomFoodFactory;
import edu.ntut.eatogo.dbfactory.factory.RandomTimeFactory;
import edu.ntut.eatogo.dbfactory.factory.RandomUserFactory;
import edu.ntut.eatogo.dbfactory.persistence.entity.Food;
import edu.ntut.eatogo.dbfactory.persistence.entity.User;
import jdbc.model.global.DbConnector;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Date;
import java.util.Random;

public class DataDao {
	private String dbUsername, dbPassword;
	private Connection conn = null;
	private Random random;
	private final Integer TOTAL_USERS = 100;
	private final Integer TOTAL_STORES = 1054;
	private final Integer TOTAL_OWNERS = 30;
	private final Integer TOTAL_MANAGERS = 60;
	private final Integer MAX_FAVORITE = 10;
	private final Integer ORDER_NUMBERS = 10;
	private final Integer FOOD_QUANTITY = 5;
	private final String ORDER_BEGIN_DATE = "2010-01-01"; // 格式為：yyyy-MM-dd
	private final String ORDER_END_DATE = "2018-01-01"; // 格式為：yyyy-MM-dd
	private final String CONFIRM_ORDER_BEGIN_DATE = "2018-01-01"; // 格式為：yyyy-MM-dd
	private final String CONFIRM_ORDER_END_DATE = "2018-02-01"; // 格式為：yyyy-MM-dd
	private final String FINISH_ORDER_BEGIN_DATE = "2018-02-01"; // 格式為：yyyy-MM-dd
	private final String FINISH_ORDER_END_DATE = "2018-03-01"; // 格式為：yyyy-MM-dd
	private Integer totalFoods;
	private String[] ORDER_TAKEOUT_PERIODS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X" };

	public DataDao(String dbUsername, String dbPassword) {
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		random = new Random();
		totalFoods = 0;
	}

	/**
	 * 建立所有資料
	 * 
	 * @return true if success, false if fail
	 */
	public boolean insertAllData() {
		return insertStaticData() && insertFakeData();
	}

	/**
	 * 建立靜態資料
	 * 
	 * @return true if success, false if fail
	 */
	public boolean insertStaticData() {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			System.out.println("開始建立固定資料");
			executeSqlFromFile("static/createStaticData.sql");
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
	 */
	private void executeSqlFromFile(String fileName) throws SQLException {
		Statement stmt = conn.createStatement();
		String url = this.getClass().getResource("/").getPath();
		File sqlFile = new File(url, fileName);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), StandardCharsets.UTF_8));
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
	 * 
	 * @return true if success, false if fail
	 */
	public boolean insertFakeData() {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			Long start = System.currentTimeMillis();
			System.out.println("開始建立動態(假)資料");

			System.out.println("開始建立假使用者資料");
			//executeSqlFromGeneratedUserData();
			System.out.println("建立假使用者資料成功");

			System.out.println("開始建立假店家資料");
			executeSqlFromFile("static/createStoresData.sql");
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

	/**
	 * 建立使用者資料，資料筆數依照TOTAL_USERS
	 */
	private void executeSqlFromGeneratedUserData() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(USE_EATOGODB_SQL);
			stmt.close();
			String INSERT_GENERATED_USERS_SQL = "INSERT INTO `USERS`"
					+ " (user_password, user_cellphone, user_name, user_email, user_create_time, user_status)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_USERS_SQL);
			RandomUserFactory userFactory = new RandomUserFactory();
			User user;
			for (int index = 1; index <= TOTAL_USERS; index++) {
				user = userFactory.generateRandomUser();
				ps.setString(1, user.getUser_password());
				ps.setString(2, user.getUser_cellphone());
				ps.setString(3, user.getUser_name());
				ps.setString(4, user.getUser_email());
				ps.setObject(5, user.getUser_create_time());
				//ps.setString(6, user.getUserStatus());
				ps.executeUpdate();
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立(假)使用者資料錯誤");
			e.printStackTrace();
		}
	}

	/**
	 * 將總筆數TOTAL_STORES家店家的店主權限平均分給前TOTAL_OWNERS個使用者 而(TOTAL_MANAGERS -
	 * TOTAL_OWNERS)個使用者則隨機成為各店家管理員
	 */
	private void executeSqlFromGeneratedAuthData() {
		int storesPerOwner = TOTAL_STORES / TOTAL_OWNERS;
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(USE_EATOGODB_SQL);
			stmt.close();
			String INSERT_GENERATED_AUTH_SQL = "INSERT INTO `STORE_AUTHORIZATIONS`"
					+ " (store_auth_id, store_auth_user, store_auth)"
					+ " VALUES"
					+ " (?, ?, ?);";
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

	/**
	 * 每間店家平均產生八道菜色，餐點類型隨機
	 */
	private void executeSqlFromGeneratedFoodData() {
		try {
			String INSERT_GENERATED_FOODS_SQL = "INSERT INTO `FOODS`"
					+ " (food_name, food_price, food_type, food_store, food_status)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(INSERT_GENERATED_FOODS_SQL);
			RandomFoodFactory foodFactory = new RandomFoodFactory();
			Food food;
			for (int store_id = 1; store_id <= TOTAL_STORES; store_id++) {
				for (int dishCount = 1; dishCount <= 8; dishCount++) {
					food = foodFactory.generateRandomFood(store_id);
					ps.setString(1, food.getFood_name());
					ps.setInt(2, food.getFood_price());
					ps.setString(3, food.getFoodType().getFood_type());
					ps.setInt(4, store_id);
					ps.setString(5, food.getFood_status());
//					ps.setLong(6, food.getFood_review_count());
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

	/**
	 * 亂數為每個使用者產生收藏清單，數量隨機，每人最多產生MAX_FAVORITE筆記錄
	 */
	private void executeSqlFromGeneratedFavoriteData() {
		try {
			String INSERT_GENERATED_FAVORITES_SQL = "INSERT INTO `FAVORITES`"
					+ " (favorite_food, favorite_user)"
					+ " VALUES"
					+ " (?, ?);";
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

	/**
	 * 共(TOTAL_USERS - TOTAL_OWNERS - TOTAL_MANAGERS)位單純使用者會各有50筆訂單記錄
	 * 每人分別有ORDER_NUMBERS筆店家未確認訂單(ordered) ORDER_NUMBERS筆店家未出貨訂單(unfinished)
	 * ORDER_NUMBERS筆客戶已評價但店家未確認訂單(unconfirmed_store)
	 * ORDER_NUMBERS筆店家已確認但客戶未評價訂單(unconfirmed_user) 以及ORDER_NUMBERS筆完成訂單(finished)
	 */
	private void executeSqlFromGeneratedOrderData() {
		for (int storeId = 1; storeId <= TOTAL_STORES; storeId++) {
			for (int orderNumber = 1; orderNumber <= ORDER_NUMBERS; orderNumber++) {
				generateOrderedOrders(storeId);
				generatedUnfinishedOrders(storeId, "unfinished");
				generatedUnfinishedOrders(storeId, "unconfirmed_store");
				generateFinishedOrders(storeId, "unconfirmed_user");
				generateFinishedOrders(storeId, "finished");
			}
		}
	}

	private void generateOrderedOrders(Integer storeId) {
		PreparedStatement ps;
		try {
			String INSERT_GENERATED_ORDERED_ORDERS_SQL = "INSERT INTO `ORDERS`"
					+ " (order_user, order_time, order_store, order_status)"
					+ " VALUES"
					+ " (?, ?, ?, ?);";
			ps = conn.prepareStatement(INSERT_GENERATED_ORDERED_ORDERS_SQL);
			ps.setInt(1, random.nextInt(TOTAL_USERS) + 1);
			Date date = RandomTimeFactory.randomDate(ORDER_BEGIN_DATE, ORDER_END_DATE);
			ps.setObject(2, date);
			ps.setInt(3, storeId);
			ps.setString(4, "ordered");
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立 ordered 訂單亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}

	private void generatedUnfinishedOrders(Integer storeId, String orderStatus) {
		PreparedStatement ps;
		try {
			String INSERT_GENERATED_UNFINISHED_ORDERS_SQL = "INSERT INTO `ORDERS`"
					+ " (order_user, order_time, order_store, order_confirm_user, order_confirm_time, order_takeout_period, order_status)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?);";
			ps = conn.prepareStatement(INSERT_GENERATED_UNFINISHED_ORDERS_SQL);
			ps.setInt(1, random.nextInt(TOTAL_USERS) + 1);
			Date date = RandomTimeFactory.randomDate(ORDER_BEGIN_DATE, ORDER_END_DATE);
			ps.setObject(2, date);
			ps.setInt(3, storeId);
			ps.setInt(4, random.nextInt(TOTAL_MANAGERS) + TOTAL_OWNERS + 1);
			date = RandomTimeFactory.randomDate(CONFIRM_ORDER_BEGIN_DATE, CONFIRM_ORDER_END_DATE);
			ps.setObject(5, date);
			String orderTakeoutPeriod = ORDER_TAKEOUT_PERIODS[random.nextInt(ORDER_TAKEOUT_PERIODS.length)];
			ps.setString(6, orderTakeoutPeriod);
			ps.setString(7, orderStatus);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立" + orderStatus + "訂單亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}

	private void generateFinishedOrders(Integer storeId, String orderStatus) {
		PreparedStatement ps;
		try {
			String INSERT_GENERATED_FINISHED_ORDERS_SQL = "INSERT INTO `ORDERS`"
					+ " (order_user, order_time, order_store, order_confirm_user, order_confirm_time, order_takeout_period, order_finished_time, order_status)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?, ?);";
			ps = conn.prepareStatement(INSERT_GENERATED_FINISHED_ORDERS_SQL);
			ps.setInt(1, random.nextInt(TOTAL_USERS) + 1);
			Date date = RandomTimeFactory.randomDate(ORDER_BEGIN_DATE, ORDER_END_DATE);
			ps.setObject(2, date);
			ps.setInt(3, storeId);
			ps.setInt(4, random.nextInt(TOTAL_MANAGERS) + TOTAL_OWNERS + 1);
			date = RandomTimeFactory.randomDate(CONFIRM_ORDER_BEGIN_DATE, CONFIRM_ORDER_END_DATE);
			ps.setObject(5, date);
			String orderTakeoutPeriod = ORDER_TAKEOUT_PERIODS[random.nextInt(ORDER_TAKEOUT_PERIODS.length)];
			ps.setString(6, orderTakeoutPeriod);
			date = RandomTimeFactory.randomDate(FINISH_ORDER_BEGIN_DATE, FINISH_ORDER_END_DATE);
			ps.setObject(7, date);
			ps.setString(8, orderStatus);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			System.out.println("SQL問題，建立" + orderStatus + "訂單亂數(假)資料錯誤");
			e.printStackTrace();
		}
	}

	private String SELECT_ORDER_BY_ORDER_STATUS_SQL = "SELECT * FROM `ORDERS` WHERE order_status = ?;";

	/**
	 * 依據亂數產生訂單及訂單狀態產生訂單詳細資訊
	 */
	private void executeSqlFromGeneratedOrderDetailData() {
		generateOrderDetails("ordered");
		generateOrderDetails("unfinished");
		generateOrderDetails("unconfirmed_store");
		generateOrderDetails("unconfirmed_user");
		generateOrderDetails("finished");
	}

	private void generateOrderDetails(String orderStatus) {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ORDER_BY_ORDER_STATUS_SQL);
			ps.setString(1, orderStatus);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				String INSERT_GENERATED_ORDER_DETAILS_SQL = "INSERT INTO `ORDER_DETAILS`"
						+ " (order_id, order_food, order_quantity)"
						+ " VALUES"
						+ " (?, ?, ?);";
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

	private void executeSqlFromGeneratedReviewData() {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ORDER_BY_ORDER_STATUS_SQL);
			ps.setString(1, "finished");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				String INSERT_GENERATED_REVIEWS_SQL = "INSERT INTO `REVIEWS`"
						+ " (review_user, review_order, review_food, review_time)"
						+ " VALUES"
						+ " (?, ?, ?, ?);";
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

	/**
	 * 查詢是否有任何靜態資料存在
	 * 
	 * @return true if exists, false if none
	 */
	public boolean isStaticDataExist() {
		boolean dataExists = false;
		try (Connection conn = new DbConnector().connect(dbUsername, dbPassword);
				Statement stmt = conn.createStatement()) {
			stmt.executeQuery(USE_EATOGODB_SQL);
			System.out.println("查詢固定資料是否存在");
			String SELECT_IDENTITY_BY_TYPE_SQL = "SELECT * FROM `IDENTITIES` WHERE identity_type = 'consumer';";
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