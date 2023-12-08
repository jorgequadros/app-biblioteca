package model;

public class Usuario extends Pessoa{
	private String usuario;
	private String senha;
	private String tipousuario;
	
	public Usuario() {}
	
	public Usuario(String nome, String endereco, String cidade, String bairro,
			int cep, String telefone, String email, String usuario, String senha, String tipousuario) {
		super(nome, endereco, cidade, bairro, cep, telefone, email);
		this.usuario=usuario;
		this.senha=senha;
		this.tipousuario=tipousuario;
	}
	
	public Usuario(int id, String nome, String endereco, String cidade, String bairro,
			int cep, String telefone, String email, String usuario, String senha, String tipousuario) {
		super(id, nome, endereco, cidade, bairro, cep, telefone, email);
		this.usuario=usuario;
		this.senha=senha;
		this.tipousuario=tipousuario;
	}
	
	public String getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
	
}
