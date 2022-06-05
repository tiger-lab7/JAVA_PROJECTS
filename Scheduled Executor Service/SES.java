import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.Runnable;

public class SES {
	private static AtomicInteger counter = new AtomicInteger(0);
	
	public static void main(String... args) {
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
		
		Runnable task = () -> {
			System.out.println("HI THERE! " + Thread.currentThread().getName());
			try {
				Thread.sleep(2500);
			} catch (InterruptedException ex) {}
			if (counter.getAndIncrement() > 10)
				System.exit(0);
		};
		
		//ses.scheduleWithFixedDelay(task, 0, 5, TimeUnit.SECONDS);
		ses.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
	}
}