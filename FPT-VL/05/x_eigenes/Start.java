package x_eigenes;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Start {

	public static void main(String[] args) {
		Bank bank = new Bank();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer>[] future = new Future[1];

		ArrayList<Inhaber> inList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			inList.add(new Inhaber(i,bank));
		}

		for (Inhaber in : inList) {
			in.start();
		}

		while (true) {
			try {
				bank.draufZahlen((int)executor.submit(new Geldpresse()).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

}
