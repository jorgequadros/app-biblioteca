package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.UsuarioController;
import helpers.UsuariosHelpers;

public class ViewUsuario extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	private JTextField tfID;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfCidade;
	private JTextField tfBairro;
	private JTextField tfEmail;
	private JTextField tfUsuario;
	private JFormattedTextField ftfCep;
	private JPasswordField pwdSenha;
	JFormattedTextField ftfTelefone;
	private JTable tbConsulta;
	
	@SuppressWarnings("serial")
	public ViewUsuario() {
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 862, 257);
		getContentPane().setLayout(null);
		
		JPanel pnFormCadastro = new JPanel();
		pnFormCadastro.setBounds(10, 11, 327, 231);
		getContentPane().add(pnFormCadastro);
		pnFormCadastro.setLayout(null);
		
		JLabel lbID = new JLabel("ID");
		lbID.setFont(new Font("Arial", Font.BOLD, 12));
		lbID.setBounds(10, 11, 23, 14);
		pnFormCadastro.add(lbID);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Arial", Font.PLAIN, 12));
		tfID.setBounds(10, 27, 23, 20);
		tfID.setEnabled(false);
		pnFormCadastro.add(tfID);
		tfID.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setFont(new Font("Arial", Font.BOLD, 12));
		lbNome.setBounds(36, 11, 46, 14);
		pnFormCadastro.add(lbNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tfNome.setBounds(35, 27, 125, 20);
		pnFormCadastro.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lbEndereco = new JLabel("Endereço");
		lbEndereco.setFont(new Font("Arial", Font.BOLD, 12));
		lbEndereco.setBounds(162, 11, 86, 14);
		pnFormCadastro.add(lbEndereco);
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		tfEndereco.setBounds(162, 27, 152, 20);
		pnFormCadastro.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lbCidade = new JLabel("Cidade");
		lbCidade.setFont(new Font("Arial", Font.BOLD, 12));
		lbCidade.setBounds(10, 57, 46, 14);
		pnFormCadastro.add(lbCidade);
		
		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Arial", Font.PLAIN, 12));
		tfCidade.setBounds(10, 74, 137, 20);
		pnFormCadastro.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lbBairro = new JLabel("Bairro");
		lbBairro.setFont(new Font("Arial", Font.BOLD, 12));
		lbBairro.setBounds(151, 57, 46, 14);
		pnFormCadastro.add(lbBairro);
		
		tfBairro = new JTextField();
		tfBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		tfBairro.setBounds(151, 74, 163, 20);
		pnFormCadastro.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lbCep = new JLabel("Cep");
		lbCep.setFont(new Font("Arial", Font.BOLD, 12));
		lbCep.setBounds(10, 105, 46, 14);
		pnFormCadastro.add(lbCep);
		
		try {
			ftfCep = new JFormattedTextField(new MaskFormatter("#####-###"));
			ftfCep.setFont(new Font("Arial", Font.PLAIN, 12));
			ftfCep.setBounds(10, 122, 70, 20);
			pnFormCadastro.add(ftfCep);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setFont(new Font("Arial", Font.BOLD, 12));
		lbTelefone.setBounds(84, 105, 63, 14);
		pnFormCadastro.add(lbTelefone);
		
		try {
			ftfTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
			ftfTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
			ftfTelefone.setBounds(84, 122, 80, 20);
			pnFormCadastro.add(ftfTelefone);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		tfEmail.setBounds(167, 122, 147, 20);
		pnFormCadastro.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lbEmail = new JLabel("E-mail");
		lbEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lbEmail.setBounds(167, 105, 46, 14);
		pnFormCadastro.add(lbEmail);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lbUsuario.setBounds(10, 153, 46, 14);
		pnFormCadastro.add(lbUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		tfUsuario.setBounds(10, 170, 86, 20);
		pnFormCadastro.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Arial", Font.BOLD, 12));
		lbSenha.setBounds(101, 153, 46, 14);
		pnFormCadastro.add(lbSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		pwdSenha.setBounds(101, 170, 102, 20);
		pnFormCadastro.add(pwdSenha);
		
		JComboBox<String> cboTipoOperador = new JComboBox<String>();
		cboTipoOperador.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Cliente", "Operador"}));
		cboTipoOperador.setFont(new Font("Arial", Font.PLAIN, 12));
		cboTipoOperador.setBounds(213, 169, 101, 22);
		pnFormCadastro.add(cboTipoOperador);
		
		JLabel lbPerfil = new JLabel("Perfil");
		lbPerfil.setFont(new Font("Arial", Font.BOLD, 12));
		lbPerfil.setBounds(213, 153, 101, 14);
		pnFormCadastro.add(lbPerfil);
		
		JScrollPane spTabela = new JScrollPane();
		spTabela.setBounds(463, 11, 381, 210);
		getContentPane().add(spTabela);
		
		tbConsulta = new JTable();
		tbConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Usu\u00E1rio", "E-mail"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbConsulta.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbConsulta.getColumnModel().getColumn(1).setPreferredWidth(208);
		tbConsulta.getColumnModel().getColumn(2).setPreferredWidth(154);
		tbConsulta.getColumnModel().getColumn(3).setPreferredWidth(134);
		tbConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//Boolean tabela =tbConsulta.isEditing();
				//verificação posterior quais campos serão mostrados na tabela
				
			}
		});
		spTabela.setViewportView(tbConsulta);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.BOLD, 12));
		btnPesquisar.setBounds(353, 11, 100, 23);
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UsuarioController uctrl = new UsuarioController();
				UsuariosHelpers uhelp = new UsuariosHelpers();
				if(tfNome.getText()==""){
					uctrl.pesquisaTodos(tbConsulta);
				}else{
					uctrl.pesquisaPorCampo(tfNome.getText(), tbConsulta);
				}
				uhelp.limpa(tfID, tfNome, tfEndereco, tfBairro, tfCidade, ftfCep, ftfTelefone, tfUsuario, tfEmail, pwdSenha);	
			}
		});
		getContentPane().add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlterar.setBounds(353, 45, 100, 23);
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					UsuarioController uctrl = new UsuarioController();
					UsuariosHelpers uhelp = new UsuariosHelpers();
					String senha= new String(pwdSenha.getPassword());
					uctrl.alterar(tfNome.getText(),tfEndereco.getText(),tfCidade.getText(), tfBairro.getText(),
						      Integer.parseInt(uhelp.cep(ftfCep.getText())),uhelp.telefone(ftfTelefone.getText()), 
							  tfEmail.getText(),tfUsuario.getText(), senha, cboTipoOperador.getSelectedItem(),tfID.getText());
					
					uhelp.limpa(tfID, tfNome, tfEndereco, tfBairro, tfCidade, ftfCep, ftfTelefone, tfUsuario, tfEmail, pwdSenha);
			}
		});
		getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 12));
		btnExcluir.setBounds(353, 79, 100, 23);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					UsuarioController uctrl = new UsuarioController();
					UsuariosHelpers uhelp = new UsuariosHelpers();
					uctrl.excluir(Integer.parseInt(tfID.getText()));
					
					uhelp.limpa(tfID, tfNome, tfEndereco, tfBairro, tfCidade, ftfCep, ftfTelefone, tfUsuario, tfEmail, pwdSenha);	
			}
		});
		getContentPane().add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Arial", Font.BOLD, 12));
		btnIncluir.setBounds(353, 113, 100, 23);
		btnIncluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				UsuariosHelpers uhelp = new UsuariosHelpers();
				UsuarioController uctrl = new UsuarioController();
				
				String senha= new String(pwdSenha.getPassword());
				if(tfNome.getText()==""){
					JOptionPane.showMessageDialog(null,"");
					if(tfEndereco.getText()==""){
					JOptionPane.showMessageDialog(null,"");
						if(tfCidade.getText().length()==0){
						JOptionPane.showMessageDialog(null,"");
							if(tfBairro.getText().length()==0){
							JOptionPane.showMessageDialog(null,"");
								
								uctrl.incluir(tfNome.getText(),tfEndereco.getText(),tfCidade.getText(), tfBairro.getText(),
										      Integer.parseInt(uhelp.cep(ftfCep.getText())),uhelp.telefone(ftfTelefone.getText()), 
											  tfEmail.getText(),tfUsuario.getText(), senha, cboTipoOperador.getSelectedItem());
											  
								uhelp.limpa(tfID, tfNome, tfEndereco, tfBairro,tfCidade, ftfCep, ftfTelefone,tfUsuario,tfEmail,pwdSenha);
							
						}
					}
				}
			}
		}});
		getContentPane().add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelar.setBounds(353, 147, 100, 23);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UsuariosHelpers uhelp = new UsuariosHelpers();
				uhelp.limpa(tfID, tfNome, tfEndereco, tfBairro,tfCidade, ftfCep, ftfTelefone,tfUsuario,tfEmail,pwdSenha);
			}
		});
		getContentPane().add(btnCancelar);
		
	}
	
}
