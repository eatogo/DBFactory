package jdbc._01_manageSchema;

import java.sql.SQLException;
import java.sql.Statement;

public class SchemaSql {
	private Statement stmt;
	
	public SchemaSql(Statement stmt) {
		this.stmt = stmt;
	}
	
	public void createDatabase() throws SQLException {
		System.out.println("開始建立資料庫");
		stmt.executeUpdate(CREATE_EATOGO_DATABASE_SQL);
		System.out.println("建立資料庫成功");
	}
	
	private void useEatogoDB() throws SQLException {
		stmt.executeUpdate(USE_EATOGO_DATABASE_SQL);
	}

	public void dropAllConstraints() throws SQLException {
		System.out.println("開始清除constraint");
		useEatogoDB();
		stmt.executeUpdate(DROP_USERS_CONSTRAINTS_USER_STATUS_SQL);
		stmt.executeUpdate(DROP_USERS_CONSTRAINTS_USER_IDENTITY_SQL);
		stmt.executeUpdate(DROP_STORES_CONSTRAINTS_SQL);
		stmt.executeUpdate(DROP_FOODS_CONSTRAINTS_FOOD_TYPE_SQL);
		stmt.executeUpdate(DROP_FOODS_CONSTRAINTS_FOOD_STORE_SQL);
		stmt.executeUpdate(DROP_ORDERS_CONSTRAINTS_ORDER_USER_SQL);
		stmt.executeUpdate(DROP_ORDERS_CONSTRAINTS_ORDER_STORE_SQL);
		stmt.executeUpdate(DROP_ORDERS_CONSTRAINTS_ORDER_CONFIRM_USER_SQL);
		stmt.executeUpdate(DROP_ORDERS_CONSTRAINTS_ORDER_TAKEOUT_PERIOD_SQL);
		stmt.executeUpdate(DROP_ORDER_DETAILS_CONSTRAINTS_ORDER_ID_SQL);
		stmt.executeUpdate(DROP_ORDER_DETAILS_CONSTRAINTS_ORDER_FOOD_SQL);
		stmt.executeUpdate(DROP_FAVORITES_CONSTRAINTS_FAVORITE_FOOD_SQL);
		stmt.executeUpdate(DROP_FAVORITES_CONSTRAINTS_FAVORITE_USER_SQL);
		stmt.executeUpdate(DROP_REVIEWS_CONSTRAINTS_REVIEW_USER_SQL);
		stmt.executeUpdate(DROP_REVIEWS_CONSTRAINTS_REVIEW_ORDER_SQL);
		stmt.executeUpdate(DROP_REVIEWS_CONSTRAINTS_REVIEW_FOOD_SQL);
		System.out.println("清除constraint成功");
	}
	
	public void dropAllTables() throws SQLException {
		System.out.println("開始清除tables");
		useEatogoDB();
		stmt.executeUpdate(DROP_ORDER_DETAILS_TABLE_SQL);
		stmt.executeUpdate(DROP_FAVORITES_TABLE_SQL);
		stmt.executeUpdate(DROP_REVIEWS_TABLE_SQL);
		stmt.executeUpdate(DROP_USERS_TABLE_SQL);
		stmt.executeUpdate(DROP_USER_STATUSES_TABLE_SQL);
		stmt.executeUpdate(DROP_IDENDITIES_TABLE_SQL);
		stmt.executeUpdate(DROP_OPERATE_TYPES_TABLE_SQL);
		stmt.executeUpdate(DROP_PERIODS_TABLE_SQL);
		stmt.executeUpdate(DROP_STORES_TABLE_SQL);
		stmt.executeUpdate(DROP_FOODS_TABLE_SQL);
		stmt.executeUpdate(DROP_FOOD_TYPES_TABLE_SQL);
		stmt.executeUpdate(DROP_ORDERS_TABLE_SQL);
		System.out.println("清除tables成功");
	}
	
