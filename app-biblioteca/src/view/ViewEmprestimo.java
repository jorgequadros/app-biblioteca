package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import controller.EmprestimoController;
import controller.LivrosController;
import controller.UsuarioController;
import helpers.EmprestimoHelpers;
import model.Livros;
import model.Usuario;
import javax.swing.JRadioButton;

public class ViewEmprestimo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfId, tfUsuario, tfId_Usuario, tfId_Livros, tfLivro;
	private JFormattedTextField ftfDataEmprestimo, ftfDataDevolucao;
	private JRadioButton rbtnDevolucao;
	
	private JTable tbConsulta;

	private JList<Livros> lsLivro; 
	private JList<Usuario> lsUsuario;
	
	protected int dias =1;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public ViewEmprestimo() {
		setTitle("Emprestimo de Livros");
		setIconifiable(true);
		setClosable(true);
		setBounds(50, 50, 910, 312);
		getContentPane().setLayout(null);
		
		JPanel pnDadosEmprestimo = new JPanel();
		pnDadosEmprestimo.setBounds(10, 11, 367, 260);
		getContentPane().add(pnDadosEmprestimo);
		pnDadosEmprestimo.setLayout(null);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbId.setBounds(10, 11, 25, 14);
		pnDadosEmprestimo.add(lbId);
		
		ftfDataEmprestimo = new JFormattedTextField();
		ftfDataEmprestimo.setEditable(false);
		
		//Formatação de data no campo
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formataData.format(c.getTime());
		ftfDataEmprestimo.setText(String.valueOf(strDate));
		
		ftfDataEmprestimo.setBounds(10, 72, 69, 20);
		pnDadosEmprestimo.add(ftfDataEmprestimo);
		
		JLabel lbDataEmprestimo = new JLabel("Data Emp.");
		lbDataEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDataEmprestimo.setBounds(10, 56, 69, 14);
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
		lsUsuario.setBounds(40, 218, 178, 31);
		pnDadosEmprestimo.add(lsUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(37, 196, 181, 20);
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
		lbId_Usuario.setBounds(10, 182, 25, 14);
		pnDadosEmprestimo.add(lbId_Usuario);
		
		tfId_Usuario = new JTextField();
		tfId_Usuario.setBounds(10, 196, 25, 20);
		tfId_Usuario.setEditable(false);
		pnDadosEmprestimo.add(tfId_Usuario);
		tfId_Usuario.setColumns(10);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbUsuario.setBounds(36, 182, 46, 14);
		pnDadosEmprestimo.add(lbUsuario);
		
		JLabel lbId_Livro = new JLabel("ID");
		lbId_Livro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbId_Livro.setBounds(10, 102, 25, 14);
		pnDadosEmprestimo.add(lbId_Livro);
		
		JLabel lbLivros = new JLabel("Livros");
		lbLivros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbLivros.setBounds(38, 102, 46, 14);
		pnDadosEmprestimo.add(lbLivros);
		
		tfId_Livros = new JTextField();
		tfId_Livros.setBounds(10, 119, 25, 20);
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
				LivrosController lctrl =new LivrosController();
				tfId_Livros.setText(String.valueOf(lsLivro.getSelectedValue().getId()));
				tfLivro.setText(lsLivro.getSelectedValue().getTitulo());
				if(!lctrl.isLivro(Integer.parseInt(tfId_Livros.getText()))){
					JOptionPane.showMessageDialog(null, "Livro emprestado!!");
					tfId_Livros.setText("");
					tfLivro.setText("");
				}
				lsLivro.setVisible(false);
			}
		});
		lsLivro.setBounds(38, 140, 180, 31);
		pnDadosEmprestimo.add(lsLivro);
		
		tfLivro = new JTextField();
		tfLivro.setBounds(36, 119, 181, 20);
	
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
		
		SpinnerNumberModel nm = new SpinnerNumberModel();
		nm.setMaximum(10);
		nm.setMinimum(1);
		
		JSpinner spnDias = new JSpinner();
		spnDias.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spnDias.setEnabled(true);
		spnDias.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		spnDias.setBounds(89, 71, 46, 20);
		
		pnDadosEmprestimo.add(spnDias);
		
		GregorianCalendar gcDevolucao = new GregorianCalendar();
		gcDevolucao.add(Calendar.DAY_OF_MONTH, dias);
		ftfDataDevolucao = new JFormattedTextField();
		ftfDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 14));
		ftfDataDevolucao.setText(formataData.format(gcDevolucao.getTime()));
		ftfDataDevolucao.setEditable(false);
		ftfDataDevolucao.setBounds(144, 70, 95, 20);
				
		pnDadosEmprestimo.add(ftfDataDevolucao);
		
		JLabel lbDataDevolucao = new JLabel("Data Devol.");
		lbDataDevolucao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDataDevolucao.setBounds(144, 55, 88, 14);
		pnDadosEmprestimo.add(lbDataDevolucao);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("teste");
				EmprestimoHelpers eHelp = new EmprestimoHelpers();
				EmprestimoController eCtrl = new EmprestimoController();
				eCtrl.pesquisaTodos(tbConsulta);
				eHelp.limpaCampos(tfId, tfUsuario, tfId_Usuario, ftfDataDevolucao, ftfDataEmprestimo,tfId_Livros, tfLivro,rbtnDevolucao);
			}
		});
		
		btnPesquisar.setBounds(249, 97, 111, 30);
		pnDadosEmprestimo.add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmprestimoController eCtrl = new EmprestimoController();
				LivrosController lctrl = new LivrosController();
				EmprestimoHelpers eHelp = new EmprestimoHelpers();
				if(rbtnDevolucao.isSelected()) {
					lctrl.alterarStatus(0,tfId_Livros.getText());
				}
				eCtrl.alterar(eHelp.convertDataBD(ftfDataEmprestimo.getText()),eHelp.convertDataBD(ftfDataDevolucao.getText()),tfId_Livros.getText(),tfId_Usuario.getText(),tfId.getText());
				eHelp.limpaCampos(tfId, tfUsuario, tfId_Usuario, ftfDataDevolucao, ftfDataEmprestimo,tfId_Livros, tfLivro,rbtnDevolucao);
			}
		});
		btnAlterar.setBounds(249, 136, 111, 23);
		pnDadosEmprestimo.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExcluir.setBounds(249, 166, 111, 23);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmprestimoController eCtrl = new EmprestimoController();
				EmprestimoHelpers eHelp = new EmprestimoHelpers();
				
				eCtrl.excluir(Integer.parseInt(tfId.getText()));
				eHelp.limpaCampos(tfId, tfUsuario, tfId_Usuario, ftfDataDevolucao, ftfDataEmprestimo,tfId_Livros, tfLivro,rbtnDevolucao);
			}
		});
		pnDadosEmprestimo.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIncluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				EmprestimoController ectrl = new EmprestimoController();
				EmprestimoHelpers ehelp = new EmprestimoHelpers();
				LivrosController lctrl = new LivrosController();
				
				ectrl.incluir(tfId_Usuario.getText(), tfId_Livros.getText(),ehelp.convertDataBD(ftfDataEmprestimo.getText()),ehelp.convertDataBD(ftfDataDevolucao.getText()));
				lctrl.alterarStatus(1,tfId_Livros.getText());
				
				ehelp.limpaCampos(tfId, tfUsuario, tfId_Usuario, ftfDataDevolucao, ftfDataEmprestimo,tfId_Livros, tfLivro,rbtnDevolucao);
			}
		});
		btnIncluir.setBounds(250, 195, 111, 23);
		pnDadosEmprestimo.add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmprestimoHelpers ehelp = new EmprestimoHelpers();
				ehelp.limpaCampos(tfId, tfUsuario, tfId_Usuario, ftfDataDevolucao, ftfDataEmprestimo,tfId_Livros, tfLivro,rbtnDevolucao);
			}
		});
		btnCancelar.setBounds(251, 226, 111, 23);
		pnDadosEmprestimo.add(btnCancelar);
		
		JLabel lbDias = new JLabel("N° Dias");
		lbDias.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbDias.setBounds(92, 56, 46, 14);
		pnDadosEmprestimo.add(lbDias);
		
		JButton btnDataDevlucao = new JButton("Calcular Data");
		btnDataDevlucao.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDataDevlucao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dias = Integer.parseInt(spnDias.getValue().toString());
				gcDevolucao.add(Calendar.DAY_OF_MONTH, dias);
				ftfDataDevolucao.setText("");
				ftfDataDevolucao.setText(formataData.format(gcDevolucao.getTime()));
			}
		});
		btnDataDevlucao.setBounds(249, 54, 106, 32);
		pnDadosEmprestimo.add(btnDataDevlucao);
		
		rbtnDevolucao = new JRadioButton("Devolução");
		rbtnDevolucao.setFont(new Font("Tahoma", Font.BOLD, 14));
		rbtnDevolucao.setBounds(51, 24, 109, 23);
		pnDadosEmprestimo.add(rbtnDevolucao);
		
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
					"ID", "Data Emprestimo", "Data Devolução", "ID Usuário","Usuários","ID Livro", "Titulo"
			}
		));
		tbConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Boolean tabela =tbConsulta.isEditing();
				try {
					tfId.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 0).toString());
					ftfDataEmprestimo.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 1).toString());
					ftfDataDevolucao.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 2).toString());
					tfId_Usuario.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 3).toString());
					tfUsuario.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 4).toString());
					String idLivros = tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 5).toString();
					String Livro = tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 6).toString();
					tfId_Livros.setText(idLivros);
					tfLivro.setText(Livro);
					if (tabela==false) {
						JOptionPane.showMessageDialog(null, "Id : " + idLivros +" Titulo : " + Livro);
					}
					
				} catch (Exception e1) {
					
					new Throwable(e1);
				}
			}
		});
		spTabela.setViewportView(tbConsulta);

	}
}
