package swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Exemplo002 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Exemplo002() {
		
			setTitle("Demonstração Layout Flow!");//ajuste JFrame
			setSize(200, 150);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container cp = getContentPane(); //container
			cp.setLayout(new FlowLayout());
			for(int i=0; i<5; i++) {
				JButton b = new JButton("Botão "+ (i+1));
				cp.add(b);
			}
	}

	public static void main(String args[]) {
		new Exemplo002().setVisible(true);
	}
}
