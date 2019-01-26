package lesson14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import oracle.jdbc.driver.OracleDriver;

/**
 * @author spasko
 */
public class ConnectToDB {

	public static final String URL = "jdbc:mysql://localhost:3306/testdb";
	public static final String USER = "MA_STUDENT";
	public static final String PASS = "KOLOBOK";

	/**
	 * Get a connection to database
	 * 
	 * @return Connection object
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Locale.setDefault(Locale.ENGLISH);
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
