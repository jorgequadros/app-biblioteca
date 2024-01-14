package PesquisaTeste.exemplos.src.MembrosEstaticos;

public class P0305Dobro {
	//armazena número de instâncias da classe
	private static int instancias = 0;
	//armazena último valor usado por metodo dobro(int)
	public int ultimovalor;
	//construtor que atualiza nº de instâncias
	public P0305Dobro() {instancias++;}
	//retorna nº de instâncias
	public static int getInstancias() {return instancias;}
	//Calcula o dobro
	public int dobro(int valor) {ultimovalor = valor; return 2*valor;}


}

