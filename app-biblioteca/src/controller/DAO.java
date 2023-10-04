package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO {

	private Connection conexao;
	
	protected Connection getConexao() throws FileNotFoundException, IOException {
		try {
			if(conexao != null && !conexao.isClosed()){
				return conexao;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		conexao = ConexaoBD.getConnection();
		return conexao;
	}
	
	protected void adicionarAtributos(PreparedStatement Stmt, 
			Object[] atributos) throws SQLException{
		int indice = 1;
		for(Object atributo: atributos) {
			
			if(atributo instanceof String) {
				Stmt.setString(indice, (String) atributo);
			}else if(atributo instanceof Integer) {
				Stmt.setInt(indice, (Integer) atributo);
			}
		
			indice++;
		}
	}
	
	public void close() throws FileNotFoundException, IOException {
		
		try {
			getConexao().close();
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			conexao = null;
		}
	}
	
	
	public int alterar(String sql, Object... atributos) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(stmt, atributos);
			if(stmt.executeUpdate()>0) {
				ResultSet resultado = stmt.getGeneratedKeys();
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			
			this.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return -1;
	}

	
	public int excluir(String sql, Object... atributos) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(stmt, atributos);
			if(stmt.executeUpdate()>0) {
				ResultSet resultado = stmt.getGeneratedKeys();
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			
			this.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return 0;
	}


	public int incluir(String sql, Object... atributos) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(stmt, atributos);
			if(stmt.executeUpdate()>0) {
				ResultSet resultado = stmt.getGeneratedKeys();
				if(resultado.next()) {
					return resultado.getInt(1);
				}
			}
			
			this.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return -1;
	}
	
	public abstract List<?> pesquisa(String sql,String params);
	public abstract List<?> pesquisaTodos(String sql);
		
}
