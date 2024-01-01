package PesquisaTeste;

import java.util.Calendar;

public class DataJava {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("Data e Hora atual: "+ c.getTime());
		System.out.println("Ano : "+c.get(Calendar.YEAR));
		c.set(Calendar.MONDAY, Calendar.JANUARY);
		System.out.println("Mês : "+c.get(Calendar.MONTH));
		System.out.println("Dia do Mês : "+c.get(Calendar.DAY_OF_MONTH));
		
		int hora = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(hora);
		if(hora > 6 && hora < 12) {
			System.out.println("Bom Dia!");
		}else if(hora > 12 && hora < 18) {
			System.out.println("Boa Tarde!");
		}else {
			System.out.println("Boa Noite!");
		}
	}
}
