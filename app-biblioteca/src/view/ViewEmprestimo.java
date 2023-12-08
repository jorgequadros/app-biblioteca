package view;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.LivrosController;
import controller.UsuarioController;
import model.Livros;
import model.Usuario;

public class ViewEmprestimo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JTextField tfId_Usuario;
	private JTextField tfId_Livros;
	private JTextField tfLivro;
	private JTable tbConsulta;
	private JTextField tfId;
	
	private JList<Livros> lsLivro; 
	private JList<Usuario> lsUsuario;
	
	@SuppressWarnings("deprecation")
	public ViewEmprestimo() {
		setIconifiable(true);
		setClosable(true);
		setBounds(50, 50, 910, 312);
		getContentPane().setLayout(null);
		
		Date dataAtual = new Date();
		
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
	
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = String.valueOf(formataData.format(dataAtual));
		ftfDataEmprestimo.setText(String.valueOf(strDate));
		ftfDataEmprestimo.setBounds(38, 25, 148, 20);
		pnDadosEmprestimo.add(ftfDataEmprestimo);
		
		JLabel lbDataEmprestimo = new JLabel("Data Emprestimo");
		lbDataEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDataEmprestimo.setBounds(38, 11, 120, 14);
		pnDadosEmprestimo.add(lbDataEmprestimo);
		
		lsUsuario = new JList<Usuario>();
		lsUsuario.setVisible(false);
		lsUsuario.setVisibleRowCount(3);
		lsUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				super.mouseClicked(e);
				
				tfId_Usuario.setText(String.valueOf(lsUsuario.getSelectedValue().getId()));
				tfUsuario.setText(lsUsuario.getSelectedValue().getNome());
				lsUsuario.setVisible(false);
			}
		});
		lsUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lsUsuario.setBounds(222, 47, 139, 31);
		pnDadosEmprestimo.add(lsUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(219, 25, 142, 20);
		tfUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				super.keyReleased(e);
				
				lsUsuario.setVisible(true);
				UsuarioController uctrl = new UsuarioController();
				uctrl.carregaLista(lsUsuario,tfUsuario.getText());
			}
		});

		pnDadosEmprestimo.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lbId_Usuario = new JLabel("ID");
		lbId_Usuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbId_Usuario.setBounds(192, 11, 25, 14);
		pnDadosEmprestimo.add(lbId_Usuario);
		
		tfId_Usuario = new JTextField();
		tfId_Usuario.setBounds(192, 25, 25, 20);
		tfId_Usuario.setEditable(false);
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
		tfId_Livros.setEditable(false);
		pnDadosEmprestimo.add(tfId_Livros);
		tfId_Livros.setColumns(10);
		
		lsLivro = new JList<Livros>();
		lsLivro.setVisible(false);
		lsLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lsLivro.setVisibleRowCount(3);
		lsLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				super.mouseClicked(e);
				
				tfId_Livros.setText(String.valueOf(lsLivro.getSelectedValue().getId()));
				tfLivro.setText(lsLivro.getSelectedValue().getTitulo());
				lsLivro.setVisible(false);
			}
		});
		lsLivro.setBounds(37, 90, 168, 31);
		pnDadosEmprestimo.add(lsLivro);
		
		tfLivro = new JTextField();
		tfLivro.setBounds(36, 67, 169, 20);
	
		tfLivro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				super.keyReleased(e);
				lsLivro.setVisible(true);
				LivrosController lctrl = new LivrosController();
				lctrl.carregaLista(lsLivro,tfLivro.getText());
			}
		});
		pnDadosEmprestimo.add(tfLivro);
		tfLivro.setColumns(10);
		
		tfId = new JTextField();
		tfId.setBounds(8, 25, 25, 20);
		tfId.setEditable(false);
		pnDadosEmprestimo.add(tfId);
		tfId.setColumns(10);
		
		JFormattedTextField ftfDataDevolucao = new JFormattedTextField();
		ftfDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 14));
		ftfDataDevolucao.setEditable(false);
		ftfDataDevolucao.setBounds(10, 171, 148, 31);
		int dataDevolucao = dataAtual.getDate()+10;
		ftfDataDevolucao.getText(String.valueOf();
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
