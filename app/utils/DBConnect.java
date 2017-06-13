package utils;

import play.Play;
import java.sql.*;


/**
 * The `DBConnect` class acts a simple connection manager for the `dbConnection`
 * and makes sure that only one connection is alive throughout the application.
 * 
 * @author marios
 */

public final class DBConnect {

	/**
	 * Holds the actual `dbConnection`.
	 */
	private static Connection dbConnection = null;

	/**
	 * Connects to Adaptivenews Database based on the configuration settings.
	 * 
	 * If the database is not reachable, an error message is written and the
	 * application exits.
	 */
	public static boolean connect() {

		try {

			String dbName = Play.application().configuration()
					.getString("db.default.url");
			String username = Play.application().configuration()
					.getString("db.default.user");
			String password = Play.application().configuration()
					.getString("db.default.password");
			String driver = Play.application().configuration()
					.getString("db.default.driver");

			Class.forName(driver);
			// Setup the connection with the DB

			try {
				dbConnection = DriverManager.getConnection(dbName, username,
						password);
			} catch (Exception e) {
				System.out.println("Error connection to DB: " + e.getMessage());
				// TODO
				// System.exit(0);
				return false;
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * Disconnect from DB.
	 */
	public static boolean disconnect() {
		if (dbConnection == null) {
			return false;
		}
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		dbConnection = null;
		return true;
	}

	/**
	 * Returns the actual `dbConnection` connection object.
	 * 
	 * If no connection is established yet, it tries to connect. Note that this
	 * is just in place for pure convenience, make sure to connect explicitly.
	 */
	public static Connection getConnection() {
		if (dbConnection == null) {
			if (!connect()) {
				return null;
			}
		}

		return dbConnection;
	}

}
