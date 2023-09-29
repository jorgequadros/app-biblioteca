package control;

public class Pessoa {

	private int id;
	private String nome;
	private String endereco;
	private String cidade;
	private String bairro;
	private int cep;
	private int telefone;
	private String email;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String endereco, String cidade, 
			String bairro, int cep, int telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.cidade= cidade;
		this.bairro=bairro;
		this.cep =cep;
		this.telefone =telefone;
		this.email=email;
	}
	
	public Pessoa(int id, String nome, String endereco, String cidade, 
			String bairro, int cep, int telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade= cidade;
		this.bairro=bairro;
		this.cep =cep;
		this.telefone =telefone;
		this.email=email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
