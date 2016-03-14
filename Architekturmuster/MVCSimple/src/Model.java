import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

	private ArrayList<String> list;

	public Model() {
		// ruft Standardkonstruktor von Observable auf
		super();
		list = new ArrayList<String>();
	}

	public void addString(String string) {
		list.add(string);

		// Observer benachrichtigen
		super.setChanged();
		super.notifyObservers();
	}

	public ArrayList<String> getStrings() {
		return list;
	}

}
