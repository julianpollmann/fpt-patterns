package extendedThread;

public class MainClass {

	public static void main(String[] args) {
		MyExtendedThread mrt1 = new MyExtendedThread("A");
		MyExtendedThread mrt2 = new MyExtendedThread("B");
		MyExtendedThread mrt3 = new MyExtendedThread("C");
		mrt1.start();
		mrt2.start();
		mrt3.start();
	}

}
