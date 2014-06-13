package lab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection createConnection() {
		Connection conn;
		try {
			// URL de conexão JDBC com o banco de dados.
			String url = "jdbc:derby://localhost/db;create=true";
			// Obtém uma conexão com o banco de dados.
			conn = DriverManager.getConnection(url, "app", "123");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
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
			//Não fazer nada.
		}
	}

	public static  void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}

}
