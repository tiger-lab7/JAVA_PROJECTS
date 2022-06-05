import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static void main(String[] args)  {
		AtomicInteger counter1 = new AtomicInteger();
		AtomicInteger counter2 = new AtomicInteger();
		
		Runnable setValue = () -> { 
			counter1.set(777);
			//try {
				//Thread.sleep(2000);
			//} catch (InterruptedException ex) { ex.printStackTrace(); }
			counter2.set(888);
			};
			
		Runnable getValue = () -> {
			int result1 = counter2.get();
			//try {
			//	Thread.sleep(2000);
			//} catch (InterruptedException ex) { ex.printStackTrace(); }
			int result2 = counter1.get();
			System.out.println(result1 + "\n" + result2);
		}; 
		
		new Thread(setValue).start();
		new Thread(getValue).start();
			
	}
	
}