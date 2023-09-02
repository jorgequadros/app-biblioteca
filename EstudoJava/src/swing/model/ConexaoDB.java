package swing.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConexaoDB {

	private static ConexaoDB instance = null;
	private Connection connection = null;
	
		
	private ConexaoDB() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("DB.properties"));
			String Driver = prop.getProperty("db.driver");
			System.out.println(Driver);
			String URL = prop.getProperty("db.url");
			System.out.println(URL);
			String USER = prop.getProperty("db.user");
			System.out.println(USER);
			String PASS = prop.getProperty("db.pass");
			Class.forName(Driver);
			if(USER.length()!=0) {
				connection = DriverManager.getConnection(URL, USER, PASS);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static ConexaoDB getInstance() {
		if(instance==null) { instance = new ConexaoDB(); }
		
		return instance;
	}
	
	public Connection getConnection() {
		try {
			if(connection==null) {throw new RuntimeErrorException(null, "connection ==null!!");}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void closeConnection(Connection con) {
			try {
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con,stmt);
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
