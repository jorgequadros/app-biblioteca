package control;

public class Usuario extends Pessoa{
	private String usuario;
	private String senha;
	@SuppressWarnings("unused")
	private enum TipoUsuario {ADMINISTRADOR, OPERACIONAL};
	
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

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
