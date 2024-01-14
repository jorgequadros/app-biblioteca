package PesquisaTeste.exemplos.src.interfaces;

public class Interaceteste {
public static void main(String[] args) {
	P0415MensagemEditavel mensagem = new P0415MensagemEditavel("Teste de Interface!!");
	mensagem.imprimir();
	mensagem.editar("java 16");
	mensagem.imprimir();
	mensagem.anexar("C++");
	mensagem.imprimir();
}
}
