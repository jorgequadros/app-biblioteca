package PesquisaTeste.exemplos.src.threads;
//Fig. 23.4: PrintTask.java
//Classe PrintTask dorme por um tempo aleatório de 0 a 5 segundos
import java.util.Random;

public class PrintTask implements Runnable{
	private int sleepTime;//tempo de adormecimento aleatório para a thread 
	private String threadName;//Nome da thread
	private static Random generator = new Random();
	
	//atribui nome à thread
	public PrintTask(String name) {
		this.threadName = name;//configura nome da thread
		sleepTime = generator.nextInt(5000);//seleciona tempo de adormecimento
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.printf("%s going to sleep for %d milliseconds. \n", threadName,sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s done sleeping\n",threadName);
	}

}
