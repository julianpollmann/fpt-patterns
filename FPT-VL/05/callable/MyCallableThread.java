package callable;

import java.util.concurrent.Callable;

public class MyCallableThread implements Callable<Integer> {

	private int nr;

	public MyCallableThread(int nr){
		this.nr = nr;
		System.out.println("Thread " + nr + " gestartet.");
	}

	@Override
	public Integer call() throws Exception {
		return checksum(this.nr);
	}

	private int checksum(int n) {
		if (n <= 9)
			return n;
		return n % 10 + checksum(n / 10);
	}

}
