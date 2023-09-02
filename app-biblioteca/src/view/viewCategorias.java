package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.CategoriasDAO;

public class viewCategorias extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDescricao;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewCategorias frame = new viewCategorias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public viewCategorias() {
		setRootPaneCheckingEnabled(false);
		setForeground(Color.CYAN);
		setClosable(true);
		setBounds(100, 100, 299, 211);
		getContentPane().setLayout(null);
		
		JLabel lbDescricao = new JLabel("Descrição: ");
		lbDescricao.setBounds(41, 11, 86, 14);
		getContentPane().add(lbDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(41, 24, 215, 20);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lbID = new JLabel("ID");
		lbID.setBounds(10, 11, 21, 14);
		getContentPane().add(lbID);
		
		txtID = new JTextField();
		txtID.setBounds(10, 24, 27, 20);
		txtID.setEnabled(false);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 246, 70);
		getContentPane().add(scrollPane);
				
		JTextArea taDescricao = new JTextArea();
		scrollPane.setViewportView(taDescricao);
		
		JLabel lblObservacao = new JLabel("Observação");
		lblObservacao.setBounds(10, 51, 71, 14);
		getContentPane().add(lblObservacao);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(10, 149, 89, 23);
		getContentPane().add(btCancelar);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(e -> {
			CategoriasDAO c = new CategoriasDAO();
			c.incluir("INSERT INTO categorias (descricao, obs) values(?,?)", txtDescricao.getText(),
					taDescricao  .getText());
		});
		btIncluir.setBounds(109, 149, 89, 23);
		getContentPane().add(btIncluir);
		
	}
}
