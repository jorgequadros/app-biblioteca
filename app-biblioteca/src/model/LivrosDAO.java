package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LivrosDAO extends DAO{

	@Override
	public List<Livros> pesquisa(String sql, String params) {
		
		List<Livros> livros = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, params);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String assunto = resultado.getString("assunto");
				String autor = resultado.getString("autor");
				int id_categoria = resultado.getInt("id_categoria");
				String descricao = resultado.getString("descricao");
				String obs = resultado.getString("obs");
				Date dtAquisicao = new Date(resultado.getDate("dtAquisicao").getTime());
				String nvDtAquisicao= new SimpleDateFormat("dd/MM/yyyy").format(dtAquisicao);
				livros.add(new Livros(id,titulo,assunto,autor,id_categoria, descricao, obs,nvDtAquisicao));
			}
			
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		
		return livros;
	}

	@Override
	public List<Livros> pesquisaTodos(String sql) {
		
		List<Livros> livros = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String assunto = resultado.getString("assunto");
				String autor = resultado.getString("autor");
				int id_categoria = resultado.getInt("id_categoria");
				String descricao = resultado.getString("descricao");
				String obs = resultado.getString("obs");
				Date dtAquisicao = new Date(resultado.getDate("dtAquisicao").getTime());
				String nvDtAquisicao= new SimpleDateFormat("dd/MM/yyyy").format(dtAquisicao);
				livros.add(new Livros(id,titulo,assunto,autor,id_categoria, descricao,obs,nvDtAquisicao));
			}
			
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		
		return livros;
	}
	
	public boolean isLivros(String sql, int valor) {
		
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, valor);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				if(resultado.getInt("situacao")==1) {
					return false;
				}
			}
			
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}

