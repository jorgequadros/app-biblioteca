package swing;

import javax.swing.table.AbstractTableModel;

public class TableModel001 extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Nomes das colunas da tabela
	private String[] colunas = { "Símb", "Nome", "NAtom", "M Atom", "M Espec" };
		// Dados da tabela
	private Object[][] dados = { 
				{ "He", "Hélio", Integer.valueOf(2), Double.valueOf(4.0026), Double.valueOf(0.179) },
				{ "Ne", "Neônio", Integer.valueOf(10), Double.valueOf(20.17), Double.valueOf(0.90) },
				{ "Ar", "Argônio", Integer.valueOf(18), Double.valueOf(39.94), Double.valueOf(1.78) },
				{ "Kr", "Criptônio", Integer.valueOf(36), Double.valueOf(83.80), Double.valueOf(3.7) },
				{ "Xe", "Xenônio", Integer.valueOf(54), Double.valueOf(131.30), Double.valueOf(5.85) },
				{ "Rd", "Radônio", Integer.valueOf(86), Double.valueOf(222), Double.valueOf(9.73) }
		};
	@Override
	public int getRowCount() {return dados.length;}
	@Override
	public int getColumnCount() {return colunas.length;	}
	@Override
	public Object getValueAt(int lin, int col) {return dados[lin][col];}
	
	public String getColumnName(int col) {return colunas[col];}
	public boolean isCellEditable(int lin, int col) {return false;}
	public Class<? extends Object> getColumnClass(int col) {return getValueAt(0, col).getClass();}
	
}
