package lab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
