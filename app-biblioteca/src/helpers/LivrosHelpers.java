package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public Date ConvertString(String data) {
		
		String dia =data.substring(0, 2);
		String mes =data.substring(3, 5);
		String ano =data.substring(6, 10);
		String convertData = dia+"-"+mes+"-"+ano;
		
		try {
			return  new SimpleDateFormat("dd-MM-yyyy").parse(convertData) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