	public void createAllTables() throws SQLException {
		System.out.println("開始建立tables");
		useEatogoDB();
		stmt.executeUpdate(CREATE_USER_STATUSES_TABLE_SQL);
		stmt.executeUpdate(CREATE_IDENTITIES_TABLE_SQL);
		stmt.executeUpdate(CREATE_USERS_TABLE_SQL);
		stmt.executeUpdate(CREATE_OPERATE_TYPES_TABLE_SQL);
		stmt.executeUpdate(CREATE_PERIODS_TABLE_SQL);
		stmt.executeUpdate(CREATE_STORES_TABLE_SQL);
		stmt.executeUpdate(CREATE_FOODS_TABLE_SQL);
		stmt.executeUpdate(CREATE_FOOD_TYPES_TABLE_SQL);
		stmt.executeUpdate(CREATE_ORDERS_TABLE_SQL);
		stmt.executeUpdate(CREATE_ORDER_DETAILS_TABLE_SQL);
		stmt.executeUpdate(CREATE_FAVORITES_TABLE_SQL);
		stmt.executeUpdate(CREATE_REVIEWS_TABLE_SQL);
		System.out.println("建立tables成功");
	}
	
	public void addAllConstraints() throws SQLException {
		System.out.println("開始建立constraints");
		useEatogoDB();
		stmt.executeUpdate(ADD_USERS_CONSTRAINTS_USER_STATUS_SQL);
		stmt.executeUpdate(ADD_USERS_CONSTRAINTS_USER_IDENTITY_SQL);
		stmt.executeUpdate(ADD_STORES_CONSTRAINTS_SQL);
		stmt.executeUpdate(ADD_FOODS_CONSTRAINTS_FOOD_TYPE_SQL);
		stmt.executeUpdate(ADD_FOODS_CONSTRAINTS_FOOD_STORE_SQL);
		stmt.executeUpdate(ADD_ORDERS_CONSTRAINTS_ORDER_USER_SQL);
		stmt.executeUpdate(ADD_ORDERS_CONSTRAINTS_ORDER_STORE_SQL);
		stmt.executeUpdate(ADD_ORDERS_CONSTRAINTS_ORDER_CONFIRM_USER_SQL);
		stmt.executeUpdate(ADD_ORDERS_CONSTRAINTS_ORDER_TAKEOUT_PERIOD_SQL);
		stmt.executeUpdate(ADD_ORDER_DETAILS_CONSTRAINTS_ORDER_ID_SQL);
		stmt.executeUpdate(ADD_ORDER_DETAILS_CONSTRAINTS_ORDER_FOOD_SQL);
		stmt.executeUpdate(ADD_FAVORITES_CONSTRAINTS_FAVORITE_FOOD_SQL);
		stmt.executeUpdate(ADD_FAVORITES_CONSTRAINTS_FAVORITE_USER_SQL);
		stmt.executeUpdate(ADD_REVIEWS_CONSTRAINTS_REVIEW_USER_SQL);
		stmt.executeUpdate(ADD_REVIEWS_CONSTRAINTS_REVIEW_ORDER_SQL);
		stmt.executeUpdate(ADD_REVIEWS_CONSTRAINTS_REVIEW_FOOD_SQL);
		System.out.println("建立constraints成功");
	}
	
	/*
	 * sql about create new database;
	 */
	private final String CREATE_EATOGO_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS eatogodb";
	private final String USE_EATOGO_DATABASE_SQL = "USE eatogodb;";
	
