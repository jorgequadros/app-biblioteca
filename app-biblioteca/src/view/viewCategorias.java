package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewCategorias extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDescricao;
	private JTextField txtID;
	private JTable JTabela;

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
		setBounds(100, 100, 416, 313);
		getContentPane().setLayout(null);
		
		JLabel lbDescricao = new JLabel("Descrição: ");
		lbDescricao.setBounds(41, 11, 86, 14);
		getContentPane().add(lbDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(41, 24, 235, 20);
		getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lbID = new JLabel("ID");
		lbID.setBounds(10, 11, 21, 14);
		getContentPane().add(lbID);
		
		txtID = new JTextField();
		txtID.setBounds(10, 24, 27, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.setBounds(301, 23, 89, 23);
		getContentPane().add(btAlterar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.setBounds(301, 52, 89, 23);
		getContentPane().add(btCancelar);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.setBounds(301, 107, 89, 23);
		getContentPane().add(btIncluir);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btExcluir.setBounds(301, 79, 89, 23);
		getContentPane().add(btExcluir);
		
		JButton btOk = new JButton("Ok");
		btOk.setBounds(301, 136, 89, 23);
		getContentPane().add(btOk);
		
		JScrollPane JSPaneTabela = new JScrollPane();
		JSPaneTabela.setBounds(10, 55, 265, 200);
		getContentPane().add(JSPaneTabela);
		
		JTabela = new JTable();
		JTabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o"
			}
		));
		JSPaneTabela.setViewportView(JTabela);

	}
}
