package PesquisaTeste.exemplos.src.interfaces;
//classe abstrata para mensagem
public abstract class P0413Mensagem {
	private String conteudo;

	public P0413Mensagem(String conteudo) {
		setConteudo(conteudo);
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		if(conteudo.length()>0) {
			this.conteudo = conteudo;
		}
			
	}
	
	
}
