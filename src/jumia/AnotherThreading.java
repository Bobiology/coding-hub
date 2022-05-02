package jumia;

public class AnotherThreading implements Runnable{
	private int threadNumber;
	public AnotherThreading(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(i+" from another thread "+threadNumber);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
	}

}
