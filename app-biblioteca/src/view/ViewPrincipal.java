package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lbNome,lbTipo;
	
	public JMenuItem mnItemCategorias, mnuItemUsuarios, mnuItemLivros;

	

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 24, 825, 548);
		contentPane.add(desktop);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 984, 22);
		contentPane.add(menuBar);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mnItemCategorias = new JMenuItem("Categorias");
		mnItemCategorias.setEnabled(false);
		mnItemCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewConsCategorias frame = new ViewConsCategorias();
							frame.setVisible(true);
							desktop.add(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnConsulta.add(mnItemCategorias);
		
		mnuItemLivros = new JMenuItem("Livros");
		mnuItemLivros.setEnabled(false);
		mnuItemLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewConsLivros frame = new ViewConsLivros();
							frame.setVisible(true);
							desktop.add(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnConsulta.add(mnuItemLivros);
		
		mnuItemUsuarios = new JMenuItem("Usuarios");
		mnuItemUsuarios.setEnabled(false);
		mnuItemUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewUsuario frame = new ViewUsuario();
							frame.setVisible(true);
							desktop.add(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnConsulta.add(mnuItemUsuarios);
		
		JMenu mnuMovimentacao = new JMenu("Movimentação");
		menuBar.add(mnuMovimentacao);
		
		JMenuItem mnuItemEmprestimo = new JMenuItem("Emprestimo");
		mnuItemEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ViewEmprestimo frame = new ViewEmprestimo();
							frame.setVisible(true);
							desktop.add(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnuMovimentacao.add(mnuItemEmprestimo);
		
		JMenu mnuSobre = new JMenu("Ajuda");
		menuBar.add(mnuSobre);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sobre");
		mnuSobre.add(mntmNewMenuItem);
	
		JLabel lbNomeUsuario = new JLabel("Nome do Usuário");
		lbNomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbNomeUsuario.setBounds(835, 33, 127, 32);
		contentPane.add(lbNomeUsuario);
		
		
		lbNome = new JLabel("");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNome.setBounds(835, 76, 127, 14);
		contentPane.add(lbNome);
		
		JLabel lbTipoUsuario = new JLabel("Tipo de Usuário");
		lbTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTipoUsuario.setBounds(835, 101, 127, 14);
		contentPane.add(lbTipoUsuario);
		
		lbTipo = new JLabel("");
		lbTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTipo.setBounds(835, 126, 110, 14);
		contentPane.add(lbTipo);
		
		JLabel lbDataSistema = new JLabel("Data");
		lbDataSistema.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbDataSistema.setBounds(835, 151, 46, 14);
		contentPane.add(lbDataSistema);
		
		Date data =new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
		JLabel lbDataAtual = new JLabel(formatador.format(data));
		lbDataAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDataAtual.setBounds(835, 176, 110, 14);
		contentPane.add(lbDataAtual);
	}
}
