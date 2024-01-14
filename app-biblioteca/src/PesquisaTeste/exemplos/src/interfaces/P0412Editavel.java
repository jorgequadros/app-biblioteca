package PesquisaTeste.exemplos.src.interfaces;

public interface P0412Editavel {

	long chave =0xABDCEF0;
	void editar(String conteudo);
	default void limpar() {
		editar("");
	}
}
