package swing;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Exemplo003 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Exemplo003() {
		setTitle("Layout Grid!");//ajuste JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); //container
		cp.setLayout(new GridLayout(2,3));
		for(int i=0; i<5; i++) {
			JButton b = new JButton("Botão "+ (i+1));
			cp.add(b);
		}
	}

	public static void main(String args[]) {
		new Exemplo003().setVisible(true);
	}
	
}
