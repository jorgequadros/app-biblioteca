package controller;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.InterfacesDAO;
import model.Usuario;
import model.UsuariosDAO;

public class UsuarioController implements InterfacesDAO{
	String codigo;
	@Override
	public void incluir(Object... campos) {
		
		UsuariosDAO udao = new UsuariosDAO();
		udao.comandoSql("INSERT INTO usuarios (nome, endereco, cidade,bairro,cep,telefone,email,usuario,pws,perfil)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?) ", campos);
	}

	@Override
	public void alterar(Object... campos) {
		
		UsuariosDAO udao = new UsuariosDAO();
		udao.comandoSql("UPDATE usuarios set "
				+ " nome=?,"
				+ " endereco=?,"
				+ " cidade=?,"
				+ " bairro=?,"
				+ " cep=?,"
				+ " telefone=?,"
				+ " email=?,"
				+ " usuario=?,"
				+ " pws=?,"
				+ " perfil=? where id=?", campos);
	}

	@Override
	public void excluir(int id) {
		
		UsuariosDAO udao = new UsuariosDAO();
		udao.comandoSql("DELETE FROM usuarios WHERE ID=?", id);
		
	}

	@Override
	public void pesquisaPorCampo(String consulta, JTable tbConsulta) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		UsuariosDAO udao = new UsuariosDAO();
		String novaConsulta = consulta+"%";
		codigo =new String();
		//"ID", "Nome", "Telefone", "E-mail", "Endere\u00E7o", "Bairro", "Cidade", "Perfil", "CEP", "Usu\u00E1rio"
		for(Usuario u: udao.pesquisa("select * from usuarios where nome like ?",novaConsulta)) {
			modelo.addRow(new Object[] {
					u.getId(),
					u.getNome(),
					u.getTelefone(),
					u.getEmail(),
					u.getEndereco(),
					u.getBairro(),
					u.getCidade(),
					u.getTipousuario(),
					u.getCep(),
					u.getUsuario()
					});
			
		}
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		UsuariosDAO udao = new UsuariosDAO();
		
		for(Usuario u: udao.pesquisaTodos("select * from usuarios")) {
				modelo.addRow(new Object[] {
						u.getId(),
						u.getNome(),
						u.getUsuario(),
						u.getEmail()	 
				});
		}
	}
	
	public void carregaLista(JList<Usuario> lsUsuario,String consulta) {
		DefaultListModel<Usuario> modelo = new DefaultListModel<Usuario>();
		
		UsuariosDAO udao =new UsuariosDAO();
		String novaConsulta = consulta+"%";
		
		for (Usuario u : udao.pesquisa("select * from usuarios where nome like ?", novaConsulta)) {
			modelo.addElement(u);
		}
		lsUsuario.setModel(modelo);
	}
}
