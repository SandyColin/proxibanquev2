package fr.formation.proxi.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	
	
	
	
	private static final MySqlConnection INSTANCE = new MySqlConnection();
	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}
	
	// attribut conn final = générer que le getteur 
	private Connection conn;
	public MySqlConnection() {		
//try catch dans le constructeur et non l'objet DriverManager car static
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?serverTimezone=Europe/Paris", 
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
