package PesquisaTeste.exemplos.src.comp.JList;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JLista extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JLabel lbPesquisar;
	JTextField tfPesquisar;
	JList<String> lista;
	
	public JLista() throws HeadlessException, SQLException {
		super("Utilizando JList!!");
		
		setLayout(new BorderLayout());
		
		DefaultListModel<String> modelo =  new DefaultListModel<>();
		try {
			ConexaoBD.getInstance();
			Connection con = ConexaoBD.getConexao();
			PreparedStatement stmt = con.prepareStatement("select nome from fornecedor");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				modelo.addElement(rs.getString("nome"));
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		lista = new JList<>(modelo);
		lista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				String item = lista.getSelectedValue();
				tfPesquisar.setText(item);
				
			}
		});
		
		JPanel p = new JPanel();
		
		lbPesquisar = new JLabel("Pesquisar Por Nome:");
		tfPesquisar = new JTextField(30);
			
		
		p.add(lbPesquisar);
		p.add(tfPesquisar);
		p.add(new JScrollPane(lista));
		
		add(p);
	}
	
	public static void main(String[] args) throws HeadlessException, SQLException {
		JLista lista = new JLista();
		lista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lista.setVisible(true);
		lista.setResizable(false);
		lista.setSize(300,250);
				
	}

	
	
	
	
	
	
}
