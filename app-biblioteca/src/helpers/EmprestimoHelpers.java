package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EmprestimoHelpers {

	public void limpaCampos(JTextField tfId, JTextField tfUsuario, JTextField tfId_Usuario, 
			JFormattedTextField ftfDataDevolucao, JFormattedTextField ftfDataEmprestimo, JTextField tfId_Livros, JTextField tfLivro,JRadioButton rbtnDevolucao) {
		
		//limpa campos
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formataData.format(c.getTime());
		GregorianCalendar gcDevolucao = new GregorianCalendar();
		gcDevolucao.add(Calendar.DAY_OF_MONTH, 1);
		ftfDataEmprestimo.setText(String.valueOf(strDate));
		ftfDataDevolucao.setText(formataData.format(gcDevolucao.getTime()));
		tfId.setText("");
		tfUsuario.setText("");
		tfId_Usuario.setText("");
		tfId_Livros.setText("");
		tfLivro.setText("");
		rbtnDevolucao.setSelected(false);
	}
	
	public String convertDataBD(String data) {
			
			String dia =data.substring(0, 2);
			String mes =data.substring(3, 5);
			String ano =data.substring(6, 10);
			String convertData = ano+"-"+mes+"-"+dia;
			return convertData;
			
	}


}
