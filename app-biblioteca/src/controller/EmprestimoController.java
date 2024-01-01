package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CategoriasDAO;
import model.Emprestimo;
import model.EmprestimoDAO;
import model.InterfacesDAO;

public class EmprestimoController implements InterfacesDAO{

	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public void incluir(Object... campos) {
		
		EmprestimoDAO edao = new EmprestimoDAO();
		edao.comandoSql("INSERT INTO emprestimos (id_usuario,id_livro ,dt_retirada,dt_devolucao) values(?,?,?,?)", campos);
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

		for(Emprestimo e: edao.pesquisa("select * from emprestimos AS e, livros AS l, usuarios As u "
				+ "where l.id=e.id_livro and u.id=e.id_usuario and dt_devolucao=?;", consulta)) {
					
			modelo.addRow(new Object[] {
					e.getId(),
					sdf.format(e.getDtEmprestimo()),
					sdf.format(e.getDtDevolucao()),
					e.getId_usuario(),
					e.getUsuarios().getNome(),
					e.getId_Livro(),
					e.getLivros().getTitulo()
					});
			
		}
		
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		
		SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String strDate = formataData.format(c.getTime());
		
		EmprestimoDAO edao = new EmprestimoDAO();
		
			
		for(Emprestimo e: edao.pesquisaTodos("select * from emprestimos AS e, livros AS l, usuarios As u where l.id=e.id_livro and u.id=e.id_usuario and e.dt_devolucao='"+strDate+"';")) {
			modelo.addRow(new Object[] {
					e.getId(),
					sdf.format(e.getDtEmprestimo()),
					sdf.format(e.getDtDevolucao()),
					e.getId_usuario(),
					e.getUsuarios().getNome(),
					e.getId_Livro(),
					e.getLivros().getTitulo(),
					});
			
		}
	}

}
