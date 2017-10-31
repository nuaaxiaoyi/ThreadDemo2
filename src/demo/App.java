package demo;

import java.util.Scanner;

class Processor extends Thread {
	
	private volatile boolean running = true;
	public void run(){
		while(running){
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}
	
	
}



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Processor p1 = new Processor();
		
		p1.start();  // first thread
					// the second thread is the main()
		
		System.out.println("press return to stop....");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		p1.shutdown();
	}

}
