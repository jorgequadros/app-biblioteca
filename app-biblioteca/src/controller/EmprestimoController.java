package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CategoriasDAO;
import model.Emprestimo;
import model.EmprestimoDAO;
import model.InterfacesDAO;

public class EmprestimoController implements InterfacesDAO{

	@Override
	public void incluir(Object... campos) {
		
		EmprestimoDAO edao = new EmprestimoDAO();
		edao.comandoSql("INSERT INTO emprestimos (dt_retirada,dt_devolucao, id_livro,id_usuario) values(?,?,?,?)", campos);
	}

	@Override
	public void alterar(Object... campos) {
		
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
		
		CategoriasDAO c =new CategoriasDAO();
		c.comandoSql("delete from emprestimos where id=?", id);
	}

	@Override
	public void pesquisaPorCampo(String consulta, JTable tbConsulta) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		EmprestimoDAO edao = new EmprestimoDAO();
		
		for(Emprestimo e: edao.pesquisa("select * from emprestimos AS e, livros AS l, usuario As u where l.id=e.id_livro and u.id=e.usuario and dt_devolucao=?;", consulta)) {
			modelo.addRow(new Object[] {
					e.getId(),
					e.getDtEmprestimo(),
					e.getDtDevolucao(),
					e.getId_usuario()
					});
			
		}
		
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		EmprestimoDAO edao = new EmprestimoDAO();
		//Alterar para buscar por data
		for(Emprestimo e: edao.pesquisaTodos("select * from emprestimo;")) {
			modelo.addRow(new Object[] {
					e.getId(),
					e.getDtEmprestimo(),
					e.getDtDevolucao(),
					e.getId_usuario()
					});
			
		}
	}

}
