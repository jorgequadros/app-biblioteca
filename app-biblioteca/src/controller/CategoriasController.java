package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Categorias;
import model.CategoriasDAO;
import model.InterfacesDAO;

public class CategoriasController implements InterfacesDAO{

	@Override
	public void incluir(Object... campos) {
		
		CategoriasDAO cdao = new CategoriasDAO();
		cdao.comandoSql("INSERT INTO categorias (descricao, obs) values(?,?)", campos);
	}

	@Override
	public void alterar(Object... campos) {
		
		CategoriasDAO c =new CategoriasDAO();
		c.comandoSql("update categorias "
				+ "set descricao=?, "
				+ "obs=?"
				+ " where id=?;", campos);
	}

	@Override
	public void excluir(int id) {
		
		CategoriasDAO c =new CategoriasDAO();
		c.comandoSql("delete from categorias where id=?", id);
		
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		CategoriasDAO cdao = new CategoriasDAO();
		
		for(Categorias c: cdao.pesquisaTodos("select * from categorias")) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getDescricao(),
					c.getObs()
					});
			
		}
	}

	public void pesquisaPorCampo(String consulta, JTable tbConsulta) {
		
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

}
