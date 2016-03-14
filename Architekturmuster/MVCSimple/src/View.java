import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JTextPane;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class View implements Observer {

	private ArrayList<String> list;
	private ListView<String> listView;
	private JButton button;
	private JTextPane inputpane;

	public View() {
		button = new JButton();
	}

	@Override
	public void update(Observable o, Object arg) {
		list = ((Model) o).getStrings();
		listView.setItems(FXCollections.observableArrayList(list));
	}

	public void addActionListener(Controller controller) {
		button.addActionListener(controller);
	}

	public String getInputPaneText() {
		return inputpane.getText();
	}

}
