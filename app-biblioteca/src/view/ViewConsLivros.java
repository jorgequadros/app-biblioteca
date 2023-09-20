package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import control.Categorias;
import control.Livros;
import model.CategoriasDAO;
import model.IntJanelas;
import model.LivrosDAO;

@SuppressWarnings("serial")
public class ViewConsLivros extends JInternalFrame implements IntJanelas{
	private JTextField tfId;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JFormattedTextField tfDataAquisicao;
	private JComboBox<Categorias> cboCategorias;
	private JTable tbConsulta;

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
		//super("Consulta Livros!",true,true,false,true);//(redimensionar, fechar, maximizar, iconificar)
		setIconifiable(true);
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
		tfId.setColumns(10);
		tfId.setEnabled(false);
		pnFormulario.add(tfId);
		
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
		
		try {
			tfDataAquisicao = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfDataAquisicao.setBounds(10, 116, 83, 20);
		pnFormulario.add(tfDataAquisicao);
		
		JLabel lblCategoria = new JLabel("Categorias");
		lblCategoria.setBounds(103, 102, 75, 14);
		pnFormulario.add(lblCategoria);
		
		cboCategorias = new JComboBox<Categorias>();
		cboCategorias.setBounds(103, 115, 116, 22);
		
		CategoriasDAO cdao = new CategoriasDAO();
		List<Categorias> lista = cdao.pesquisa("select * from categorias");
		cboCategorias.removeAll();
		
		for(Categorias c:lista) {
			cboCategorias.addItem(c);
		}
				
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
		btnPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					if(tfTitulo.getText().length()>0) {
						pesquisaPorCampo(tfTitulo.getText());
					}else {
						pesquisaTodos();
					}
				}
				
			
		});
		pnFormulario.add(btnPesquisa);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(229, 53, 89, 23);
		pnFormulario.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(229, 87, 89, 23);
		pnFormulario.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(229, 116, 89, 23);
		btnIncluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Categorias c = (Categorias) cboCategorias.getSelectedItem();
								
				LivrosDAO ldao = new LivrosDAO();
				ldao.incluir("INSERT INTO livros (titulo, id_categoria, autor, dtAquisicao, assunto) values(?,?,?,?,?)", tfTitulo.getText(), c.getId(), tfAutor.getText(), convertDataBD(tfDataAquisicao.getText()), taAssunto.getText());
			}
		});
		pnFormulario.add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(229, 144, 89, 23);
		pnFormulario.add(btnCancelar);
		
		JScrollPane spTbConsulta = new JScrollPane();
		spTbConsulta.setBounds(347, 11, 525, 231);
		getContentPane().add(spTbConsulta);
		
		tbConsulta = new JTable();
		tbConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "Autor", "Categoria", "Assunto", "Data Compra"
			}
		));
		spTbConsulta.setViewportView(tbConsulta);

	}
	
		
	public String convertDataBD(String data) {
		String dia =data.substring(0, 2);
		String mes =data.substring(3, 5);
		String ano =data.substring(6, 10);
		String convertData = ano+"-"+mes+"-"+dia;
		return convertData;
	}
	
	
	public void pesquisaTodos() {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		LivrosDAO ldao = new LivrosDAO();
		
		for(Livros l: ldao.pesquisa("select * from livros")) {
				modelo.addRow(new Object[] {
						l.getId(),
						l.getAssunto(),
						l.getAutor(),
						l.getId_categoria(),
						l.getTitulo(),
						l.getDtAquisicao()	 
				});
		}
	}

	public void pesquisaPorCampo(String consulta) {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		LivrosDAO ldao = new LivrosDAO();
		
		for(Livros l: ldao.pesquisa("select * from livros where titulo like '"+consulta+"%'")) {
			modelo.addRow(new Object[] {
					l.getId(),
					l.getAssunto(),
					l.getAutor(),
					l.getId_categoria(),
					l.getTitulo(),
					l.getDtAquisicao()
					});
			
		}
	}
	
}
