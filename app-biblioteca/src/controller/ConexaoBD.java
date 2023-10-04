package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBD {

	//private static ConexaoBD instance = null;
	private Connection connection =null;
		
	private ConexaoBD() {}
		
	public static Connection getConnection() {
		try {
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream("C:/Users/jorge/OneDrive/Documentos/DB.properties"));
		
				String dbUrl = prop.getProperty("db.url");
				String dbUser = prop.getProperty("db.user");
				String dbPwd = prop.getProperty("db.pwd");

				return DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	public void shutdown() { // Efetua fechamento controlado da conexão
		System.out.println("DB[shutdown cliente]");
	
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