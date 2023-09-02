package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import control.Categorias;

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
	
	public abstract int Pesquisar(String sql, Object...atributos);
	public abstract int Alterar(String sql, Object...atributos);
	public abstract int Excluir(String sql, Object...atributos);
	public abstract int incluir(String sql, Object...atributos);
	public abstract List<Categorias> PesquisaTodos(String sql);
}