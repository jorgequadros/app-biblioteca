package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ViewEmprestimo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	
	public ViewEmprestimo() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 910, 300);
		getContentPane().setLayout(null);
		
		JPanel jpDadosEmprestimo = new JPanel();
		jpDadosEmprestimo.setBounds(10, 11, 367, 135);
		getContentPane().add(jpDadosEmprestimo);
		jpDadosEmprestimo.setLayout(null);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 25, 82, 20);
		jpDadosEmprestimo.add(formattedTextField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 46, 14);
		jpDadosEmprestimo.add(lblNewLabel);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(102, 25, 97, 20);
		jpDadosEmprestimo.add(formattedTextField_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(102, 11, 46, 14);
		jpDadosEmprestimo.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(63, 68, 142, 20);
		jpDadosEmprestimo.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 89, 138, 41);
		jpDadosEmprestimo.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 54, 46, 14);
		jpDadosEmprestimo.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 68, 51, 20);
		jpDadosEmprestimo.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(63, 56, 46, 14);
		jpDadosEmprestimo.add(lblNewLabel_3);

	}
}
