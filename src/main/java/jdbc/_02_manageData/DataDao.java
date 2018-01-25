package jdbc._02_manageData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc._00_Init.DbConnector;

public class DataDao {

	public boolean insertFixedData() {
		try {
			Connection conn = new DbConnector().rootConnect();
			PreparedStatement ps = conn.prepareStatement(null);
			
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立固定資料失敗");
			e.printStackTrace();
			return false;
		}
	}
}
