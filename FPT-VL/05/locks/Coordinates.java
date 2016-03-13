package locks;
import java.awt.Point;
import java.util.concurrent.locks.Lock;

public class Coordinates implements Runnable {

	Lock lock;
	Point p;

	public Coordinates(Point p, Lock lock) {
		this.p = p;
		this.lock = lock;
	}

	public void run() {
		//Zufallswert für x erzeugen
		int x = (int) (Math.random() * 1000);
		int y = x;

		while (true) {
			//Kritischen Bereich sperren
			//lock.lock();

			p.x = x;
			p.y = y;
			int xc = p.x;
			int yc = p.y;

			//Kritischen Bereich entsperren
			//lock.unlock();

			//Ohne Lock könnte der Fall auftreten, dass xc != yc ist, mit
			//Lock wird die if-Bedingung immer false und es kommt zu keiner Ausgabe
			if (xc != yc)
				System.out.println("Aha: x=" + xc + ", y=" + yc);
		}

	}

}
