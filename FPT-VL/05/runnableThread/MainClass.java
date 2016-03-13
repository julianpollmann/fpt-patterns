package runnableThread;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		ArrayList<MyRunnableThread> mrtList = new ArrayList<>();
		mrtList.add(new MyRunnableThread("A"));
		mrtList.add(new MyRunnableThread("B"));
		mrtList.add(new MyRunnableThread("C"));
		ArrayList<Thread> thList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			thList.add(new Thread(mrtList.get(i)));
			thList.get(i).start();
			try {
				thList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
