package PesquisaTeste.exemplos.src.faculdade;

public class exercicio02 {
	public static void main(String[] args) {
		double Imposto = 1000.00,valoraPagar, valorMulta, valorJurosDia;
		int diasDeAtraso=10;
		double percentagemMultaAtraso = 2.0,percentagemJurosDia =0.1;
		valoraPagar = Imposto;
		if(diasDeAtraso>0) {
			valorMulta=valoraPagar*(percentagemMultaAtraso)/100;
			valoraPagar+=valorMulta;
			valorJurosDia = Imposto*(percentagemJurosDia)/100;
			valoraPagar+=valorJurosDia*diasDeAtraso;
			System.out.println("Valor para Pagar Hoje: "+valoraPagar);
			for (int i = 0; i < 5; i++) {
				valoraPagar+=valorJurosDia;
				System.out.println("Valor para Pagar Hoje: "+valoraPagar);
			}
		}
	}

}
