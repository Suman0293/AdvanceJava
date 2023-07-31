package in.co.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;






public final class JdbcDataSource {

	private static JdbcDataSource jds = null;
   private ComboPooledDataSource ds = null;
	
	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

	private JdbcDataSource() {
		try {
			ds = new ComboPooledDataSource();
			ds.setDriverClass(rb.getString("driver"));
			ds.setJdbcUrl(rb.getString("url"));
			ds.setUser(rb.getString("user"));
			ds.setPassword(rb.getString("password"));
			ds.setInitialPoolSize(Integer.parseInt(rb.getString("initial")));
			ds.setAcquireIncrement(Integer.parseInt(rb.getString("acquire")));
			ds.setMaxPoolSize(Integer.parseInt(rb.getString("maxium")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JdbcDataSource getInstance() {
		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}

	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (Exception e) {
			return null;
		}
	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}
	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}
}
