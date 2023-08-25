package swing;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Exemplo004 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Exemplo004() {
		setTitle("Layout Grid!");//ajuste JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); //container
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		cp.add(new JButton("Botão 1"));
		cp.add(new JButton("Botão 2"));
		cp.add(new JButton("Botão 3 Diferente"));
		cp.add(new JButton("Botão 4"));
		cp.add(new JButton("Botão 5"));
		
	}

	public static void main(String args[]) {
		new Exemplo004().setVisible(true);
	}
	
}
