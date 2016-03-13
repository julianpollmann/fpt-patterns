package synchronized_meth;
import java.awt.Point;

public class Coordinates implements Runnable {

	Point p;

	public Coordinates(Point p) {
		this.p = p;

	}

	public void run() {
		// Zufallswert für x erzeugen
		int x = (int) (Math.random() * 1000);
		int y = x;

		int xc;
		int yc;

		while (true) {
			//Kritischen Bereich sperren
			synchronized (p) { // auf Objektvariable gesetzt
				p.x = x;
				p.y = y;
				xc = p.x;
				yc = p.y;

			}
			//Kritischer bereich zuende

			// Ohne synchronized könnte der Fall auftreten, dass xc != yc ist, durch
			// synchronized wird die if-Bedingung immer false und es kommt zu keiner
			// Ausgabe
			if (xc != yc)
				System.out.println("Aha: x=" + xc + ", y=" + yc);
		}

	}

}
