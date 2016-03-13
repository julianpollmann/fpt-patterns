package runnableThread;

public class MyRunnableThread implements Runnable {

	private String s;

	public MyRunnableThread(String s) {
		this.s = s;
	}

	@Override
	public void run() {
		while(true) {

			if (s.equals("A")) {
				try {
					Thread.sleep((long) 2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(s);
			try {
				Thread.sleep((long) 300);// (Math.random()*2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
