package model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.Categorias;

public class CategoriasDAO extends DAO{
	
	@Override
	public List<Categorias> pesquisa(String sql) {
		// TODO Auto-generated method stub
		List<Categorias> categorias = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			//stmt.setString(1, "'"+consulta+"'%'");
			ResultSet resultado = stmt.executeQuery(sql);
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String descricao = resultado.getString("descricao");
				String obs = resultado.getString("obs");
				categorias.add(new Categorias(id,descricao,obs));
			}
			
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return categorias;
	}

	@Override
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

	@Override
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

	@Override
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
			throw new RuntimeException();
		}
		
		return -1;
	}

}
