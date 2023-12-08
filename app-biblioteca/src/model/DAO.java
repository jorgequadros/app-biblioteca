package model;

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
			
		}
		conexao = ConexaoBD.getConnection();
		return conexao;
	}
	
	public int comandoSql(String sql, Object... atributos) {
		
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
			
			System.out.println(e);
		}
		
		return -1;
	}
	
	protected void adicionarAtributos(PreparedStatement Stmt, Object[] atributos) throws SQLException{
		
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
			
		}finally {
			conexao = null;
		}
	}
	
	public abstract List<?> pesquisa(String sql,String params);
	public abstract List<?> pesquisaTodos(String sql);
		
}
