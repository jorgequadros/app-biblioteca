package model;

public class Emprestimo {

	private int id;
	private String dtEmprestimo;
	private String dtDevolucao;
	private int id_Livro;
	private int id_usuario;
	
	public Emprestimo() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(String dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public String getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(String dtDevolucao) {
		this.dtDevolucao = dtDevolucao;
	}

	public int getId_Livro() {
		return id_Livro;
	}

	public void setId_Livro(int id_Livro) {
		this.id_Livro = id_Livro;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
}
