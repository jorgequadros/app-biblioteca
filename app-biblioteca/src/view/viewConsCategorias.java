package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import control.Categorias;
import model.CategoriasDAO;
import swing.model.ProdutoM;
import swing.model.ProdutosMDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class viewConsCategorias extends JInternalFrame {
	private JTextField tfDescricao;
	private JTable tbconsulta;
	private JTextField tfID;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * viewConsCategorias frame = new viewConsCategorias(); frame.setVisible(true);
	 * } catch (Exception e) { e.printStackTrace(); } } });
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public viewConsCategorias() {
		setBounds(100, 100, 386, 354);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 353, 151);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(10, 41, 46, 14);
		panel.add(lblDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setBounds(62, 38, 187, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);

		JLabel btnObs = new JLabel("Obs");
		btnObs.setBounds(10, 83, 46, 14);
		panel.add(btnObs);

		JScrollPane spnObs = new JScrollPane();
		spnObs.setBounds(62, 83, 189, 57);
		panel.add(spnObs);

		JTextArea taObs = new JTextArea();
		spnObs.setViewportView(taObs);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(259, 7, 89, 23);
		panel.add(btnPesquisar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(259, 32, 89, 23);
		panel.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(259, 59, 89, 23);
		panel.add(btnExcluir);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriasDAO c = new CategoriasDAO();
				c.incluir("INSERT INTO categorias (descricao, obs) values(?,?)", tfDescricao.getText(),
						taObs.getText());
			}
		});
		btnIncluir.setBounds(259, 85, 89, 23);
		panel.add(btnIncluir);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(259, 119, 89, 23);
		panel.add(btnSair);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		panel.add(lblId);
		
		tfID = new JTextField();
		tfID.setBounds(61, 8, 86, 20);
		panel.add(tfID);
		tfID.setColumns(10);

		JScrollPane spnTableConsulta = new JScrollPane();
		spnTableConsulta.setBounds(20, 173, 340, 126);
		getContentPane().add(spnTableConsulta);

		tbconsulta = new JTable();
		tbconsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfDescricao.setText(tbconsulta.getValueAt(tbconsulta.getSelectedRow(), 1).toString());
				taObs.setText(tbconsulta.getValueAt(tbconsulta.getSelectedRow(), 2).toString());
			}
		});
		tbconsulta.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Descri\u00E7\u00E3o", "Obs" }));
		spnTableConsulta.setViewportView(tbconsulta);
		
		DefaultTableModel modelo = (DefaultTableModel) tbconsulta.getModel();
		tbconsulta.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		try {
			lerTabela();
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void lerTabela() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) tbconsulta.getModel();
		modelo.setNumRows(0);
		CategoriasDAO cdao = new CategoriasDAO();
		
		for(Categorias c: cdao.PesquisaTodos("select * from categorias")) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getDescricao(),
					c.getObs()
					});
			
		}
	}
}
