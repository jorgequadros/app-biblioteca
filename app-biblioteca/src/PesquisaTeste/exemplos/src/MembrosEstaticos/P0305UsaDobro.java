package PesquisaTeste.exemplos.src.MembrosEstaticos;
@SuppressWarnings("static-access")
public class P0305UsaDobro {
	public static void main(String[] args) {
		//uso de método estático da classe Dobro sem instância
		System.out.println("Nº Instâncias de Dobro = "+ P0305Dobro.getInstancias());
		//declara e inicializa variável inteira com valor arbitrário
		int x =7;
		//instanciação
		System.out.println("Instanciando objeto Dobro");
		P0305Dobro d = new P0305Dobro();
		//uso de métodos estáticos e não estáticos da classe Dobro
		System.out.println("Numero Instâncias de Dobro  = "+d.getInstancias());
		System.out.println("O Dobro de "+ x +" = " +d.dobro(x));
		System.out.println("Ultimo Valor usado: "+d.ultimovalor);
	}
}
