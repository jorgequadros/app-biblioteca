package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

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
		setBounds(100, 100, 372, 174);
		getContentPane().setLayout(null);
		
		JLabel lbDescricao = new JLabel("Descrição: ");
		lbDescricao.setBounds(102, 11, 86, 14);
		getContentPane().add(lbDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(102, 24, 235, 20);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lbID = new JLabel("ID");
		lbID.setBounds(10, 11, 21, 14);
		getContentPane().add(lbID);
		
		txtID = new JTextField();
		txtID.setBounds(10, 24, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.setBounds(7, 69, 89, 23);
		getContentPane().add(btAlterar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(131, 69, 89, 23);
		getContentPane().add(btCancelar);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.setBounds(248, 69, 89, 23);
		getContentPane().add(btIncluir);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btExcluir.setBounds(7, 97, 89, 23);
		getContentPane().add(btExcluir);
		
		JButton btOk = new JButton("Ok");
		btOk.setBounds(131, 97, 89, 23);
		getContentPane().add(btOk);

	}
}
