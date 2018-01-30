package jndi._01_manageSchema;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jndi._00_init.DbConnector;

public class SchemaDao {
	
	public boolean createDatabase(String dbUsername, String dbPassword) {
		try {
			Connection conn = DbConnector.connect().getConnection();
			Statement stmt = conn.createStatement();
			SchemaSql schemaSql = new SchemaSql(stmt);
			schemaSql.createDatabase();
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("執行建立資料庫動作失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createAllTables(String dbUsername, String dbPassword) {
		try {
			Connection conn = DbConnector.connect().getConnection();
			Statement stmt = conn.createStatement();
			SchemaSql schemaSql = new SchemaSql(stmt);
			schemaSql.createAllTables();
			schemaSql.addAllConstraints();
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("執行建立table動作失敗");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean recreateAllTables(String dbUsername, String dbPassword) {
		try {
			Connection conn = DbConnector.connect().getConnection();
			Statement stmt = conn.createStatement();
			SchemaSql schemaSql = new SchemaSql(stmt);
			schemaSql.dropAllConstraints();
			schemaSql.dropAllTables();
			schemaSql.createAllTables();
			schemaSql.addAllConstraints();
			stmt.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("執行重建tables動作失敗");
			e.printStackTrace();
			return false;
		}
	}
	
}
