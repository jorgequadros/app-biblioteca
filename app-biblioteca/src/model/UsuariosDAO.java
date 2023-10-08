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

public class UsuariosDAO extends DAO{

	@Override
	public List<Usuario> pesquisa(String sql, String params) {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, params);
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String endereco = resultado.getString("endereco");
				String cidade = resultado.getString("cidade");
				String bairro = resultado.getString("bairro");
				int cep = resultado.getInt("cep");
				int telefone = resultado.getInt("telefone");
				String email = resultado.getString("email");;
				String usuario= resultado.getString("usuario");
				String senha= resultado.getString("senha");
				String tipousuario= resultado.getString("tipousuario");
				
				usuarios.add(new Usuario(id,nome,endereco,cidade,bairro,cep,telefone, email, usuario,senha,tipousuario));
			}
			
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return usuarios;
	}

	@Override
	public List<Usuario> pesquisaTodos(String sql) {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			
			ResultSet resultado = stmt.executeQuery();
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String endereco = resultado.getString("endereco");
				String cidade = resultado.getString("cidade");
				String bairro = resultado.getString("bairro");
				int cep = resultado.getInt("cep");
				int telefone = resultado.getInt("telefone");
				String email = resultado.getString("email");;
				String usuario= resultado.getString("usuario");
				String senha= resultado.getString("senha");
				String tipousuario= resultado.getString("tipousuario");
				
				usuarios.add(new Usuario(id,nome,endereco,cidade,bairro,cep,telefone, email, usuario,senha,tipousuario));
			}
			
			stmt.close();
			getConexao().close();
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return usuarios;
	}
	
	public Date ConvertString(String data) {
		
		try {
			String dia =data.substring(0, 2);
			String mes =data.substring(3, 5);
			String ano =data.substring(6, 10);
			String convertData = dia+"-"+mes+"-"+ano;
			return  new SimpleDateFormat("dd-MM-yyyy").parse(convertData) ;
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
