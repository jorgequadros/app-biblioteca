package swing;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
//layout nula
public class Exemplo001 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Exemplo001(){
		setTitle("Layout Nula!");//ajuste JFrame
		setSize(200, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane(); //container
		cp.setLayout(null);
		for(int i=0; i<5; i++) {
			JButton b = new JButton("Botão "+ (i+1));
			b.setBounds(10+i*90, 30, 80, 20);//x,y,larg,alt
			cp.add(b);
		}
	}
	
	public static void main(String args[]) {
		new Exemplo001().setVisible(true);
	}
}
