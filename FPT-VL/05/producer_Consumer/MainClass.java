package producer_Consumer;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class MainClass {

	//Beispiel für Erzeuger/Verbraucher mit uneingeschränkter Containergröße
	//(notify wird nur vom Producer aufgerufen)
	public static void main(String[] args) {

		Vector v = new Vector();

		Producer p = new Producer(v);
		Consumer c1 = new Consumer(v);
		Consumer c2 = new Consumer(v);
		Consumer c3 = new Consumer(v);
		Consumer c4 = new Consumer(v);
		Consumer c5 = new Consumer(v);
		Consumer c6 = new Consumer(v);

		p.start();
		/*try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
		*/
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();


	}

}
