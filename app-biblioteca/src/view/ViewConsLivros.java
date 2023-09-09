package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Categorias;
import model.CategoriasDAO;

@SuppressWarnings("serial")
public class ViewConsLivros extends JInternalFrame {
	private JTextField tfId;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JComboBox cboCategorias;
	private JTable consulta;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewConsLivros frame = new
	 * ViewConsLivros(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ViewConsLivros() {
		setIconifiable(true);
		//super("Consulta Livros!",true,true,false,true);//(redimensionar, fechar, maximizar, iconificar)
		setClosable(true);
		setBounds(100, 100, 910, 300);
		getContentPane().setLayout(null);
		
		JPanel pnFormulario = new JPanel();
		pnFormulario.setBounds(10, 11, 327, 231);
		getContentPane().add(pnFormulario);
		pnFormulario.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		pnFormulario.add(lblId);
		
		tfId = new JTextField();
		tfId.setBounds(10, 26, 33, 20);
		pnFormulario.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(47, 11, 46, 14);
		pnFormulario.add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(46, 26, 173, 20);
		pnFormulario.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 52, 46, 14);
		pnFormulario.add(lblAutor);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(10, 71, 209, 20);
		pnFormulario.add(tfAutor);
		tfAutor.setColumns(10);
		
		JLabel lblDtAquisicao = new JLabel("Data Aquisição");
		lblDtAquisicao.setBounds(10, 102, 83, 14);
		pnFormulario.add(lblDtAquisicao);
		
		JFormattedTextField tfDataAquisicao = new JFormattedTextField();
		tfDataAquisicao.setBounds(10, 116, 83, 20);
		pnFormulario.add(tfDataAquisicao);
		
		JLabel lblCategoria = new JLabel("Categorias");
		lblCategoria.setBounds(103, 102, 75, 14);
		pnFormulario.add(lblCategoria);
		
		cboCategorias = new JComboBox<Categorias>();
		cboCategorias.setBounds(103, 115, 116, 22);
		cboCategorias.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				carregaJCombo();
				
			}
		});
		pnFormulario.add(cboCategorias);
		
		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(10, 147, 46, 14);
		pnFormulario.add(lblAssunto);
		
		JScrollPane spTaAssunto = new JScrollPane();
		spTaAssunto.setBounds(10, 161, 209, 62);
		pnFormulario.add(spTaAssunto);
		
		JTextArea taAssunto = new JTextArea();
		spTaAssunto.setViewportView(taAssunto);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.setBounds(229, 26, 89, 23);
		pnFormulario.add(btnPesquisa);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(229, 53, 89, 23);
		pnFormulario.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(229, 87, 89, 23);
		pnFormulario.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(229, 116, 89, 23);
		pnFormulario.add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(229, 144, 89, 23);
		pnFormulario.add(btnCancelar);
		
		JScrollPane spTbConsulta = new JScrollPane();
		spTbConsulta.setBounds(347, 11, 525, 231);
		getContentPane().add(spTbConsulta);
		
		consulta = new JTable();
		consulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "Autor", "Categoria", "Assunto", "Data Compra"
			}
		));
		spTbConsulta.setViewportView(consulta);

	}
	
	private void carregaJCombo() {
		CategoriasDAO cdao = new CategoriasDAO();
		List<Categorias> categorias = cdao.pesquisaTodos("select * from categorias");
		
		cboCategorias.removeAll();
		
		for(Categorias c: categorias) {
			cboCategorias.addItem(c);
		}
		
	}
}
