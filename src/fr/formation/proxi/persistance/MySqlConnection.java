package fr.formation.proxi.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	
	
	
	
	private static final MySqlConnection INSTANCE = new MySqlConnection();
	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}
	

	private Connection conn;
	public MySqlConnection() {		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxibanquev2", 
					"root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			// Avec librairie log4j LOGGER.erreur(message, e)
			e.printStackTrace();
		}
	}
	public Connection getConn() {
		return conn;
	}
}
