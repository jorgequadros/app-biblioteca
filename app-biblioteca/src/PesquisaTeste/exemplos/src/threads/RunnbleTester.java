package PesquisaTeste.exemplos.src.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnbleTester {

	public static void main(String[] args) {
		PrintTask task1 = new PrintTask("thread1");
		PrintTask task2 = new PrintTask("thread2");
		PrintTask task3 = new PrintTask("thread3");
		System.out.println("Inciando Processos!!");
		
		ExecutorService threadsExecutor = Executors.newFixedThreadPool(3);
		
		threadsExecutor.execute(task1);
		threadsExecutor.execute(task2);
		threadsExecutor.execute(task3);
		
		threadsExecutor.shutdown();
		
		System.out.println("Threads Iniciados,no fim main.\n");
	}
}
