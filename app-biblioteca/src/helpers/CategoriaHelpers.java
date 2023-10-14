package helpers;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CategoriaHelpers {
	public void limpaCampos(JTextField tfDescricao, JTextField tfID, JTextArea taObs) {
		tfDescricao.setText("");
		tfID.setText("");
		taObs.setText("");
	}
}
