package producer_Consumer;
import java.util.Vector;

public class Consumer extends Thread {
	private Vector v;

	public Consumer(Vector v) {
		this.v = v;
	}

	public void run() {
		while (true) {

			// intrinsischen Lock von v setzen
			synchronized (v) {

				// VARIANTE 1

				// WAIT sollte in einer Schleife mit der Bedingung aufgerufen
				// werden, so wird die Bedingung immer abgeprüft

				while (v.size() < 1) {
					try {
						v.wait();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}

				System.out.print(this.getName() + " Konsument fand "
						+ (String) v.elementAt(0));
				// Element entfernen
				v.removeElementAt(0);
				System.out.println(" (verbleiben: " + v.size() + ")");

				// VARIANTE 2

				// If-Statement an dieser Stelle gefährlich, da notify() von
				// diversen Stellen aufgerufen werden könnte und
				// die Bedingung dann ungeprüft bleibt

				// if (v.size() < 1) {
				// try {
				// In Warteschlange von v einreihen und Sperre freigeben
				// v.wait();
				// } catch (InterruptedException e) {
				// System.out.println(e);
				// }
				// }
				// System.out.print(this.getName() + " Konsument fand "
				// + (String) v.elementAt(0));
				// // Element entfernen
				// v.removeElementAt(0);
				// System.out.println(" (verbleiben: " + v.size() + ")");

				// VARIANTE 3

				// If-Statement an dieser Stelle unproblematisch, da durch else
				// die Bedingung
				// neu abgeprüft werden muss. Drückt das Verhalten von VARIANTE
				// 1 nur anders aus.
				// Dennoch sollte VARIANTE 1 verwendet werden!

				// if (v.size() < 1) {
				// try {
				// In Warteschlange von v einreihen und Sperre freigeben
				// v.wait();
				// } catch (InterruptedException e) {
				// System.out.println(e);
				// }
				// } else {
				// System.out.print(this.getName() + " Konsument fand "
				// + (String) v.elementAt(0));
				// Element entfernen
				// v.removeElementAt(0);
				// System.out.println(" (verbleiben: " + v.size() + ")");
				// }

			} // Ende des kritischen Bereiches

			// Sleep um ggf. den Thread zu verzögern

			// try {
			// Thread.sleep((int) (100 * Math.random()));
			// } catch (InterruptedException e) {
			//
			// }
		}
	}
}
