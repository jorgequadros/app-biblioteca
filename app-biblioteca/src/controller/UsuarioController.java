package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.InterfacesDAO;
import model.Usuario;
import model.UsuariosDAO;

public class UsuarioController implements InterfacesDAO{

	@Override
	public void incluir(Object... campos) {
		// TODO Auto-generated method stub
		UsuariosDAO udao = new UsuariosDAO();
		udao.comandoSql("INSERT INTO usuarios (nome, endereco, cidade,bairro,cep,telefone,email,usuario,pws,perfil)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?) ", campos);
	}

	@Override
	public void alterar(Object... campos) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		UsuariosDAO udao = new UsuariosDAO();
		udao.comandoSql("DELETE FROM usuarios WHERE ID=?", id);
		
	}

	@Override
	public void pesquisaPorCampo(String consulta, JTable tbConsulta) {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		UsuariosDAO udao = new UsuariosDAO();
		String novaConsulta = consulta+"%";
		for(Usuario u: udao.pesquisa("select * from usuarios where nome like ?",novaConsulta)) {
			modelo.addRow(new Object[] {
					u.getId(),
					u.getNome(),
					u.getUsuario(),
					u.getEmail()
					});
			
		}
	}

	@Override
	public void pesquisaTodos(JTable tbConsulta) {
		// TODO Auto-generated method stub
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

}
