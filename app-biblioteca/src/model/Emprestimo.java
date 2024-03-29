package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Emprestimo {

	private int id;
	private Date dtEmprestimo;
	private Date dtDevolucao;
	private int id_Livro;
	private Livros livros;
	private int id_usuario;
	private Usuario usuarios;
	
	public Emprestimo() {}
	public Emprestimo(int id, Date dtDevolucao,Date dtEmprestimo, int id_Livro, String titulo, 
			int id_usuario, String nome) {
		this.setId(id);
		this.setDtDevolucao(dtDevolucao);
		this.setDtEmprestimo(dtEmprestimo);
		this.setId_Livro(id_Livro);
		livros = new Livros();
		this.livros.setTitulo(titulo);
		this.setId_usuario(id_usuario);
		usuarios = new Usuario();
		this.usuarios.setNome(nome);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public Date getDtEmprestimo() {
		return dtEmprestimo;
	}

	public void setDtEmprestimo(Date dtEmprestimo) {
		this.dtEmprestimo = dtEmprestimo;
	}

	public Date getDtDevolucao() {
		return dtDevolucao;
	}

	public void setDtDevolucao(Date dtDevolucao) {
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(this.getDtDevolucao());
	}
}
