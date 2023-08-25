package swing;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import swing.model.ProdutoM;
import swing.model.ProdutosMDAO;

public class TabelaSwing004 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  JTable tabela;
	
	public static void main(String[] args) {
		new TabelaSwing004().setVisible(true);;
	}
	
	public TabelaSwing004() throws HeadlessException {
		setTitle("Tabela com BD!");
		setSize(500, 200);
		setLayout(new FlowLayout());
		tabela = new JTable();
		tabela.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Descrição", "qtde", "preço"
				}
		));
		
		add(new JScrollPane(tabela));
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		tabela.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		try {
			lerTabela();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void lerTabela() throws IOException, SQLException {
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		modelo.setNumRows(0);
		ProdutosMDAO pdao = new ProdutosMDAO();
		
		for(ProdutoM p: pdao.read()) {
			modelo.addRow(new Object[] {
					p.getId(),
					p.getDescricao(),
					p.getQtde(),
					p.getValor()
					});
			
		}
	}

	
	
}
