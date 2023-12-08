package controller;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CategoriasDAO;
import model.InterfacesDAO;
import model.Livros;
import model.LivrosDAO;

public class LivrosController implements InterfacesDAO{

	@Override
	public void incluir(Object... campos) {
		
		LivrosDAO ldao = new LivrosDAO();
		ldao.comandoSql("INSERT INTO emprestimo (dt_devolucao,dt_retirada,id_livro,id_usuario) values(?,?,?,?)", campos);
	}

	@Override
	public void alterar(Object... campos) {
		
		LivrosDAO l =new LivrosDAO();
		l.comandoSql("update livros "
				+ "set titulo=?, "
				+ "autor=?, "
				+ "id_categoria=?, "
				+ "assunto=?, "
				+ "dtAquisicao=? "
				+ " where id=?;",campos);
	}

	@Override
	public void excluir(int id) {
		
		CategoriasDAO c =new CategoriasDAO();
		c.comandoSql("delete from livros where id=?", id);
	}

	@Override
	public void pesquisaPorCampo(String consulta, JTable tbConsulta) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		LivrosDAO ldao = new LivrosDAO();
		String novaConsulta = consulta+"%";
		for(Livros l: ldao.pesquisa("select * from livros AS l, Categorias As c where c.id=l.id_categoria and titulo like ?",novaConsulta)) {
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
	
	public void carregaLista(JList<Livros> lsUsuario,String consulta) {
		DefaultListModel<Livros> modelo = new DefaultListModel<Livros>();
		
		LivrosDAO ldao =new LivrosDAO();
		String novaConsulta = consulta+"%";
		for (Livros l : ldao.pesquisa("select * from livros AS l, Categorias As c where c.id=l.id_categoria and titulo like ?", novaConsulta)) {
			modelo.addElement(l);
		}
		lsUsuario.setModel(modelo);
	}

}
