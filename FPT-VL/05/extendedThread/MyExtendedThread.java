package extendedThread;

public class MyExtendedThread extends Thread {

	private String s;

	public MyExtendedThread(String s) {
		this.s = s;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println(s);
			try {
				this.sleep((long) (Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
