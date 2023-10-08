package model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDAO extends DAO{
	
	@Override
	public List<Categorias> pesquisa(String sql, String params) {
		// TODO Auto-generated method stub
		
		List<Categorias> categorias = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, params+'%');
			ResultSet resultado = stmt.executeQuery();
			
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
			System.out.println(e);
		} 
		
		return categorias;
	}

	@Override
	public List<Categorias> pesquisaTodos(String sql) {
		// TODO Auto-generated method stub
		List<Categorias> categorias = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			
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


}
