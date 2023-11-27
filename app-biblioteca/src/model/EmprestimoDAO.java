package model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO extends DAO{

	@Override
	public List<Emprestimo> pesquisa(String sql, String params) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
			
			List<Emprestimo> emprestimo = new ArrayList<>();
			try {
				PreparedStatement stmt = getConexao().prepareStatement(sql);
				stmt.setString(1, params+'%');
				ResultSet resultado = stmt.executeQuery();
				
				while (resultado.next()) {
					int id = resultado.getInt("id");
					String descricao = resultado.getString("descricao");
					String obs = resultado.getString("obs");
					emprestimo.add(new Emprestimo());
				}
				
				stmt.close();
				getConexao().close();
				
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} 
			
			return emprestimo;
	}

	@Override
	public List<Emprestimo> pesquisaTodos(String sql) {
		// TODO Auto-generated method stub
		List<Emprestimo> emprestimo = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String descricao = resultado.getString("descricao");
				String obs = resultado.getString("obs");
				emprestimo.add(new Emprestimo());
			}
			
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return emprestimo;
	}

}
