package locks;
import java.awt.Point;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

	public static void main(String[] args) {
		Point p = new Point();
		//Neues Lockobjekt erstellen
		Lock myLock = new ReentrantLock();
		Thread t1 = new Thread(new Coordinates(p, myLock));
		Thread t2 = new Thread(new Coordinates(p, myLock));
		t1.start();
		t2.start();
	}

}
