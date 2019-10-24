package connection;

import static connection.Provider.CONNECTION_URL;
import static connection.Provider.DRIVER;
import static connection.Provider.PASSWORD;
import static connection.Provider.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection connection = null;
	static {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Connection getCon() {
		return connection;
	}
}
