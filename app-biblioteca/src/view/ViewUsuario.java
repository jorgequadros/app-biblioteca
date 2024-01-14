package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

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

public class ViewUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfId, tfNome, tfEndereco,tfCidade, tfBairro, tfUsuario, tfEmail;
	private JFormattedTextField ftfCep, ftfTelefone;
	private JPasswordField pfSenha;
	private JTable tbConsulta;

	private JComboBox<String> cboPerfil;

	public ViewUsuario() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 900, 400);
		getContentPane().setLayout(null);
		
		JPanel pnForm = new JPanel();
		pnForm.setBounds(10, 11, 323, 348);
		getContentPane().add(pnForm);
		pnForm.setLayout(null);
		
		JLabel lbId = new JLabel("ID");
		lbId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbId.setBounds(10, 11, 25, 14);
		pnForm.add(lbId);
		
		tfId = new JTextField();
		tfId.setBounds(35, 8, 46, 20);
		pnForm.add(tfId);
		tfId.setColumns(10);
		
		JLabel lbNOme = new JLabel("Nome");
		lbNOme.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbNOme.setBounds(91, 11, 46, 14);
		pnForm.add(lbNOme);
		
		tfNome = new JTextField();
		tfNome.setBounds(126, 8, 170, 20);
		pnForm.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lbEndereco = new JLabel("Endereço");
		lbEndereco.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbEndereco.setBounds(10, 36, 48, 14);
		pnForm.add(lbEndereco);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(65, 37, 231, 20);
		pnForm.add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lbCidade = new JLabel("Cidade");
		lbCidade.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbCidade.setBounds(10, 71, 46, 14);
		pnForm.add(lbCidade);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(54, 68, 242, 20);
		pnForm.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lbBairro = new JLabel("Bairro");
		lbBairro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbBairro.setBounds(10, 102, 46, 14);
		pnForm.add(lbBairro);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(54, 99, 242, 20);
		pnForm.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lbCep = new JLabel("CEP");
		lbCep.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbCep.setBounds(10, 127, 46, 14);
		pnForm.add(lbCep);
		
		try {
			ftfCep = new JFormattedTextField(new MaskFormatter("#####-###"));
			ftfCep.setFont(new Font("Arial", Font.PLAIN, 12));
			ftfCep.setBounds(46, 127, 70, 20);
			pnForm.add(ftfCep);
		} catch (ParseException e) {
			
			System.out.println(e);
		}
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbTelefone.setBounds(126, 130, 56, 14);
		pnForm.add(lbTelefone);
		
		try {
			ftfTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
			ftfTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
			ftfTelefone.setBounds(186, 130, 80, 20);
			pnForm.add(ftfTelefone);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbUsuario.setBounds(10, 163, 46, 14);
		pnForm.add(lbUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(55, 158, 86, 20);
		pnForm.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbSenha.setBounds(156, 163, 46, 14);
		pnForm.add(lbSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(192, 160, 104, 20);
		pnForm.add(pfSenha);
		
		JLabel lbEmail = new JLabel("E-mail");
		lbEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbEmail.setBounds(10, 188, 46, 14);
		pnForm.add(lbEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(50, 185, 86, 20);
		pnForm.add(tfEmail);
		tfEmail.setColumns(10);
		
		JLabel lbPerfil = new JLabel("Perfil");
		lbPerfil.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lbPerfil.setBounds(156, 188, 36, 14);
		pnForm.add(lbPerfil);
		
		cboPerfil = new JComboBox<String>(new String[] {"Administrador", "Cliente", "Operador"});
		cboPerfil.setFont(new Font("Arial", Font.PLAIN, 12));
		cboPerfil.setBounds(213, 169, 101, 22);
		cboPerfil.setBounds(192, 188, 104, 22);
		pnForm.add(cboPerfil);
		
		JButton btnPesquisa = new JButton("Pesquisa");
		btnPesquisa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnPesquisa.setBounds(10, 248, 89, 23);
		btnPesquisa.addActionListener(new ActionListener() {
			
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
				uhelp.limpa(tfId, tfNome, tfEndereco, tfBairro, tfCidade, ftfCep, ftfTelefone, tfUsuario, tfEmail, pfSenha);
			}
		});
		pnForm.add(btnPesquisa);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAlterar.setBounds(109, 248, 89, 23);
		btnAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					UsuarioController uctrl = new UsuarioController();
					UsuariosHelpers uhelp = new UsuariosHelpers();
					String senha= new String(pfSenha.getPassword());
					uctrl.alterar(tfNome.getText(),tfEndereco.getText(),tfCidade.getText(), tfBairro.getText(),
						      Integer.parseInt(uhelp.cep(ftfCep.getText())),uhelp.telefone(ftfTelefone.getText()), 
							  tfEmail.getText(),tfUsuario.getText(), senha, cboPerfil.getSelectedItem(),tfId.getText());
					
					uhelp.limpa(tfId, tfNome, tfEndereco, tfBairro, tfCidade, ftfCep, ftfTelefone, tfUsuario, tfEmail, pfSenha);
			}
		});
		pnForm.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnExcluir.setBounds(208, 248, 89, 23);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					UsuarioController uctrl = new UsuarioController();
					UsuariosHelpers uhelp = new UsuariosHelpers();
					uctrl.excluir(Integer.parseInt(tfId.getText()));
					
					uhelp.limpa(tfId, tfNome, tfEndereco, tfBairro, tfCidade, ftfCep, ftfTelefone, tfUsuario, tfEmail, pfSenha);	
			}
		});
		pnForm.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnIncluir.setBounds(48, 292, 89, 23);
		btnIncluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				UsuariosHelpers uhelp = new UsuariosHelpers();
				UsuarioController uctrl = new UsuarioController();
				
				String senha= new String(pfSenha.getPassword());
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
											  tfEmail.getText(),tfUsuario.getText(), senha, cboPerfil.getSelectedItem());
											  
								uhelp.limpa(tfId, tfNome, tfEndereco, tfBairro,tfCidade, ftfCep, ftfTelefone,tfUsuario,tfEmail,pfSenha);
							
						}
					}
				}
			}
		}});
		pnForm.add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(158, 292, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuariosHelpers uhelp = new UsuariosHelpers();
				uhelp.limpa(tfId, tfNome, tfEndereco, tfBairro,tfCidade, ftfCep, ftfTelefone,tfUsuario,tfEmail,pfSenha);
			}
		});
		pnForm.add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 11, 531, 348);
		getContentPane().add(scrollPane);
		
		tbConsulta = new JTable();
		tbConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Telefone", "E-mail", "Endere\u00E7o", "Bairro", "Cidade", "Perfil", "CEP", "Usu\u00E1rio"
			}
		));
		tbConsulta.getColumnModel().getColumn(0).setPreferredWidth(31);
		tbConsulta.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tbConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				try {
					tfId.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 0).toString());
					tfNome.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 1).toString());
					ftfTelefone.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 2).toString());
					tfEmail.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 3).toString());
					tfEndereco.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 4).toString());
					tfBairro.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 5).toString());
					tfCidade.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 6).toString());
					cboPerfil.setSelectedItem(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 7).toString());
					ftfCep.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 8).toString());
					tfUsuario.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 9).toString());		
	
				} catch (Exception e1) {
					System.out.println(e1);
				}
					
			}
		});
		scrollPane.setViewportView(tbConsulta);
	}

}
