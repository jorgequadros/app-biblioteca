package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBD {
		
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
			
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}
