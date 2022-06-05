
import java.lang.Math;
import java.util.concurrent.atomic.AtomicBoolean;


public class BackOffLock implements Lock {
	private final int MIN_DELAY = 10;
	private final int MAX_DELAY = 50;
	private AtomicBoolean state;
	
	BackOffLock(AtomicBoolean state) {
		this.state = state;
	}
	
	
	public void lock() {
		int delay = MIN_DELAY;
		
		while (true) { // repeat until not succeed			
			while(state.get()) { } // resourse-safe waiting in a loop for the state be free 
			if (!state.getAndSet(true)) // succesfully set lock and set 'true' for it's value
				return;
			try {
				Thread.sleep((int)(Math.random() * 10 + delay)); // Else: random delay if not succeed
				System.out.println("Delay: " + (int)(Math.random() * delay + delay));
			} catch (InterruptedException ex) {}
			if (delay < MAX_DELAY)
				delay *= 2; // exponentialy double the delay for the NEXT attemp to unlock for THIS THREAD
		}  
	}
	
	
	public void release() {
		state.set(false);
	}
}


interface Lock {
	void lock();
	void release();
}
