package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ViewConsLivros extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewConsLivros frame = new
	 * ViewConsLivros(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ViewConsLivros() {
		setIconifiable(true);
		//super("Consulta Livros!",true,true,false,true);//(redimensionar, fechar, maximizar, iconificar)
		setClosable(true);
		setBounds(100, 100, 910, 300);
		getContentPane().setLayout(null);
		
		JPanel pnFormulario = new JPanel();
		pnFormulario.setBounds(10, 11, 327, 231);
		getContentPane().add(pnFormulario);
		pnFormulario.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 11, 46, 14);
		pnFormulario.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 26, 33, 20);
		pnFormulario.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(47, 11, 46, 14);
		pnFormulario.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 26, 173, 20);
		pnFormulario.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Autor");
		lblNewLabel_2.setBounds(10, 52, 46, 14);
		pnFormulario.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 71, 209, 20);
		pnFormulario.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data Aquisição");
		lblNewLabel_3.setBounds(10, 102, 83, 14);
		pnFormulario.add(lblNewLabel_3);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 116, 83, 20);
		pnFormulario.add(formattedTextField);
		
		JLabel lblNewLabel_4 = new JLabel("Categorias");
		lblNewLabel_4.setBounds(103, 102, 75, 14);
		pnFormulario.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 115, 116, 22);
		pnFormulario.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Assunto");
		lblNewLabel_5.setBounds(10, 147, 46, 14);
		pnFormulario.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 209, 62);
		pnFormulario.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(229, 26, 89, 23);
		pnFormulario.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.setBounds(229, 53, 89, 23);
		pnFormulario.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setBounds(229, 87, 89, 23);
		pnFormulario.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Incluir");
		btnNewButton_3.setBounds(229, 116, 89, 23);
		pnFormulario.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cancelar");
		btnNewButton_4.setBounds(229, 144, 89, 23);
		pnFormulario.add(btnNewButton_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(347, 11, 525, 231);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "Autor", "Categoria", "Assunto", "Data Compra"
			}
		));
		scrollPane_1.setViewportView(table);

	}
}
