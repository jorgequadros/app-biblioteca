package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CategoriasDAO;
import model.InterfacesDAO;
import model.Livros;
import model.LivrosDAO;

public class LivrosController implements InterfacesDAO{

	@Override
	public void incluir(Object... campos) {
		// TODO Auto-generated method stub
		LivrosDAO ldao = new LivrosDAO();
		ldao.incluir("INSERT INTO livros (titulo, id_categoria, autor, dtAquisicao, assunto) values(?,?,?,?,?)", campos);
	}

	@Override
	public void alterar(Object... campos) {
		// TODO Auto-generated method stub
		LivrosDAO l =new LivrosDAO();
		l.alterar("update livros "
				+ "set titulo=?, "
				+ "autor=?, "
				+ "id_categoria=?, "
				+ "assunto=?, "
				+ "dtAquisicao=? "
				+ " where id=?;",campos);
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		CategoriasDAO c =new CategoriasDAO();
		c.excluir("delete from livros where id=?", id);
	}

	@Override
	public void pesquisaPorCampo(String consulta, JTable tbConsulta) {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		LivrosDAO ldao = new LivrosDAO();
		String novaConsulta = consulta+"%";
		for(Livros l: ldao.pesquisa("select * from livros where titulo like ?",novaConsulta)) {
			modelo.addRow(new Object[] {
					l.getId(),
					l.getTitulo(),
					l.getAutor(),
					l.getCat().getId(),
					l.getCat().getDescricao(),
					l.getCat().getObs(),
					l.getAssunto(),
					l.getDtAquisicao()
					});
			
		}
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		LivrosDAO ldao = new LivrosDAO();
		
		for(Livros l: ldao.pesquisaTodos("select * from livros AS l, Categorias As c where c.id=l.id_categoria")) {
				modelo.addRow(new Object[] {
						l.getId(),
						l.getTitulo(),
						l.getAutor(),
						l.getCat().getId(),
						l.getCat().getDescricao(),
						l.getAssunto(),
						l.getDtAquisicao()	 
				});
		}
				
	}
	
	public int buscaIdCategoria(Object Valor) {
		CategoriasDAO cdao = new  CategoriasDAO();
		return cdao.buscaId(Valor);
	}

}
