package model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import control.Livros;

public class LivrosDAO extends DAO{

	@Override
	public List<Livros> pesquisa(String sql) {
		// TODO Auto-generated method stub
		List<Livros> livros = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			//stmt.setString(1, "'"+consulta+"'%'");
			ResultSet resultado = stmt.executeQuery(sql);
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String assunto = resultado.getString("assunto");
				String autor = resultado.getString("autor");
				int id_categoria = resultado.getInt("id_categoria");
				Date dtAquisicao = new Date(resultado.getDate("dtAquisicao").getTime());
				String nvDtAquisicao= new SimpleDateFormat("dd/MM/yyyy").format(dtAquisicao);
				livros.add(new Livros(id,titulo,assunto,autor,id_categoria, nvDtAquisicao));
			}
			
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return livros;
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
			throw new RuntimeException();
		}
		return 0;
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
		return -1;
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
			System.out.println(e);
		}
		return -1;
	}
	
	public Date ConvertString(String data) {
		
		String dia =data.substring(0, 2);
		String mes =data.substring(3, 5);
		String ano =data.substring(6, 10);
		String convertData = dia+"-"+mes+"-"+ano;
		
		try {
			return  new SimpleDateFormat("dd-MM-yyyy").parse(convertData) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

