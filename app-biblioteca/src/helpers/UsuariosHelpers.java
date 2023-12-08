package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuariosHelpers {
	public String cep(String valor) {
		return valor.replace("-", "");
	}
	
	public String telefone(String valor) {
		String nvValor = valor.replace("-", "");
		String nvValor1 = nvValor.replace("(", "");
		String VlsemTraco=nvValor1.replace(")", "");
		return VlsemTraco;
	}
	
	public void limpa(JTextField tfID, JTextField tfNome, JTextField tfEndereco, JTextField tfBairro,
			JTextField tfCidade, JFormattedTextField ftfCep, JFormattedTextField ftfTelefone, 
			JTextField tfUsuario, JTextField tfEmail, JPasswordField pwdSenha) {
		tfID.setText("");
		tfNome.setText("");
		tfEndereco.setText("");
		tfBairro.setText("");
		tfCidade.setText("");
		ftfCep.setText("");
		ftfTelefone.setText("");
		tfUsuario.setText("");
		tfEmail.setText("");
		pwdSenha.setText("");
	}
	
	public Date ConvertString(String data) {
		
		try {
			String dia =data.substring(0, 2);
			String mes =data.substring(3, 5);
			String ano =data.substring(6, 10);
			String convertData = dia+"-"+mes+"-"+ano;
			return  new SimpleDateFormat("dd-MM-yyyy").parse(convertData) ;
		
		} catch (ParseException e) {
			//
			e.printStackTrace();
		}
		return null;
	}
}