	/*
	 * sql about drop and create new tables
	 */
	private final String DROP_USER_STATUSES_TABLE_SQL = "DROP TABLE IF EXISTS `USER_STATUSES`;";
	private final String CREATE_USER_STATUSES_TABLE_SQL = "CREATE TABLE `USER_STATUSES` ("
			+ "status_type        VARCHAR(20) PRIMARY KEY NOT NULL,"
			+ "status_description VARCHAR(20) NOT NULL);";
	private final String DROP_IDENDITIES_TABLE_SQL = "DROP TABLE IF EXISTS `IDENTITIES`;";
	private final String CREATE_IDENTITIES_TABLE_SQL = "CREATE TABLE `IDENTITIES` ("
			+ "identity_type        VARCHAR(20) PRIMARY KEY NOT NULL,"
			+ "identity_description VARCHAR(20) NOT NULL);";
	private final String DROP_USERS_TABLE_SQL = "DROP TABLE IF EXISTS `USERS`;";
	private final String CREATE_USERS_TABLE_SQL = "CREATE TABLE `USERS` ("
			+ "user_id          INT          PRIMARY KEY NOT NULL AUTO_INCREMENT,"
			+ "user_password    VARCHAR(50)  NOT NULL,"
			+ "user_cellphone   VARCHAR(20)  NOT NULL,"
			+ "user_name        VARCHAR(50)  NOT NULL,"
			+ "user_email       VARCHAR(50),"
			+ "user_avatar      VARCHAR(255) DEFAULT 'default.png',"
			+ "user_create_time DATETIME     NOT NULL,"
			+ "user_status      VARCHAR(20)  NOT NULL DEFAULT 'unregistered',"
			+ "user_identity    VARCHAR(10)  NOT NULL DEFAULT 'consumer',"
			+ "user_store       SMALLINT);";
	private final String DROP_OPERATE_TYPES_TABLE_SQL = "DROP TABLE IF EXISTS `OPERATE_TYPES`;";
	private final String CREATE_OPERATE_TYPES_TABLE_SQL = "CREATE TABLE `OPERATE_TYPES` ("
			+ "operate_type             VARCHAR(20) PRIMARY KEY NOT NULL,"
			+ "operate_type_description VARCHAR(20) NOT NULL,"
			+ "operate_rest_mode        VARCHAR(20),"
			+ "operate_period           VARCHAR(26) NOT NULL);";
	private final String DROP_PERIODS_TABLE_SQL = "DROP TABLE IF EXISTS `PERIODS`;";
	private final String CREATE_PERIODS_TABLE_SQL = "CREATE TABLE `PERIODS` ("
			+ "period_id          CHAR        PRIMARY KEY NOT NULL,"
			+ "period_description VARCHAR(20),"
			+ "period_start       TIME        NOT NULL,"
			+ "period_end         TIME        NOT NULL);";
	private final String DROP_STORES_TABLE_SQL = "DROP TABLE IF EXISTS `STORES`;";
	private final String CREATE_STORES_TABLE_SQL = "CREATE TABLE `STORES` ("
			+ "store_id           INT          PRIMARY KEY NOT NULL AUTO_INCREMENT,"
			+ "store_name         VARCHAR(50)  NOT NULL,"
			+ "store_address      VARCHAR(255) NOT NULL,"
			+ "store_phone        VARCHAR(20)  NOT NULL,"
			+ "store_email        VARCHAR(50),"
			+ "store_logo         VARCHAR(255) NOT NULL DEFAULT 'store_default.png',"
			+ "store_open_hour    VARCHAR(100),"
			+ "store_intro        TEXT,"
			+ "store_latitude     DOUBLE       NOT NULL,"
			+ "store_longitude    DOUBLE       NOT NULL,"
			+ "store_city         VARCHAR(50),"
			+ "store_region       VARCHAR(50),"
			+ "store_operate_type VARCHAR(20)  NOT NULL DEFAULT 'wholeday',"
			+ "store_status       VARCHAR(10)  NOT NULL DEFAULT 'rest');";
	private final String DROP_FOODS_TABLE_SQL = "DROP TABLE IF EXISTS `FOODS`;";
	private final String CREATE_FOODS_TABLE_SQL = "CREATE TABLE `FOODS` ("
			+ "food_id           INT          PRIMARY KEY NOT NULL AUTO_INCREMENT,"
			+ "food_name         VARCHAR(50)  NOT NULL,"
			+ "food_price        MEDIUMINT,"
			+ "food_intro        VARCHAR(50),"
			+ "food_pic_hdpi     VARCHAR(255),"
			+ "food_pic_ldpi     VARCHAR(255),"
			+ "food_pic_mdpi     VARCHAR(255),"
			+ "food_pic          VARCHAR(255),"
			+ "food_limit        INT           NOT NULL DEFAULT '1000',"
			+ "food_type         VARCHAR(20)   NOT NULL,"
			+ "food_store        INT           NOT NULL,"
			+ "food_status       VARCHAR(20)   NOT NULL DEFAULT 'logging',"
			+ "food_review_count BIGINT        NOT NULL DEFAULT '0');";
	private final String DROP_FOOD_TYPES_TABLE_SQL = "DROP TABLE IF EXISTS `FOOD_TYPES`;";
	private final String CREATE_FOOD_TYPES_TABLE_SQL = "CREATE TABLE `FOOD_TYPES` ("
			+ "food_type        VARCHAR(20) PRIMARY KEY NOT NULL,"
			+ "food_description VARCHAR(50) NOT NULL);";
	private final String DROP_ORDERS_TABLE_SQL = "DROP TABLE IF EXISTS `ORDERS`;";
	private final String CREATE_ORDERS_TABLE_SQL = "CREATE TABLE `ORDERS` ("
			+ "order_id             INT          PRIMARY KEY NOT NULL AUTO_INCREMENT,"
			+ "order_user           INT          NOT NULL,"
			+ "order_note           VARCHAR(100),"
			+ "order_time           DATETIME     NOT NULL,"
			+ "order_reserve_date   DATE,"
			+ "order_store          INT          NOT NULL,"
			+ "order_confirm_user   INT,"
			+ "order_confirm_time   DATETIME,"
			+ "order_takeout_period CHAR,"
			+ "order_status         VARCHAR(20)  NOT NULL DEFAULT 'unfinished',"
			+ "order_finished_time  DATETIME);";
	private final String DROP_ORDER_DETAILS_TABLE_SQL = "DROP TABLE IF EXISTS `ORDER_DETAILS`;";
	private final String CREATE_ORDER_DETAILS_TABLE_SQL = "CREATE TABLE `ORDER_DETAILS` ("
			+ "order_detail_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
			+ "order_id        INT NOT NULL,"
			+ "order_food      INT NOT NULL,"
			+ "order_quantity  INT NOT NULL DEFAULT '1');";
	private final String DROP_FAVORITES_TABLE_SQL = "DROP TABLE IF EXISTS `FAVORITES`;";
	private final String CREATE_FAVORITES_TABLE_SQL = "CREATE TABLE `FAVORITES` ("
			+ "favorite_id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
			+ "favorite_food INT NOT NULL,"
			+ "favorite_user INT NOT NULL);";
	private final String DROP_REVIEWS_TABLE_SQL = "DROP TABLE IF EXISTS `REVIEWS`;";
	private final String CREATE_REVIEWS_TABLE_SQL = "CREATE TABLE `REVIEWS` ("
			+ "review_id      INT      PRIMARY KEY NOT NULL AUTO_INCREMENT,"
			+ "review_user    INT      NOT NULL,"
			+ "review_order   INT      NOT NULL,"
			+ "review_food    INT,"
			+ "review_time    DATETIME NOT NULL,"
			+ "review_comment TEXT);";
	
