package jdbc._03_manageView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc._00_Init.DbConnector;

public class ViewDao {
	Connection conn = null;
	Statement stmt = null;

	private final String CREATE_VIEW_FOOD_LATLNG_SQL = "CREATE OR REPLACE VIEW `VIEW_FOOD_LATLNG` AS"
			+ " SELECT food_id, food_name, food_price, food_intro, food_pic_hdpi, food_pic_ldpi, food_pic_mdpi,"
			+ " food_pic, food_limit, food_type, food_store, food_status, food_review_count, store_latitude, store_longitude"
			+ " FROM FOODS INNER JOIN STORES ON food_store = store_id;";

	public boolean createFoodWithLocationView(String dbUsername, String dbPassword) {
		try {
			conn = new DbConnector().connect(dbUsername, dbPassword);
			stmt = conn.createStatement();
			System.out.println("開始建立View: Food with location");
			useEatogoDB();
			stmt.executeUpdate(CREATE_VIEW_FOOD_LATLNG_SQL);
			System.out.println("建立View成功");
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL問題，建立View失敗");
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("關閉stmt錯誤");
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("關閉conn錯誤");
					e.printStackTrace();
				}
			}
		}
	}

	private final String USE_EATOGO_DATABASE_SQL = "USE eatogodb;";

	private void useEatogoDB() {
		try {
			stmt.executeUpdate(USE_EATOGO_DATABASE_SQL);
		} catch (SQLException e) {
			System.out.println("使用資料庫錯誤");
			e.printStackTrace();
		}
	}
}
