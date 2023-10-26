package view;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.LivrosController;
import helpers.LivrosHelpers;
import model.Categorias;
import model.CategoriasDAO;

@SuppressWarnings("serial")
public class ViewConsLivros extends JInternalFrame {
	private JTextField tfId;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextArea taAssunto;
	private JFormattedTextField tfDataAquisicao;
	private JComboBox<Categorias> cboCategorias;
	private JTable tbConsulta;
	private DefaultComboBoxModel<Categorias> ModelCombo;
	/**
	 * Launch the application.
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
		
		tfTitulo = new JTextField(50);
		tfTitulo.setBounds(46, 26, 173, 20);
		pnFormulario.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 52, 46, 14);
		pnFormulario.add(lblAutor);
		
		tfAutor = new JTextField(50);
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
		
		cboCategorias.removeAll();
		CategoriasDAO cdao = new CategoriasDAO();
		
		ModelCombo=(DefaultComboBoxModel<Categorias>) this.cboCategorias.getModel();
		for(Categorias c: cdao.pesquisaTodos("select * from categorias")) {
			ModelCombo.addElement(c);
		}
		
		pnFormulario.add(cboCategorias);
		
		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(10, 147, 46, 14);
		pnFormulario.add(lblAssunto);
		
		JScrollPane spTaAssunto = new JScrollPane();
		spTaAssunto.setBounds(10, 161, 209, 62);
		pnFormulario.add(spTaAssunto);
		
		taAssunto = new JTextArea();
		spTaAssunto.setViewportView(taAssunto);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.setBounds(229, 26, 89, 23);
		btnPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					if(tfTitulo.getText().length()>0) {
						LivrosController lctrl = new LivrosController();
						lctrl.pesquisaPorCampo(tfTitulo.getText(),tbConsulta);
					}else {
						LivrosController lctrl = new LivrosController();
						lctrl.pesquisaTodos(tbConsulta);
					}
				}
					
		});
		pnFormulario.add(btnPesquisa);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(229, 53, 89, 23);
		btnAlterar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//seleciona o item Jcombobox e passando para um objeto
				Categorias c = (Categorias) cboCategorias.getSelectedItem();
											
						if(tfId.getText().length()==0) {
							JOptionPane.showMessageDialog(null, "Campos ID Vazio!!");
						}else if(tfAutor.getText().length()==0){
								JOptionPane.showMessageDialog(null, "Campos Autor Vazio!!");
							}else if(taAssunto.getText().length()==0) {
									JOptionPane.showMessageDialog(null, "Campos Assunto Vazio!!");
								}else if(tfDataAquisicao.getText().length()==0) {
									JOptionPane.showMessageDialog(null, "Campos Data Aquisição Vazio!!");
									}else if(tfTitulo.getText().length()==0) {
										JOptionPane.showMessageDialog(null, "Campos Obs Vazio!!");
										}else {
											LivrosHelpers lhelp = new LivrosHelpers();
											LivrosController lctrl = new LivrosController();
											lctrl.alterar(tfTitulo.getText(), tfAutor.getText(), c.getId(),taAssunto.getText(), lhelp.convertDataBD(tfDataAquisicao.getText()),tfId.getText());
											lhelp.limpaCampos(tfAutor,tfId,tfTitulo,tfDataAquisicao,taAssunto);
											JOptionPane.showMessageDialog(null, "Registro Atualizado com sucesso!!");
										}
					
				}
		});
		pnFormulario.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(229, 87, 89, 23);
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos ID Vazio!!");
				}else {
					LivrosHelpers lhelp = new LivrosHelpers();
					LivrosController lctrl = new LivrosController();
					lctrl.excluir(Integer.parseInt(tfId.getText()));
					JOptionPane.showMessageDialog(null, "Registro Excluido com sucesso!!");
					lhelp.limpaCampos(tfAutor,tfId,tfTitulo,tfDataAquisicao,taAssunto);
				}
			}
		});
		pnFormulario.add(btnExcluir);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(229, 116, 89, 23);
		btnIncluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Categorias c = (Categorias) cboCategorias.getSelectedItem();
				
				if(tfAutor.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Campos Autor Vazio!!");
					}else if(taAssunto.getText().length()==0) {
							JOptionPane.showMessageDialog(null, "Campos Assunto Vazio!!");
						}else if(tfDataAquisicao.getText().length()==0) {
							JOptionPane.showMessageDialog(null, "Campos Data Aquisição Vazio!!");
							}else if(tfTitulo.getText().length()==0) {
								JOptionPane.showMessageDialog(null, "Campos Obs Vazio!!");
								}else {
									LivrosHelpers lhelp = new LivrosHelpers();
									LivrosController lctrl = new LivrosController();
									lctrl.incluir(tfTitulo.getText(), c.getId(), tfAutor.getText(), lhelp.convertDataBD(tfDataAquisicao.getText()), taAssunto.getText());
									JOptionPane.showMessageDialog(null, "Registro Incluido com sucesso!!");
									lhelp.limpaCampos(tfAutor,tfId,tfTitulo,tfDataAquisicao,taAssunto);
								}
			}
		});
		pnFormulario.add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(229, 144, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LivrosHelpers lhelp = new LivrosHelpers();
				lhelp.limpaCampos(tfAutor,tfId,tfTitulo,tfDataAquisicao,taAssunto);
			}
		});
		pnFormulario.add(btnCancelar);
		
		JScrollPane spTbConsulta = new JScrollPane();
		spTbConsulta.setBounds(347, 11, 525, 231);
		getContentPane().add(spTbConsulta);
		
		tbConsulta = new JTable();
		tbConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Boolean tabela =tbConsulta.isEditing();
				try {
					tfId.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 0).toString());
					tfTitulo.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 1).toString());
					tfAutor.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 2).toString());
					tfDataAquisicao.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 6).toString());
					ModelCombo.setSelectedItem(tbConsulta.getValueAt(tbConsulta.getSelectedRow(),4));
					
					if(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 5).toString().length()>0) {
						taAssunto.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 5).toString());
					}else{
						taAssunto.setText("");
						
					};
					String Id = tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 0).toString();
					String Livro = tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 1).toString();
					if (tabela==false) {
						JOptionPane.showMessageDialog(null, "Id : " + Id +" Titulo : " + Livro);
					} 
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					new Throwable(e1);
				}
			}
		});
		tbConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "Autor", "ID Categoria","Categoria", "Assunto", "Data Compra"
			}
		));
		spTbConsulta.setViewportView(tbConsulta);

	}
	
}
