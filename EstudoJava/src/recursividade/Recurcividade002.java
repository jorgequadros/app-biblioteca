package recursividade;

public class Recurcividade002 {

	public Recurcividade002() {
		super();
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 10; i++) {
			
			System.out.print(fibonacci(i)+" ");
		}
	}

	public static int fibonacci(int num) {
		if(num<2) {return 1;}
		return fibonacci(num-1)+fibonacci(num-2);	
	}
	
	public static void main(String[] args) {
		new Recurcividade002();
	}
}
