package swing.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProdutosMDAO{
	
	public void create(ProdutoM p) throws IOException {
		Connection con = ConexaoDB.getInstance().getConnection();
		PreparedStatement stmt =null;
		
		try {
			stmt = con.prepareStatement("insert into produtos1(descricao,qtde,preco) values (?,?,?)");
			stmt.setString(1, p.getDescricao());
			stmt.setInt(2, p.getQtde());
			stmt.setDouble(3, p.getValor());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro ao salvar:"+e);
			
		}
	}

	public void update(ProdutoM p) throws IOException {
		Connection con = ConexaoDB.getInstance().getConnection();
		PreparedStatement stmt =null;
		
		try {
			stmt = con.prepareStatement("update produtos1 set descricao= ?, qtde=?, preco=? ) where id=?");
			stmt.setString(1, p.getDescricao());
			stmt.setInt(2, p.getQtde());
			stmt.setDouble(3, p.getValor());
			stmt.setInt(4, p.getId());
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro ao Atualizar:"+e);
			
		}
	}
	
	public List<ProdutoM> read() throws IOException, SQLException{
		
		Connection con = ConexaoDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProdutoM> produtos = new ArrayList<>();
		try {
			stmt = con.prepareStatement("select * from produtos1");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ProdutoM produto = new ProdutoM();
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtde(rs.getInt("qtde"));
				produto.setValor(rs.getInt("preco"));
				produtos.add(produto);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			con.close();			
		}
		
		return produtos;
	}

}
