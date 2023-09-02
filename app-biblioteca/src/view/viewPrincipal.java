package view;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewPrincipal window = new viewPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(desktop);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 22);
		desktop.add(menuBar);
		
		JMenu mnuCadastro = new JMenu("Cadastro");
		menuBar.add(mnuCadastro);
		
		JMenuItem mnuItemCadCategorias = new JMenuItem("Categorias");
		mnuItemCadCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							viewCategorias frame = new viewCategorias();
							frame.setVisible(true);
							desktop.add(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnuCadastro.add(mnuItemCadCategorias);
		
		JMenuItem mnuItemCadLivros = new JMenuItem("Livros");
		mnuCadastro.add(mnuItemCadLivros);
		
		JMenuItem mnuItemCadUsuario = new JMenuItem("Usuários");
		mnuCadastro.add(mnuItemCadUsuario);
		
		JMenu MnuConsulta = new JMenu("Consulta");
		menuBar.add(MnuConsulta);
		
		JMenuItem ItemMnuConsCategoria = new JMenuItem("Categorias");
		ItemMnuConsCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							viewConsCategorias frame = new viewConsCategorias();
							frame.setVisible(true);
							desktop.add(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		MnuConsulta.add(ItemMnuConsCategoria);
		
		JMenu mnuMovimentacao = new JMenu("Movimentação");
		menuBar.add(mnuMovimentacao);
		
		JMenuItem mnuItemEmprestimos = new JMenuItem("Emprestimos");
		mnuMovimentacao.add(mnuItemEmprestimos);
	}
}
