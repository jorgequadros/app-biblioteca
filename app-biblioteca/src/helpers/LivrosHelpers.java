package helpers;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LivrosHelpers {

	public String convertDataBD(String data) {
		String dia =data.substring(0, 2);
		String mes =data.substring(3, 5);
		String ano =data.substring(6, 10);
		String convertData = ano+"-"+mes+"-"+dia;
		return convertData;
	}
	
	public void limpaCampos(JTextField tfId, JTextField tfTitulo, JTextField tfAutor, JTextField tfDataAquisicao, JTextArea taAssunto){
		tfId.setText("");
		tfTitulo.setText("");
		tfAutor.setText("");
		taAssunto.setText("");
		tfDataAquisicao.setText("");
	}
}
