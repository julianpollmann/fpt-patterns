package fxStringList;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class View extends BorderPane {

	private SimpleStringProperty buttonText = new SimpleStringProperty("Enter");
	private Button button = new Button();
	private TextField input = new TextField();

	private ListView<String> list = new ListView<String>();

	public View() {
		HBox box = new HBox(input, button);
		setCenter(list);
		setBottom(box);

		// Beispiel f�r ein einfaces Binding ---> �ndert sich die Property, so
		// �ndert sich auch die Beschriftung des Buttons
		button.textProperty().bind(buttonText);

		// Nur n�tig, wenn das Aussehen einer Zelle ge�ndert werden soll (z.B:
		// "..." + text + "...")
		// (hilfreich f�r die �bungen)
		// Hier die L�sung ohne Lambda Ausdr�cke �ber eine neue Klasse
		// "MyCustomCell"
//		Callback<ListView<String>, ListCell<String>> cb = new Callback<ListView<String>, ListCell<String>>() {
//			@Override
//			public ListCell<String> call(ListView<String> param) {
//				return new MyCustomCell();
//			}
//		};
//		list.setCellFactory(cb);

		// Nur n�tig, wenn das Aussehen einer Zelle ge�ndert werden soll (z.B:
		// "..." + text + "...")
		// (hilfreich f�r die �bungen)
		// Hier die L�sung mit Lamdba Ausdr�cke, es entf�llt eine neue Klasse
		// "MyCustomCell"

//		list.setCellFactory(c -> {
//
//			ListCell<String> cell = new ListCell<String>() {
//				@Override
//				protected void updateItem(String myObject, boolean b) {
//					super.updateItem(myObject, myObject == null || b);
//					if (myObject != null) {
//						setText("..." + myObject + "...");
//					} else {
//						// wichtig da sonst der text stehen bleibt!
//						setText("");
//					}
//				}
//
//			};
//			return cell;
//
//		});
	}

	public void addEventHandler(EventHandler<ActionEvent> eventHandler) {
		button.addEventHandler(ActionEvent.ACTION, eventHandler);
	}

	public ListView<String> getList() {
		return list;
	}

	public String getInputPaneText() {
		return input.getText();
	}

}
