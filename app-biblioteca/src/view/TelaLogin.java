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

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	

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
		tfUsuario.setFont(new Font("Arial", Font.ITALIC, 14));
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
				if(tctrl.login(tfUsuario.getText(), new String(pfSenha.getPassword()))) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								ViewPrincipal window = new ViewPrincipal();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Senha ou usuário errado!!");
				};
			}
		});
		btnLogar.setFont(new Font("Arial", Font.BOLD, 14));
		btnLogar.setBounds(225, 39, 104, 40);
		contentPane.add(btnLogar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setBounds(225, 89, 104, 40);
		contentPane.add(btnCancelar);
	}
}
