package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	// inicio metod para conectar com DB

	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			if (conn == null) {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);// vai obter uma conexão com o banco de dados

			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		}
		return conn;
	}
	// fim do metod para conectar com DB

	public static void closeConnectcion() {
		if (conn != null) {
			try {

				conn.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs/* lendo meu arquivo em db.properties e guardando */);
			return props;
		} catch (IOException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		}

	}

}
