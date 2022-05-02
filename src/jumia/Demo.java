package jumia;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

	public static void main(String[] args) {
		
		
		
		
		for (int i = 0; i < 5; i++) {
			Threading t = new Threading(i);
			
			//t.start();
			
			AnotherThreading at = new AnotherThreading(i);
			
			//Thread myThread = new Thread(at);
			//myThread.start();
			
			ExecutorService es = Executors.newFixedThreadPool(4);
			es.submit(at);
			es.submit(t);
		}

	}

}
