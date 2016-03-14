import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class View implements Observer {

	private ArrayList<String> list;
	private ListView<String> listView;

	public View() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		list = ((Model) o).getStrings();
		listView.setItems(FXCollections.observableArrayList(list));
	}

}
