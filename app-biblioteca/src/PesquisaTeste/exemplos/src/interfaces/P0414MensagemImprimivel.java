package PesquisaTeste.exemplos.src.interfaces;
//classe derivada com realização de interface 
public class P0414MensagemImprimivel extends P0413Mensagem implements P0411Imprimir{

	public P0414MensagemImprimivel(String conteudo) {
		super(conteudo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		imprimirNoConsole();
	}

	@Override
	public void imprimirNoConsole() {
		// TODO Auto-generated method stub
		System.out.println(P0411Imprimir.INICIO);
		System.out.println(getConteudo());
		System.out.println(P0411Imprimir.FIM);
	}

}
