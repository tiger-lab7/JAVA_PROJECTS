import java.lang.ThreadLocal;
import java.lang.Runnable;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static void main(String[] args) {
		final String[] names = new String[] {"CAT BARSIK", "CAT SNEJOK", "CAT PUSHOK", "CAT VASILEK"};
		AtomicInteger counter = new AtomicInteger(0);
		
		
		Runnable task = () -> {
				ThreadLocal<String> threadName = new ThreadLocal<>();
				threadName.set(Thread.currentThread().getName());
				
				ThreadLocal<String> outerName = new ThreadLocal<>();
				outerName.set(names[counter.getAndIncrement()]);
				
				System.out.println(threadName.get() + " " + outerName.get());
		};
		
		for (String name : names)
			new Thread(task).start();
	} 
	
}