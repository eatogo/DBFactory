package jndi._00_init;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnector {
	static DataSource ds = null;

	public static DataSource connect() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/eatogodb");
			return ds;
		} catch (NamingException e) {
			System.out.println("建立連線池錯誤");
			e.printStackTrace();
			return null;
		}
	}
}
