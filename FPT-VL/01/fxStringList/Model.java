package fxStringList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model  {

	//Beobachtbarer Datencontainer, der bei �ndeurngen die Beobachter informiert.
	private ObservableList<String> strings = FXCollections.observableArrayList();


	public void addString(String s) {
		strings.add(s);
	}

	public ObservableList<String> getStrings() {
		return strings;
	}

}
