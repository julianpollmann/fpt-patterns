package x_eigenes;

import java.util.concurrent.Callable;

public class Geldpresse implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int plus = (int)(Math.random()*1000);
		System.out.println("Nachdruck: " + plus);
		Thread.sleep(1000);
		return plus;
	}


}
