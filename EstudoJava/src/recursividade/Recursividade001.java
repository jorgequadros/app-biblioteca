package recursividade;
//fatoral
public class Recursividade001 {

	public Recursividade001() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(fatorial(5));
	}
	
	public static int fatorial(int num) {
		if(num==0) {return 1;};
		return num* fatorial(num-1);
	}
	
	public static void main(String[] args) {
		new Recursividade001();
	}
	
}
