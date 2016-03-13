
public class Singleton {

	private final static Singleton instance = new Singleton();

	// Konstruktor ist privat, kann nicht extern aufgerufen werden
	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

}
