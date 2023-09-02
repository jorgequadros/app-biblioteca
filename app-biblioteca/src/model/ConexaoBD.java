package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	//private static ConexaoBD instance = null;
	private Connection connection =null;
	private int clients = 0;
	
	private ConexaoBD() {
		
	}
	
	
	
	public static Connection getConnection() {
		try {
			//Properties prop = new Properties();
			//prop.load(new FileInputStream("DB.properties"));
			String dbUrl = "jdbc:mysql://localhost:3306/biblioteca";//prop.getProperty("db.url");
			String dbUser = "root";//prop.getProperty("db.user");
			String dbPwd = "Sql105899@";//prop.getProperty("db.pwd");//
			
			return DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void shutdown() { // Efetua fechamento controlado da conexão
		System.out.println("DB[shutdown cliente]");
		clients--;
		if (clients > 0) {
			return;
		}
		try {
			connection.close();
			//instance = null;
			connection = null;
			System.out.println("DB[conexao fechada]");
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}
	
}
