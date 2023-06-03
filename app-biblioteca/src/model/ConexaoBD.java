package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConexaoBD {

	private static ConexaoBD instance = null;
	private Connection connection =null;
	
	private int clients = 0;
	
	private ConexaoBD() {
		try {

			String dbDriver = "com.mysql.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/biblioteca";
			String dbUser = "root";
			String dbPwd = "Sql105899@";
			Class.forName(dbDriver);
			if(dbUser.length()!=0) {
				connection = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
			}else {
				connection = DriverManager.getConnection(dbUrl);
			}
			System.out.println("DB[Conexão OK]");
		} catch (SQLException | ClassNotFoundException e) {
					System.err.println(e);
		}
	}
	
	public static ConexaoBD getInstance() {
		if(instance == null) {instance = new ConexaoBD();}
		return instance;
	}
	
	public Connection getConnection() {
		if(connection == null) {throw new RuntimeErrorException(null, "connection==null");};
		clients++;
		System.out.println("DB[conexão cliente]");
		return connection;
	}
	
	public void shutdown() { // Efetua fechamento controlado da conexão
		System.out.println("DB[shutdown cliente]");
		clients--;
		if (clients > 0) {
			return;
		}
		try {
			connection.close();
			instance = null;
			connection = null;
			System.out.println("DB[conexao fechada]");
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
	}
	
}
