package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Font;

public class ViewEmprestimo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JTextField tfId_Usuario;
	private JTextField tfId_Livros;
	private JTextField tfLivro;
	private JTable tbConsulta;
	private JTextField tfId;

	
	public ViewEmprestimo() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 910, 312);
		getContentPane().setLayout(null);
		
		JPanel pnDadosEmprestimo = new JPanel();
		pnDadosEmprestimo.setBounds(10, 11, 367, 260);
		getContentPane().add(pnDadosEmprestimo);
		pnDadosEmprestimo.setLayout(null);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbId.setBounds(10, 11, 25, 14);
		pnDadosEmprestimo.add(lbId);
		
		JFormattedTextField ftfDataEmprestimo = new JFormattedTextField();
		ftfDataEmprestimo.setEditable(false);
		ftfDataEmprestimo.setBounds(38, 25, 148, 20);
		pnDadosEmprestimo.add(ftfDataEmprestimo);
		
		JLabel lbDataEmprestimo = new JLabel("Data Emprestimo");
		lbDataEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDataEmprestimo.setBounds(38, 11, 120, 14);
		pnDadosEmprestimo.add(lbDataEmprestimo);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(219, 25, 142, 20);
		pnDadosEmprestimo.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JScrollPane spnListUsuario = new JScrollPane();
		spnListUsuario.setBounds(219, 46, 138, 41);
		pnDadosEmprestimo.add(spnListUsuario);
		
		JList list = new JList();
		spnListUsuario.setViewportView(list);
		
		JLabel lbId_Usuario = new JLabel("ID");
		lbId_Usuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbId_Usuario.setBounds(192, 11, 25, 14);
		pnDadosEmprestimo.add(lbId_Usuario);
		
		tfId_Usuario = new JTextField();
		tfId_Usuario.setBounds(192, 25, 25, 20);
		pnDadosEmprestimo.add(tfId_Usuario);
		tfId_Usuario.setColumns(10);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbUsuario.setBounds(218, 11, 46, 14);
		pnDadosEmprestimo.add(lbUsuario);
		
		JLabel lbId_Livro = new JLabel("ID");
		lbId_Livro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbId_Livro.setBounds(10, 53, 25, 14);
		pnDadosEmprestimo.add(lbId_Livro);
		
		JLabel lbLivros = new JLabel("Livros");
		lbLivros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbLivros.setBounds(43, 52, 46, 14);
		pnDadosEmprestimo.add(lbLivros);
		
		tfId_Livros = new JTextField();
		tfId_Livros.setBounds(8, 67, 25, 20);
		pnDadosEmprestimo.add(tfId_Livros);
		tfId_Livros.setColumns(10);
		
		tfLivro = new JTextField();
		tfLivro.setBounds(36, 67, 169, 20);
		pnDadosEmprestimo.add(tfLivro);
		tfLivro.setColumns(10);
		
		JScrollPane spnListaLivros = new JScrollPane();
		spnListaLivros.setBounds(38, 88, 167, 57);
		pnDadosEmprestimo.add(spnListaLivros);
		
		JList lsLivros = new JList();
		spnListaLivros.setViewportView(lsLivros);
		
		tfId = new JTextField();
		tfId.setBounds(8, 25, 25, 20);
		pnDadosEmprestimo.add(tfId);
		tfId.setColumns(10);
		
		JFormattedTextField ftfDataDevolucao = new JFormattedTextField();
		ftfDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 14));
		ftfDataDevolucao.setEditable(false);
		ftfDataDevolucao.setBounds(10, 171, 148, 31);
		pnDadosEmprestimo.add(ftfDataDevolucao);
		
		JLabel lbDataDevolucao = new JLabel("Data Devolução");
		lbDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDataDevolucao.setBounds(10, 156, 140, 14);
		pnDadosEmprestimo.add(lbDataDevolucao);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisar.setBounds(272, 98, 89, 23);
		pnDadosEmprestimo.add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBounds(272, 132, 89, 23);
		pnDadosEmprestimo.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(272, 161, 89, 23);
		pnDadosEmprestimo.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIncluir.setBounds(272, 192, 89, 23);
		pnDadosEmprestimo.add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(272, 226, 89, 23);
		pnDadosEmprestimo.add(btnCancelar);
		
		JPanel pnTabela = new JPanel();
		pnTabela.setBounds(386, 11, 498, 260);
		getContentPane().add(pnTabela);
		pnTabela.setLayout(null);
		
		JScrollPane spTabela = new JScrollPane();
		spTabela.setBounds(10, 11, 478, 238);
		pnTabela.add(spTabela);
		
		tbConsulta = new JTable();
		tbConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Usu\u00E1rio", "Livros", "Data Devolu\u00E7\u00E3o"
			}
		));
		spTabela.setViewportView(tbConsulta);

	}
}
