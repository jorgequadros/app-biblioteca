package swing;

	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.SwingUtilities;

	public class TabelaSwing001 extends JFrame{

	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private  JTable tabela;
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
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(()->{new TabelaSwing001().setVisible(true);});
			
		}

		public TabelaSwing001() {
			super();
			
			setTitle("Tabela com BD!");
			tabela = new JTable(dados,colunas);
			getContentPane().add(new JScrollPane(tabela), "Center");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(500, 200);
					
		}
		
	}


