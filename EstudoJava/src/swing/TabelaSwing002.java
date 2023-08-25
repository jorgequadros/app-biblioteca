package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TabelaSwing002 extends JFrame{
	private  JTable tabela;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{new TabelaSwing002().setVisible(true);});
		
	}

	public TabelaSwing002() {
		super();
		
		setTitle("Tabela com Table Model!");
		tabela = new JTable(new TableModel001());
		getContentPane().add(new JScrollPane(tabela), "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
				
	}
}
