package thread3;

public class App {
	private int count = 0;
	
	public synchronized void increment(){
		count++;
	}
	public  static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.doWord();
	}
	
	public void doWord(){
		
			Thread t1 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(int i = 0; i < 10000; i++){
						//count++;   // count = count + 1;  
						increment();
					}
				}
			});
			Thread t2 = new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(int i = 0; i < 10000; i++){
						//count++;     
						increment();  //10002 count
					}
				}
			});
			t1.start();
			t2.start();

			System.out.println("count now is: " + count);
			
			try {
				t1.join();// waiting untill the thread is finished	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			System.out.println("when thread is finished, count now is: " + count);   
			// why result is not 20000?  two thread start at the same time, sync problem
			
	}

}
