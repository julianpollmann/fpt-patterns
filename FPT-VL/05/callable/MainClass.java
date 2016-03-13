package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

	public static void main(String[] args) {

		int[] numbers = {123, 678, 12234};

		ExecutorService ex = Executors.newCachedThreadPool();
		Future<Integer>[] solution = new Future[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			solution[i] = ex.submit(new MyCallableThread(numbers[i]));
			try {
				System.out.println("" + solution[i].get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		ex.shutdown();

	}

}