	/*
	 * sql about add new constraints
	 */
	private final String ADD_USERS_CONSTRAINTS_USER_STATUS_SQL = 
			"ALTER TABLE `USERS` ADD CONSTRAINT USERS_user_status_FK"
			+ " FOREIGN KEY (user_status) REFERENCES `USER_STATUSES` (status_type);";
	private final String ADD_USERS_CONSTRAINTS_USER_IDENTITY_SQL = 
			"ALTER TABLE `USERS` ADD CONSTRAINT USERS_user_identity_FK"
			+ " FOREIGN KEY (user_identity) REFERENCES `IDENTITIES` (identity_type);";
	private final String ADD_STORES_CONSTRAINTS_SQL =
			"ALTER TABLE `STORES` ADD CONSTRAINT STORES_store_operate_type_FK"
			+ " FOREIGN KEY (store_operate_type) REFERENCES `OPERATE_TYPES` (operate_type);";
	private final String ADD_FOODS_CONSTRAINTS_FOOD_TYPE_SQL = 
			"ALTER TABLE `FOODS` ADD CONSTRAINT FOODS_food_type_FK"
			+ " FOREIGN KEY (food_type) REFERENCES `FOOD_TYPES` (food_type);";
	private final String ADD_FOODS_CONSTRAINTS_FOOD_STORE_SQL = 
			"ALTER TABLE `FOODS` ADD CONSTRAINT FOODS_food_store_FK"
			+ " FOREIGN KEY (food_store) REFERENCES `STORES` (store_id);";
	private final String ADD_ORDERS_CONSTRAINTS_ORDER_USER_SQL =
			"ALTER TABLE `ORDERS` ADD CONSTRAINT ORDERS_order_user_FK"
			+ " FOREIGN KEY (order_user) REFERENCES `USERS` (user_id);";
	private final String ADD_ORDERS_CONSTRAINTS_ORDER_STORE_SQL =
			"ALTER TABLE `ORDERS` ADD CONSTRAINT ORDERS_order_store_FK"
			+ " FOREIGN KEY (order_store) REFERENCES `STORES` (store_id);";
	private final String ADD_ORDERS_CONSTRAINTS_ORDER_CONFIRM_USER_SQL =
			"ALTER TABLE `ORDERS` ADD CONSTRAINT ORDERS_order_confirm_user_FK"
			+ " FOREIGN KEY (order_confirm_user) REFERENCES `USERS` (user_id);";
	private final String ADD_ORDERS_CONSTRAINTS_ORDER_TAKEOUT_PERIOD_SQL =
			"ALTER TABLE `ORDERS` ADD CONSTRAINT ORDERS_order_takeout_period_FK"
			+ " FOREIGN KEY (order_takeout_period) REFERENCES `PERIODS` (period_id);";
	private final String ADD_ORDER_DETAILS_CONSTRAINTS_ORDER_ID_SQL =
			"ALTER TABLE `ORDER_DETAILS` ADD CONSTRAINT ORDER_DETAILS_order_id_FK"
			+ " FOREIGN KEY (order_id) REFERENCES `ORDERS` (order_id);";
	private final String ADD_ORDER_DETAILS_CONSTRAINTS_ORDER_FOOD_SQL =
			"ALTER TABLE `ORDER_DETAILS` ADD CONSTRAINT ORDER_DETAILS_order_food_FK"
			+ " FOREIGN KEY (order_food) REFERENCES `FOODS` (food_id);";
	private final String ADD_FAVORITES_CONSTRAINTS_FAVORITE_FOOD_SQL =
			"ALTER TABLE `FAVORITES` ADD CONSTRAINT FAVORITES_favorite_food_FK"
			+ " FOREIGN KEY (favorite_food) REFERENCES `FOODS` (food_id);";
	private final String ADD_FAVORITES_CONSTRAINTS_FAVORITE_USER_SQL =
			"ALTER TABLE `FAVORITES` ADD CONSTRAINT FAVORITES_favorite_user_FK"
			+ " FOREIGN KEY (favorite_user) REFERENCES `USERS` (user_id);";
	private final String ADD_REVIEWS_CONSTRAINTS_REVIEW_USER_SQL =
			"ALTER TABLE `REVIEWS` ADD CONSTRAINT REVIEWS_review_user_FK"
			+ " FOREIGN KEY (review_user) REFERENCES `USERS` (user_id);";
	private final String ADD_REVIEWS_CONSTRAINTS_REVIEW_ORDER_SQL =
			"ALTER TABLE `REVIEWS` ADD CONSTRAINT REVIEWS_review_order_FK"
			+ " FOREIGN KEY (review_order) REFERENCES `ORDERS` (order_id);";
	private final String ADD_REVIEWS_CONSTRAINTS_REVIEW_FOOD_SQL =
			"ALTER TABLE `REVIEWS` ADD CONSTRAINT REVIEWS_review_food_FK"
			+ " FOREIGN KEY (review_food) REFERENCES `FOODS` (food_id);";
	
