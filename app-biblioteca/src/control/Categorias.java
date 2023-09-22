package control;

public class Categorias {

	private int id;
	private String descricao;
	private String Obs;
	
	public Categorias() {}
	
	
	public void setObs(String obs) {
		Obs = obs;
	}

	public String getObs() {
		return Obs;
	}

	public Categorias(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Categorias(int id, String descricao, String Obs) {
		this.id = id;
		this.descricao = descricao;
		this.Obs = Obs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getDescricao();
	}
}
