package control;

public class Livros {

	private int id;
	private String titulo;
	private String assunto;
	private String dtAquisicao;
	private String autor;
	private Categorias categorias;
	
	public Livros() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDtAquisicao() {
		return dtAquisicao;
	}

	public void setDtAquisicao(String dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	
}
