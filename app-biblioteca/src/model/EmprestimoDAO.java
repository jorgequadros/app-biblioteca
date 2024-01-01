package model;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO extends DAO{
	
	@Override
	public List<Emprestimo> pesquisa(String sql, String params) {
		
			List<Emprestimo> emprestimo = new ArrayList<>();
			try {
				
				PreparedStatement stmt = getConexao().prepareStatement(sql);
				stmt.setString(1, params+'%');
				ResultSet resultado = stmt.executeQuery();
				
				while (resultado.next()) {
					int id = resultado.getInt("id");
					int id_usuario = resultado.getInt("id_usuario");
					String nomeUsuario = resultado.getString("nome");
					int id_livro = resultado.getInt("id_livro");
					String titulo = resultado.getString("titulo");
					Date devolucao = resultado.getDate("dt_devolucao");
					Date retirada = resultado.getDate("dt_retirada");
					
					emprestimo.add(new Emprestimo(id,retirada,devolucao, id_livro, titulo, id_usuario,nomeUsuario));
				}
				
				stmt.close();
				getConexao().close();
				
			} catch (IOException | SQLException e) {
				
				System.out.println(e);
			} 
			
			return emprestimo;
	}

	@Override
	public List<Emprestimo> pesquisaTodos(String sql) {
		
		List<Emprestimo> emprestimo = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			if(resultado.next()) {
				do {
					int id = resultado.getInt("id");
					int id_usuario = resultado.getInt("id_usuario");
					String nomeUsuario = resultado.getString("nome");
					int id_livro = resultado.getInt("id_livro");
					String titulo = resultado.getString("titulo");
					Date devolucao = resultado.getDate("dt_devolucao");
					Date retirada = resultado.getDate("dt_retirada");
					emprestimo.add(new Emprestimo(id,retirada,devolucao, id_livro, titulo, id_usuario,nomeUsuario));
				}while (resultado.next()) ;
			}
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
		
			e.printStackTrace();
		} 
		
		return emprestimo;
	}

}
