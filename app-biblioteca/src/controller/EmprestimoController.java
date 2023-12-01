package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Categorias;
import model.CategoriasDAO;
import model.Emprestimo;
import model.EmprestimoDAO;
import model.InterfacesDAO;

public class EmprestimoController implements InterfacesDAO{

	@Override
	public void incluir(Object... campos) {
		// TODO Auto-generated method stub
		EmprestimoDAO edao = new EmprestimoDAO();
		edao.comandoSql("INSERT INTO emprestimos (dt_retirada,dt_devolucao, id_livro,id_usuario) values(?,?,?,?)", campos);
	}

	@Override
	public void alterar(Object... campos) {
		// TODO Auto-generated method stub
		EmprestimoDAO edao = new EmprestimoDAO();
		edao.comandoSql("update emprestimos "
				+ "set dt_retirada=?, "
				+ "dt_devolucao=?,"
				+ "id_livro=?,"
				+ "id_usuario=?"
				+ " where id=?;", campos);
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		CategoriasDAO c =new CategoriasDAO();
		c.comandoSql("delete from emprestimos where id=?", id);
	}

	@Override
	public void pesquisaPorCampo(String consulta, JTable tbConsulta) {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		CategoriasDAO cdao = new CategoriasDAO();
		
		for(Categorias c: cdao.pesquisa("select * from categorias where descricao like ?;", consulta)) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getDescricao(),
					c.getObs()
					});
			
		}
		
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		EmprestimoDAO edao = new EmprestimoDAO();
		//Alterar para buscar por data
		for(Emprestimo e: edao.pesquisaTodos("select * from emprestimo;")) {
			modelo.addRow(new Object[] {
					e.getId(),
					e.getLivros().getTitulo(),
					e.getUsuarios().getNome()
					});
			
		}
	}

}
