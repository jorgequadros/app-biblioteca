package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class EmprestimoHelpers {

	public void limpaCampos(JTextField tfId, JTextField tfUsuario, JTextField tfId_Usuario, JTextField tfId_Livros, JTextField tfLivro,
			JFormattedTextField ftfDataEmprestimo, JFormattedTextField ftfDataDevolucao) {
		//limpa campos
		tfId.setText("");
		tfUsuario.setText("");
		tfId_Usuario.setText("");
		tfId_Livros.setText("");
		tfLivro.setText("");
		ftfDataEmprestimo.setText("");
		ftfDataDevolucao.setText("");
		
	}
	
	public static java.sql.Date convertDataBD(JFormattedTextField ftfDate) throws ParseException {
		SimpleDateFormat data =new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date strData = (java.sql.Date) data.parse(ftfDate.getText());
		System.out.println(data.parse(ftfDate.getText()));
		System.out.println(strData);
				
//		
//		data.setLenient(false);
//		try {
//			System.out.println(data.parse(ftfDate.getText()));
//			return data.parse(ftfDate.getText());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return strData;
	}
	
}
