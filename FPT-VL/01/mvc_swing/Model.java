package mvc_swing;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{

	private ArrayList<String> strings;

	public Model(){
		//super();
		strings = new ArrayList<String>();
	}

	public void addString(String s){
		strings.add(s);

		//Mark as changed and inform the observers
		super.setChanged();
		super.notifyObservers(s);
	}

	public ArrayList<String> getStrings(){
		return strings;
	}

}
