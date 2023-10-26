package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Categorias;
import model.CategoriasDAO;
import model.InterfacesDAO;

public class CategoriasController implements InterfacesDAO{

	@Override
	public void incluir(Object... campos) {
		// TODO Auto-generated method stub
		CategoriasDAO cdao = new CategoriasDAO();
		cdao.incluir("INSERT INTO categorias (descricao, obs) values(?,?)", campos);
	}

	@Override
	public void alterar(Object... campos) {
		// TODO Auto-generated method stub
		CategoriasDAO c =new CategoriasDAO();
		c.alterar("update categorias "
				+ "set descricao=?, "
				+ "obs=?"
				+ " where id=?;", campos);
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		CategoriasDAO c =new CategoriasDAO();
		c.excluir("delete from categorias where id=?", id);
		
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		// TODO Auto-generated method stub
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

}
