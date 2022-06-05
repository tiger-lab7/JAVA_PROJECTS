import java.lang.Runnable;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static void main(String... args) {
		Work work = new Work();
		work.start();		
	}
}

class Work {
	
	private AtomicInteger counter = new AtomicInteger();
	
	Runnable task1 = () -> {
			synchronized(counter) {
					for (int i = 0; i < 25; i++) {
							counter.set(i);
							
							try {
								Thread.sleep(50);
								counter.wait();
							} catch (InterruptedException ex) { ex.printStackTrace(); }
							
							System.out.println(counter.get());
					}
			}
		};
		
		Runnable task2 = () -> {
			for (int i = 0; i < 10; i++) {
				counter.set(777);
				System.out.println("Set 777!");
				counter.notify();
				try {
					Thread.sleep(50);
				} catch (InterruptedException ex) { ex.printStackTrace(); }
				
			}
			
		};
		
		public void start() {
			new Thread(task1).start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) { ex.printStackTrace(); }
			new Thread(task2).start();
		}
}

