package controller;

import model.UsuariosDAO;


public class TelaLoginController {
	

	public boolean login(String login, String senha) {
		UsuariosDAO udao = new UsuariosDAO();
		if(udao.login("select usuario, pws from usuarios where usuario=?;", login, senha)) {
			return true;				
		}
		return false;
		
	}
	
}
