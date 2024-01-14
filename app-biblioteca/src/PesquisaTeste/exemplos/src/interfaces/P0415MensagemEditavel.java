package PesquisaTeste.exemplos.src.interfaces;

public class P0415MensagemEditavel extends P0413Mensagem implements P0411Imprimir, P0416Editavel2{

	public P0415MensagemEditavel(String conteudo) {
		super(conteudo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void editar(String conteudo) {
		// TODO Auto-generated method stub
		setConteudo(conteudo);
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		imprimirNoConsole();
	}

	@Override
	public void imprimirNoConsole() {
		// TODO Auto-generated method stub
		System.out.println(P0411Imprimir.INICIO+"\n"+getConteudo()+"\n"+P0411Imprimir.FIM);
	}

	@Override
	public void anexar(String conteudo) {
		// TODO Auto-generated method stub
		String anexo =getConteudo()+",\n";
		anexo +=conteudo;
		this.setConteudo(anexo);
	}

}
