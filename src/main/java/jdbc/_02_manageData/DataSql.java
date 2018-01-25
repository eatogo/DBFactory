package jdbc._02_manageData;

import java.sql.SQLException;
import java.sql.Statement;

public class DataSql {
	private Statement stmt;
	
	public DataSql(Statement stmt) {
		this.stmt = stmt;
	}
	
	private void useEatogoDB() throws SQLException {
		stmt.executeUpdate(USE_EATOGO_DATABASE_SQL);
	}
	
	public void insertFixedData() throws SQLException {
		useEatogoDB();
		
	}
	
	public void insertFakedData() throws SQLException {
		useEatogoDB();
		
	}
	
	/*
	 * sql about use Eatogo DB
	 */
	private final String USE_EATOGO_DATABASE_SQL = "USE eatogodb;";
	
	
}
