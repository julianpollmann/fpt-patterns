package synchronized_meth;
import java.awt.Point;

public class MainClass {

	public static void main(String[] args) {
		Point p = new Point();
		Thread t1 = new Thread(new Coordinates(p));
		Thread t2 = new Thread(new Coordinates(p));
		t1.start();
		t2.start();
	}

}
