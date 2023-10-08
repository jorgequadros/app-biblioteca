package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Categorias;
import model.CategoriasDAO;
import model.IntJanelas;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class viewConsCategorias extends JInternalFrame implements IntJanelas{
	private JTextField tfDescricao;
	private JTable tbConsulta;
	private JTextField tfID;
	private JTextArea taObs;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * viewConsCategorias frame = new viewConsCategorias(); frame.setVisible(true);
	 * } catch (Exception e) { e.printStackTrace(); } } });
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public viewConsCategorias() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 740, 210);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 353, 151);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(64, 11, 59, 14);
		panel.add(lblDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setBounds(62, 27, 187, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);

		JLabel btnObs = new JLabel("Obs");
		btnObs.setBounds(10, 57, 46, 14);
		panel.add(btnObs);
		
		JScrollPane spTaObs = new JScrollPane();
		spTaObs.setBounds(10, 73, 241, 69);
		panel.add(spTaObs);
		
		taObs = new JTextArea();
		spTaObs.setViewportView(taObs);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfDescricao.getText().length()>0) {
					pesquisaPorCampo(tfDescricao.getText());
				}else {
					pesquisaTodos();
				}
			}
		});
		btnPesquisar.setBounds(260, 2, 92, 25);
		panel.add(btnPesquisar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfID.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Campos ID Vazio!!");
				}else if(tfDescricao.getText().length()==0){
						JOptionPane.showMessageDialog(null, "Campos Descrição Vazio!!");
					}else if(taObs.getText().length()==0) {
							JOptionPane.showMessageDialog(null, "Campos Obs Vazio!!");
						}else {
							CategoriasDAO c =new CategoriasDAO();
							c.alterar("update categorias "
									+ "set descricao=?, "
									+ "obs=?"
									+ " where id=?;", tfDescricao.getText(), taObs.getText(), tfID.getText());
						}
				limpaCampos();
				} 
		});
		
		btnAlterar.setBounds(260, 30, 92, 25);
		panel.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfID.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Campos ID Vazio!!");
				}else if(tfDescricao.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Campos Descrição Vazio!!");
				}else if(taObs.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Campos Obs Vazio!!");
				}else {
					CategoriasDAO c =new CategoriasDAO();
					c.excluir("delete from categorias where id=?", tfID.getText());
				}
				limpaCampos();
			}
		});
		
		btnExcluir.setBounds(260, 60, 92, 25);
		panel.add(btnExcluir);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfDescricao.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Campos Descrição Vazio!!");
					
				}else if(taObs.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Campos Obs Vazio!!");
				}else {
					CategoriasDAO cdao = new CategoriasDAO();
					cdao.incluir("INSERT INTO categorias (descricao, obs) values(?,?)", tfDescricao.getText(),
							taObs.getText());
					JOptionPane.showMessageDialog(null, "Incluido com sucesso!!");
				}
				limpaCampos();
			}
		});
		btnIncluir.setBounds(260, 90, 92, 25);
		panel.add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(260, 120, 92, 25);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				limpaCampos();
			}
		});
		panel.add(btnCancelar);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 46, 14);
		panel.add(lblId);
		
		tfID = new JTextField();
		tfID.setEnabled(false);
		tfID.setBounds(10, 27, 46, 20);
		
		panel.add(tfID);
		tfID.setColumns(10);
					
		JScrollPane spnTableConsulta = new JScrollPane();
		spnTableConsulta.setBounds(373, 11, 340, 151);
		getContentPane().add(spnTableConsulta);

		tbConsulta = new JTable();
		tbConsulta.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Boolean tabela =tbConsulta.isEditing();
				try {
					tfID.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 0).toString());
					tfDescricao.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 1).toString());
					
					if(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 2).toString().length()>0) {
						taObs.setText(tbConsulta.getValueAt(tbConsulta.getSelectedRow(), 2).toString());
					}else{
						taObs.setText("");
						
					};
					
					if (tabela==false) {
						JOptionPane.showMessageDialog(null, "Tabela não pode!!");
					} 
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					new Throwable(e1);
				}
			}
		});
		tbConsulta.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Descri\u00E7\u00E3o", "Obs" }));
		spnTableConsulta.setViewportView(tbConsulta);
		
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		tbConsulta.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		//pesquisaTodos();

	}
		
	public void pesquisaTodos() {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		CategoriasDAO cdao = new CategoriasDAO();
		
		for(Categorias c: cdao.pesquisaTodos("select * from categorias")) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getDescricao(),
					c.getObs()
					});
			
		}
	}

	public void pesquisaPorCampo(String consulta) {
		// TODO Auto-generated method stub
		DefaultTableModel modelo = (DefaultTableModel) tbConsulta.getModel();
		modelo.setNumRows(0);
		CategoriasDAO cdao = new CategoriasDAO();
		
		for(Categorias c: cdao.pesquisa("select * from categorias where descricao like ?;", consulta)) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getDescricao(),
					c.getObs()
					});
			
		}
	}
	
	public void limpaCampos() {
		tfDescricao.setText("");
		tfID.setText("");
		taObs.setText("");
	}
}
