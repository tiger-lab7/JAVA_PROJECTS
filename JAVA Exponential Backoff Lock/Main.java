import java.util.concurrent.atomic.AtomicBoolean;
import java.lang.Runnable;
import java.lang.Thread;

public class Main {
	static final AtomicBoolean state =  new AtomicBoolean(false); // Lock primitive object with an initial value
	
	public static void main(String... args) {
		
		Runnable task = () -> {
			BackOffLock bOLock = new BackOffLock(state);
			bOLock.lock();
			System.out.println("Lock grabbed! Thread: " + Thread.currentThread().getName());
			bOLock.release();
		};
		
		for (int i = 0; i < 50; i++)
			new Thread(task).start();
		
	}
}