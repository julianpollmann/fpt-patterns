package producer_Consumer;
import java.util.Vector;

public class Producer extends Thread {
	private Vector v;

	public Producer(Vector v) {
		this.v = v;
	}

	public void run() {
		String s;

		while (true) {

			// intrinsischen Lock von v setzen
			synchronized (v) {
				s = "Wert " + Math.random();
				v.addElement(s);
				System.out.println(this.getName() + " Produzent erzeugte " + s);
				v.notify();
			} // Ende des kritischen Bereiches

			// Sleep um ggf. den Thread zu verzögern

			 try {
				 Thread.sleep((int) (100 * Math.random()));
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		}
	}
}