	/*
	 * sql about drop all constraints
	 */
	private final String DROP_USERS_CONSTRAINTS_USER_STATUS_SQL = 
			"ALTER TABLE `USERS` DROP FOREIGN KEY USERS_user_status_FK;";
	private final String DROP_USERS_CONSTRAINTS_USER_IDENTITY_SQL = 
			"ALTER TABLE `USERS` DROP FOREIGN KEY USERS_user_identity_FK;";
	private final String DROP_STORES_CONSTRAINTS_SQL =
			"ALTER TABLE `STORES` DROP FOREIGN KEY STORES_store_operate_type_FK;";
	private final String DROP_FOODS_CONSTRAINTS_FOOD_TYPE_SQL = 
			"ALTER TABLE `FOODS` DROP FOREIGN KEY FOODS_food_type_FK;";
	private final String DROP_FOODS_CONSTRAINTS_FOOD_STORE_SQL = 
			"ALTER TABLE `FOODS` DROP FOREIGN KEY FOODS_food_store_FK;";
	private final String DROP_ORDERS_CONSTRAINTS_ORDER_USER_SQL =
			"ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_user_FK;";
	private final String DROP_ORDERS_CONSTRAINTS_ORDER_STORE_SQL =
			"ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_store_FK;";
	private final String DROP_ORDERS_CONSTRAINTS_ORDER_CONFIRM_USER_SQL =
			"ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_confirm_user_FK;";
	private final String DROP_ORDERS_CONSTRAINTS_ORDER_TAKEOUT_PERIOD_SQL =
			"ALTER TABLE `ORDERS` DROP FOREIGN KEY ORDERS_order_takeout_period_FK;";
	private final String DROP_ORDER_DETAILS_CONSTRAINTS_ORDER_ID_SQL =
			"ALTER TABLE `ORDER_DETAILS` DROP FOREIGN KEY ORDER_DETAILS_order_id_FK;";
	private final String DROP_ORDER_DETAILS_CONSTRAINTS_ORDER_FOOD_SQL =
			"ALTER TABLE `ORDER_DETAILS` DROP FOREIGN KEY ORDER_DETAILS_order_food_FK;";
	private final String DROP_FAVORITES_CONSTRAINTS_FAVORITE_FOOD_SQL =
			"ALTER TABLE `FAVORITES` DROP FOREIGN KEY FAVORITES_favorite_food_FK;";
	private final String DROP_FAVORITES_CONSTRAINTS_FAVORITE_USER_SQL =
			"ALTER TABLE `FAVORITES` DROP FOREIGN KEY FAVORITES_favorite_user_FK;";
	private final String DROP_REVIEWS_CONSTRAINTS_REVIEW_USER_SQL =
			"ALTER TABLE `REVIEWS` DROP FOREIGN KEY REVIEWS_review_user_FK;";
	private final String DROP_REVIEWS_CONSTRAINTS_REVIEW_ORDER_SQL =
			"ALTER TABLE `REVIEWS` DROP FOREIGN KEY REVIEWS_review_order_FK;";
	private final String DROP_REVIEWS_CONSTRAINTS_REVIEW_FOOD_SQL =
			"ALTER TABLE `REVIEWS` DROP FOREIGN KEY REVIEWS_review_food_FK;";
	
}
