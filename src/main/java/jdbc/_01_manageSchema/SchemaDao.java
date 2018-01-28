package jdbc._01_manageSchema;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc._00_Init.DbConnector;

public class SchemaDao {
	
	public boolean createDatabase(String dbUsername, String dbPassword) {
		try {
			Connection conn = new DbConnector().connect(dbUsername, dbPassword);
			Statement stmt = conn.createStatement();
			SchemaSql schemaSql = new SchemaSql(stmt);
			schemaSql.createDatabase();
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立資料庫失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createAllTables(String dbUsername, String dbPassword) {
		try {
			Connection conn = new DbConnector().connect(dbUsername, dbPassword);
			Statement stmt = conn.createStatement();
			SchemaSql schemaSql = new SchemaSql(stmt);
			System.out.println("開始建立tables");
			schemaSql.createAllTables();
			schemaSql.addAllConstraints();
			System.out.println("建立tables成功");
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立tables失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean recreateAllTables(String dbUsername, String dbPassword) {
		try {
			Connection conn = new DbConnector().connect(dbUsername, dbPassword);
			Statement stmt = conn.createStatement();
			SchemaSql schemaSql = new SchemaSql(stmt);
			System.out.println("開始建立tables");
			schemaSql.dropAllConstraints();
			schemaSql.dropAllTables();
			schemaSql.createAllTables();
			schemaSql.addAllConstraints();
			System.out.println("建立tables成功");
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("建立tables失敗");
			e.printStackTrace();
			return false;
		}
	}
	
}
