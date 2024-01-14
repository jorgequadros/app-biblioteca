package PesquisaTeste.Mercadinho2.src.Model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import PesquisaTeste.Mecadinho.src.Model.bean.Produto;
import PesquisaTeste.Mercadinho2.src.Model.bean.ProdutoM;
import model.ConexaoBD;

public class ProdutosMDAO{
	
	public void create(ProdutoM p) throws IOException {
		Connection con = ConexaoBD.getConnection();
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

	public void update(Produto p) throws IOException {
		Connection con = ConexaoBD.getConnection();
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
	
	public List<Produto> read() throws IOException, SQLException{
		
		Connection con = ConexaoBD.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Produto> produtos = new ArrayList<>();
		try {
			stmt = con.prepareStatement("select * from produtos1");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Produto produto = new Produto();
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
