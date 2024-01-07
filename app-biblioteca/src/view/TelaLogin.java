package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.TelaLoginController;
import model.Usuario;
import model.UsuariosDAO;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	String nome;
	String perfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setTitle("Login de Usuário");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		lbUsuario.setBounds(49, 42, 89, 14);
		contentPane.add(lbUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		tfUsuario.setBounds(49, 59, 128, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lbSenha.setBounds(49, 90, 46, 14);
		contentPane.add(lbSenha);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Arial", Font.ITALIC, 14));
		pfSenha.setBounds(49, 109, 134, 20);
		contentPane.add(pfSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoginController tctrl = new TelaLoginController();
				if (tfUsuario.getText().length()==0) {
					JOptionPane.showMessageDialog(TelaLogin.this, "Campo usuário Vázio!!", "Campo vazio", JOptionPane.INFORMATION_MESSAGE);
				}else if(pfSenha.getPassword().length==0){
					JOptionPane.showMessageDialog(TelaLogin.this, "Campo Senha Vázio!!", "Campo vazio", JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(tctrl.login(tfUsuario.getText(), new String(pfSenha.getPassword()))) {
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									UsuariosDAO udao = new UsuariosDAO();
									
									for(Usuario u: udao.pesquisa("select * from usuarios where usuario=?", tfUsuario.getText())) {
										nome=u.getNome();
										perfil=u.getTipousuario();
										System.out.println("Nome Usuario: " +nome);
										System.out.println("Perfil: "+perfil);
									}
									ViewPrincipal window = new ViewPrincipal();
									window.setVisible(true);
									window.lbNome.setText(nome);
									window.lbTipo.setText(perfil);
									if(perfil.equals("Administrador")){
										window.mnItemCategorias.setEnabled(true);
										window.mnuItemLivros.setEnabled(true);
										window.mnuItemUsuarios.setEnabled(true);
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						dispose();
					}else {
						
						JOptionPane.showMessageDialog(TelaLogin.this,"Senha ou usuário errado!!","Usuário não encontrado!!", JOptionPane.INFORMATION_MESSAGE);
					};
				}
				
			}
		});
		btnLogar.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogar.setBounds(234, 89, 104, 40);
		contentPane.add(btnLogar);
	}
}
