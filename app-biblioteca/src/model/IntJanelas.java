package model;

import javax.swing.JTable;

public interface IntJanelas {
	public void incluir(Object... campos);
	public void alterar(Object... campos);
	public void excluir(int id);
	public void pesquisaPorCampo(String consulta, JTable tbConsulta) ;
	void pesquisaTodos(JTable tbConsulta);
	
}
