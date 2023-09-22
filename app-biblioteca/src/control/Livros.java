package control;

public class Livros {

	private int id;
	private String titulo;
	private String assunto;
	private String dtAquisicao;
	private String autor;
	public Categorias cat;
	
	public Livros(int id, String titulo, String assunto, String autor, int id_categoria, String descricao, String obs, String dtAquisicao2) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.titulo =titulo;
		this.assunto=assunto;
		this.dtAquisicao=dtAquisicao2;
		this.autor= autor;
		cat = new Categorias();
		this.cat.setId(id_categoria);
		this.cat.setDescricao(descricao);
		this.cat.setObs(obs);
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

}
